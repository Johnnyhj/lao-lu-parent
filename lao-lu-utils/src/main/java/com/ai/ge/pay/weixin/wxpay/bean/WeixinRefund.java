package com.ai.ge.pay.weixin.wxpay.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.ai.ge.pay.weixin.wxpay.utils.ClientCustomSSL;
import com.ai.ge.pay.weixin.wxpay.utils.RequestHandler;
import com.ai.ge.pay.weixin.wxpay.utils.TenpayUtil;

public class WeixinRefund {

	private static Logger logger = Logger.getLogger(WeixinRefund.class);

	// 微信支付商户开通后 微信会提供appid和appsecret和商户号partner
	private String appid;
	private String mch_id;
	private String appsecret;
	private String partner;
	// 这个参数partnerkey是在商户后台配置的一个32位的key,微信商户平台-账户设置-安全设置-api安全
	private String partnerkey;
	
	
	public WeixinRefund(String appid,String mch_id,String appsecret,String partnerkey){
		this.appid= appid;
		this.mch_id=mch_id;
		this.appsecret=appsecret;
		this.partnerkey=partnerkey;
	}
	
	/**
	 * 元转换成分
	 * @param amount
	 * @return
	 */
	public static String getMoney(String amount) {
		if(amount==null){
			return "";
		}
		// 金额转化为分为单位
		String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额  
        int index = currency.indexOf(".");  
        int length = currency.length();  
        Long amLong = 0l;  
        if(index == -1){  
            amLong = Long.valueOf(currency+"00");  
        }else if(length - index >= 3){  
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));  
        }else if(length - index == 2){  
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);  
        }else{  
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");  
        }  
        return amLong.toString(); 
	}
	
	/**
	 * 获取随机字符串
	 * @return
	 */
	public static String getNonceStr() {
		// 随机数
		String currTime = TenpayUtil.getCurrTime();
		// 8位日期
		String strTime = currTime.substring(8, currTime.length());
		// 四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		// 10位序列号,可以自行调整。
		return strTime + strRandom;
	}

	
	public static String getRequestXml(SortedMap<String,String> parameters){
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			if ("attach".equalsIgnoreCase(k)||"body".equalsIgnoreCase(k)||"sign".equalsIgnoreCase(k)) {
				sb.append("<"+k+">"+"<![CDATA["+v+"]]></"+k+">");
			}else {
				sb.append("<"+k+">"+v+"</"+k+">");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}
	
	/**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map doXMLParse(String strxml) throws JDOMException, IOException {
		strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

		if(null == strxml || "".equals(strxml)) {
			return null;
		}
		
		Map m = new HashMap();
		
		InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List children = e.getChildren();
			if(children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = getChildrenText(children);
			}
			
			m.put(k, v);
		}
		
		//关闭流
		in.close();
		
		return m;
	}

	/**
	 * 获取子结点的xml
	 * @param children
	 * @return String
	 */
	public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if(!children.isEmpty()) {
			Iterator it = children.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if(!list.isEmpty()) {
					sb.append(getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}
		
		return sb.toString();
	}
	
	
	/**
	 * 微信退款
	 * @param dto
	 */
	public void refund(WxRefundDto dto){
		String total_fee = getMoney(dto.getTotal_fee());
		String refund_fee = getMoney(dto.getRefund_fee());
		SortedMap<String,String> para = new TreeMap<String,String>();
		para.put("appid", appid);
		para.put("mch_id",mch_id);
		para.put("transaction_id", dto.getTransaction_id());
		para.put("out_trade_no", dto.getOut_trade_no());
		para.put("out_refund_no", dto.getOut_refund_no());
		para.put("total_fee", total_fee);
		para.put("refund_fee", refund_fee);
		para.put("refund_fee_type", "CNY");//非必填
		para.put("nonce_str", getNonceStr());
		para.put("op_user_id", dto.getOp_user_id());
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign =reqHandler.createSign(para);
		para.put("sign", sign);
		String requestXML = getRequestXml(para);
		
		try {
			String queryResult = ClientCustomSSL.doRefund("https://api.mch.weixin.qq.com/secapi/pay/refund",requestXML);
			Map<Object, Object> resultMap = doXMLParse(queryResult);
			String  return_code = (String) resultMap.get("return_code");
			String result_code = (String) resultMap.get("result_code");
			if(return_code.equalsIgnoreCase("SUCCESS")&&result_code.equalsIgnoreCase("SUCCESS")){
				//TODO退款成功
			}else{
				//TODO退款失败
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
	}
	
}

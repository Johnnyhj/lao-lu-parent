package com.ai.ge.pay.weixin.wxpay.bean;


import com.ai.ge.pay.weixin.wxpay.utils.GetWxOrderno;
import com.ai.ge.pay.weixin.wxpay.utils.RequestHandler;
import com.ai.ge.pay.weixin.wxpay.utils.Sha1Util;
import com.ai.ge.pay.weixin.wxpay.utils.TenpayUtil;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 *
 * 
 */
public class WeixinPay {

    private static Logger logger = Logger.getLogger(WeixinPay.class);

	//微信支付商户开通后 微信会提供appid和appsecret和商户号partner
	private String appid ;//= DESEncryptUtil.decrypt(PropertiesUtil.getPropertyValue("APP_ID"), JackJson.activityKey);
	//"wxf7ae0d9350c4a574";
	private String appsecret ;//= DESEncryptUtil.decrypt(PropertiesUtil.getPropertyValue("APP_SECRET"), JackJson.activityKey);//"1c4ffe1ff01908430255fd6ead3364f9";
	private String partner ;//= DESEncryptUtil.decrypt(PropertiesUtil.getPropertyValue("PARTNER"), JackJson.activityKey);//"1238542802";
	//这个参数partnerkey是在商户后台配置的一个32位的key,微信商户平台-账户设置-安全设置-api安全
	private String partnerkey ;//= DESEncryptUtil.decrypt(PropertiesUtil.getPropertyValue("PARTNER_KEY"), JackJson.activityKey);//"1234567890qwertyuioplkjhgfdsazxc";
//	private static String partnerkey = "xzbfz8l7qma07zjqratlfghxi74c5crk";
	//openId 是微信用户针对公众号的标识，授权的部分这里不解释
//	private static String openId = "owtbos0kFT5tzGYrB8ZWKnIxZVxQ";
	//private static String openId = "owtbos59dbiwIzfxBiA-kGuSax-M";
	//微信支付成功后通知地址 必须要求80端口并且地址不能带参数
	private String notifyurl ;//= PropertiesUtil.getPropertyValue("static.deployWebPath") +
	// "instance/weixin/callback.do";	  // Key


	public WeixinPay(String appid, String appsecret, String partner, String partnerkey, String notifyurl) {
		this.appid = appid;
		this.appsecret = appsecret;
		this.partner = partner;
		this.partnerkey = partnerkey;
		this.notifyurl = notifyurl;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeixinPay weixinPay = new WeixinPay(null, null, null, null, null);
		//微信支付jsApi
		WxPayDto tpWxPay = new WxPayDto();
		//tpWxPay.setOpenId(openId);
		tpWxPay.setBody("商品信息");
		tpWxPay.setOrderId(getNonceStr());
		tpWxPay.setSpbillCreateIp("127.0.0.1");
		tpWxPay.setTotalFee("0.01");
		weixinPay.getPackage(tpWxPay);
	    
	    //扫码支付
	    WxPayDto tpWxPay1 = new WxPayDto();
	    tpWxPay1.setBody("商品信息");
	    tpWxPay1.setOrderId(getNonceStr());
	    tpWxPay1.setSpbillCreateIp("127.0.0.1");
	    tpWxPay1.setTotalFee("0.01");
		weixinPay.getCodeurl(tpWxPay1);

	}
	
	/**
	 * 获取微信扫码支付二维码连接
	 */
	public String getCodeurl(WxPayDto tpWxPayDto){
		
		// 1 参数
		// 订单号
		String orderId = tpWxPayDto.getOrderId();
		// 附加数据 原样返回
		String attach = "";
		// 总金额以分为单位，不带小数点
		String totalFee = getMoney(tpWxPayDto.getTotalFee());
		
		// 订单生成的机器 IP
		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		String notify_url = notifyurl;
		String trade_type = "NATIVE";

		// 商户号
		String mch_id = partner;
		// 随机字符串
		String nonce_str = getNonceStr();

		// 商品描述根据情况修改
		String body = tpWxPayDto.getBody();

		// 商户订单号
		String out_trade_no = orderId;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);

		// 这里写的金额为1 分到时修改
		packageParams.put("total_fee", totalFee);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);

		packageParams.put("trade_type", trade_type);

		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" 
				+ "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<attach>" + attach + "</attach>"
				+ "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "</xml>";
		String code_url = "";
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		
		
		code_url = new GetWxOrderno().getCodeUrl(createOrderURL, xml);
		System.out.println("code_url----------------"+code_url);
		
		return code_url;
	}
	
	
	/**
	 * 获取请求预支付id报文
	 * @return
	 */
	@SuppressWarnings("static-access")
	public String getPackage(WxPayDto tpWxPayDto) {
		
		String openId = tpWxPayDto.getOpenId();
		// 1 参数
		// 订单号
		String orderId = tpWxPayDto.getOrderId();
		// 附加数据 原样返回
		String attach = "";
		// 总金额以分为单位，不带小数点
		String totalFee = getMoney(tpWxPayDto.getTotalFee());
		
		// 订单生成的机器 IP
		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		String notify_url = notifyurl;
		String trade_type = "JSAPI";

		// ---必须参数
		// 商户号
		String mch_id = partner;
		// 随机字符串
		String nonce_str = getNonceStr();

		// 商品描述根据情况修改
		String body = tpWxPayDto.getBody();

		// 商户订单号[订单号使用order_seq]
		String out_trade_no = orderId;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);

		// 这里写的金额为1 分到时修改
		packageParams.put("total_fee", totalFee);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);

		packageParams.put("trade_type", trade_type);
		packageParams.put("openid", openId);

		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" 
				+ "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<attach>" + attach + "</attach>"
				+ "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "<openid>" + openId + "</openid>"
				+ "</xml>";
		String prepay_id = "";
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		
		prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);

		//System.out.println("获取到的预支付ID：" + prepay_id);
        logger.info("获取到的预支付ID：" + prepay_id);
		
		//获取prepay_id后，拼接最后请求支付所需要的package
		
		SortedMap<String, String> finalPackage = new TreeMap<String, String>();
		String timestamp = Sha1Util.getTimeStamp();
		String packages = "prepay_id="+prepay_id;
		finalPackage.put("appId", appid);
		finalPackage.put("timeStamp", timestamp);
		finalPackage.put("nonceStr", nonce_str);
		finalPackage.put("package", packages);
		finalPackage.put("signType", "MD5");
		//要签名
		String paySign = reqHandler.createSign(finalPackage);

        Map<String, String> stringMap = new TreeMap<String, String>();
        stringMap.put("appId", appid);
        stringMap.put("timeStamp", timestamp);
        stringMap.put("nonceStr", nonce_str);
        stringMap.put("package", packages);
        stringMap.put("signType", "MD5");
        stringMap.put("paySign", paySign);

        String finaPackage = JSON.toJSONString(stringMap);

        //System.out.println("V3 jsApi package:"+finaPackage);
        logger.info("V3 jsApi package:"+finaPackage);
		return finaPackage;
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

}

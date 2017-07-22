package com.ai.ge.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import java.io.IOException;

/**
 * 
 * 天翼开放平台短链接转换工具类
 * 
 * 天翼开放平台：http://open.189.cn/
 * 
 * @author igood
 *
 */
public class ShortLinkHelper {
	// 日志记录
	private static Logger 								log = Logger.getLogger(ShortLinkHelper.class);
	
	// 天翼开放平台令牌接口URL
	private static final String 						TOKEN_URL = "https://oauth.api.189.cn/emp/oauth2/v2/access_token";
	
	// 天翼开放平台令牌接口授权模式
	private static final String 						GRANT_TYPE = "client_credentials";
	
	// 天翼开放平台短链接转换接口URL
	private static final String							SHORT_LINK_URL = "http://api.189.cn/EMP/shorturl/long2short";
	
	// 天翼开放平台长链接转换接口URL
	private static final String							LONG_LINK_URL = "http://api.189.cn/EMP/shorturl/short2long";
	
	// 天翼开放平台账号
	private static final String							APP_ID = "295424620000034888";
	
	// 天翼开放平台密码
	private static final String							APP_SECRET = "990f84c1a4eeac0e353dab6bab4a6992";
	
	// 
	private static final HttpClient 					hc = new HttpClient();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long c1 = System.currentTimeMillis();
		String accessToken = ShortLinkHelper.getToken();
		System.out.println(ShortLinkHelper.longToShort(accessToken, "http://svn.ailk.org:8000/FlowPackSale/gate/clientGate.do?m=initFlowPackSale&userId=mVcUaNn6tDcwOaaabbbcccHdaA/jcwdddeeefffdddeeefff"));
		long c2 = System.currentTimeMillis();
		System.out.println("耗时：" + (c2 - c1) + "毫秒");
	}
	
	/**
	 * 调用天翼开放平台令牌接口获取令牌
	 * 
	 * 请求参数：
	 * grant_type 此值必须为“authorization_code”
	 * app_id 应用注册时分配的应用ID
	 * app_secret 申请应用时分配的应用密钥
	 * state 用于跟踪调用状态。在响应消息中将会原封不动的返回该值
	 * scope 权限列表，保留字段，默认为空
	 * 
	 * 应答参数：
	 * res_code 标准返回码。返回0表示成功；其他表示调用出错或异常。
	 * res_message 返回码描述信息
	 * state 与请求参数中state的值一致
	 * 
	 * @return 令牌
	 */
	public static String getToken(){
		log.debug("[getToken] 调用天翼开放平台令牌接口获取令牌");
		try {
			PostMethod method = new PostMethod(TOKEN_URL);
			/*HttpMethodParams hmp = new HttpMethodParams();
			hmp.setParameter("grant_type", "client_credentials");
			hmp.setParameter("app_id", "295424620000034888");
			hmp.setParameter("app_secret", "990f84c1a4eeac0e353dab6bab4a6992");
			method.setParams(hmp);*/
			
			NameValuePair[] params = new NameValuePair[3];
			params[0] = new NameValuePair("grant_type", GRANT_TYPE);
			params[1] = new NameValuePair("app_id", APP_ID);
			params[2] = new NameValuePair("app_secret", APP_SECRET);
			
			method.setRequestBody(params);
			
			hc.executeMethod(method);
			String resp = method.getResponseBodyAsString();
			log.debug("[getToken] 请求返回值：" + resp);

            JSONObject jobj = JSON.parseObject(resp);
			if(!"0".equals(jobj.getString("res_code"))){
				log.debug("[getToken] 请求令牌返回错误");
				return null;
			}

			log.debug("[getToken] 请求令牌成功");
			return jobj.getString("access_token");
		} catch (HttpException e) {
			e.printStackTrace();
			log.error("[getToken] 调用天翼开放平台令牌接口获取令牌失败，错误信息：" + e.toString());
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			log.error("[getToken] 调用天翼开放平台令牌接口获取令牌失败，错误信息：" + e.toString());
			return null;
		}
	}
	
	/**
	 * 调用天翼开放平台短链接转换接口将长连接转换为短链接
	 * 
	 * @param longUrl 长连接
	 * @return
	 */
	public static String longToShort(String longUrl){
		return ShortLinkHelper.longToShort(ShortLinkHelper.getToken(), longUrl);
	}

	/**
	 * 调用天翼开放平台短链接转换接口将长连接转换为短链接
	 * 
	 * 请求参数：
	 * app_id 应用ID，开发者创建应用时，天翼开放平台会为应用自动分配此ID，开发者进入"管理中心"，在"应用详情"中可查看app_id。
	 * access_token 访问令牌，是调用平台能力接口的通行证，可通过调用“令牌接口”获得。
	 * longurl 需要进行转换的长地址
	 * 
	 * 请求参数示例：http://url?access_token=XXXX&app_id=YYYY&longurl=ZZZZ
	 * 
	 * 响应结果：
	 * res_code 响应码
	 * res_message 响应描述信息
	 * shorturl 长地址转换后的短地址
	 * 
	 * 响应结果示例：
	 * <result><res_code>0</res_code><res_message>成功</res_message><shorturl>XXXXXX</shorturl></result>
	 * 
	 * 
	 * @param accessToken 令牌
	 * @param longUrl 待转换的长链接
	 * 
	 * @return 转换后的短链接
	 */
	public static String longToShort(String accessToken, String longUrl){
		log.debug("[longToShort] 调用天翼开放平台短链接转换接口将长连接转换为短链接");
		log.debug("[longToShort] 参数：accessToken = " + accessToken + "，longUrl = " + longUrl);
		
		if(accessToken == null || accessToken.trim().length() == 0){
			log.debug("[longToShort] accessToken为空，直接返回");
			return null;
		}
		if(longUrl == null || longUrl.trim().length() == 0){
			log.debug("[longToShort] longUrl为空，直接返回");
			return null;
		}

		PostMethod method = new PostMethod(SHORT_LINK_URL);
		// xml文档对象
		Document resultDoc = null;
		
		try {
			NameValuePair[] params = new NameValuePair[3];
			params[0] = new NameValuePair("access_token", accessToken);
			params[1] = new NameValuePair("app_id", APP_ID);
			params[2] = new NameValuePair("longurl", longUrl);
			
			method.setRequestBody(params);
			
			hc.executeMethod(method);
			String resp = method.getResponseBodyAsString();
			log.debug("[longToShort] 请求返回值：" + resp);
			
			resultDoc = DocumentHelper.parseText(resp);
			Node resultNode = resultDoc.selectSingleNode("//result/res_code");
			if(resultNode == null || !"0".equals(resultNode.getStringValue())){
				log.debug("[longToShort] 请求返回错误");
				return null;
			}
			
			return resultDoc.selectSingleNode("//result/shorturl").getStringValue();
		} catch (HttpException e) {
			e.printStackTrace();
			log.error("[longToShort] 调用天翼开放平台短链接转换接口将长连接转换为短链接失败，错误信息：" + e.toString());
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			log.error("[longToShort] 调用天翼开放平台短链接转换接口将长连接转换为短链接失败，错误信息：" + e.toString());
			return null;
		} catch (DocumentException e) {
			e.printStackTrace();
			log.error("[longToShort] 调用天翼开放平台短链接转换接口将长连接转换为短链接失败，错误信息：" + e.toString());
			return null;
		}
	}

	/**
	 * 调用天翼开放平台短链接转换接口将短连接转换为长链接
	 * 
	 * 请求参数：
	 * app_id 应用ID，开发者创建应用时，天翼开放平台会为应用自动分配此ID，开发者进入"管理中心"，在"应用详情"中可查看app_id。
	 * access_token 访问令牌，是调用平台能力接口的通行证，可通过调用“令牌接口”获得。
	 * longurl 需要进行转换的长地址
	 * 
	 * 请求参数示例：http://url?access_token=XXXX&app_id=YYYY&longurl=ZZZZ
	 * 
	 * 响应结果：
	 * res_code 响应码
	 * res_message 响应描述信息
	 * shorturl 长地址转换后的短地址
	 * 
	 * 响应结果示例：
	 * <result><res_code>0</res_code><res_message>成功</res_message><longurl>XXXXXX</longurl></result>
	 * 
	 * @param accessToken
	 * @param shortUrl
	 * @return
	 */
	public static String shortToLong(String accessToken, String shortUrl){
		log.debug("[shortToLong] 调用天翼开放平台短链接转换接口将短连接转换为长链接");
		log.debug("[shortToLong] 参数：accessToken = " + accessToken + "，shortUrl = " + shortUrl);
		
		if(accessToken == null || accessToken.trim().length() == 0){
			log.debug("[shortToLong] accessToken为空，直接返回");
			return null;
		}
		if(shortUrl == null || shortUrl.trim().length() == 0){
			log.debug("[shortToLong] shortUrl为空，直接返回");
			return null;
		}
		
		String uri = LONG_LINK_URL + "?access_token=" + accessToken + "&app_id=" + APP_ID + "&longurl=" + shortUrl;
		HttpMethod method = new GetMethod(uri);
		// xml文档对象
		Document resultDoc = null;
		
		try {
			hc.executeMethod(method);
			String resp = method.getResponseBodyAsString();
			log.debug("[shortToLong] 请求返回值：" + resp);
			
			resultDoc = DocumentHelper.parseText(resp);
			Node resultNode = resultDoc.selectSingleNode("//result/res_code");
			if(resultNode == null || !"0".equals(resultNode.getStringValue())){
				log.debug("[shortToLong] 请求返回错误");
				return null;
			}
			
			return resultDoc.selectSingleNode("//result/longurl").getStringValue();
		} catch (HttpException e) {
			e.printStackTrace();
			log.error("[shortToLong] 调用天翼开放平台短链接转换接口将短连接转换为长链接失败，错误信息：" + e.toString());
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			log.error("[shortToLong] 调用天翼开放平台短链接转换接口将短连接转换为长链接失败，错误信息：" + e.toString());
			return null;
		} catch (DocumentException e) {
			e.printStackTrace();
			log.error("[shortToLong] 调用天翼开放平台短链接转换接口将短连接转换为长链接失败，错误信息：" + e.toString());
			return null;
		}
	}
	
}

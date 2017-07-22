package com.ai.ge.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class HttpUtil {
	
	public static Logger log = Logger.getLogger(HttpUtil.class);
	
	
	public static String httpPost(String posturl, String params) {

		try {
			URL postUrl = new URL(posturl);
			HttpURLConnection connection = (HttpURLConnection) postUrl
					.openConnection();

			connection.setDoOutput(true);

			connection.setDoInput(true);

			connection.setRequestMethod("POST");

			connection.setUseCaches(false);
			

			connection.setInstanceFollowRedirects(true);

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			connection.connect();
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());

			out.writeBytes(params);
			out.flush();
			out.close(); // flush and close
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
			String line = "";
			StringBuffer resultStr = new StringBuffer("");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				resultStr.append(line);
			}
			
			reader.close();
			connection.disconnect();
			return resultStr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("[httpPost] exception" + e.toString());
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {
			String params = "{\"appKey\":\"yitongjin\",\"appSecret\":\"e10adc3949ba59abbe56e057f20f883e\",\"status\":1,\"taskId\":\"10002\",\"taskPassword\":\"3er42ki5\",\"userId\":\"13685\",\"attrList\":[{\"attrId\":1496,\"attrValue\":\"2001001\"},{\"attrId\":\"1530\",\"attrValue\":\"500\"},{\"attrId\":40,\"attrValue\":\""+ URLEncoder.encode("如果是发挥死","UTF-8") +"\"},{\"attrId\":1491,\"attrValue\":\"200\"}],\"incentiveList\":[{\"incentiveValue\":\"2\",\"incentivesTypeCd\":2}]}";
			
			String paramsaString = "inParam=" + params;
			String returnString = HttpUtil.httpPost("http://61.160.128.34:8000/wa_pa/gate/userTaskSubmit.do", paramsaString);
			System.out.print(returnString);	
		} catch (Exception e) {
			// TODO: handle exception
		}



	}
}

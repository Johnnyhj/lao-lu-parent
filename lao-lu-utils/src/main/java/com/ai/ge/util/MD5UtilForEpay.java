package com.ai.ge.util;

import org.apache.log4j.Logger;


/**
 * CryptTool 封装了一些加密工具方法, 包括 3DES, MD5 等.
 * 
 * @author hxq
 * @version 1.0 2006-01-10
 */
public class MD5UtilForEpay {

	public static Logger log = Logger.getLogger(MD5UtilForEpay.class);

	public static String REQUEST_DES_STRING = "MERCHANTID=p1&ORDERSEQ=p2&ORDERDATE=p3&ORDERAMOUNT=p4&KEY=p5";

	public static String RESPONSE_DES_STRING = "UPTRANSEQ=p1&MERCHANTID=p2&ORDERSEQ=p3&ORDERAMOUNT=p4&RETNCODE=p5&RETNINFO=p6&TRANDATE=p7&KEY=p8";

	public static String ORDER_QUERY_REQUEST_DES_STRING = "COMMCODE=p1&ORDERSEQ=p2&ORDERREQTRANSEQ=p3&KEY=p4";

	public static String ORDER_QUERY_RESPONSE_DES_STRING = "RETURNCODE=p1&COMMCODE=p2&ORDERSEQ=p3&ORDERREQTRANSEQ=p4&TRANSTATUS=p5&ORDERAMOUNT=p6&KEY=p7";
	
	public static String ORDER_EPAY_REFUND_DES_STRING="COMMCODE=p1&COMMPWD=p2&ORDERREFUNDID=p3&REQTIME=p4&TRANSAMT=p5&KEY=p6";
	
	public static String KEY = "";
	
	static {
		KEY = "0DD68C47D264159BB1AE1D46F25794B62909E88E67FF9296";
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * MD5 摘要计算(byte[]).
	 * 
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[] 16 bit digest
	 */
	public static byte[] md5Digest(byte[] src) throws Exception {
		java.security.MessageDigest alg = java.security.MessageDigest
				.getInstance("MD5"); // MD5 is 16 bit message digest

		return alg.digest(src);
	}

	/**
	 * MD5 摘要计算(String).
	 * 
	 * @param src
	 *            String
	 * @throws Exception
	 * @return String
	 */
	public static String md5Digest(String src) throws Exception {
		return byteArrayToHexString(md5Digest(src.getBytes()));
	}

	public static String getMac(String MERCHANTID, String ORDERSEQ,
			String ORDERDATE, String ORDERAMOUNT) {

		String desString = REQUEST_DES_STRING.replace("p1", MERCHANTID)
				.replace("p2", ORDERSEQ).replace("p3", ORDERDATE)
				.replace("p4", ORDERAMOUNT).replace("p5", KEY);
		log.debug("[getMac] 原文字符串 desString: " + desString);

		String MAC = "";
		try {
			MAC = md5Digest(desString);
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("[getMac] 加密异常 " + e.toString());
		}
		log.debug("[getMac] 加密后 mac: " + MAC);
		return MAC;
	}

	public static String getSign(String UPTRANSEQ, String MERCHANTID,
			String ORDERSEQ, String ORDERAMOUNT, String RETNCODE,
			String RETNINFO, String TRANDATE) {

		String desStr = RESPONSE_DES_STRING.replace("p1", UPTRANSEQ)
				.replace("p2", MERCHANTID).replace("p3", ORDERSEQ)
				.replace("p4", ORDERAMOUNT).replace("p5", RETNCODE)
				.replace("p6", RETNINFO).replace("p7", TRANDATE)
				.replace("p8", KEY);
		log.debug("[getSign] 原文字符串 desString: " + desStr);

		String SIGN = "";
		try {
			SIGN = md5Digest(desStr);
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("[getSign] 加密异常 " + e.toString());
		}
		log.debug("[getSign] 加密后 sign: " + SIGN);
		return SIGN;
	}
	
	public static String getEpayRefundMac(String commcode,String commpwd,String oldOrderId,String oldOrderPayId,String orderrefundid,String reqtime,String transamt){
		String desStr = ORDER_EPAY_REFUND_DES_STRING.replace("p1", commcode).replace("p2", commpwd)
				.replace("p3", orderrefundid).replace("p4", reqtime)
				.replace("p5", transamt).replace("p6", KEY);
		log.debug("[getEpayRefundMac] 原文字符串 desString: " + desStr);
		String MAC = "";
		try {
		MAC = md5Digest(desStr);
		} catch (Exception e) {
		e.printStackTrace();
		log.debug("[getEpayRefundMac] 加密异常 " + e.toString());
		}
		log.debug("[getEpayRefundMac] 加密后 MAC: " + MAC);
		return MAC;
	}
	
	
	public static String getOrderQueryMac(String merchantid, String orderseq,
			String orderreqtranseq) {
		String desStr = ORDER_QUERY_REQUEST_DES_STRING.replace("p1", merchantid)
				.replace("p2", orderseq).replace("p3", orderreqtranseq)
				.replace("p4", KEY);
		log.debug("[getOrderQueryMac] 原文字符串 desString: " + desStr);
		
		String MAC = "";
		try {
			MAC = md5Digest(desStr);
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("[getOrderQueryMac] 加密异常 " + e.toString());
		}
		log.debug("[getOrderQueryMac] 加密后 MAC: " + MAC);
		return MAC;
	}
	
	public static String getOrderQuerySIGN(String returnCode, String commcode,
			String orderid, String ordertran, String transtatus,
			String ordermount) {
		
		String desStr = ORDER_QUERY_RESPONSE_DES_STRING
				.replace("p1", returnCode).replace("p2", commcode)
				.replace("p3", orderid).replace("p4", ordertran)
				.replace("p5", transtatus).replace("p6", ordermount)
				.replace("p7", KEY);
		log.debug("[getOrderQuerySIGN] 原文字符串 desString: " + desStr);
		
		String SIGN = "";
		try {
			SIGN = md5Digest(desStr);
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("[getOrderQuerySIGN] 加密异常 " + e.toString());
		}
		log.debug("[getOrderQuerySIGN] 加密后 sign: " + SIGN);
		
		return SIGN;
		
	}

	/** Test crypt */
	public static void main(String[] args) {
		try {
			// 获得的明文数据
			 String desStr = "MERCHANTID=01320108040938000&ORDERSEQ=1016&ORDERDATE=20150525091927&ORDERAMOUNT=2200.00&KEY=538858";
			System.out.println("原文字符串 desStr ＝＝ " + desStr);
			// 生成MAC
			String MAC = md5Digest(desStr);
			System.out.println("MAC == " + MAC);
			// E09D878D991B545EC69FA6C76A25A38E
			System.out.println(MAC.equals("E09D878D991B545EC69FA6C76A25A38E"));

			System.out.println("MAC == " + MAC);
			// 使用key值生成 SIGN
			String keyStr = "123456";// 使用固定key

			// 获得的明文数据

			desStr = "UPTRANSEQ=20080101000001&MERCHANTID=0250000001&ORDERID=2006050112564931556&PAYMENT=10000&RETNCODE=00&RETNINFO=00&PAYDATE =20060101";
			// 将key值和明文数据组织成一个待签名的串
			desStr = desStr + "&KEY=" + keyStr;
			System.out.println("原文字符串 desStr ＝＝ " + desStr);
			// 生成 SIGN
			String SIGN = md5Digest(desStr);
			System.out.println("SIGN == " + SIGN);

			// String deString =
			// "MERCHANTID=01320108040938000&ORDERSEQ=1000123221&ORDERDATE=20150522&ORDERAMOUNT=10000.00&KET=538858";
			// String desTRetestString =
			// "MERCHANTID=01320108040938000&ORDERSEQ=1000123221&ORDERDATE=20150522&ORDERAMOUNT=10000.00&KEY=538858";
			// char[] a1 = deString.toCharArray();
			// char[] b1 = desTRetestString.toCharArray();
			// int c = a1.length<b1.length? a1.length:b1.length;
			// for(int i=0;i<c;i++){
			// if(a1[i]!=b1[i]){
			// System.out.println(a1[i]);
			// System.out.println(b1[i]);
			// System.out.println("错误位置"+i);
			// break;
			// }
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}




}

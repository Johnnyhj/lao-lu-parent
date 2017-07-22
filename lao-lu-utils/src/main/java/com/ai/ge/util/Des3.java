package com.ai.ge.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 3DES加密工具类
 * 
 * @author liufeng
 * @date 2012-10-11
 */
public class Des3 {
	// 密钥
	// liuyunqiang@lx100$#365#$
	private final static String secretKey = "2013%jiangsu&&telecom#wa";
	// 向量
	private final static String iv = "01234567";
	// 加解密统一使用的编码方式
	private final static String encoding = "utf-8";

	// private static SimpleDateFormat dateformat=new SimpleDateFormat("MMdd");
	/**
	 * 3DES加密
	 * 
	 * @param plainText
	 *            普通文本
	 * @return
	 * @throws Exception
	 */
	public static String encode(String plainText) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		String result = Base64.encode(encryptData);
		result = result.replace("+", "aaabbbccc");
		result = result.replace("=", "dddeeefff");
		return result;
	}

	/**
	 * 3DES解密
	 * 
	 * @param encryptText
	 *            加密文本
	 * @return
	 * @throws Exception
	 */
	public static String decode(String encryptText) throws Exception {
		String encrytTemp = encryptText.replace("aaabbbccc", "+");
		encrytTemp = encrytTemp.replace("dddeeefff", "=");

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

		byte[] decryptData = cipher.doFinal(Base64.decode(encrytTemp));

		return new String(decryptData, encoding);
	}

	public static void main(String[] args) {
		try {
			long c1 = System.currentTimeMillis();
			String s1 = Des3.encode("29088");
			long c2 = System.currentTimeMillis();
			System.out.println(s1);
			System.out.println("加密耗时: " + (c2 - c1));
			
			/*String s2 = Des3.decode("9xSp4xlU/QWO3c7yEVCahwdddeeefffdddeeefff");
			long c3 = System.currentTimeMillis();
			System.out.println(s2);
			System.out.println("解密耗时: " + (c3 - c2));*/
			// System.out.println(Des3.decode("0zL6Cr7uvCc="));

			// String s1 =
			// "{\"key\":\"1111\",\"param\":{\"name\":\"某某某\",\"accNbr\":\"18953115311\",\"sessionId\":\"TS0cRQJhl1xrGMVSZhjX1Dcr1mGYJFk8fK2ZJhfttY1X3GvgwFvv!64992831\",\"validaCode\":\"7672\",\"cerdAddr\":\"北京朝阳区\",\"cerdValue\":\"372501198310082412\"},\"actionCode\":\"BJ_PAD_ACTION_INFO_UPLOADSUBMIT\"}";
			// String s1 =
			// "PAWhXpLvg/xy9WNRCPY4v2E3COzinFskDW3fI09eCeOQsNXUeC6ZP0wExA0f/f2ni6ZbPbEdGY7GhL0UK851azsxtenEHvl7n5Q3qEtpm6cs7Ec8oSqDJaElyRmYRXkgaaabbbccczaLuMc3w77LZf3oyawaaabbbccckv2LiCPieGMm6UfT9PbpyOIkbxXoHFikDgv8pmh07ZiOeCwOyRxYN8AhOIpRFMZ8ol3EbMKdPviseCw3HOPjZgtwn5fkyyrX8ylFaaabbbcccxPYOHNG1y9dOJV9VVPUISHQqd540XYKaMBcAhwEF/uEIUDUW4aaabbbcccb6aM2i1tQvUBpzqkRCJZIXVPoVEgyHXHhm6Y5/j/ioWsqsaa06Z02";

			// System.out.println(Des3.decode("PAWhXpLvg/xy9WNRCPY4v2E3COzinFskDW3fI09eCeOQsNXUeC6ZP0wExA0f/f2nG1xwVmiGWbyfYs7Ec5FNbIrJZ/dT2wBkeL9qqnicaNLhY2J5fLtHBkeMH9EKpXs3yw1Zaaabbbcccybon92wofOPSD7PHH3zjet5dMV5MNu/DKW8VQFhjG2bK2Y9g2tUHu4WkUn8yQ8kcWd0Lj6nQjHWjHUl2gdjd9XuuZNRnR4V0ntBvDnEw7g8eT9jLHb/xxnNwmhziyYZojqdhReTjh5VoLTh7EgGSYXMu1HETFLSaaabbbccc1GZufxNdjHC2INHEXffyuxIyRBwbrjImZNKFqaifQcp8wavcwdddeeefffdddeeefff"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
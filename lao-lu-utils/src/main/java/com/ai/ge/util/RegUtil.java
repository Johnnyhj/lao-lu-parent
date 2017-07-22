package com.ai.ge.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegUtil {
	/**
	 * 默认的账号正则表达式：只能由6到20位数字，字母，下划线组成
	 */
	public static String			DEFAULT_ACCOUNT_REGEX = "^[a-zA-Z0-9_]{6,20}$";
	
	/**
	 * 默认的邮箱正则表达式
	 */
	public static String			DEFAULT_EMAIL_REGEX = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	
	/**
	 * 默认的手机号码正则表达式
	 */
	public static String			DEFAULT_PHONE_REGEX = "^((13[0-9])|(15[0-9])|(177)|(18[0-9]))\\d{8}$";
	
	/**
	 * 默认的身份证号码正则表达式
	 */
	public static String			DEFAULT_IDCARD_REGEX = "^((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91)\\d{4})((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\\d)|(2[0-8])))|((((0[1,3-9])|(1[0-2]))(29|30))|(((0[13578])|(1[02]))31))))((\\d{3}(x|X))|(\\d{4}))$";
	
	public static Pattern			pattern;
	
	public static Matcher			matcher;
	
	
	/**
	 * 使用默认的账号正则表达式校验账号格式是否正确
	 * 
	 * @param account 账号
	 * @return
	 */
	public static boolean checkAccount(String account){		
		return RegUtil.checkAccount(account, null);
	}
	
	/**
	 * 使用自定义的账号正则表达式来校验账号格式是否正确
	 * 
	 * @param account 账号
	 * @param regex 正则表达式
	 * @return
	 */
	public static boolean checkAccount(String account, String regex){
		if(regex == null || regex.trim().length() == 0){
			regex = RegUtil.DEFAULT_ACCOUNT_REGEX;
		}
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(account);
		
		return matcher.matches();
	}

	/**
	 * 使用默认的邮箱正则表达式校验邮箱格式是否正确
	 * 
	 * @param email 邮箱地址
	 * @return
	 */
	public static boolean checkEmail(String email){		
		return RegUtil.checkEmail(email, null);
	}
	
	/**
	 * 使用自定义的邮箱正则表达式来校验邮箱格式是否正确
	 * 
	 * @param email 邮箱地址
	 * @param regex 正则表达式
	 * @return
	 */
	public static boolean checkEmail(String email, String regex){
		if(regex == null || regex.trim().length() == 0){
			regex = RegUtil.DEFAULT_EMAIL_REGEX;
		}
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	/**
	 * 使用默认的手机号码正则表达式校验手机号码格式是否正确
	 * 
	 * @param phoneNum 手机号码
	 * @return
	 */
	public static boolean checkPhoneNum(String phoneNum){		
		return RegUtil.checkPhoneNum(phoneNum, null);
	}
	
	/**
	 * 使用自定义的手机号码正则表达式来校验手机号码格式是否正确
	 * 
	 * @param phoneNum 手机号码
	 * @param regex 正则表达式
	 * @return
	 */
	public static boolean checkPhoneNum(String phoneNum, String regex){
		if(regex == null || regex.trim().length() == 0){
			regex = RegUtil.DEFAULT_PHONE_REGEX;
		}
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(phoneNum);
		
		return matcher.matches();
	}
	

	/**
	 * 使用默认的身份证号码正则表达式校验身份证号码格式是否正确
	 * 
	 * @param idCard 身份证号码
	 * @return
	 */
	public static boolean checkIdCard(String idCard){		
		return RegUtil.checkIdCard(idCard, null);
	}
	
	/**
	 * 使用自定义的身份证号码正则表达式来校验身份证号码格式是否正确
	 * 
	 * @param idCard 身份证号码
	 * @param regex 正则表达式
	 * @return
	 */
	public static boolean checkIdCard(String idCard, String regex){
		if(regex == null || regex.trim().length() == 0){
			regex = RegUtil.DEFAULT_IDCARD_REGEX;
		}
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(idCard);
		
		return matcher.matches();
	}
}

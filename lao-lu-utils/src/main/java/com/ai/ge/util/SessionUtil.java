package com.ai.ge.util;

import javax.servlet.http.HttpSession;

/**
 * 
 * session中存取值的处理
 * 
 * @author tongfang
 *
 */
public class SessionUtil {

	
	/**
	 * 设置目标对象到session中
	 * 
	 * @param session 当前会话
	 * 
	 * @param key 保存对象的键
	 * 
	 * @param obj 保存的对象
	 * 
	 */
	public static void setAttribute(HttpSession session, String key, Object obj){
		if(session == null){
			return;
		}
		session.setAttribute(key, obj);
	}
	

	/**
	 * 从session中获取目标对象
	 * 
	 * @param session 当前会话
	 * 
	 * @param key 对象的键
	 * 
	 * 
	 */
	public static Object getAttribute(HttpSession session, String key){
		if(session == null){
			return null;
		}
		
		return session.getAttribute(key);
	}
	
	/**
	 * 设置session立即失效
	 * 
	 * @param session 
	 */
	public static void invalidateSession(HttpSession session){
		if(session != null){
			session.invalidate();
		}
	}
	
}

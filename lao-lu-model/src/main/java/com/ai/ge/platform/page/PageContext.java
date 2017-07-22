package com.ai.ge.platform.page;

import org.apache.log4j.Logger;


public class PageContext extends Page{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4311874603534942872L;

	private static final Logger logger = Logger.getLogger(PageContext.class);

	private static ThreadLocal<PageContext> context = new ThreadLocal<PageContext>();

	public static PageContext getContext(){
		return context.get();
	}
	
	public static PageContext createPage(){
		PageContext page = new PageContext();
		context.set(page);
		return page;
	}
	

	public  static void removeContext(){
		context.remove();
	}

	protected void initialize() {

		

	}
	


	
	
	

	
}

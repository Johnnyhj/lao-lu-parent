package com.ai.ge.common;

import com.ai.ge.util.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class CreditContextLoaderListener extends ContextLoaderListener {

	
	/**
	 * 日志记录器
	 */
	private Logger 	log = Logger.getLogger(CreditContextLoaderListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);

		log.debug("[contextDestroyed] --开始-- WEB项目启动，加载配置数据");
		CommonUtil.APPLICATION_CONTEXT = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		log.info("CommonUtil.APPLICATION_CONTEXT注册...");
		//初始化线程池
		if(CommonUtil.threadPool == null)
		{
			//核心线程数
			Integer corepoolsize = Integer.valueOf(CommonUtil.getConfigValue("thread.corepoolsize"));
			//最大线程数
			Integer maximumPoolSize = Integer.valueOf(CommonUtil.getConfigValue("thread.maximumPoolSize"));
			//回收线程等待时间
			Integer keepAliveTime = Integer.valueOf(CommonUtil.getConfigValue("thread.keepAliveTime"));
			//队列长度
			Integer queuesize = Integer.valueOf(CommonUtil.getConfigValue("thread.queuesize"));
			CommonUtil.threadPool = new ThreadPoolExecutor(
					corepoolsize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
		            new ArrayBlockingQueue<Runnable>(queuesize),
		            new ThreadFactory(){
						public Thread newThread(Runnable r) {
							return new Thread(r);
						}
		            },
		            new ThreadPoolExecutor.CallerRunsPolicy());
		}
		log.debug("[contextDestroyed] --WEB 项目加载配置数据结束");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	
	}

}

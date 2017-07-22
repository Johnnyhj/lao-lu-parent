package com.ai.ge.platform.job;


import com.ai.ge.platform.serviceimpl.performance.PerformanceServiceImpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoaderListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 履约可能失败，通过本JOB进行手工同步
 */
public class SynchronizePerformanceJob implements Job
{

    /**
     * 日志记录器
     */
    private Logger logger = Logger.getLogger(SynchronizePerformanceJob.class);

    private PerformanceServiceImpl performanceServiceImpl = ContextLoaderListener.getCurrentWebApplicationContext().getBean("performanceServiceImpl", PerformanceServiceImpl.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("同步失败芝麻信用履约定时任务开始：" + sdf.format(new Date()));
        try {
            int count = performanceServiceImpl.synchronizePerformance();
            logger.debug("同步"+count+"个失败履约");
        } catch (Exception e) {
            logger.error("同步失败芝麻信用履约定时任务异常", e);
        }
        logger.error("同步失败芝麻信用履约定时任务结束：" + sdf.format(new Date()));
    }


}

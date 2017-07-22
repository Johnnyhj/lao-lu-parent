package com.ai.ge.platform.job;


import com.ai.ge.platform.serviceimpl.phonenum.PhoneNumServiceImpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoaderListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 释放预占电话号码
 */
public class ReleaseNumberJob implements Job
{
    /**
     * 日志记录器
     */
    private Logger logger = Logger.getLogger(ReleaseNumberJob.class);

    private PhoneNumServiceImpl phoneNumServiceImpl  = ContextLoaderListener.getCurrentWebApplicationContext().getBean("phoneNumServiceImpl", PhoneNumServiceImpl.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("预占电话号码释放定时任务开始：" + sdf.format(new Date()));
        try {
            int count = phoneNumServiceImpl.releaseNumber(null);
            logger.debug("释放"+count+"个电话号码");
        } catch (Exception e) {
            logger.error("预占电话号码定时任务异常", e);
        }
        logger.error("预占电话号码定时任务结束：" + sdf.format(new Date()));
    }


}

package com.ai.ge.platform.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Administrator on 2016-8-17.
 */
public class PayDividedCollectJob implements Job {

    private Logger log = Logger.getLogger(PayDividedCollectJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try
        {
            log.debug("PayDividedCollectJob[execute] ------------------------ start ------------------------ ");

            System.out.println("定时任务执行中...");

            log.debug("PayDividedCollectJob[execute] ------------------------ executing ------------------------ ");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("PayDividedCollectJob[execute] error! error message is: " + e.toString());
        }
    }
}

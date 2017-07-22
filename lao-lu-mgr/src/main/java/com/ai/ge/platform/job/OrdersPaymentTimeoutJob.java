package com.ai.ge.platform.job;


import com.ai.ge.platform.serviceimpl.order.OrderServiceImpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoaderListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdersPaymentTimeoutJob implements Job
{

    /**
     * 日志记录器
     */
    private Logger logger = Logger.getLogger(OrdersPaymentTimeoutJob.class);

    private OrderServiceImpl orderServiceImpl  = ContextLoaderListener.getCurrentWebApplicationContext().getBean("orderServiceImpl", OrderServiceImpl.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式

        try
        {
            logger.debug("访问订单支付超时定时任务开始：" + sdf.format(new Date()));
            try {
                int count = orderServiceImpl.updatePaymentTimeoutOrders(null);
                logger.debug("处理"+count+"条超时订单");
            } catch (Exception e) {
                logger.error("访问订单支付超时定时任务异常", e);
            }

            logger.error("访问订单支付超时定时任务结束：" + sdf.format(new Date()));

        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("访问订单支付定时任务异常结束：" + sdf.format(new Date()));
        }
    }


}

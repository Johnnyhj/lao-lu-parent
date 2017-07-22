package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.model.order.PerformanceLog;
import com.ai.ge.platform.service.performance.PerformanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "listperformance")
public class Listperformance implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(Listperformance.class);

    @Resource
    protected PerformanceService performanceService;
    /**
     * 查询履约情况
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            String orderId = message.getParameter("order_id");
            List<PerformanceLog> plList = performanceService.queryPerformaceByOrderId(Long.parseLong(orderId));
            message.setCode(AbilityConstant.R_SUCCESS);
            message.setBody(plList);
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }
}

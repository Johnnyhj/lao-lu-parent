package com.ai.ge.platform.controller.order;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "orderDetail")
public class OrderDetailMain extends ServiceParamMain implements IAbility
{

    private Logger logger = LoggerFactory.getLogger(OrderDetailMain.class);

    @Override
    public Message execute(Message message)
    {
        Long orderId = Long.valueOf(message.getParameter("orderId"));

        try
        {
            message.setBody(orderService.findOrdersDto(orderId));
            message.setCode(AbilityConstant.R_SUCCESS);
            message.setView("order/orderDetail");

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }

}

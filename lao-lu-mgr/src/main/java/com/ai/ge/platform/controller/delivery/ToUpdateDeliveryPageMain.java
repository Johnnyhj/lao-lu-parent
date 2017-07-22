package com.ai.ge.platform.controller.delivery;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.OrdersDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/27.
 */
@Service
@AbilityRegister(name = "toUpdateDeliveryPage")
public class ToUpdateDeliveryPageMain extends ServiceParamMain implements IAbility
{

    private Logger logger = LoggerFactory.getLogger(ToUpdateDeliveryPageMain.class);

    @Override
    public Message execute(Message message)
    {
        Long orderId = Long.valueOf(message.getParameter("orderId"));

        try
        {
            OrdersDto ordersDto = orderService.findOrdersDto(orderId);
            ordersDto.setDeliveryInfo(deliveryService.findDelivery(orderId));

            message.setBody(ordersDto);
            message.setCode(AbilityConstant.R_SUCCESS);
            message.setView("delivery/editDelivery");

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }

}

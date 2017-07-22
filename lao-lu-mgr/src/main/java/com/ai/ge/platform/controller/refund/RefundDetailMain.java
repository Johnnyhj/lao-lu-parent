package com.ai.ge.platform.controller.refund;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.OrderOperateDto;
import com.ai.ge.platform.dto.order.OrdersDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "refundDetail")
public class RefundDetailMain extends ServiceParamMain implements IAbility
{

    private Logger logger = LoggerFactory.getLogger(RefundDetailMain.class);

    @Override
    public Message execute(Message message)
    {
        Long orderId = Long.valueOf(message.getParameter("orderId"));

        try
        {
            Map<String, Object> resultMap = new HashMap<String, Object>();

            OrdersDto ordersDto = orderService.findOrdersDto(orderId);

            // 查询退款等操作的信息
            List<OrderOperateDto> orderOperateDtoList = orderService.listOrderOperateUser(orderId);


            resultMap.put("order", ordersDto);
            resultMap.put("orderOperateList", orderOperateDtoList);

            message.setBody(resultMap);
            message.setCode(AbilityConstant.R_SUCCESS);
            message.setView("refund/refundDetail");

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }

}

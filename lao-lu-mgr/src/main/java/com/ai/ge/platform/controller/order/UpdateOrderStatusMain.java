package com.ai.ge.platform.controller.order;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.order.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/28.
 *
 * 甩单
 */
@Service
@AbilityRegister(name = "updateOrderStatus")
public class UpdateOrderStatusMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(UpdateOrderStatusMain.class);

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;
        String resultMsg = "甩单成功";

        try
        {
            Orders orders = new Orders();
            orders.setOrderId(Long.parseLong(message.getParameter("orderId")));
            orders.setStatus(Short.parseShort(message.getParameter("status")));

            orderService.updateOrders(orders);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = "甩单失败";

        } finally
        {
            message.setCode(resultCode);
            message.setMsg(resultMsg);

        }
        return message;
    }
}

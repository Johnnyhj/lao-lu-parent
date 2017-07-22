package com.ai.ge.platform.controller.refund;

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
 * Created by guochunhao on 17/6/22.
 */
@Service
@AbilityRegister(name = "updateRefundMain")
public class UpdateRefundMain extends ServiceParamMain implements IAbility
{

    private Logger logger = LoggerFactory.getLogger(UpdateRefundMain.class);

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;

        short status = Short.parseShort(message.getParameter("status"));
        String resultMsg = "申请退款";

        if ((short) 10 == status)
        {
            resultMsg = "完成退款";
        }

        try
        {
            Orders orders = new Orders();
            orders.setOrderId(Long.parseLong(message.getParameter("orderId")));
            orders.setStatus(Short.parseShort(message.getParameter("status")));

            orderService.updateRefund(orders, getUserId(message));

            resultMsg = resultMsg + "成功";
            message.setCode(resultCode);
            message.setMsg(resultMsg);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = resultMsg + "失败";
            message.setCode(resultCode);
            message.setMsg(resultMsg);

        }

        return message;
    }

}

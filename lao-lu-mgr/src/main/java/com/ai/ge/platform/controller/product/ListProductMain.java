package com.ai.ge.platform.controller.product;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.page.PageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "products")
public class ListProductMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListProductMain.class);

    @Override
    public Message execute(Message message)
    {
        Orders orders = message.getParam(Orders.class);

        try {
            PageContext page = super.setPageContext(message.getRequest());

            List<Orders> list = orderService.findListByCond(orders);

            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("list", list);
            resultMap.put("page", page);

            PageContext.removeContext();

            message.setBody(resultMap);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        message.setView("order/listOrder");

        return message;
    }
}

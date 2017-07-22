package com.ai.ge.platform.controller.refund;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.page.PageContext;
import com.ai.ge.platform.shiro.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/6/22.
 */
@Service
@AbilityRegister(name = "listRefund")
public class ListRefundMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListRefundMain.class);

    @Override
    public Message execute(Message message)
    {
        Orders orders = message.getParam(Orders.class);

        try {
            PageContext page = super.setPageContext(message.getRequest());

            // 获取当前登录用户，通过用户的类型根据区域过滤数据
            SysUser user = (SysUser) message.getRequest().getAttribute(Constants.SYSTEM_CURRENT_USER);
            orders.setUserType(user.getUserType());
            orders.setProvinceAearId(user.getProvinceAearId());
            orders.setCityAearId(user.getCityAearId());

            List<Short> statusList = new ArrayList<Short>();
            statusList.add(com.ai.ge.platform.common.jcaptcha.Constants.ORDER_STATUS.NOT_COMPLETED);
            statusList.add(com.ai.ge.platform.common.jcaptcha.Constants.ORDER_STATUS.REFUND);
            statusList.add(com.ai.ge.platform.common.jcaptcha.Constants.ORDER_STATUS.TUI_KUAN_ZHONG);

            List<Orders> list = orderService.listRefund(statusList, orders);

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

        message.setView("refund/listRefund");

        return message;
    }
}

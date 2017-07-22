package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.service.order.OrderService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SystemAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "listcustorders")
public class ListCustOrdersMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListCustOrdersMain.class);

    @Resource
    protected OrderService orderService;

    @Resource
    private SystemAreaService systemAreaService;

    @Resource
    private RedisSpringProxy redisService;

    /**
     * 查询用户下的所有订单
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            //解析参数
            String custId = message.getParameter("cust_id");
            if(null==custId||"".equalsIgnoreCase(custId))//使用session中的用户
            {
//                PlatFormUserCache cache = (PlatFormUserCache) SessionUtil.getAttribute(message.getRequest().getSession(true), "user");
//                custId = cache.getId().toString();
            }

            String orderId = message.getParameter("order_id");
            if(null!=orderId&&!"".equalsIgnoreCase(orderId)){//根据订单号直接差订单
                Orders record = new Orders();
                record.setOrderId(Long.parseLong(orderId));
                List<Orders> list = orderService.findListByCond(record);
                //生成前段页面所需省市字段
                for(Orders o:list){
                    String key = "AI-WEB_PROVINCE_BYID_"+o.getProvinceAearId();
                    SystemArea sa = null;
                    sa = redisService.read(key, SystemArea.class);
                    if(null == sa){
                        sa = systemAreaService.listSystemAreaById(o.getProvinceAearId());
                        redisService.save(key,sa);
                    }
                    String pName = sa.getAreaName();

                    key = "AI-WEB_CITY_BYID_"+o.getCityAearId();
                    sa = redisService.read(key, SystemArea.class);
                    if(null == sa){
                        sa = systemAreaService.listSystemAreaById(o.getCityAearId());
                        redisService.save(key,sa);
                    }
                    String cName = sa.getAreaName();

                    if(pName.equalsIgnoreCase(cName)){
                        o.setProvinceAndCity(pName+" ");
                    }else
                        o.setProvinceAndCity(pName+" " + cName);
                }
                message.setBody(list);
            }else
                message.setBody(orderService.findOrdersByCustId(custId));
            message.setCode(AbilityConstant.R_SUCCESS);
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }
}

package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.service.order.OrderService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "updatedelivery")
public class UpdateDeliveryMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(UpdateDeliveryMain.class);

    @Resource
    protected OrderService ordersService;

    /**
     * 更新订单送货地址
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            //解析参数
            String strRequestJson = readParamFromRequest(message.getRequest());
            JSONObject jSONObj= JSONObject.fromObject(strRequestJson);
            String alipayUserId = (String)jSONObj.get("alipay_user_id");
            Long orderId = jSONObj.getLong("order_id");
            String customerName = null;
            String customerPhone = null;
            String customerAddress = null;
            Long provinceAearId = null;
            Long cityAearId = null;


            Object obj = jSONObj.get("customer_name");
            if(null!=obj)
                customerName =  jSONObj.getString("customer_name");
            obj = jSONObj.get("customer_phone");
            if(null!=obj)
                customerPhone =  jSONObj.getString("customer_phone");
            obj = jSONObj.get("customer_address");
            if(null!=obj)
                customerAddress =  jSONObj.getString("customer_address");
            obj = jSONObj.get("province_aear_id");
            if(null!=obj)
                provinceAearId =  jSONObj.getLong("province_aear_id");
            obj = jSONObj.get("city_aear_id");
            if(null!=obj)
                cityAearId =  jSONObj.getLong("city_aear_id");

            Orders order = new Orders();
            order.setOrderId(orderId);
            order.setCustomerName(customerName);
            order.setCustomerPhone(customerPhone);
            order.setCustomerAddress(customerAddress);
            order.setProvinceAearId(provinceAearId);
            order.setCityAearId(cityAearId);
            ordersService.updateOrders(order);

            message.setCode(AbilityConstant.R_SUCCESS);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }

    private String readParamFromRequest(HttpServletRequest request){
        String rv = null;

        try{
            java.io.InputStream in = request.getInputStream();
            int len = request.getContentLength();
            byte [] buffer  = new byte[len];
            in.read(buffer);
            rv  = new String(buffer,"UTF-8");

            logger.debug("【入参】\r\n" + rv);
        }catch(Exception e){
            logger.error("读取参数失败");
            rv = null;
        }

        return rv;
    }
}

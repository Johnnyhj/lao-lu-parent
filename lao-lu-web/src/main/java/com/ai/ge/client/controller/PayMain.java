package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.service.pay.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "pay")
public class PayMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(PayMain.class);

    @Resource
    protected PayService payService;

    /**
     * 支付
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            //获取订单ID
            String orderId = message.getParameter("orderId");
            String rv = payService.pay(Long.parseLong(orderId),message.getRequest());

            if(!"failed".equalsIgnoreCase(rv)) {
                message.setBody(rv);
                message.setView("pay/pay");
            }
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

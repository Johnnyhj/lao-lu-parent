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

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "payedCallback")
public class PayedCallBackMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(PayedCallBackMain.class);

    @Resource
    protected PayService payService;

    /**
     * 支付结束跳转后续页面
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            String orderSeq = message.getParameter("orderSeq");
            String result = message.getParameter("payResult");

            logger.debug("支付完成回调接口开始：");
            logger.debug("订单号：" + orderSeq + "回调结果：" + result);

            String url = "redirect:"+"";
            message.setView(url);
            message.toView();
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }
}

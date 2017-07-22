//package com.ai.ge.platform.main.order;
//
//import com.ai.ge.bus.core.AbilityConstant;
//import com.ai.ge.bus.core.AbilityRegister;
//import com.ai.ge.bus.core.IAbility;
//import com.ai.ge.bus.core.Message;
//import com.ai.ge.platform.result.ObjectResult;
//import com.ai.ge.platform.result.Result;
//import com.ai.ge.platform.service.pay.PayService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * Created by wangying on 17/5/12.
// */
//@Service
//@AbilityRegister(name = "refund")
//public class RefundMain implements IAbility
//{
//    private Logger logger = LoggerFactory.getLogger(RefundMain.class);
//
//    @Resource
//    protected PayService payService;
//
//    /**
//     * 支付
//     * @param message
//     * @return
//     */
//    @Override
//    public Message execute(Message message)
//    {
//        try {
//            //获取订单ID
//            String orderId = message.getParameter("orderId");
//            ObjectResult refund = payService.refund(Long.parseLong(orderId), message.getRequest());
//
//            message.setBody(refund);
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//
//            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
//            message.setMsg(e.getMessage());
//        }
//
//        return message;
//    }
//
//}

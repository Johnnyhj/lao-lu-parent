package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.pay.weixin.wxpay.utils.MD5Util;
import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.service.pay.PayService;
import com.ai.ge.platform.serviceimpl.pay.util.DESEncryptUtil;
import com.ai.ge.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "payednotify")
public class PayedNotifyMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(PayedNotifyMain.class);

    @Resource
    protected PayService payService;

    /**
     * 支付完成通知
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            String orderSeq = message.getParameter("orderSeq");
            String pfOrderSeq = message.getParameter("pfOrderSeq");
            String orderPrice = message.getParameter("orderPrice");
            String payMessage = message.getParameter("payMessage");
            String transactionId = message.getParameter("transactionId");
            String gateway = message.getParameter("gateway");
            String resultCode = message.getParameter("resultCode");
            String timestamp = message.getParameter("timestamp");
            String strSign = message.getParameter("sign");

            String secret = CommonUtil.getConfigValue("UNIFY_PAY_SECRET");
            secret = DESEncryptUtil.decrypt(secret, DESEncryptUtil.PAY_DESKEY);

            String sign = resultCode + secret + orderSeq + pfOrderSeq
                    + transactionId + orderPrice + gateway + timestamp;

            logger.debug("resultCode："+resultCode);
            logger.debug("secret："+secret);
            logger.debug("orderSeq："+orderSeq);
            logger.debug("pfOrderSeq："+pfOrderSeq);
            logger.debug("transactionId："+transactionId);
            logger.debug("orderPrice："+orderPrice);
            logger.debug("gateway："+gateway);
            logger.debug("timestamp："+timestamp);

            // 签名验证
            String reSign = MD5Util.MD5Encode(sign, "UTF-8");
            logger.debug("reSign："+reSign);
            logger.debug("strSign："+strSign);

            if (!reSign.equals(strSign)) {
                logger.error("支付宝支付返回签名不正确，原签名[{}]计算后签名[{}]", new Object[]{strSign, sign});
                throw new DataException("sign error");
            }else{
                logger.debug("支付完成通知接口开始：");
                logger.debug("订单号：" + orderSeq + "通知结果：" + resultCode + "通知消息：" + payMessage);
                payService.payedNotify(orderSeq,resultCode,orderPrice,payMessage,transactionId,gateway,sign,pfOrderSeq);
            }
            logger.debug("支付完成通知接口结束：");
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return null;
    }

    public static void main(String[] args) {
        String secret = CommonUtil.getConfigValue("UNIFY_PAY_SECRET");
        System.out.println(secret);
        secret = DESEncryptUtil.decrypt(secret, DESEncryptUtil.PAY_DESKEY);
        System.out.println(secret);
    }
}

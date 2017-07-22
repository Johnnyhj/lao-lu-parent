package com.ai.ge.platform.service.pay;

import com.ai.ge.platform.result.ObjectResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guochunhao on 17/5/19.
 */
public interface PayService
{
    /**
     * 生成支付路径
     * @param orderId 订单ID
     * @return 支付URL
     */
    String pay(Long orderId,HttpServletRequest request) throws Exception;

    /**
     * 支付回调处理方法
     *
     * @param orderId 订单ID
     * @param payResult 支付结果
     * @return 跳转URL
     */
    String payedCallback(Long orderId,String payResult);


    /**
     * 支付完成通知方法
     *
     * @param orderSeq 订单流水
     * @param payResult 支付结果
     * @return 跳转URL
     */
    void payedNotify(String orderSeq,
                       String payResult,
                       String orderPrice,
                       String payMessage,
                       String transactionId,
                       String gateway,
                       String sign,
                       String pfOrderSeq);

    /**
     * 退款
     *
     * @param orderId 订单号
     * @param request 支付结果
     * @return 跳转URL
     */
    ObjectResult refund(Long orderId, HttpServletRequest request) throws Exception;
}

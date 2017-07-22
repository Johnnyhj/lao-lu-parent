package com.ai.ge.platform.serviceimpl.http.zhima;

/**
 * 信用套餐查询接口
 */
public class ZhimaOrderConfirmHttpRequestObject extends ZhimaHttpRequestObject {
    /**
     * 1、	芝麻业务办理完成后会回调商户指定的地址，并且加上一个参数orderNo
     * 2、	商户接受到orderNo后来芝麻查询相关信息，具体接口参见第四部分订单查询接口
     */
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}

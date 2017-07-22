package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by sx on 2016/3/16.
 */
public class OrderValidateForECResponse {

    @XStreamAlias("orderValidateForECReturn")
    private OrderValidateForECReturn orderValidateForECReturn;

    public OrderValidateForECReturn getOrderValidateForECReturn() {
        return orderValidateForECReturn;
    }

    public void setOrderValidateForECReturn(OrderValidateForECReturn orderValidateForECReturn) {
        this.orderValidateForECReturn = orderValidateForECReturn;
    }
}

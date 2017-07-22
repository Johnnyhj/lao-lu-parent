package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by sx on 2016/3/16.
 */
public class CreateOrderForECReturn {
    @XStreamAlias("orderListResponse")
    private OrderListResponse orderListResponse;

    public OrderListResponse getOrderListResponse() {
        return orderListResponse;
    }

    public void setOrderListResponse(OrderListResponse orderListResponse) {
        this.orderListResponse = orderListResponse;
    }
}

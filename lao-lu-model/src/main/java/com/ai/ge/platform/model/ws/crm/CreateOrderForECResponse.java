package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * CRM生单返回
 */
public class CreateOrderForECResponse {
    @XStreamAlias("createOrderForECReturn")
    private CreateOrderForECReturn createOrderForECReturn;

    public CreateOrderForECReturn getCreateOrderForECReturn() {
        return createOrderForECReturn;
    }

    public void setCreateOrderForECReturn(CreateOrderForECReturn createOrderForECReturn) {
        this.createOrderForECReturn = createOrderForECReturn;
    }
}

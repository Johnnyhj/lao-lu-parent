package com.ai.ge.platform.model.ws;

import com.ai.ge.platform.model.ws.crm.CreateOrderForECResponse;
import com.ai.ge.platform.model.ws.crm.OrderValidateForECResponse;
import com.ai.ge.platform.model.ws.billing.AreaCodeQrsp;
import com.ai.ge.platform.model.ws.billing.CurrAcuRsp;
import com.ai.ge.platform.model.ws.billing.OrderMealsRsp;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by sx on 2016/3/10.
 */


public class Body {

    @XStreamAlias("web:ORDER_MEALSRsp")
    private OrderMealsRsp orderMealsRsp;

    @XStreamAlias("web:CurrAcuRsp")
    private CurrAcuRsp currAcuRsp;

    @XStreamAlias("orderValidateForECResponse")
    private OrderValidateForECResponse orderValidateForECResponse;

    @XStreamAlias("createOrderForECResponse")
    private CreateOrderForECResponse createOrderForECResponse;

    @XStreamAlias("web:AREA_CODE_QRsp")
    private AreaCodeQrsp areaCodeQrsp;

    public OrderMealsRsp getOrderMealsRsp() {
        return orderMealsRsp;
    }

    public void setOrderMealsRsp(OrderMealsRsp orderMealsRsp) {
        this.orderMealsRsp = orderMealsRsp;
    }

    public CurrAcuRsp getCurrAcuRsp() {
        return currAcuRsp;
    }

    public void setCurrAcuRsp(CurrAcuRsp currAcuRsp) {
        this.currAcuRsp = currAcuRsp;
    }

    public OrderValidateForECResponse getOrderValidateForECResponse() {
        return orderValidateForECResponse;
    }

    public void setOrderValidateForECResponse(OrderValidateForECResponse orderValidateForECResponse) {
        this.orderValidateForECResponse = orderValidateForECResponse;
    }

    public CreateOrderForECResponse getCreateOrderForECResponse() {
        return createOrderForECResponse;
    }

    public void setCreateOrderForECResponse(CreateOrderForECResponse createOrderForECResponse) {
        this.createOrderForECResponse = createOrderForECResponse;
    }

    public AreaCodeQrsp getAreaCodeQrsp() {
        return areaCodeQrsp;
    }

    public void setAreaCodeQrsp(AreaCodeQrsp areaCodeQrsp) {
        this.areaCodeQrsp = areaCodeQrsp;
    }
}

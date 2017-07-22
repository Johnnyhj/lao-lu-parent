package com.ai.ge.platform.dto.order;

import com.ai.ge.platform.model.ws.Envelope;
import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;

/**
 * WebService调用过程监听上下文
 */
public class WebServiceContext {
    /**
     * 接口名称
     */
    private String actionName;
    /**
     * 调用接口Uri
     */
    private String requestUri;
    /**
     * 请求报文
     */
    private String requestMessage;

    /**
     * 响应报文
     */
    private String responseMessage;

    /**
     * 接口返回结果对象
     */
    private Envelope envelope;

    /**
     * 订单过程上下文
     */
    private OrderContext orderContext;

    /**
     * WebService执行日志
     */
    private LogInterfaceCallWithBLOBs logInterfaceCall;

    /**
     * 当前用户手机号码
     */
    private String phoneNum;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public OrderContext getOrderContext() {
        return orderContext;
    }

    public void setOrderContext(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    public LogInterfaceCallWithBLOBs getLogInterfaceCall() {
        return logInterfaceCall;
    }

    public void setLogInterfaceCall(LogInterfaceCallWithBLOBs logInterfaceCall) {
        this.logInterfaceCall = logInterfaceCall;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }
}

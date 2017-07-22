package com.ai.ge.platform.service.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 *
 */
public abstract class HttpRequestObject implements Serializable {

    /**
     * 接口名称
     */
    @JSONField(serialize = false)
    private String actionName;
    /**
     * 调用接口Uri
     */
    @JSONField(serialize = false)
    private String requestUri;
    /**
     * 请求报文
     */
    @JSONField(serialize = false)
    private String requestMessage;
    /**
     * 请求流水号
     */
    @JSONField(serialize = false)
    private String requestSeq;

    /**
     * 随机串，一个请求流水号发起多次支付
     */
    @JSONField(serialize = false)
    private String nonceStr;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
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

    public String getRequestSeq() {
        return requestSeq;
    }

    public void setRequestSeq(String requestSeq) {
        this.requestSeq = requestSeq;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

}

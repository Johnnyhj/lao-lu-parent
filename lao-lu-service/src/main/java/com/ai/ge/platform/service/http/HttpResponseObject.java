package com.ai.ge.platform.service.http;

import com.ai.ge.platform.result.ObjectResult;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 *
 */
public abstract class HttpResponseObject extends ObjectResult implements Serializable {
    /**
     * 响应报文
     */
    @JSONField(deserialize = false)
    private String responseMessage;
    /**
     * 接口调用时间
     */
    @JSONField(deserialize = false)
    private Long timeByCall;


    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    public Long getTimeByCall() {
        return timeByCall;
    }

    public void setTimeByCall(Long timeByCall) {
        this.timeByCall = timeByCall;
    }
}

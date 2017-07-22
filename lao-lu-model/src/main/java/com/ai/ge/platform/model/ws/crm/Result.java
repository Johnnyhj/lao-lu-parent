package com.ai.ge.platform.model.ws.crm;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by sx on 2016/3/16.
 */
public class Result {
    @XStreamAlias("result")
    private String result;

    @XStreamAlias("resultMsg")
    private String resultMsg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}

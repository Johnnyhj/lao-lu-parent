package com.ai.ge.platform.model.log;

public class LogInterfaceCallWithBLOBs extends LogInterfaceCall {
    private String params;

    private String resultText;

    private String failReason;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}
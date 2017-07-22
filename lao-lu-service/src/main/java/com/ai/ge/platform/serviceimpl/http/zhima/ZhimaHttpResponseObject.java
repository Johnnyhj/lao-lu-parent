package com.ai.ge.platform.serviceimpl.http.zhima;

import com.ai.ge.platform.service.http.HttpResponseObject;

/**
 *
 */
public class ZhimaHttpResponseObject extends HttpResponseObject {

    private boolean success;

    private String errorCode;

    private String errorMessage;

    private String body;

    private Param param;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }

    /**
     * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
     */
    private String bizNo;

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }


    public static class Param {
        private String params;

        public String getParams() {
            return params;
        }

        public void setParams(String params) {
            this.params = params;
        }
    }
}

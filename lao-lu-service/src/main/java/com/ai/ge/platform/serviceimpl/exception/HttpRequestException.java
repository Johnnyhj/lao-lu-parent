package com.ai.ge.platform.serviceimpl.exception;

/**
 * 网络请求异常
 */
public class HttpRequestException extends Exception {

    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public HttpRequestException(String message) {
        super(message);
    }

    public HttpRequestException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public HttpRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

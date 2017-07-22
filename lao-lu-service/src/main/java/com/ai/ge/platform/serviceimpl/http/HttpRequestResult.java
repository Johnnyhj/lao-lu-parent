package com.ai.ge.platform.serviceimpl.http;


import com.ai.ge.platform.result.ObjectResult;

/**
 *
 */
public class HttpRequestResult extends ObjectResult {
    public static final String SUCCESS_CODE = "1";
    public static final String ERROR_CODE = "0";

    private HttpRequestContext httpRequestContext;

    public HttpRequestContext getHttpRequestContext() {
        return httpRequestContext;
    }

    public void setHttpRequestContext(HttpRequestContext httpRequestContext) {
        this.httpRequestContext = httpRequestContext;
    }
}

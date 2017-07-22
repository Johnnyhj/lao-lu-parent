package com.ai.ge.platform.serviceimpl.http;


import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;
import com.ai.ge.platform.service.http.HttpRequestAuthObject;
import com.ai.ge.platform.service.http.HttpRequestObject;
import com.ai.ge.platform.service.http.HttpResponseObject;
import org.apache.commons.lang.CharEncoding;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 */
public class HttpRequestContext {

    public HttpRequestContext() {
    }

    public HttpRequestContext(HttpRequestObject httpRequestObject, HttpResponseObject httpResponseObject) {
        this.httpRequestObject = httpRequestObject;
        this.httpResponseObject = httpResponseObject;
    }

    public HttpRequestContext(HttpRequestAuthObject httpRequestAuthObject, HttpRequestObject httpRequestObject, HttpResponseObject httpResponseObject) {
        this.httpRequestAuthObject = httpRequestAuthObject;
        this.httpRequestObject = httpRequestObject;
        this.httpResponseObject = httpResponseObject;
    }

    /**
     * 接口请求认证对象
     */
    private HttpRequestAuthObject httpRequestAuthObject;

    /**
     * 接口请求对象
     */
    private HttpRequestObject httpRequestObject;

    /**
     * 接口返回结果对象
     */
    private HttpResponseObject httpResponseObject;

    /**
     * Http请求执行日志
     */
    private LogInterfaceCallWithBLOBs logInterfaceCall;


    private String contentType;

    private String charset = CharEncoding.UTF_8;


    private Map<String, Object> extend = new HashMap<String, Object>();

    /**
     * Post请求form-data请求参数
     */
    private Map<String, String> parameters = new TreeMap<String, String>();


    public HttpResponseObject getHttpResponseObject() {
        return httpResponseObject;
    }

    public void setHttpResponseObject(HttpResponseObject httpResponseObject) {
        this.httpResponseObject = httpResponseObject;
    }

    public LogInterfaceCallWithBLOBs getLogInterfaceCall() {
        return logInterfaceCall;
    }

    public void setLogInterfaceCall(LogInterfaceCallWithBLOBs logInterfaceCall) {
        this.logInterfaceCall = logInterfaceCall;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }


    public void setAttribute(String key, Object value) {
        extend.put(key, value);
    }

    public Object getAttribute(String key) {
        return extend.get(key);
    }

    public <T> T getAttribute(String key, Class<T> clazz) {
        return (T) extend.get(key);
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public HttpRequestAuthObject getHttpRequestAuthObject() {
        return httpRequestAuthObject;
    }

    public void setHttpRequestAuthObject(HttpRequestAuthObject httpRequestAuthObject) {
        this.httpRequestAuthObject = httpRequestAuthObject;
    }

    public HttpRequestObject getHttpRequestObject() {
        return httpRequestObject;
    }

    public void setHttpRequestObject(HttpRequestObject httpRequestObject) {
        this.httpRequestObject = httpRequestObject;
    }
}

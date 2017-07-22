package com.ai.ge.platform.serviceimpl.http;

import com.ai.ge.platform.dto.order.WebServiceContext;

/**
 * WebService调用过程监听
 */
public interface WebServiceProcessEventListener {
    /**
     * WebService调用过程前
     * @param webServiceContext
     */
    void preProcess(WebServiceContext webServiceContext);

    /**
     * WebService调用过程后
     *
     * @param webServiceContext
     */
    void postProcess(WebServiceContext webServiceContext);

    /**
     * WebService调用失败过程后
     *
     * @param webServiceContext
     * @param  ex
     */
    void exceptionProcess(WebServiceContext webServiceContext, Exception ex);
}

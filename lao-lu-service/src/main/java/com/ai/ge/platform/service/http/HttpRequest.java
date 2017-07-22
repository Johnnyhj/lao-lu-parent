package com.ai.ge.platform.service.http;

import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import org.apache.commons.httpclient.HttpMethodBase;

import java.io.IOException;
import java.util.Map;

/**
 * Http处理请求接口
 */
public interface HttpRequest {

    /**
     * 添加Http请求头
     *
     * @param method
     */
    void addRequestHeader(HttpMethodBase method);

    /**
     * 添加请求参数
     *
     * @param parameter
     */
    void addParameter(HttpMethodBase method, Map<String, String> parameter);

    /**
     * 对Http响应进行解析，默认直接按响应编码直接转String
     *
     * @param method
     * @return
     * @throws IOException
     */
    String getResponseBodyAsString(HttpMethodBase method) throws IOException;

    /**
     * 加载模板内容，拼装请求数据
     *
     * @param tempFile
     * @param params
     * @return
     */
    String getTemplateText(String tempFile, Map<String, Object> params);


    /**
     * 校验接口响应消息格式
     *
     * @param httpResponseObject
     * @throws BusinessException
     */
    void checkResponseMessage(HttpResponseObject httpResponseObject) throws BusinessException;

}

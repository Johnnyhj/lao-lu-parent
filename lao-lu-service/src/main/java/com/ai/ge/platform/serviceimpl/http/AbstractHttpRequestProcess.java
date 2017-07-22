package com.ai.ge.platform.serviceimpl.http;


import com.ai.ge.platform.mapper.log.LogInterfaceCallMapper;
import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;
import com.ai.ge.platform.model.log.LoggerStorageObject;
import com.ai.ge.platform.service.http.HttpRequestObject;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.log.LoggerStorageFactory;
import com.ai.ge.util.XmlObjectTransformUtils;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * HttpRequest接口默认实现
 */
public abstract class AbstractHttpRequestProcess extends AbstractHttpRequest {

    protected static final String SUCCESS_CODE = "0";

    protected static final String RESPONSE_MESSAGE_ERROR = "接口响应消息未按约定格式返回";

    private static final Logger logger = LoggerFactory.getLogger(AbstractHttpRequestProcess.class);

    @Resource
    private LogInterfaceCallMapper logInterfaceCallMapper;


    public HttpRequestResult process(HttpRequestContext httpRequestContext) throws BusinessException {
        HttpRequestResult httpRequestResult = new HttpRequestResult();

        HttpMethodBase method = getHttpMethod(httpRequestContext);
        addRequestHeader(method);
        HttpRequestObject httpRequestObject = httpRequestContext.getHttpRequestObject();
        if (method instanceof EntityEnclosingMethod && StringUtils.isNotBlank(httpRequestObject.getRequestMessage())) {
            StringRequestEntity stringRequestEntity = null;
            String contentType = httpRequestContext.getContentType(), charset = httpRequestContext.getCharset();
            if (StringUtils.isNotBlank(contentType) && StringUtils.isNotBlank(charset)) {
                try {
                    stringRequestEntity = new StringRequestEntity(httpRequestObject
                            .getRequestMessage(), contentType, charset);
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage(), e);

                    stringRequestEntity = new StringRequestEntity(httpRequestObject
                            .getRequestMessage());
                }
            } else {
                stringRequestEntity = new StringRequestEntity(httpRequestObject
                        .getRequestMessage());
            }
            ((EntityEnclosingMethod) method).setRequestEntity(stringRequestEntity);
        }

        /**
         * post请求参数
         */
        addParameter(method, httpRequestContext.getParameters());

        //日志文件
        LogInterfaceCallWithBLOBs logInterfaceCall = new LogInterfaceCallWithBLOBs();
        logInterfaceCall.setUrl(httpRequestObject.getRequestUri());
        logInterfaceCall.setParams(httpRequestObject.getRequestMessage());
        logInterfaceCall.setActionName(httpRequestObject.getActionName());
        logInterfaceCall.setRequestTimes(new Date());

        logInterfaceCall.setResult((short) 0);


        logInterfaceCall.setOrderGroupSeq(httpRequestObject.getRequestSeq());
//        logInterfaceCall.setNonceStr(httpRequestContext.getNonceStr());

        long timeByCall = System.currentTimeMillis();
        httpRequestContext.setLogInterfaceCall(logInterfaceCall);
        httpRequestContext.getHttpResponseObject().setTimeByCall(timeByCall);
        try {
            executeMethod(method, httpRequestContext);
        } catch (Exception e) {
            logInterfaceCall.setFailReason(e.getMessage());

            LoggerStorageFactory.add(this, logInterfaceCall);
            throw new BusinessException(e.getMessage());
        }

        if (isDebug) {
            logger.debug("接收接口调用返回数据处理......");
        }

        LoggerStorageFactory.add(this, logInterfaceCall);

        httpRequestResult.setResultCode(HttpRequestResult.SUCCESS_CODE);
        httpRequestResult.setHttpRequestContext(httpRequestContext);
        return httpRequestResult;
    }


    /**
     * 创建 HttpMethodBase 对象
     *
     * @param httpRequestContext
     * @return
     */
    protected HttpMethodBase getHttpMethod(HttpRequestContext httpRequestContext) {
        HttpRequestObject httpRequestObject = httpRequestContext.getHttpRequestObject();
        return new PostMethod(httpRequestObject.getRequestUri());
    }


    @Override
    protected void executeMethodPost(HttpMethodBase method, HttpRequestContext httpRequestContext)
            throws Exception {
        String responseMessage = getResponseBodyAsString(method);
        LogInterfaceCallWithBLOBs logInterfaceCall = httpRequestContext.getLogInterfaceCall();
        Integer statusCode = method.getStatusCode();
        long timeByCall = httpRequestContext.getHttpResponseObject().getTimeByCall();


        httpRequestContext.getHttpResponseObject().setResponseMessage(responseMessage);

        appendLogInterfaceCall(logInterfaceCall, statusCode.shortValue(), (int) (System.currentTimeMillis() -
                timeByCall));
        logInterfaceCall.setResultText(responseMessage);

        HttpResponseObject httpResponseObject = null;
        try {
            httpResponseObject = transform(responseMessage);

            checkResponseMessage(httpResponseObject);
        } catch (Exception e) {
            logInterfaceCall.setFailReason("响应包不符合约定格式，无法解析");
            if (isDebug) {
                logger.debug("解析响应包异常，响应包[" + responseMessage + "]", e);
            }

//            LoggerStorageFactory.add(this, logInterfaceCall);
            throw new BusinessException("服务器正忙，请稍后再试");
        }

        httpRequestContext.setHttpResponseObject(httpResponseObject);
        httpRequestContext.setLogInterfaceCall(logInterfaceCall);

        logInterfaceCall = getLogByCallProcess(httpRequestContext, null);

        httpRequestContext.setLogInterfaceCall(logInterfaceCall);
    }

    /**
     * 解析WebService数据响应包
     *
     * @param responseMessage Http请求响应字符串
     * @return
     */
    protected HttpResponseObject transform(String responseMessage) {
        return XmlObjectTransformUtils.transform(responseMessage, HttpResponseObject.class);
    }


    @Override
    protected void executeMethodException(HttpMethodBase method, Exception ex, HttpRequestContext httpRequestContext) throws Exception {
        LogInterfaceCallWithBLOBs logInterfaceCall = httpRequestContext.getLogInterfaceCall();
        long timeByCall = httpRequestContext.getHttpResponseObject().getTimeByCall();

        appendLogInterfaceCall(logInterfaceCall, null, (int) (System.currentTimeMillis() - timeByCall));
        httpRequestContext.setLogInterfaceCall(logInterfaceCall);

        logInterfaceCall = getLogByCallProcess(httpRequestContext, ex);
        LoggerStorageFactory.add(this, logInterfaceCall);
        httpRequestContext.setLogInterfaceCall(logInterfaceCall);

        throw new BusinessException("服务器正忙，请稍后再试");
    }


    /**
     * 添加Http请求头，SOAP1.1和SOAP1.2协议不一样，默认是1.2协议
     *
     * @param method
     */
    @Override
    public void addRequestHeader(HttpMethodBase method) {
        method.addRequestHeader("Content-Type", "application/xml; charset=utf-8;");
    }

    /**
     * 记录日志文件信息
     *
     * @param logInterfaceCall
     * @param httpCode           响应状态码
     * @param interfaceCallTimes 请求响应时间
     */
    protected void appendLogInterfaceCall(LogInterfaceCallWithBLOBs logInterfaceCall, Short httpCode, int
            interfaceCallTimes) {
        logInterfaceCall.setHttpCode(httpCode);
        logInterfaceCall.setInterfaceCallTimes(interfaceCallTimes);
        logInterfaceCall.setResponseTimes(new Date());
    }

    @Override
    public void saveObject(LoggerStorageObject object) {
        if (null == object) {
            logger.info("注入object对象为空");
            return;
        }

        if (object instanceof LogInterfaceCallWithBLOBs) {
            logInterfaceCallMapper.insertSelective((LogInterfaceCallWithBLOBs) object);
        } else {
            logger.info("注入object对象非LogInterfaceCall实例..." + object.getClass().getName());
        }
    }


    /**
     * 获取调用过程中的日志信息
     *
     * @param httpRequestContext
     * @param ex
     * @return
     */
    protected abstract LogInterfaceCallWithBLOBs getLogByCallProcess(HttpRequestContext httpRequestContext,
                                                                     Exception ex);

}

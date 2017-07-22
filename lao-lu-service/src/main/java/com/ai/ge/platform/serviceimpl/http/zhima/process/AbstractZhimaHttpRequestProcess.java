package com.ai.ge.platform.serviceimpl.http.zhima.process;

import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.http.HttpRequestAuthObject;
import com.ai.ge.platform.service.http.HttpRequestObject;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpRequestAuthObject;
import com.ai.ge.platform.serviceimpl.log.LoggerStorageFactory;
import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 *
 */

public abstract class AbstractZhimaHttpRequestProcess extends AbstractHttpRequestProcess {
    @Override
    public void checkResponseMessage(HttpResponseObject httpResponseObject) throws BusinessException {
    }


    @Override
    protected LogInterfaceCallWithBLOBs getLogByCallProcess(HttpRequestContext httpRequestContext, Exception ex) {
        LogInterfaceCallWithBLOBs logInterfaceCall = httpRequestContext.getLogInterfaceCall();

        //如果捕捉到异常信息
        if (null != ex) {
            logInterfaceCall.setFailReason(ex.getMessage());
        } else {
            HttpResponseObject httpResponseObject = httpRequestContext.getHttpResponseObject();
            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                //校验返回签名
                logInterfaceCall.setResult((short) 1);
            } else {
                String failReason = httpResponseObject.getResultMsg();

                logInterfaceCall.setResult((short) 0);
                logInterfaceCall.setFailReason(failReason);
            }
        }
        return logInterfaceCall;
    }

    /**
     * 请求参数报文
     *
     * @param httpRequestContext
     * @return
     */
    protected String getLogInterfaceParams(HttpRequestContext httpRequestContext) {
        return JSON.toJSONString(httpRequestContext.getHttpRequestObject());
    }


    @Override
    public HttpRequestResult process(HttpRequestContext httpRequestContext) throws BusinessException {
        HttpRequestAuthObject httpRequestAuthObject = httpRequestContext.getHttpRequestAuthObject();
        if (null == httpRequestAuthObject) {
            httpRequestAuthObject = getHttpRequestAuthObject();
            httpRequestContext.setHttpRequestAuthObject(httpRequestAuthObject);
        }


        HttpRequestObject httpRequestObject = httpRequestContext.getHttpRequestObject();

        LogInterfaceCallWithBLOBs logInterfaceCall = new LogInterfaceCallWithBLOBs();
        logInterfaceCall.setUrl(httpRequestObject.getRequestUri());
        logInterfaceCall.setParams(getLogInterfaceParams(httpRequestContext));
        logInterfaceCall.setActionName(httpRequestObject.getActionName());
        logInterfaceCall.setRequestTimes(new Date());

        logInterfaceCall.setResult((short) 0);
        long timeByCall = System.currentTimeMillis();
        httpRequestContext.setLogInterfaceCall(logInterfaceCall);
        HttpResponseObject httpResponseObject = httpRequestContext.getHttpResponseObject();
        httpResponseObject.setTimeByCall(timeByCall);

        beforeProcess(httpRequestContext);

        Exception processException = null;

        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = afterProcess(httpRequestContext);

            logInterfaceCall.setHttpCode((short) 200);
            logInterfaceCall.setResultText(JSON.toJSONString(httpResponseObject));
            logInterfaceCall = getLogByCallProcess(httpRequestContext, null);
        } catch (Exception e) {
            processException(httpRequestContext, e);

            logInterfaceCall = getLogByCallProcess(httpRequestContext, e);
            processException = e;
        }
        logInterfaceCall.setResponseTimes(new Date());
        logInterfaceCall.setInterfaceCallTimes((int) (logInterfaceCall.getResponseTimes().getTime() - logInterfaceCall.getRequestTimes().getTime()));

        LoggerStorageFactory.add(this, logInterfaceCall);
        if (null != processException) {
            //抛出异常
            throw new BusinessException(processException.getMessage());
        }

        return httpRequestResult;
    }

    protected HttpRequestAuthObject getHttpRequestAuthObject() {
        String appId = sysDataService.getByKeyType("zhima_app_id", SysDataService.WEB_APP);
        String privateKey = sysDataService.getByKeyType("zhima_private_key", SysDataService.WEB_APP);
        String publicKey = sysDataService.getByKeyType("zhima_public_key", SysDataService.WEB_APP);


        return new ZhimaHttpRequestAuthObject(appId, privateKey, publicKey);
    }


    protected void beforeProcess(HttpRequestContext httpRequestContext) throws BusinessException {
    }

    protected abstract HttpRequestResult afterProcess(HttpRequestContext httpRequestContext) throws BusinessException;

    protected void processException(HttpRequestContext httpRequestContext, Exception ex) {
    }


}

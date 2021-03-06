package com.ai.ge.platform.serviceimpl.http.zhima.process;

import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaGetScoreHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaGetScoreHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpRequestAuthObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpResponseObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;
import com.antgroup.zmxy.openplatform.api.ZhimaApiException;
import com.antgroup.zmxy.openplatform.api.request.ZhimaCreditScoreGetRequest;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditScoreGetResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

/**
 * 查询芝麻用户的芝麻信用评分
 */

@Component("zhimaGetScoreHttpRequestProcess")
public class ZhimaGetScoreHttpRequestProcess extends AbstractZhimaHttpRequestProcess {

    private static Logger logger = LoggerFactory.getLogger(ZhimaOrderConfirmHttpRequestProcess.class);


    @Override
    protected HttpResponseObject transform(String responseMessage) {
        return null;
    }

    @Override
    public void addRequestHeader(HttpMethodBase method) {
    }

    @Override
    protected HttpRequestResult afterProcess(HttpRequestContext httpRequestContext) throws BusinessException {
        HttpRequestResult httpRequestResult = new HttpRequestResult();

        ZhimaHttpRequestAuthObject httpRequestAuthObject = (ZhimaHttpRequestAuthObject) httpRequestContext.getHttpRequestAuthObject();
        ZhimaGetScoreHttpRequestObject httpRequestObject = (ZhimaGetScoreHttpRequestObject) httpRequestContext.getHttpRequestObject();
        ZhimaGetScoreHttpResponseObject httpResponseObject = (ZhimaGetScoreHttpResponseObject) httpRequestContext.getHttpResponseObject();

        ZhimaCreditScoreGetRequest req = new ZhimaCreditScoreGetRequest();
        req.setChannel("apppc");
        req.setPlatform(httpRequestObject.getPlatform());
        req.setTransactionId(httpRequestObject.getTransactionId());// 必要参数
        req.setProductCode(httpRequestObject.getProductCode());// 必要参数
        req.setOpenId(httpRequestObject.getOpenId());// 必要参数

        DefaultZhimaClient client = new DefaultZhimaClient(httpRequestObject.getRequestUri(), httpRequestAuthObject.getAppId(),
                httpRequestAuthObject.getPrivateKey(), httpRequestAuthObject.getPublicKey());
        try {
            //TODO 测试桩
//            ZhimaCreditScoreGetResponse response = client.execute(req);
            ZhimaCreditScoreGetResponse response = testPileData(httpRequestObject.getRequestUri());


            BeanUtils.copyProperties(response, httpResponseObject, new String[]{"params"});

            ZhimaHttpResponseObject.Param param = new ZhimaHttpResponseObject.Param();
            param.setParams(response.getParams().get("params"));
            httpResponseObject.setParam(param);


            if (response.isSuccess()) {
                httpResponseObject.setResultCode(ObjectResult.SUCCESS_CODE);
            } else {
                httpResponseObject.setResultCode(response.getErrorCode());
                httpResponseObject.setResultMsg(response.getErrorMessage());
            }

        } catch (ZhimaApiException e) {
            throw new BusinessException(e.getMessage(), e);
        }


        httpRequestResult.setResultCode(HttpRequestResult.SUCCESS_CODE);
        httpRequestResult.setHttpRequestContext(httpRequestContext);
        return httpRequestResult;
    }


    protected ZhimaCreditScoreGetResponse testPileData(String requestUri) throws ZhimaApiException {
        HttpClient httpClient = new HttpClient();

        PostMethod postMethod = new PostMethod(requestUri);
        String responseText = null;
        try {
            httpClient.executeMethod(postMethod);

            responseText = postMethod.getResponseBodyAsString();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }


        JSONObject parseObject = JSON.parseObject(responseText);

        ZhimaCreditScoreGetResponse response = new ZhimaCreditScoreGetResponse();

        response.setSuccess(parseObject.getBoolean("success"));
        response.setZmScore(parseObject.getString("zmScore"));
        response.setBizNo(parseObject.getString("bizNo"));
        response.setBody(parseObject.getString("body"));

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("params", parseObject.getJSONObject("params").getString("params"));
        response.setParams(params);

        postMethod.releaseConnection();

        return response;
    }
}

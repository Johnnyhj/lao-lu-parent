package com.ai.ge.platform.serviceimpl.http.zhima.process;

import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpRequestAuthObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaSingleFeedbackHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaSingleFeedbackHttpResponseObject;
import com.alibaba.fastjson.JSON;
import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;
import com.antgroup.zmxy.openplatform.api.ZhimaApiException;
import com.antgroup.zmxy.openplatform.api.request.ZhimaDataSingleFeedbackRequest;
import com.antgroup.zmxy.openplatform.api.response.ZhimaDataSingleFeedbackResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 单条数据反馈服务接口
 */

@Component("zhimaSingleFeedbackHttpRequestProcess")
public class ZhimaSingleFeedbackHttpRequestProcess extends AbstractZhimaHttpRequestProcess {

    private static Logger logger = LoggerFactory.getLogger(ZhimaSingleFeedbackHttpRequestProcess.class);


    protected String getSingleFeedbackTypeId() {
        return sysDataService.getByKeyType("single_feedback_type_id", SysDataService.WEB_APP);
    }

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
        ZhimaSingleFeedbackHttpRequestObject httpRequestObject = (ZhimaSingleFeedbackHttpRequestObject) httpRequestContext.getHttpRequestObject();
        ZhimaSingleFeedbackHttpResponseObject httpResponseObject = (ZhimaSingleFeedbackHttpResponseObject) httpRequestContext.getHttpResponseObject();

        ZhimaDataSingleFeedbackRequest req = new ZhimaDataSingleFeedbackRequest();
        req.setChannel("apppc");

        req.setPlatform(httpRequestObject.getPlatform());
        req.setTypeId(getSingleFeedbackTypeId());
        req.setIdentity("biz_date#user_credentials_type#user_credentials_no#order_no#bill_no#bill_type");

        req.setData(JSON.toJSONString(httpRequestObject.getBatchFeedback()));
//        req.setBizExtParams(" {\" extparam1\" :\" value1\" }");

        DefaultZhimaClient client = new DefaultZhimaClient(httpRequestObject.getRequestUri(), httpRequestAuthObject.getAppId(),
                httpRequestAuthObject.getPrivateKey(), httpRequestAuthObject.getPublicKey());
        try {
            //TODO 测试桩
//            ZhimaDataSingleFeedbackResponse response = client.execute(req);
            ZhimaDataSingleFeedbackResponse response = testPileData(httpRequestObject.getRequestUri());


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


    protected ZhimaDataSingleFeedbackResponse testPileData(String requestUri) throws ZhimaApiException {
        HttpClient httpClient = new HttpClient();

        PostMethod postMethod = new PostMethod(requestUri);
        String responseText = null;
        try {
            httpClient.executeMethod(postMethod);

            responseText = postMethod.getResponseBodyAsString();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }


        ZhimaDataSingleFeedbackResponse response = JSON.parseObject(responseText, ZhimaDataSingleFeedbackResponse.class);

//        ZhimaCreditScoreGetResponse response = new ZhimaCreditScoreGetResponse();
//
//        response.setSuccess(parseObject.getBoolean("success"));
//        response.setZmScore(parseObject.getString("zmScore"));
//        response.setBizNo(parseObject.getString("bizNo"));
//        response.setBody(parseObject.getString("body"));
//
//        HashMap<String, String> params = new HashMap<String, String>();
//        params.put("params", parseObject.getJSONObject("params").getString("params"));
//        response.setParams(params);

        postMethod.releaseConnection();

        return response;
    }
}

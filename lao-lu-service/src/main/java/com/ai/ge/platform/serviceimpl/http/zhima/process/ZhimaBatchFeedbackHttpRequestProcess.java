package com.ai.ge.platform.serviceimpl.http.zhima.process;

import com.ai.ge.platform.dto.log.LogDataBatchFeedbackDto;
import com.ai.ge.platform.model.log.LogDataBatchFeedbackDetail;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.service.log.LogDataBatchFeedbackService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaBatchFeedbackHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaBatchFeedbackHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpRequestAuthObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpResponseObject;
import com.alibaba.fastjson.JSON;
import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;
import com.antgroup.zmxy.openplatform.api.FileItem;
import com.antgroup.zmxy.openplatform.api.ZhimaApiException;
import com.antgroup.zmxy.openplatform.api.request.ZhimaDataBatchFeedbackRequest;
import com.antgroup.zmxy.openplatform.api.response.ZhimaDataBatchFeedbackResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * 批量数据反馈服务接口
 */

@Component("zhimaBatchFeedbackHttpRequestProcess")
public class ZhimaBatchFeedbackHttpRequestProcess extends AbstractZhimaHttpRequestProcess {

    private static final String LOG_DATA_KEY = "logDataBatchFeedbackDto";

    private static Logger logger = LoggerFactory.getLogger(ZhimaBatchFeedbackHttpRequestProcess.class);

    protected String getBatchFeedbackTypeId() {
        return sysDataService.getByKeyType("batch_feedback_type_id", SysDataService.WEB_APP);
    }

    @Resource
    private LogDataBatchFeedbackService logDataBatchFeedbackService;

    @Override
    protected HttpResponseObject transform(String responseMessage) {
        return null;
    }

    @Override
    public void addRequestHeader(HttpMethodBase method) {
    }

    @Override
    protected String getLogInterfaceParams(HttpRequestContext httpRequestContext) {
        return StringUtils.EMPTY;
    }


    @Override
    protected void beforeProcess(HttpRequestContext httpRequestContext) throws BusinessException {
        LogDataBatchFeedbackDto logDataBatchFeedbackDto = logDataBatchFeedbackService.saveDataBatchFeedback(httpRequestContext, null);

        logDataBatchFeedbackDto = logDataBatchFeedbackService.saveSplitDataBatchFeedback(logDataBatchFeedbackDto, null);

        httpRequestContext.setAttribute(LOG_DATA_KEY, logDataBatchFeedbackDto);
    }

    @Override
    protected HttpRequestResult afterProcess(HttpRequestContext httpRequestContext) throws BusinessException {
        HttpRequestResult httpRequestResult = new HttpRequestResult();

        ZhimaHttpRequestAuthObject httpRequestAuthObject = (ZhimaHttpRequestAuthObject) httpRequestContext.getHttpRequestAuthObject();
        ZhimaBatchFeedbackHttpRequestObject httpRequestObject = (ZhimaBatchFeedbackHttpRequestObject) httpRequestContext.getHttpRequestObject();
        ZhimaBatchFeedbackHttpResponseObject httpResponseObject = (ZhimaBatchFeedbackHttpResponseObject) httpRequestContext.getHttpResponseObject();

        ZhimaDataBatchFeedbackRequest req = new ZhimaDataBatchFeedbackRequest();
        req.setChannel("apppc");
        req.setPlatform(httpRequestObject.getPlatform());

        req.setFileType("json_data");// 必要参数
        req.setFileCharset("UTF-8");// 必要参数

        req.setColumns("biz_date,user_credentials_type,user_credentials_no,user_name,order_no,phone_no,order_start_date,order_end_date,order_status,bill_no,bill_installment,bill_desc,bill_type,bill_amt,bill_last_date,bill_status,bill_payoff_date,bill_type_ovd_amt,bill_type_ovd_date,memo");// 必要参数
        req.setPrimaryKeyColumns("biz_date,user_credentials_type,user_credentials_no,order_no,bill_no,bill_type");// 必要参数
        req.setFileDescription("信用套餐履约信息");//
        req.setTypeId(getBatchFeedbackTypeId());// 必要参数
//        req.setBizExtParams("{\"extparam1\":\"value1\"}");//


        DefaultZhimaClient client = new DefaultZhimaClient(httpRequestObject.getRequestUri(), httpRequestAuthObject.getAppId(),
                httpRequestAuthObject.getPrivateKey(), httpRequestAuthObject.getPublicKey());
        try {
            ZhimaDataBatchFeedbackResponse response = null;
            int pushStatusFlag = 0;


            LogDataBatchFeedbackDto logDataBatchFeedbackDto = httpRequestContext.getAttribute(LOG_DATA_KEY, LogDataBatchFeedbackDto.class);

            logDataBatchFeedbackDto.setPushTime(new Date());
            for (LogDataBatchFeedbackDetail logDataBatchFeedbackDetail : logDataBatchFeedbackDto.getLogDataBatchFeedbackDetails()) {
                req.setRecords(String.valueOf(logDataBatchFeedbackDetail.getDataNum()));// 必要参数
                req.setFile(new FileItem(logDataBatchFeedbackDetail.getSplitFilePath()));// 必要参数

                logDataBatchFeedbackDetail.setPushTime(new Date());

                //TODO 测试桩
//            response = client.execute(req);
                response = testPileData(httpRequestObject.getRequestUri());

                logDataBatchFeedbackDetail.setPushCompleteTime(new Date());
                if (response.isSuccess()) {
                    logDataBatchFeedbackDetail.setPushStatus(0);

                    pushStatusFlag++;
                } else {
                    logDataBatchFeedbackDetail.setPushStatus(1);
                    break;
                }
            }
            logDataBatchFeedbackDto.setPushCompleteTime(new Date());


            //更新推送日志
            int pushStatus = 1;
            if (pushStatusFlag == logDataBatchFeedbackDto.getLogDataBatchFeedbackDetails().size()) {
                pushStatus = 0;
            } else if (0 < pushStatusFlag) {
                pushStatus = 2;
            }

            logDataBatchFeedbackDto.setPushStatus(pushStatus);
            logDataBatchFeedbackService.saveOrUpdateObject(logDataBatchFeedbackDto);

            //返回推送结果
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


    protected ZhimaDataBatchFeedbackResponse testPileData(String requestUri) throws ZhimaApiException {
        HttpClient httpClient = new HttpClient();

        PostMethod postMethod = new PostMethod(requestUri);
        String responseText = null;
        try {
            httpClient.executeMethod(postMethod);

            responseText = postMethod.getResponseBodyAsString();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }


        ZhimaDataBatchFeedbackResponse response = JSON.parseObject(responseText, ZhimaDataBatchFeedbackResponse.class);

        postMethod.releaseConnection();

        return response;
    }
}

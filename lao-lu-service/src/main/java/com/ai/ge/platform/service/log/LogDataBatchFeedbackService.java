package com.ai.ge.platform.service.log;

import com.ai.ge.platform.dto.log.LogDataBatchFeedbackDto;
import com.ai.ge.platform.model.log.LogDataBatchFeedback;
import com.ai.ge.platform.model.log.LogDataBatchFeedbackDetail;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;

/**
 * 批量反馈数据日志
 */
public interface LogDataBatchFeedbackService {

    /**
     * 查询单条数据
     *
     * @param object
     * @return
     */
    LogDataBatchFeedbackDto getObjectByObject(LogDataBatchFeedback object);

    /**
     * 保存或更新数据
     *
     * @param object
     * @return
     */
    int saveOrUpdateObject(LogDataBatchFeedbackDto object);


    /**
     * 保存 批量反馈日志到日志文件
     *
     * @param httpRequestContext
     * @param directory          保存后的JSON文件存放目录
     */
    LogDataBatchFeedbackDto saveDataBatchFeedback(HttpRequestContext httpRequestContext, String directory) throws BusinessException;

    /**
     * 保存 拆分批量反馈日志文件
     *
     * @param logDataBatchFeedbackDto
     * @param directory
     */
    LogDataBatchFeedbackDto saveSplitDataBatchFeedback(LogDataBatchFeedbackDto logDataBatchFeedbackDto, String directory) throws BusinessException;

    /**
     * 文件推送详情
     *
     * @param logDataBatchFeedbackDetail
     * @param pushStatus                 0.推头成功，1.推送失败
     * @param failReason
     */
    void publishByLogBatchFeedbackDetail(LogDataBatchFeedbackDetail logDataBatchFeedbackDetail, int pushStatus, String failReason);

    /**
     * 文件推送日志
     *
     * @param logDataBatchFeedbackDto
     * @param pushStatus              0.推头成功，1.推送失败，2.部分推送成功
     * @param failReason
     */
    void publishByLogBatchFeedback(LogDataBatchFeedbackDto logDataBatchFeedbackDto, int pushStatus, String failReason);

    /**
     * 更新文件推送日志
     *
     * @param logDataBatchFeedbackDto
     */
    void publishByLogBatchFeedback(LogDataBatchFeedbackDto logDataBatchFeedbackDto);
}

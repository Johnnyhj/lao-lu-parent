package com.ai.ge.platform.serviceimpl.http.zhima;

import com.ai.ge.platform.serviceimpl.http.zhima.request.BatchFeedback;

import java.util.List;

/**
 * 批量反馈接口
 */
public class ZhimaBatchFeedbackHttpRequestObject extends ZhimaHttpRequestObject {

    private String transactionId;

    private List<BatchFeedback> batchFeedbacks;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public List<BatchFeedback> getBatchFeedbacks() {
        return batchFeedbacks;
    }

    public void setBatchFeedbacks(List<BatchFeedback> batchFeedbacks) {
        this.batchFeedbacks = batchFeedbacks;
    }
}

package com.ai.ge.platform.serviceimpl.http.zhima;

import com.ai.ge.platform.serviceimpl.http.zhima.request.BatchFeedback;

/**
 * 单条数据反馈服务接口
 */
public class ZhimaSingleFeedbackHttpRequestObject extends ZhimaHttpRequestObject {


    private BatchFeedback batchFeedback;


    public BatchFeedback getBatchFeedback() {
        return batchFeedback;
    }

    public void setBatchFeedback(BatchFeedback batchFeedback) {
        this.batchFeedback = batchFeedback;
    }
}

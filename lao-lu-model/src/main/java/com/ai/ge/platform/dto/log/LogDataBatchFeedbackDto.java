package com.ai.ge.platform.dto.log;

import com.ai.ge.platform.model.log.LogDataBatchFeedback;
import com.ai.ge.platform.model.log.LogDataBatchFeedbackDetail;

import java.util.List;

/**
 *
 */
public class LogDataBatchFeedbackDto extends LogDataBatchFeedback {

    private List<LogDataBatchFeedbackDetail> logDataBatchFeedbackDetails;

    public List<LogDataBatchFeedbackDetail> getLogDataBatchFeedbackDetails() {
        return logDataBatchFeedbackDetails;
    }

    public void setLogDataBatchFeedbackDetails(List<LogDataBatchFeedbackDetail> logDataBatchFeedbackDetails) {
        this.logDataBatchFeedbackDetails = logDataBatchFeedbackDetails;
    }
}

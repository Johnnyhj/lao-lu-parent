package com.ai.ge.platform.mapper.log;

import com.ai.ge.platform.model.log.LogDataBatchFeedbackDetail;
import com.ai.ge.platform.model.log.LogDataBatchFeedbackDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDataBatchFeedbackDetailMapper {
    int countByExample(LogDataBatchFeedbackDetailExample example);

    int deleteByExample(LogDataBatchFeedbackDetailExample example);

    int deleteByPrimaryKey(Integer logFeedbackDetailId);

    int deleteBylogFeedbackId(Integer logFeedbackId);

    int insert(LogDataBatchFeedbackDetail record);

    int insertBatch(@Param("records") List<LogDataBatchFeedbackDetail> records, @Param("logFeedbackId") Integer logFeedbackId);

    int insertSelective(LogDataBatchFeedbackDetail record);

    List<LogDataBatchFeedbackDetail> selectByExample(LogDataBatchFeedbackDetailExample example);

    LogDataBatchFeedbackDetail selectByPrimaryKey(Integer logFeedbackDetailId);

    int updateByExampleSelective(@Param("record") LogDataBatchFeedbackDetail record, @Param("example") LogDataBatchFeedbackDetailExample example);

    int updateByExample(@Param("record") LogDataBatchFeedbackDetail record, @Param("example") LogDataBatchFeedbackDetailExample example);

    int updateByPrimaryKeySelective(LogDataBatchFeedbackDetail record);

    int updateByPrimaryKey(LogDataBatchFeedbackDetail record);
}
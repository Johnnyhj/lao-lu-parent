package com.ai.ge.platform.mapper.log;

import com.ai.ge.platform.model.log.LogDataBatchFeedback;
import com.ai.ge.platform.model.log.LogDataBatchFeedbackExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDataBatchFeedbackMapper {
    int countByExample(LogDataBatchFeedbackExample example);

    int deleteByExample(LogDataBatchFeedbackExample example);

    int deleteByPrimaryKey(Integer logFeedbackId);

    int insert(LogDataBatchFeedback record);

    int insertSelective(LogDataBatchFeedback record);

    List<LogDataBatchFeedback> selectByExample(LogDataBatchFeedbackExample example);

    LogDataBatchFeedback selectByPrimaryKey(Integer logFeedbackId);

    int updateByExampleSelective(@Param("record") LogDataBatchFeedback record, @Param("example") LogDataBatchFeedbackExample example);

    int updateByExample(@Param("record") LogDataBatchFeedback record, @Param("example") LogDataBatchFeedbackExample example);

    int updateByPrimaryKeySelective(LogDataBatchFeedback record);

    int updateByPrimaryKey(LogDataBatchFeedback record);
}
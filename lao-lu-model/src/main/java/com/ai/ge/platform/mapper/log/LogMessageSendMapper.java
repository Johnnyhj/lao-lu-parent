package com.ai.ge.platform.mapper.log;

import com.ai.ge.platform.model.log.LogMessageSend;
import com.ai.ge.platform.model.log.LogMessageSendExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMessageSendMapper {
    int countByExample(LogMessageSendExample example);

    int deleteByExample(LogMessageSendExample example);

    int deleteByPrimaryKey(Long messageSendId);

    int insert(LogMessageSend record);

    int insertSelective(LogMessageSend record);

    List<LogMessageSend> selectByExample(LogMessageSendExample example);

    LogMessageSend selectByPrimaryKey(Long messageSendId);

    int updateByExampleSelective(@Param("record") LogMessageSend record, @Param("example") LogMessageSendExample example);

    int updateByExample(@Param("record") LogMessageSend record, @Param("example") LogMessageSendExample example);

    int updateByPrimaryKeySelective(LogMessageSend record);

    int updateByPrimaryKey(LogMessageSend record);

    List<LogMessageSend> selectBySelective(LogMessageSend record);

}
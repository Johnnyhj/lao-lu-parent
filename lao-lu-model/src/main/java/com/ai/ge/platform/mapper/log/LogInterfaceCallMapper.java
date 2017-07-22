package com.ai.ge.platform.mapper.log;

import com.ai.ge.platform.model.log.LogInterfaceCall;
import com.ai.ge.platform.model.log.LogInterfaceCallExample;
import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogInterfaceCallMapper {
    int countByExample(LogInterfaceCallExample example);

    int deleteByExample(LogInterfaceCallExample example);

    int deleteByPrimaryKey(Long interfaceCallId);

    int insert(LogInterfaceCallWithBLOBs record);

    int insertSelective(LogInterfaceCallWithBLOBs record);

    List<LogInterfaceCallWithBLOBs> selectByExampleWithBLOBs(LogInterfaceCallExample example);

    List<LogInterfaceCall> selectByExample(LogInterfaceCallExample example);

    LogInterfaceCallWithBLOBs selectByPrimaryKey(Long interfaceCallId);

    int updateByExampleSelective(@Param("record") LogInterfaceCallWithBLOBs record, @Param("example") LogInterfaceCallExample example);

    int updateByExampleWithBLOBs(@Param("record") LogInterfaceCallWithBLOBs record, @Param("example") LogInterfaceCallExample example);

    int updateByExample(@Param("record") LogInterfaceCall record, @Param("example") LogInterfaceCallExample example);

    int updateByPrimaryKeySelective(LogInterfaceCallWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogInterfaceCallWithBLOBs record);

    int updateByPrimaryKey(LogInterfaceCall record);
}
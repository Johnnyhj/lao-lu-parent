package com.ai.ge.platform.mapper.log;

import com.ai.ge.platform.model.log.LogAuthProcess;
import com.ai.ge.platform.model.log.LogAuthProcessWithBLOBs;
import com.ai.ge.platform.dto.log.LogAuthProcessDto;
import com.ai.ge.platform.model.log.LogAuthProcessExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LogAuthProcessMapper {
    int countByExample(LogAuthProcessExample example);

    int deleteByExample(LogAuthProcessExample example);

    int deleteByPrimaryKey(Long processId);

    int insert(LogAuthProcessWithBLOBs record);

    int insertSelective(LogAuthProcessWithBLOBs record);

    List<LogAuthProcessWithBLOBs> selectByExampleWithBLOBs(LogAuthProcessExample example);

    List<LogAuthProcess> selectByExample(LogAuthProcessExample example);

    LogAuthProcessWithBLOBs selectByPrimaryKey(Long processId);

    int updateByExampleSelective(@Param("record") LogAuthProcessWithBLOBs record, @Param("example") LogAuthProcessExample example);

    int updateByExampleWithBLOBs(@Param("record") LogAuthProcessWithBLOBs record, @Param("example") LogAuthProcessExample example);

    int updateByExample(@Param("record") LogAuthProcess record, @Param("example") LogAuthProcessExample example);

    int updateByPrimaryKeySelective(LogAuthProcessWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogAuthProcessWithBLOBs record);

    int updateByPrimaryKey(LogAuthProcess record);

    List<LogAuthProcessDto> findAllLog(LogAuthProcessWithBLOBs logAuthProcess);

    LogAuthProcessDto queryLogDetailByProcessId(Long processId);

}
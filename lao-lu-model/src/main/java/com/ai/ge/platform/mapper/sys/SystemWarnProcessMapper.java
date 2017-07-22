package com.ai.ge.platform.mapper.sys;

import com.ai.ge.platform.model.sys.SystemWarnProcess;
import com.ai.ge.platform.model.sys.SystemWarnProcessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemWarnProcessMapper {
    int countByExample(SystemWarnProcessExample example);

    int deleteByExample(SystemWarnProcessExample example);

    int deleteByPrimaryKey(Long systemWarnProcessId);

    int insert(SystemWarnProcess record);

    int insertSelective(SystemWarnProcess record);

    List<SystemWarnProcess> selectByExample(SystemWarnProcessExample example);

    SystemWarnProcess selectByPrimaryKey(Long systemWarnProcessId);

    int updateByExampleSelective(@Param("record") SystemWarnProcess record, @Param("example") SystemWarnProcessExample example);

    int updateByExample(@Param("record") SystemWarnProcess record, @Param("example") SystemWarnProcessExample example);

    int updateByPrimaryKeySelective(SystemWarnProcess record);

    int updateByPrimaryKey(SystemWarnProcess record);
}
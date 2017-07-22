package com.ai.ge.platform.mapper.auth;

import com.ai.ge.platform.model.auth.SystemAuthorizationHistory;
import com.ai.ge.platform.model.auth.SystemAuthorizationHistoryExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemAuthorizationHistoryMapper {
    int countByExample(SystemAuthorizationHistoryExample example);

    int deleteByExample(SystemAuthorizationHistoryExample example);

    int deleteByPrimaryKey(Long sysAuthId);

    int insert(SystemAuthorizationHistory record);

    int insertSelective(SystemAuthorizationHistory record);

    List<SystemAuthorizationHistory> selectByExample(SystemAuthorizationHistoryExample example);

    SystemAuthorizationHistory selectByPrimaryKey(Long sysAuthId);

    int updateByExampleSelective(@Param("record") SystemAuthorizationHistory record, @Param("example") SystemAuthorizationHistoryExample example);

    int updateByExample(@Param("record") SystemAuthorizationHistory record, @Param("example") SystemAuthorizationHistoryExample example);

    int updateByPrimaryKeySelective(SystemAuthorizationHistory record);

    int updateByPrimaryKey(SystemAuthorizationHistory record);
}
package com.ai.ge.platform.mapper.auth;

import com.ai.ge.platform.model.auth.SystemAuthorization;
import com.ai.ge.platform.model.auth.SystemAuthorizationExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemAuthorizationMapper {
    int countByExample(SystemAuthorizationExample example);

    int deleteByExample(SystemAuthorizationExample example);

    int deleteByPrimaryKey(Long sysAuthId);

    int insert(SystemAuthorization record);

    int insertSelective(SystemAuthorization record);

    List<SystemAuthorization> selectByExample(SystemAuthorizationExample example);

    SystemAuthorization selectByPrimaryKey(Long sysAuthId);

    int updateByExampleSelective(@Param("record") SystemAuthorization record, @Param("example") SystemAuthorizationExample example);

    int updateByExample(@Param("record") SystemAuthorization record, @Param("example") SystemAuthorizationExample example);

    int updateByPrimaryKeySelective(SystemAuthorization record);

    int updateByPrimaryKey(SystemAuthorization record);
}
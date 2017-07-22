package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.dto.user.SysUserRoleReleationDto;
import com.ai.ge.platform.model.user.SysUserRoleReleation;
import com.ai.ge.platform.model.user.SysUserRoleReleationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserRoleReleationMapper {
    int countByExample(SysUserRoleReleationExample example);

    int deleteByExample(SysUserRoleReleationExample example);

    int insert(SysUserRoleReleation record);

    int insertSelective(SysUserRoleReleation record);

    List<SysUserRoleReleation> selectByExample(SysUserRoleReleationExample example);

    int updateByExampleSelective(@Param("record") SysUserRoleReleation record, @Param("example")
    SysUserRoleReleationExample example);

    int updateByExample(@Param("record") SysUserRoleReleation record, @Param("example") SysUserRoleReleationExample
            example);


    List<SysUserRoleReleationDto> selectSysUserRoleByUserId(Map<String, Object> params);

    int deleteByUserIdOrRoleId(@Param("userId") Long userId, @Param("roleId") Long roleId);
}
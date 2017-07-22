package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.model.user.SysRoleResourceReleation;
import com.ai.ge.platform.model.user.SysRoleResourceReleationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleResourceReleationMapper {
    int countByExample(SysRoleResourceReleationExample example);

    int deleteByExample(SysRoleResourceReleationExample example);

    int insert(SysRoleResourceReleation record);

    int insertSelective(SysRoleResourceReleation record);

    List<SysRoleResourceReleation> selectByExample(SysRoleResourceReleationExample example);

    int updateByExampleSelective(@Param("record") SysRoleResourceReleation record, @Param("example") SysRoleResourceReleationExample example);

    int updateByExample(@Param("record") SysRoleResourceReleation record, @Param("example") SysRoleResourceReleationExample example);
}
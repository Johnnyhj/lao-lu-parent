package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.model.user.SysUserOrganization;
import com.ai.ge.platform.model.user.SysUserOrganizationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserOrganizationMapper {
    int countByExample(SysUserOrganizationExample example);

    int deleteByExample(SysUserOrganizationExample example);

    int deleteByPrimaryKey(Long suoId);

    int insert(SysUserOrganization record);

    int insertSelective(SysUserOrganization record);

    List<SysUserOrganization> selectByExample(SysUserOrganizationExample example);

    SysUserOrganization selectByPrimaryKey(Long suoId);

    int updateByExampleSelective(@Param("record") SysUserOrganization record, @Param("example") SysUserOrganizationExample example);

    int updateByExample(@Param("record") SysUserOrganization record, @Param("example") SysUserOrganizationExample example);

    int updateByPrimaryKeySelective(SysUserOrganization record);

    int updateByPrimaryKey(SysUserOrganization record);

    int deleteByUserIdOrOrgaId(@Param("userId") Long userId, @Param("orgaId") Long orgaId);
}
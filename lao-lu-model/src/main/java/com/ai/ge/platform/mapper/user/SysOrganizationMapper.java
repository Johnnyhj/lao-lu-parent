package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.model.user.SysOrganization;
import com.ai.ge.platform.model.user.SysOrganizationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrganizationMapper {
    int countByExample(SysOrganizationExample example);

    int deleteByExample(SysOrganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    List<SysOrganization> selectByExample(SysOrganizationExample example);

    SysOrganization selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample
            example);

    int updateByExample(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);

    List<SysOrganization> listForTree();

    List<Long> selectLowerOrgaBySysOrgaId(@Param("sysOrgaId") Long sysOrgaId);

    List<String> findRoles(@Param("username") String username);

    List<String> findPermissions(@Param("username") String username);
}
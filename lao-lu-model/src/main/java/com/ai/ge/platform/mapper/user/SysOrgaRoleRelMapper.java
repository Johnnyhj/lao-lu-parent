package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.dto.user.SysOrgaRoleRelDto;
import com.ai.ge.platform.model.user.SysOrgaRoleRel;
import com.ai.ge.platform.model.user.SysOrgaRoleRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysOrgaRoleRelMapper {
    int countByExample(SysOrgaRoleRelExample example);

    int deleteByExample(SysOrgaRoleRelExample example);

    int deleteByPrimaryKey(Long orgaRoleId);

    int insert(SysOrgaRoleRel record);

    int insertSelective(SysOrgaRoleRel record);

    List<SysOrgaRoleRel> selectByExample(SysOrgaRoleRelExample example);

    SysOrgaRoleRel selectByPrimaryKey(Long orgaRoleId);

    int updateByExampleSelective(@Param("record") SysOrgaRoleRel record, @Param("example") SysOrgaRoleRelExample
            example);

    int updateByExample(@Param("record") SysOrgaRoleRel record, @Param("example") SysOrgaRoleRelExample example);

    int updateByPrimaryKeySelective(SysOrgaRoleRel record);

    int updateByPrimaryKey(SysOrgaRoleRel record);

    List<SysOrgaRoleRelDto> selectOrgaRoleByOrgaId(Map<String, Object> params);
}
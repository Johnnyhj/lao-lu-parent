package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.model.user.SysRole;
import com.ai.ge.platform.model.user.SysRoleExample;
import com.ai.ge.platform.dto.sys.SysRoleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRoleDto> findAllRoleResource();

    List<String> findRolesByUsername(@Param("userName") String userName);

    List<String> findPermissionsByUsername(@Param("userName") String userName);
}
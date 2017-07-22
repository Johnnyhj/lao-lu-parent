package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.dto.user.SysUserDto;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.model.user.SysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUserDto> listByExample(SysUserExample example);

    List<SysUserDto> searchSysUser(Map<String, Object> params);

    SysUserDto selectSysUserRoleOrga(Map<String, Object> params);

    List<SysUserDto> searchSysUserArea(Map<String, Object> params);

    /**
     * 通过区域查找用户
     *
     * @param queryCond
     * @return
     */
    List<SysUser> selectUserByArea(Map<String, Object> queryCond);

    /*================================================ 以下是web端接口 ==================================================================*/

    List<SysUserDto> selectBySelective(SysUser sysUser);

}
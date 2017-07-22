package com.ai.ge.platform.service.user;

import com.ai.ge.platform.model.user.SysRole;
import com.ai.ge.platform.dto.sys.SysRoleDto;

import java.util.List;
import java.util.Set;


public interface SysRoleService {


    SysRole createRole(SysRole role);

    /**
     * 新增角色、资源信息
     *
     * @param role
     * @return
     */
    SysRoleDto createRoleResource(SysRoleDto role);

    SysRole updateRole(SysRole role);

    /**
     * 更新角色、资源信息
     *
     * @param role
     * @return
     */
    SysRoleDto updateRoleResource(SysRoleDto role);

    void deleteRole(Long roleId);

    /**
     * 删除角色、资源信息
     *
     * @param roleId
     */
    void deleteRoleResource(Long roleId);

    SysRole findOne(Long roleId);

    /**
     * 检索角色、资源信息
     *
     * @param roleId
     * @return
     */
    SysRoleDto findRoleResource(Long roleId);

    List<SysRole> findAll();

    /**
     * 检索全部角色、资源信息
     *
     * @return
     */
    List<SysRoleDto> findAllRoleResource();

    /**
     * 根据角色编号得到角色标识符列表
     *
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据用户名查询角色标识列表
     *
     * @param userName
     * @return
     */
    Set<String> findRolesByUsername(String userName);

    /**
     * 根据角色编号得到权限字符串列表
     *
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);

    Set<String> findPermissionsByUsername(String userName);
}

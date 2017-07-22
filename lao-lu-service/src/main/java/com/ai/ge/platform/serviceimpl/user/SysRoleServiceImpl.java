package com.ai.ge.platform.serviceimpl.user;

import com.ai.ge.platform.mapper.user.SysRoleResourceReleationMapper;
import com.ai.ge.platform.model.user.SysRole;
import com.ai.ge.platform.model.user.SysRoleResourceReleation;
import com.ai.ge.platform.service.user.SysRoleService;
import com.ai.ge.platform.dto.sys.SysRoleDto;
import com.ai.ge.platform.mapper.user.SysRoleMapper;
import com.ai.ge.platform.model.user.SysRoleExample;
import com.ai.ge.platform.model.user.SysRoleResourceReleationExample;
import com.ai.ge.platform.service.user.SysResourceService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class SysRoleServiceImpl implements SysRoleService
{

    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysResourceService resourceService;
    @Resource
    private SysRoleResourceReleationMapper roleResourceReleationMapper;

    public SysRole createRole(SysRole role) {
        sysRoleMapper.insertSelective(role);

        return role;
    }

    @Override
    public SysRoleDto createRoleResource(SysRoleDto role) {

        sysRoleMapper.insertSelective(role);

        if (CollectionUtils.isNotEmpty(role.getSysRoleResourceRelations())) {
            for (SysRoleResourceReleation relation : role.getSysRoleResourceRelations()) {
                relation.setSysRoleId(role.getId());
                roleResourceReleationMapper.insertSelective(relation);
            }
        }

        return role;
    }

    public SysRole updateRole(SysRole role) {
        sysRoleMapper.updateByPrimaryKeySelective(role);

        return role;
    }

    @Override
    public SysRoleDto updateRoleResource(SysRoleDto role) {
        sysRoleMapper.updateByPrimaryKeySelective(role);

        if (CollectionUtils.isNotEmpty(role.getSysRoleResourceRelations())) {
            SysRoleResourceReleationExample example = new SysRoleResourceReleationExample();
            example.createCriteria().andSysRoleIdEqualTo(role.getId());
            roleResourceReleationMapper.deleteByExample(example);

            for (SysRoleResourceReleation relation : role.getSysRoleResourceRelations()) {
                roleResourceReleationMapper.insertSelective(relation);
            }
        }
        return role;
    }

    public void deleteRole(Long roleId) {
        sysRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public void deleteRoleResource(Long roleId) {
        sysRoleMapper.deleteByPrimaryKey(roleId);

        SysRoleResourceReleationExample example = new SysRoleResourceReleationExample();
        example.createCriteria().andSysRoleIdEqualTo(roleId);
        roleResourceReleationMapper.deleteByExample(example);
    }

    @Override
    public SysRole findOne(Long roleId) {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public SysRoleDto findRoleResource(Long roleId) {
        SysRoleDto sysRoleDto = new SysRoleDto();

        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);

        // 取得角色资源关系信息
        if (sysRole != null) {
            BeanUtils.copyProperties(sysRole, sysRoleDto);

            SysRoleResourceReleationExample example = new SysRoleResourceReleationExample();
            example.createCriteria().andSysRoleIdEqualTo(roleId);
            List<SysRoleResourceReleation> roleResourceReleations = roleResourceReleationMapper.selectByExample(example);

            sysRoleDto.setSysRoleResourceRelations(roleResourceReleations);
        }

        return sysRoleDto;
    }

    @Override
    public List<SysRole> findAll() {
        SysRoleExample example = new SysRoleExample();
        return sysRoleMapper.selectByExample(example);
    }

    @Override
    public List<SysRoleDto> findAllRoleResource() {
        return sysRoleMapper.findAllRoleResource();
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();

        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andIdIn(Arrays.asList(roleIds));
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);

        if (CollectionUtils.isNotEmpty(sysRoles)) {
            for (SysRole sysRole : sysRoles) {
                roles.add(sysRole.getRole());
            }
        }

        //for(Long roleId : roleIds) {
        //    SysRole role = findOne(roleId);
        //    if(role != null) {
        //        roles.add(role.getRole());
        //    }
        //}
        return roles;
    }

    @Override
    public Set<String> findRolesByUsername(String userName) {
        return new HashSet<String>(sysRoleMapper.findRolesByUsername(userName));
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();

        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andIdIn(Arrays.asList(roleIds));
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);

        if (CollectionUtils.isNotEmpty(sysRoles)) {
            for (SysRole sysRole : sysRoles) {
                resourceIds.addAll(sysRole.getListResourceIds());
            }
        }
        //for(Long roleId : roleIds) {
        //    SysRole role = findOne(roleId);
        //    if(role != null) {
        //        resourceIds.addAll(role.getListResourceIds());
        //    }
        //}
        return resourceService.findPermissions(resourceIds);
    }

    @Override
    public Set<String> findPermissionsByUsername(String userName) {
        return new HashSet<String>(sysRoleMapper.findPermissionsByUsername(userName));
    }
}

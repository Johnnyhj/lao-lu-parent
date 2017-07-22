package com.ai.ge.platform.serviceimpl.user;

import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.mapper.user.SysResourceMapper;
import com.ai.ge.platform.mapper.user.SysRoleMapper;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysResourceExample;
import com.ai.ge.platform.service.user.SysResourceService;
import com.ai.ge.platform.service.user.UserService;
import com.ai.ge.util.StructureTransitionUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service

public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private UserService userService;

    @Override
    public SysResource createResource(SysResource resource) {
        sysResourceMapper.insertSelective(resource);
        return resource;
    }

    @Override
    public SysResource updateResource(SysResource resource) {
        sysResourceMapper.updateByPrimaryKeySelective(resource);
        return resource;
    }

    @Override
    public void deleteResource(Long resourceId) {
        sysResourceMapper.deleteByPrimaryKey(resourceId);
    }

    @Override
    public SysResource findOne(Long resourceId) {
        return sysResourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public List<SysResource> findAll() {
        SysResourceExample example = new SysResourceExample();
        return sysResourceMapper.selectByExample(example);
    }

    @Override
    public List<SysResource> findForTree()
    {
        List<SysResource> sysResources = sysResourceMapper.listForTree();

        if (CollectionUtils.isNotEmpty(sysResources))
        {
            StructureTransitionUtil.listToTree(sysResources, new StructureTransitionUtil.TransformMatcher<SysResource>()
            {
                @Override
                public void transform(SysResource parent, SysResource child)
                {
                    if (parent.getId().equals(child.getParentId()))
                    {
                        parent.getSysResources().add(child);
                    }
                }

                @Override
                public boolean remove(SysResource object)
                {
                    return 1 != object.getParentId();
                }
            });
        }

        return sysResources;
    }

    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for (Long resourceId : resourceIds) {
            SysResource resource = findOne(resourceId);
            if (resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public List<SysResource> findMenus(SysUser sysUser) {
        List<SysResource> sysResources = sysResourceMapper.listObjectByUsername(sysUser.getUsername(), "menu");
        sysResources.addAll(sysResourceMapper.listObjectByUsernameOrga(sysUser.getUsername(), "menu"));

        Set<SysResource> resourceSet = new HashSet<SysResource>(sysResources);
        sysResources = new ArrayList<SysResource>(resourceSet);


        if (CollectionUtils.isNotEmpty(sysResources)) {
            StructureTransitionUtil.listToTree(sysResources, new StructureTransitionUtil
                    .TransformMatcher<SysResource>() {
                @Override
                public void transform(SysResource parent, SysResource child) {
                    if (parent.getId().equals(child.getParentId())) {
                        parent.getSysResources().add(child);
                    }
                }

                @Override
                public boolean remove(SysResource object) {
                    return 1 != object.getParentId();
                }
            });

            return sysResources;
        }

        return new ArrayList<SysResource>();
    }

    @Override
    public List<SysResource> findMenus(Set<String> permissions) {
        List<SysResource> allResources = findAll();
        List<SysResource> menus = new ArrayList<SysResource>();
        for (SysResource resource : allResources) {
            if (resource.isRootNode()) {
                continue;
            }
            if (!resource.getType().equals(SysResource.ResourceType.menu.name())) {
                continue;
            }
            if (!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }

        StructureTransitionUtil.listToTree(menus, new StructureTransitionUtil.TransformMatcher<SysResource>() {
            @Override
            public void transform(SysResource parent, SysResource child) {
                if (parent.getId().equals(child.getParentId())) {
                    parent.getSysResources().add(child);
                }
            }

            @Override
            public boolean remove(SysResource object) {
                return 1 != object.getParentId();
            }
        });


        return menus;
    }


    private boolean hasPermission(Set<String> permissions, SysResource resource) {
        if (StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for (String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if (p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
}

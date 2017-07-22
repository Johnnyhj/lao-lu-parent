package com.ai.ge.platform.web.taglib;

import com.ai.ge.platform.model.user.SysRole;
import com.ai.ge.platform.service.user.SysRoleService;
import com.ai.ge.platform.model.user.SysOrganization;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.service.user.SysOrganizationService;
import com.ai.ge.platform.service.user.SysResourceService;
import com.ai.ge.platform.shiro.spring.SpringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 *
 */
public class Functions {

    public static boolean in(Iterable iterable, Object element) {
        if(iterable == null) {
            return false;
        }
        return CollectionUtils.contains(iterable.iterator(), element);
    }

    public static String organizationName(Long organizationId) {
        SysOrganization organization = getOrganizationService().findOne(organizationId);
        if(organization == null) {
            return "";
        }
        return organization.getName();
    }

    public static String organizationNames(Collection<Long> organizationIds) {
        if(CollectionUtils.isEmpty(organizationIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long organizationId : organizationIds) {
            SysOrganization organization = getOrganizationService().findOne(organizationId);
            if(organization == null) {
                return "";
            }
            s.append(organization.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }
    public static String roleName(Long roleId) {
        SysRole role = getRoleService().findOne(roleId);
        if(role == null) {
            return "";
        }
        return role.getDescription();
    }

    public static String roleNames(Collection<Long> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            SysRole role = getRoleService().findOne(roleId);
            if(role == null) {
                return "";
            }
            s.append(role.getDescription());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }
    public static String resourceName(Long resourceId) {
        SysResource resource = getResourceService().findOne(resourceId);
        if(resource == null) {
            return "";
        }
        return resource.getName();
    }
    public static String resourceNames(Collection<Long> resourceIds) {
        if(CollectionUtils.isEmpty(resourceIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long resourceId : resourceIds) {
            SysResource resource = getResourceService().findOne(resourceId);
            if(resource == null) {
                return "";
            }
            s.append(resource.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }

    private static SysOrganizationService organizationService;
    private static SysRoleService roleService;
    private static SysResourceService resourceService;

    public static SysOrganizationService getOrganizationService() {
        if(organizationService == null) {
            organizationService = SpringUtils.getBean(SysOrganizationService.class);
        }
        return organizationService;
    }

    public static SysRoleService getRoleService() {
        if(roleService == null) {
            roleService = SpringUtils.getBean(SysRoleService.class);
        }
        return roleService;
    }

    public static SysResourceService getResourceService() {
        if(resourceService == null) {
            resourceService = SpringUtils.getBean(SysResourceService.class);
        }
        return resourceService;
    }
}


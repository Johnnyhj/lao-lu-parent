package com.ai.ge.platform.service.user;

import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysUser;

import java.util.List;
import java.util.Set;


public interface SysResourceService {


    SysResource createResource(SysResource resource);
    SysResource updateResource(SysResource resource);
    void deleteResource(Long resourceId);

    SysResource findOne(Long resourceId);
    List<SysResource> findAll();

    /**
     * 取得资源一览
     * @return
     */
    List<SysResource> findForTree();

    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 得到当前用户的菜单
     * @param sysUser
     * @return
     */
    List<SysResource> findMenus(SysUser sysUser);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<SysResource> findMenus(Set<String> permissions);
}

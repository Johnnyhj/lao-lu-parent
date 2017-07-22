package com.ai.ge.platform.service.user;

import com.ai.ge.platform.dto.user.SysOrganizationDto;
import com.ai.ge.platform.model.user.SysOrganization;

import java.util.List;
import java.util.Set;

/**
 *
 */
public interface SysOrganizationService {


    SysOrganization createOrganization(SysOrganizationDto organization);

    SysOrganization updateOrganization(SysOrganizationDto organization);

    void deleteOrganization(Long organizationId);

    SysOrganization findOne(Long organizationId);

    SysOrganizationDto findDtoOne(Long organizationId);

    SysOrganization findParent(SysOrganization parent);

    SysOrganizationDto findOrganizationWithRole(Long organizationId);

    List<SysOrganization> findAll();

    Object findAllWithExclude(SysOrganization excludeOraganization);

    void move(SysOrganization source, SysOrganization target);

    List<SysOrganization> findForTree();

    /**
     * 所有部门机构Json字符串
     *
     * @return
     */
    String getSysOrganizationJson();

    /**
     * 查询用户所在机构角色
     *
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 查询用户所在机构权限
     *
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);
}

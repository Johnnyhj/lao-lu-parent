package com.ai.ge.platform.dto.user;

import com.ai.ge.platform.model.user.SysOrganization;

import java.util.List;

/**
 *
 */
public class SysOrganizationDto extends SysOrganization {
    private List<SysOrgaRoleRelDto> sysOrgaRoleRels;

    public List<SysOrgaRoleRelDto> getSysOrgaRoleRels() {
        return sysOrgaRoleRels;
    }

    public void setSysOrgaRoleRels(List<SysOrgaRoleRelDto> sysOrgaRoleRels) {
        this.sysOrgaRoleRels = sysOrgaRoleRels;
    }
}

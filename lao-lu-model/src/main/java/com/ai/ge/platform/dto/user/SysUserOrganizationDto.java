package com.ai.ge.platform.dto.user;

import com.ai.ge.platform.model.user.SysUserOrganization;

/**
 *
 */
public class SysUserOrganizationDto extends SysUserOrganization {
    private String orgaName;

    public String getOrgaName() {
        return orgaName;
    }

    public void setOrgaName(String orgaName) {
        this.orgaName = orgaName;
    }
}

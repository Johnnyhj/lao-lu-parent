package com.ai.ge.platform.dto.user;


import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.user.SysUser;

import java.util.List;

/**
 *
 */
public class SysUserDto extends SysUser {
    private List<SysUserRoleReleationDto> sysUserRoleReleations;

    /**
     * 用户部门关联
     */
    private SysUserOrganizationDto primaryUserOrgaRel;

    private String systemAreaIds;

    private SystemArea systemArea;

    public List<SysUserRoleReleationDto> getSysUserRoleReleations() {
        return sysUserRoleReleations;
    }

    public void setSysUserRoleReleations(List<SysUserRoleReleationDto> sysUserRoleReleations) {
        this.sysUserRoleReleations = sysUserRoleReleations;
    }

    public SysUserOrganizationDto getPrimaryUserOrgaRel() {
        return primaryUserOrgaRel;
    }

    public void setPrimaryUserOrgaRel(SysUserOrganizationDto primaryUserOrgaRel) {
        this.primaryUserOrgaRel = primaryUserOrgaRel;

    }

    public String getSystemAreaIds()
    {
        return systemAreaIds;
    }

    public void setSystemAreaIds(String systemAreaIds)
    {
        this.systemAreaIds = systemAreaIds;
    }

    public SystemArea getSystemArea()
    {
        return systemArea;
    }

    public void setSystemArea(SystemArea systemArea)
    {
        this.systemArea = systemArea;
    }
}

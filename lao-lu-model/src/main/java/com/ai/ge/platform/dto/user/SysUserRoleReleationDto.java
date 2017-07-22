package com.ai.ge.platform.dto.user;

import com.ai.ge.platform.model.user.SysUserRoleReleation;

/**
 *
 */
public class SysUserRoleReleationDto extends SysUserRoleReleation
{
    private String sysRoleName;
    private String sysRoleDesc;

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }

    public String getSysRoleDesc() {
        return sysRoleDesc;
    }

    public void setSysRoleDesc(String sysRoleDesc) {
        this.sysRoleDesc = sysRoleDesc;
    }
}

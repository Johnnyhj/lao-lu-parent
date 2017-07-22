package com.ai.ge.platform.dto.sys;

import com.ai.ge.platform.model.user.SysRole;
import com.ai.ge.platform.model.user.SysRoleResourceReleation;

import java.util.List;

/**
 * Created by jinlu on 2016/6/30.
 */
public class SysRoleDto extends SysRole
{

    /* 角色权限关联列表 */
    List<SysRoleResourceReleation> sysRoleResourceRelations;

    public List<SysRoleResourceReleation> getSysRoleResourceRelations() {
        return sysRoleResourceRelations;
    }

    public void setSysRoleResourceRelations(List<SysRoleResourceReleation> sysRoleResourceRelations) {
        this.sysRoleResourceRelations = sysRoleResourceRelations;
    }
}

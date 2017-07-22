package com.ai.ge.platform.model.user;

import java.util.Date;

public class SysOrgaRoleRel {
    private Long orgaRoleId;

    private Long roleId;

    private Long orgaId;

    private Date createTime;

    private Date effectiveTime;

    private Date failTime;

    public Long getOrgaRoleId() {
        return orgaRoleId;
    }

    public void setOrgaRoleId(Long orgaRoleId) {
        this.orgaRoleId = orgaRoleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getOrgaId() {
        return orgaId;
    }

    public void setOrgaId(Long orgaId) {
        this.orgaId = orgaId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getFailTime() {
        return failTime;
    }

    public void setFailTime(Date failTime) {
        this.failTime = failTime;
    }
}
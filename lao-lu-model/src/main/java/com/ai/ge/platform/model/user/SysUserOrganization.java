package com.ai.ge.platform.model.user;

import java.util.Date;

public class SysUserOrganization {
    private Long suoId;

    private Long orgaId;

    private Long userId;

    private Date createTime;

    public Long getSuoId() {
        return suoId;
    }

    public void setSuoId(Long suoId) {
        this.suoId = suoId;
    }

    public Long getOrgaId() {
        return orgaId;
    }

    public void setOrgaId(Long orgaId) {
        this.orgaId = orgaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
package com.ai.ge.platform.model.user;

import java.util.Date;

public class SysRoleResourceReleation {
    private Long srrId;

    private Long sysRoleId;

    private Long sysResourceId;

    private Date createTime;

    public Long getSrrId() {
        return srrId;
    }

    public void setSrrId(Long srrId) {
        this.srrId = srrId;
    }

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public Long getSysResourceId() {
        return sysResourceId;
    }

    public void setSysResourceId(Long sysResourceId) {
        this.sysResourceId = sysResourceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
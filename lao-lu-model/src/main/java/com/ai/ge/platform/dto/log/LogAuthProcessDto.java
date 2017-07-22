package com.ai.ge.platform.dto.log;

import com.ai.ge.platform.model.log.LogAuthProcessWithBLOBs;
import com.ai.ge.platform.model.user.SysUser;

import java.io.Serializable;

/**
 * Created by count on 16/9/21.
 */
public class LogAuthProcessDto extends LogAuthProcessWithBLOBs implements Serializable {

    private static final long serialVersionUID = 3178346209733809264L;

    SysUser sysUser;

    String authUserName;

    public String getAuthUserName() {
        return authUserName;
    }

    public void setAuthUserName(String authUserName) {
        this.authUserName = authUserName;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}

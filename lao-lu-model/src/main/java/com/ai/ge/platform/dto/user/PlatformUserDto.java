package com.ai.ge.platform.dto.user;

import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.user.PlatformUser;

/**
 * Created by guochunhao on 17/5/18.
 */
public class PlatformUserDto extends PlatformUser
{
    /**
     * 订单
     */

    /**
     * 履约计划
     */

    /**
     * 地区
     */
    private SystemArea systemArea;

    public SystemArea getSystemArea()
    {
        return systemArea;
    }

    public void setSystemArea(SystemArea systemArea)
    {
        this.systemArea = systemArea;
    }
}

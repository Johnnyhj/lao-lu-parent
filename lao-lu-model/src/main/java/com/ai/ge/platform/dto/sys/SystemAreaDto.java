package com.ai.ge.platform.dto.sys;

import com.ai.ge.platform.model.sys.SystemArea;

/**
 * Created by guochunhao on 17/5/27.
 */
public class SystemAreaDto extends SystemArea
{
    private Long parentAreaId;

    private String parentAreaName;

    public Long getParentAreaId()
    {
        return parentAreaId;
    }

    public void setParentAreaId(Long parentAreaId)
    {
        this.parentAreaId = parentAreaId;
    }

    public String getParentAreaName()
    {
        return parentAreaName;
    }

    public void setParentAreaName(String parentAreaName)
    {
        this.parentAreaName = parentAreaName;
    }
}

package com.ai.ge.platform.dto.number;

import com.ai.ge.platform.model.product.NumberInfo;

/**
 * Created by guochunhao on 17/5/28.
 */
public class NumberInfoDto extends NumberInfo
{
    private Long areaId;

    private String areaName;

    private Short userType;

    public Short getUserType()
    {
        return userType;
    }

    public void setUserType(Short userType)
    {
        this.userType = userType;
    }

    public Long getAreaId()
    {
        return areaId;
    }

    public void setAreaId(Long areaId)
    {
        this.areaId = areaId;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }
}

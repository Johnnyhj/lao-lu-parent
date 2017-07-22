package com.ai.ge.platform.dto.order;

import com.ai.ge.platform.dto.sys.SystemAreaDto;
import com.ai.ge.platform.model.order.OfferSpec;
import com.ai.ge.platform.model.order.OfferSpecInfo;

/**
 * Created by guochunhao on 17/5/24.
 *
 * 套餐相关dto
 */
public class OfferSpecDto extends OfferSpec
{
    private OfferSpecInfo offerSpecInfo;

    private SystemAreaDto systemArea;

    public SystemAreaDto getSystemArea()
    {
        return systemArea;
    }

    public void setSystemArea(SystemAreaDto systemArea)
    {
        this.systemArea = systemArea;
    }

    public OfferSpecInfo getOfferSpecInfo()
    {
        return offerSpecInfo;
    }

    public void setOfferSpecInfo(OfferSpecInfo offerSpecInfo)
    {
        this.offerSpecInfo = offerSpecInfo;
    }
}

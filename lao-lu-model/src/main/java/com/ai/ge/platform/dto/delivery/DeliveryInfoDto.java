package com.ai.ge.platform.dto.delivery;

import com.ai.ge.platform.model.order.DeliverOrderRelation;
import com.ai.ge.platform.model.order.DeliveryInfo;

/**
 * Created by guochunhao on 17/5/28.
 */
public class DeliveryInfoDto extends DeliveryInfo
{
    private DeliverOrderRelation deliverOrderRelation;

    public DeliverOrderRelation getDeliverOrderRelation()
    {
        return deliverOrderRelation;
    }

    public void setDeliverOrderRelation(DeliverOrderRelation deliverOrderRelation)
    {
        this.deliverOrderRelation = deliverOrderRelation;
    }
}

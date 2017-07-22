package com.ai.ge.platform.service.delivery;

import com.ai.ge.platform.dto.delivery.DeliveryInfoDto;

/**
 * Created by guochunhao on 17/5/28.
 */
public interface DeliveryService
{
    /**
     * 新增物流信息
     */
    int insertDelivery(DeliveryInfoDto record);

    /**
     * 更新物流信息
     */
    int updateDelivery(DeliveryInfoDto record);

    /**
     * 删除物流信息
     */
    int deleteDelivery(DeliveryInfoDto record);

    /**
     * 根据订单号查询物流物流信息
     */
    DeliveryInfoDto findDelivery(Long orderId);
}

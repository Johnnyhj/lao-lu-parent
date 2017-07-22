package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.dto.delivery.DeliveryInfoDto;
import com.ai.ge.platform.model.order.DeliveryInfo;
import com.ai.ge.platform.model.order.DeliveryInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryInfoMapper {
    int countByExample(DeliveryInfoExample example);

    int deleteByExample(DeliveryInfoExample example);

    int deleteByPrimaryKey(Long deliveryId);

    int insert(DeliveryInfo record);

    int insertSelective(DeliveryInfo record);

    List<DeliveryInfo> selectByExample(DeliveryInfoExample example);

    DeliveryInfo selectByPrimaryKey(Long deliveryId);

    int updateByExampleSelective(@Param("record") DeliveryInfo record, @Param("example") DeliveryInfoExample example);

    int updateByExample(@Param("record") DeliveryInfo record, @Param("example") DeliveryInfoExample example);

    int updateByPrimaryKeySelective(DeliveryInfo record);

    int updateByPrimaryKey(DeliveryInfo record);

    DeliveryInfoDto selectDeliveryDto(Long orderId);
}
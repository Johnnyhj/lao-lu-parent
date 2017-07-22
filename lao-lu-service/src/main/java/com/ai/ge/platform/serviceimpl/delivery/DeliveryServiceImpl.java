package com.ai.ge.platform.serviceimpl.delivery;

import com.ai.ge.arrears.constant.OrdersStatusConstants;
import com.ai.ge.platform.dto.delivery.DeliveryInfoDto;
import com.ai.ge.platform.exception.ParamException;
import com.ai.ge.platform.mapper.order.DeliverOrderRelationMapper;
import com.ai.ge.platform.mapper.order.DeliveryInfoMapper;
import com.ai.ge.platform.mapper.order.OrdersMapper;
import com.ai.ge.platform.model.order.DeliveryInfo;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.service.delivery.DeliveryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by guochunhao on 17/5/28.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService
{
    @Resource
    private DeliveryInfoMapper deliveryInfoMapper;

    @Resource
    private DeliverOrderRelationMapper deliverOrderRelationMapper;

    @Resource
    private OrdersMapper ordersMapper;

    /**
     * 新增物流信息
     *
     * @param record
     */
    @Transactional
    @Override
    public int insertDelivery(DeliveryInfoDto record)
    {
        validateParam(record);

        // 新增物流信息
        if (null == record.getCreateTime())
        {
            record.setCreateTime(new Date());
        }
        deliveryInfoMapper.insertSelective(record);

        // 再增加物流与订单的关联关系
        record.getDeliverOrderRelation().setDeliveryId(record.getDeliveryId());
        deliverOrderRelationMapper.insertSelective(record.getDeliverOrderRelation());

        // 更改订单状态为 4 已发货
        Orders order = new Orders();
        order.setStatus(OrdersStatusConstants.COMPLETED_DELIVERED);
        order.setExpressMoney(record.getExpressMoney());

        order.setOrderId(record.getDeliverOrderRelation().getOrderId());

        return ordersMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 更新物流信息
     *
     * @param record
     */
    @Transactional
    @Override
    public int updateDelivery(DeliveryInfoDto record)
    {
        validateParam(record);

        if (null == record.getUpdateTime())
        {
            record.setUpdateTime(new Date());
        }

        return deliveryInfoMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除物流信息
     *
     * @param record
     */
    @Override
    public int deleteDelivery(DeliveryInfoDto record)
    {
        return 0;
    }

    /**
     * 根据订单号查询物流信息
     *
     * @param orderId
     * @return
     */
    @Override
    public DeliveryInfoDto findDelivery(Long orderId)
    {
        return deliveryInfoMapper.selectDeliveryDto(orderId);
    }

    private void validateParam(DeliveryInfoDto record)
    {
        // 参数校验
        if (null == record.getDeliveryType())
        {
            throw new ParamException("缺少参数物流类型");
        }

        if (null == record.getExpressSeq())
        {
            throw new ParamException("缺少参数物流单号");
        }

        if (null == record.getExpressName())
        {
            throw new ParamException("缺少参数物流名称");
        }

        if (null == record.getExpressMoney())
        {
            throw new ParamException("缺少参数物流金额");
        }
    }
}

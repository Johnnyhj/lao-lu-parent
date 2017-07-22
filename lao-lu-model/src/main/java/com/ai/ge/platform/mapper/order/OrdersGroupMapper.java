package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.OrdersGroup;
import com.ai.ge.platform.model.order.OrdersGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersGroupMapper {
    int countByExample(OrdersGroupExample example);

    int deleteByExample(OrdersGroupExample example);

    int deleteByPrimaryKey(Long ordersGroupId);

    int insert(OrdersGroup record);

    int insertSelective(OrdersGroup record);

    List<OrdersGroup> selectByExample(OrdersGroupExample example);

    OrdersGroup selectByPrimaryKey(Long ordersGroupId);

    int updateByExampleSelective(@Param("record") OrdersGroup record, @Param("example") OrdersGroupExample example);

    int updateByExample(@Param("record") OrdersGroup record, @Param("example") OrdersGroupExample example);

    int updateByPrimaryKeySelective(OrdersGroup record);

    int updateByPrimaryKey(OrdersGroup record);
}
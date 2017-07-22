package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.dto.order.OrdersDto;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.model.order.OrdersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> listBySelective(Orders record);

    List<Orders> listRefund(@Param("statusList") List<Short> statusList, @Param("order") Orders orders);

    OrdersDto selectOrderDetail(Long orderId);
}
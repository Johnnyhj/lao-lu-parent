package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.OrdersLog;
import com.ai.ge.platform.model.order.OrdersLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersLogMapper {
    int countByExample(OrdersLogExample example);

    int deleteByExample(OrdersLogExample example);

    int deleteByPrimaryKey(Long olId);

    int insert(OrdersLog record);

    int insertSelective(OrdersLog record);

    List<OrdersLog> selectByExample(OrdersLogExample example);

    OrdersLog selectByPrimaryKey(Long olId);

    int updateByExampleSelective(@Param("record") OrdersLog record, @Param("example") OrdersLogExample example);

    int updateByExample(@Param("record") OrdersLog record, @Param("example") OrdersLogExample example);

    int updateByPrimaryKeySelective(OrdersLog record);

    int updateByPrimaryKey(OrdersLog record);
}
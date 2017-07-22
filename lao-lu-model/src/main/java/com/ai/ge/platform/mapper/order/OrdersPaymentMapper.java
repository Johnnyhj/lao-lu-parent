package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.OrdersPayment;
import com.ai.ge.platform.model.order.OrdersPaymentExample;
import com.ai.ge.platform.model.order.OrdersPaymentKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersPaymentMapper {
    int countByExample(OrdersPaymentExample example);

    int deleteByExample(OrdersPaymentExample example);

    int deleteByPrimaryKey(OrdersPaymentKey key);

    int insert(OrdersPayment record);

    int insertSelective(OrdersPayment record);

    List<OrdersPayment> selectByExample(OrdersPaymentExample example);

    OrdersPayment selectByPrimaryKey(OrdersPaymentKey key);

    int updateByExampleSelective(@Param("record") OrdersPayment record, @Param("example") OrdersPaymentExample example);

    int updateByExample(@Param("record") OrdersPayment record, @Param("example") OrdersPaymentExample example);

    int updateByPrimaryKeySelective(OrdersPayment record);

    int updateByPrimaryKey(OrdersPayment record);

    List<OrdersPayment> selectBySelective(OrdersPayment record);
}
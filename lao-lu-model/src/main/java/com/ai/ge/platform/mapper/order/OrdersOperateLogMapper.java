package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.dto.order.OrderOperateDto;
import com.ai.ge.platform.model.order.OrdersOperateLog;
import com.ai.ge.platform.model.order.OrdersOperateLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersOperateLogMapper {
    int countByExample(OrdersOperateLogExample example);

    int deleteByExample(OrdersOperateLogExample example);

    int deleteByPrimaryKey(Long operateId);

    int insert(OrdersOperateLog record);

    int insertSelective(OrdersOperateLog record);

    List<OrdersOperateLog> selectByExample(OrdersOperateLogExample example);

    OrdersOperateLog selectByPrimaryKey(Long operateId);

    int updateByExampleSelective(@Param("record") OrdersOperateLog record, @Param("example") OrdersOperateLogExample example);

    int updateByExample(@Param("record") OrdersOperateLog record, @Param("example") OrdersOperateLogExample example);

    int updateByPrimaryKeySelective(OrdersOperateLog record);

    int updateByPrimaryKey(OrdersOperateLog record);

    List<OrderOperateDto> selectOrderOperateUser(Long operateId);
}
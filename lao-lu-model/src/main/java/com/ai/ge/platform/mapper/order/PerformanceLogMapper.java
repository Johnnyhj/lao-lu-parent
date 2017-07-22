package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.PerformanceLog;
import com.ai.ge.platform.model.order.PerformanceLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PerformanceLogMapper {
    int countByExample(PerformanceLogExample example);

    int deleteByExample(PerformanceLogExample example);

    int deleteByPrimaryKey(Long olId);

    int insert(PerformanceLog record);

    int insertSelective(PerformanceLog record);

    List<PerformanceLog> selectByExample(PerformanceLogExample example);

    PerformanceLog selectByPrimaryKey(Long olId);

    int updateByExampleSelective(@Param("record") PerformanceLog record, @Param("example") PerformanceLogExample example);

    int updateByExample(@Param("record") PerformanceLog record, @Param("example") PerformanceLogExample example);

    int updateByPrimaryKeySelective(PerformanceLog record);

    int updateByPrimaryKey(PerformanceLog record);

    List<PerformanceLog> queryPerformaceLogByOrderId(@Param("orderId") Long orderId);
}
package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.PerformanceInfo;
import com.ai.ge.platform.model.order.PerformanceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerformanceInfoMapper {
    int countByExample(PerformanceInfoExample example);

    int deleteByExample(PerformanceInfoExample example);

    int deleteByPrimaryKey(Long performanceId);

    int insert(PerformanceInfo record);

    int insertSelective(PerformanceInfo record);

    List<PerformanceInfo> selectByExample(PerformanceInfoExample example);

    PerformanceInfo selectByPrimaryKey(Long performanceId);

    int updateByExampleSelective(@Param("record") PerformanceInfo record, @Param("example") PerformanceInfoExample example);

    int updateByExample(@Param("record") PerformanceInfo record, @Param("example") PerformanceInfoExample example);

    int updateByPrimaryKeySelective(PerformanceInfo record);

    int updateByPrimaryKey(PerformanceInfo record);
}
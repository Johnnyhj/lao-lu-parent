package com.ai.ge.platform.mapper.schedule;

import com.ai.ge.platform.model.schedule.ScheduleJobClass;
import com.ai.ge.platform.model.schedule.ScheduleJobClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleJobClassMapper {
    int countByExample(ScheduleJobClassExample example);

    int deleteByExample(ScheduleJobClassExample example);

    int deleteByPrimaryKey(Long jobId);

    int insert(ScheduleJobClass record);

    int insertSelective(ScheduleJobClass record);

    List<ScheduleJobClass> selectByExample(ScheduleJobClassExample example);

    ScheduleJobClass selectByPrimaryKey(Long jobId);

    int updateByExampleSelective(@Param("record") ScheduleJobClass record, @Param("example") ScheduleJobClassExample example);

    int updateByExample(@Param("record") ScheduleJobClass record, @Param("example") ScheduleJobClassExample example);

    int updateByPrimaryKeySelective(ScheduleJobClass record);

    int updateByPrimaryKey(ScheduleJobClass record);
}
package com.ai.ge.platform.mapper.schedule;


import com.ai.ge.platform.model.schedule.ScheduleQuartzGroup;
import com.ai.ge.platform.model.schedule.ScheduleQuartzGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleQuartzGroupMapper {
    int countByExample(ScheduleQuartzGroupExample example);

    int deleteByExample(ScheduleQuartzGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(ScheduleQuartzGroup record);

    int insertSelective(ScheduleQuartzGroup record);

    List<ScheduleQuartzGroup> selectByExample(ScheduleQuartzGroupExample example);

    ScheduleQuartzGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") ScheduleQuartzGroup record, @Param("example") ScheduleQuartzGroupExample example);

    int updateByExample(@Param("record") ScheduleQuartzGroup record, @Param("example") ScheduleQuartzGroupExample example);

    int updateByPrimaryKeySelective(ScheduleQuartzGroup record);

    int updateByPrimaryKey(ScheduleQuartzGroup record);
}
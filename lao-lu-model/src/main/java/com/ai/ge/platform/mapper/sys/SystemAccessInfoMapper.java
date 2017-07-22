package com.ai.ge.platform.mapper.sys;

import com.ai.ge.platform.model.sys.SystemAccessInfo;
import com.ai.ge.platform.model.sys.SystemAccessInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SystemAccessInfoMapper {
    int countByExample(SystemAccessInfoExample example);

    int deleteByExample(SystemAccessInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAccessInfo record);

    int insertSelective(SystemAccessInfo record);

    List<SystemAccessInfo> selectByExample(SystemAccessInfoExample example);

    SystemAccessInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAccessInfo record, @Param("example") SystemAccessInfoExample example);

    int updateByExample(@Param("record") SystemAccessInfo record, @Param("example") SystemAccessInfoExample example);

    int updateByPrimaryKeySelective(SystemAccessInfo record);

    int updateByPrimaryKey(SystemAccessInfo record);

    List<Map<String,Object>> statisticsAccIp(Map<String, Object> params);
}
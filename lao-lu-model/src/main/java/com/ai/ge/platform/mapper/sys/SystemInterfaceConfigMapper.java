package com.ai.ge.platform.mapper.sys;

import com.ai.ge.platform.model.sys.SystemInterfaceConfig;
import com.ai.ge.platform.model.sys.SystemInterfaceConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemInterfaceConfigMapper {
    int countByExample(SystemInterfaceConfigExample example);

    int deleteByExample(SystemInterfaceConfigExample example);

    int deleteByPrimaryKey(Long interfaceConfigId);

    int insert(SystemInterfaceConfig record);

    int insertSelective(SystemInterfaceConfig record);

    List<SystemInterfaceConfig> selectByExample(SystemInterfaceConfigExample example);

    SystemInterfaceConfig selectByPrimaryKey(Long interfaceConfigId);

    int updateByExampleSelective(@Param("record") SystemInterfaceConfig record, @Param("example") SystemInterfaceConfigExample example);

    int updateByExample(@Param("record") SystemInterfaceConfig record, @Param("example") SystemInterfaceConfigExample example);

    int updateByPrimaryKeySelective(SystemInterfaceConfig record);

    int updateByPrimaryKey(SystemInterfaceConfig record);
}
package com.ai.ge.platform.mapper.sys;

import com.ai.ge.platform.model.sys.SysOrganizationChannel;
import com.ai.ge.platform.model.sys.SysOrganizationChannelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrganizationChannelMapper {
    int countByExample(SysOrganizationChannelExample example);

    int deleteByExample(SysOrganizationChannelExample example);

    int insert(SysOrganizationChannel record);

    int insertSelective(SysOrganizationChannel record);

    List<SysOrganizationChannel> selectByExample(SysOrganizationChannelExample example);

    int updateByExampleSelective(@Param("record") SysOrganizationChannel record, @Param("example") SysOrganizationChannelExample example);

    int updateByExample(@Param("record") SysOrganizationChannel record, @Param("example") SysOrganizationChannelExample example);
}
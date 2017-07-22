package com.ai.ge.platform.mapper.sys;

import com.ai.ge.platform.model.sys.AlipayConfigurationInfo;
import com.ai.ge.platform.model.sys.AlipayConfigurationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlipayConfigurationInfoMapper {
    int countByExample(AlipayConfigurationInfoExample example);

    int deleteByExample(AlipayConfigurationInfoExample example);

    int deleteByPrimaryKey(Long alipayConfId);

    int insert(AlipayConfigurationInfo record);

    int insertSelective(AlipayConfigurationInfo record);

    List<AlipayConfigurationInfo> selectByExample(AlipayConfigurationInfoExample example);

    AlipayConfigurationInfo selectByPrimaryKey(Long alipayConfId);

    int updateByExampleSelective(@Param("record") AlipayConfigurationInfo record, @Param("example") AlipayConfigurationInfoExample example);

    int updateByExample(@Param("record") AlipayConfigurationInfo record, @Param("example") AlipayConfigurationInfoExample example);

    int updateByPrimaryKeySelective(AlipayConfigurationInfo record);

    int updateByPrimaryKey(AlipayConfigurationInfo record);
}
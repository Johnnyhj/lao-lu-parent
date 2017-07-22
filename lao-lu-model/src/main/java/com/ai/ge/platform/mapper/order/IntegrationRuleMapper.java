package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.dto.order.IntegrationRuleDto;
import com.ai.ge.platform.model.order.IntegrationRule;
import com.ai.ge.platform.model.order.IntegrationRuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntegrationRuleMapper {
    int countByExample(IntegrationRuleExample example);

    int deleteByExample(IntegrationRuleExample example);

    int deleteByPrimaryKey(Long integrationRuleId);

    int insert(IntegrationRule record);

    int insertSelective(IntegrationRule record);

    List<IntegrationRule> selectByExample(IntegrationRuleExample example);

    IntegrationRule selectByPrimaryKey(Long integrationRuleId);

    int updateByExampleSelective(@Param("record") IntegrationRule record, @Param("example") IntegrationRuleExample example);

    int updateByExample(@Param("record") IntegrationRule record, @Param("example") IntegrationRuleExample example);

    int updateByPrimaryKeySelective(IntegrationRule record);

    int updateByPrimaryKey(IntegrationRule record);

    List<IntegrationRuleDto> listBySelective(IntegrationRule record);
}
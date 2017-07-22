package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ParaGroup;
import com.ai.ge.platform.model.product.ParaGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParaGroupMapper {
    int countByExample(ParaGroupExample example);

    int deleteByExample(ParaGroupExample example);

    int deleteByPrimaryKey(Long paraSpecGroupCd);

    int insert(ParaGroup record);

    int insertSelective(ParaGroup record);

    List<ParaGroup> selectByExample(ParaGroupExample example);

    ParaGroup selectByPrimaryKey(Long paraSpecGroupCd);

    int updateByExampleSelective(@Param("record") ParaGroup record, @Param("example") ParaGroupExample example);

    int updateByExample(@Param("record") ParaGroup record, @Param("example") ParaGroupExample example);

    int updateByPrimaryKeySelective(ParaGroup record);

    int updateByPrimaryKey(ParaGroup record);
}
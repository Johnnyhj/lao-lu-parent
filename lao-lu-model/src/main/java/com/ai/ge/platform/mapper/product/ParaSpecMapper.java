package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ParaSpec;
import com.ai.ge.platform.model.product.ParaSpecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParaSpecMapper {
    int countByExample(ParaSpecExample example);

    int deleteByExample(ParaSpecExample example);

    int deleteByPrimaryKey(Long paraSpecId);

    int insert(ParaSpec record);

    int insertSelective(ParaSpec record);

    List<ParaSpec> selectByExample(ParaSpecExample example);

    ParaSpec selectByPrimaryKey(Long paraSpecId);

    int updateByExampleSelective(@Param("record") ParaSpec record, @Param("example") ParaSpecExample example);

    int updateByExample(@Param("record") ParaSpec record, @Param("example") ParaSpecExample example);

    int updateByPrimaryKeySelective(ParaSpec record);

    int updateByPrimaryKey(ParaSpec record);
}
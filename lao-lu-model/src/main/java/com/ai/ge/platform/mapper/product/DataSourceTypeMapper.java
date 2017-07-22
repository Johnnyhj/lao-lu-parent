package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.DataSourceType;
import com.ai.ge.platform.model.product.DataSourceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataSourceTypeMapper {
    int countByExample(DataSourceTypeExample example);

    int deleteByExample(DataSourceTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DataSourceType record);

    int insertSelective(DataSourceType record);

    List<DataSourceType> selectByExample(DataSourceTypeExample example);

    DataSourceType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DataSourceType record, @Param("example") DataSourceTypeExample example);

    int updateByExample(@Param("record") DataSourceType record, @Param("example") DataSourceTypeExample example);

    int updateByPrimaryKeySelective(DataSourceType record);

    int updateByPrimaryKey(DataSourceType record);
}
package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.DataSourceControlsType;
import com.ai.ge.platform.model.product.DataSourceControlsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataSourceControlsTypeMapper {
    int countByExample(DataSourceControlsTypeExample example);

    int deleteByExample(DataSourceControlsTypeExample example);

    int deleteByPrimaryKey(Integer dscTypeCd);

    int insert(DataSourceControlsType record);

    int insertSelective(DataSourceControlsType record);

    List<DataSourceControlsType> selectByExample(DataSourceControlsTypeExample example);

    DataSourceControlsType selectByPrimaryKey(Integer dscTypeCd);

    int updateByExampleSelective(@Param("record") DataSourceControlsType record, @Param("example") DataSourceControlsTypeExample example);

    int updateByExample(@Param("record") DataSourceControlsType record, @Param("example") DataSourceControlsTypeExample example);

    int updateByPrimaryKeySelective(DataSourceControlsType record);

    int updateByPrimaryKey(DataSourceControlsType record);
}
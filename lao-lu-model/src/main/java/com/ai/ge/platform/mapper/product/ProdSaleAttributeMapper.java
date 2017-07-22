package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ProdSaleAttribute;
import com.ai.ge.platform.model.product.ProdSaleAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdSaleAttributeMapper {
    int countByExample(ProdSaleAttributeExample example);

    int deleteByExample(ProdSaleAttributeExample example);

    int deleteByPrimaryKey(Long prodSaleAttrId);

    int insert(ProdSaleAttribute record);

    int insertSelective(ProdSaleAttribute record);

    List<ProdSaleAttribute> selectByExample(ProdSaleAttributeExample example);

    ProdSaleAttribute selectByPrimaryKey(Long prodSaleAttrId);

    int updateByExampleSelective(@Param("record") ProdSaleAttribute record, @Param("example") ProdSaleAttributeExample example);

    int updateByExample(@Param("record") ProdSaleAttribute record, @Param("example") ProdSaleAttributeExample example);

    int updateByPrimaryKeySelective(ProdSaleAttribute record);

    int updateByPrimaryKey(ProdSaleAttribute record);
}
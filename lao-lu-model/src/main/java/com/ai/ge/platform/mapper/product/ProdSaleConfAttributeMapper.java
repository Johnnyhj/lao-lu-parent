package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ProdSaleConfAttribute;
import com.ai.ge.platform.model.product.ProdSaleConfAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdSaleConfAttributeMapper {
    int countByExample(ProdSaleConfAttributeExample example);

    int deleteByExample(ProdSaleConfAttributeExample example);

    int deleteByPrimaryKey(Long prodSaleAttrId);

    int insert(ProdSaleConfAttribute record);

    int insertSelective(ProdSaleConfAttribute record);

    List<ProdSaleConfAttribute> selectByExample(ProdSaleConfAttributeExample example);

    ProdSaleConfAttribute selectByPrimaryKey(Long prodSaleAttrId);

    int updateByExampleSelective(@Param("record") ProdSaleConfAttribute record, @Param("example") ProdSaleConfAttributeExample example);

    int updateByExample(@Param("record") ProdSaleConfAttribute record, @Param("example") ProdSaleConfAttributeExample example);

    int updateByPrimaryKeySelective(ProdSaleConfAttribute record);

    int updateByPrimaryKey(ProdSaleConfAttribute record);
}
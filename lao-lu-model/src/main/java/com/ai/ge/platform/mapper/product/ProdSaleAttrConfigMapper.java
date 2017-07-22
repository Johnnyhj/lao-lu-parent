package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ProdSaleAttrConfig;
import com.ai.ge.platform.model.product.ProdSaleAttrConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProdSaleAttrConfigMapper {
    int countByExample(ProdSaleAttrConfigExample example);

    int deleteByExample(ProdSaleAttrConfigExample example);

    int deleteByPrimaryKey(Long configId);

    int insert(ProdSaleAttrConfig record);

    int insertSelective(ProdSaleAttrConfig record);

    List<ProdSaleAttrConfig> selectByExample(ProdSaleAttrConfigExample example);

    ProdSaleAttrConfig selectByPrimaryKey(Long configId);

    int updateByExampleSelective(@Param("record") ProdSaleAttrConfig record, @Param("example") ProdSaleAttrConfigExample example);

    int updateByExample(@Param("record") ProdSaleAttrConfig record, @Param("example") ProdSaleAttrConfigExample example);

    int updateByPrimaryKeySelective(ProdSaleAttrConfig record);

    int updateByPrimaryKey(ProdSaleAttrConfig record);

    List<ProdSaleAttrConfig> selectByProdId(Long prodId);

//    List<ProdSaleAttrConfig> selectByProdId(Map<String, Object> cond);
}
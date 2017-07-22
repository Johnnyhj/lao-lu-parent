package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ProductPics;
import com.ai.ge.platform.model.product.ProductPicsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPicsMapper {
    int countByExample(ProductPicsExample example);

    int deleteByExample(ProductPicsExample example);

    int deleteByPrimaryKey(Long prodPicsId);

    int insert(ProductPics record);

    int insertSelective(ProductPics record);

    List<ProductPics> selectByExample(ProductPicsExample example);

    ProductPics selectByPrimaryKey(Long prodPicsId);

    int updateByExampleSelective(@Param("record") ProductPics record, @Param("example") ProductPicsExample example);

    int updateByExample(@Param("record") ProductPics record, @Param("example") ProductPicsExample example);

    int updateByPrimaryKeySelective(ProductPics record);

    int updateByPrimaryKey(ProductPics record);
}
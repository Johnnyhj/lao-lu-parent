package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ProductParameters;
import com.ai.ge.platform.model.product.ProductParametersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductParametersMapper {
    int countByExample(ProductParametersExample example);

    int deleteByExample(ProductParametersExample example);

    int insert(ProductParameters record);

    int insertSelective(ProductParameters record);

    List<ProductParameters> selectByExample(ProductParametersExample example);

    int updateByExampleSelective(@Param("record") ProductParameters record, @Param("example") ProductParametersExample example);

    int updateByExample(@Param("record") ProductParameters record, @Param("example") ProductParametersExample example);
}
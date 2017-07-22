package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ProdTypePara;
import com.ai.ge.platform.model.product.ProdTypeParaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdTypeParaMapper {
    int countByExample(ProdTypeParaExample example);

    int deleteByExample(ProdTypeParaExample example);

    int insert(ProdTypePara record);

    int insertSelective(ProdTypePara record);

    List<ProdTypePara> selectByExample(ProdTypeParaExample example);

    int updateByExampleSelective(@Param("record") ProdTypePara record, @Param("example") ProdTypeParaExample example);

    int updateByExample(@Param("record") ProdTypePara record, @Param("example") ProdTypeParaExample example);
}
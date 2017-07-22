package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ProdStockLog;
import com.ai.ge.platform.model.product.ProdStockLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdStockLogMapper {
    int countByExample(ProdStockLogExample example);

    int deleteByExample(ProdStockLogExample example);

    int deleteByPrimaryKey(Long stockId);

    int insert(ProdStockLog record);

    int insertSelective(ProdStockLog record);

    List<ProdStockLog> selectByExample(ProdStockLogExample example);

    ProdStockLog selectByPrimaryKey(Long stockId);

    int updateByExampleSelective(@Param("record") ProdStockLog record, @Param("example") ProdStockLogExample example);

    int updateByExample(@Param("record") ProdStockLog record, @Param("example") ProdStockLogExample example);

    int updateByPrimaryKeySelective(ProdStockLog record);

    int updateByPrimaryKey(ProdStockLog record);
}
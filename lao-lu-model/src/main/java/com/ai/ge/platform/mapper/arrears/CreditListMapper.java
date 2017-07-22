package com.ai.ge.platform.mapper.arrears;

import com.ai.ge.platform.model.arrears.CreditList;
import com.ai.ge.platform.model.arrears.CreditListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditListMapper {
    int countByExample(CreditListExample example);

    int deleteByExample(CreditListExample example);

    int deleteByPrimaryKey(Long creditId);

    int insert(CreditList record);

    int insertSelective(CreditList record);

    List<CreditList> selectByExample(CreditListExample example);

    CreditList selectByPrimaryKey(Long creditId);

    int updateByExampleSelective(@Param("record") CreditList record, @Param("example") CreditListExample example);

    int updateByExample(@Param("record") CreditList record, @Param("example") CreditListExample example);

    int updateByPrimaryKeySelective(CreditList record);

    int updateByPrimaryKey(CreditList record);
}
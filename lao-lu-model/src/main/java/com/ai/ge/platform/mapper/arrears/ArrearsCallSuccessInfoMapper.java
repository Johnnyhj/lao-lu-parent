package com.ai.ge.platform.mapper.arrears;

import com.ai.ge.platform.model.arrears.ArrearsCallSuccessInfo;
import com.ai.ge.platform.model.arrears.ArrearsCallSuccessInfoExample;
import java.util.List;

import com.ai.ge.platform.model.arrears.ArrearsInfo;
import org.apache.ibatis.annotations.Param;

public interface ArrearsCallSuccessInfoMapper {
    int countByExample(ArrearsCallSuccessInfoExample example);

    int deleteByExample(ArrearsCallSuccessInfoExample example);

    int deleteByPrimaryKey(Long arrearsId);

    int insert(ArrearsCallSuccessInfo record);

    int insertSelective(ArrearsCallSuccessInfo record);

    List<ArrearsCallSuccessInfo> selectByExample(ArrearsCallSuccessInfoExample example);

    ArrearsCallSuccessInfo selectByPrimaryKey(Long arrearsId);

    int updateByExampleSelective(@Param("record") ArrearsCallSuccessInfo record, @Param("example") ArrearsCallSuccessInfoExample example);

    int updateByExample(@Param("record") ArrearsCallSuccessInfo record, @Param("example") ArrearsCallSuccessInfoExample example);

    int updateByPrimaryKeySelective(ArrearsCallSuccessInfo record);

    int updateByPrimaryKey(ArrearsCallSuccessInfo record);

    int insertArrearsCalls(List<ArrearsCallSuccessInfo> list);
}
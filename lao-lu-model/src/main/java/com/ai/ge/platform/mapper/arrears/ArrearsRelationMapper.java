package com.ai.ge.platform.mapper.arrears;

import com.ai.ge.platform.model.arrears.ArrearsRelation;
import com.ai.ge.platform.model.arrears.ArrearsRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrearsRelationMapper {
    int countByExample(ArrearsRelationExample example);

    int deleteByExample(ArrearsRelationExample example);

    int deleteByPrimaryKey(Long reId);

    int insert(ArrearsRelation record);

    int insertSelective(ArrearsRelation record);

    List<ArrearsRelation> selectByExample(ArrearsRelationExample example);

    ArrearsRelation selectByPrimaryKey(Long reId);

    int updateByExampleSelective(@Param("record") ArrearsRelation record, @Param("example") ArrearsRelationExample example);

    int updateByExample(@Param("record") ArrearsRelation record, @Param("example") ArrearsRelationExample example);

    int updateByPrimaryKeySelective(ArrearsRelation record);

    int updateByPrimaryKey(ArrearsRelation record);
}
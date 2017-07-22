package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.DeliverOrderRelation;
import com.ai.ge.platform.model.order.DeliverOrderRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliverOrderRelationMapper {
    int countByExample(DeliverOrderRelationExample example);

    int deleteByExample(DeliverOrderRelationExample example);

    int deleteByPrimaryKey(Long relationId);

    int insert(DeliverOrderRelation record);

    int insertSelective(DeliverOrderRelation record);

    List<DeliverOrderRelation> selectByExample(DeliverOrderRelationExample example);

    DeliverOrderRelation selectByPrimaryKey(Long relationId);

    int updateByExampleSelective(@Param("record") DeliverOrderRelation record, @Param("example") DeliverOrderRelationExample example);

    int updateByExample(@Param("record") DeliverOrderRelation record, @Param("example") DeliverOrderRelationExample example);

    int updateByPrimaryKeySelective(DeliverOrderRelation record);

    int updateByPrimaryKey(DeliverOrderRelation record);
}
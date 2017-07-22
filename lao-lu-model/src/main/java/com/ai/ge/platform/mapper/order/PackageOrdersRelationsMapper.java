package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.PackageOrdersRelations;
import com.ai.ge.platform.model.order.PackageOrdersRelationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PackageOrdersRelationsMapper {
    int countByExample(PackageOrdersRelationsExample example);

    int deleteByExample(PackageOrdersRelationsExample example);

    int deleteByPrimaryKey(Long relationId);

    int insert(PackageOrdersRelations record);

    int insertSelective(PackageOrdersRelations record);

    List<PackageOrdersRelations> selectByExample(PackageOrdersRelationsExample example);

    PackageOrdersRelations selectByPrimaryKey(Long relationId);

    int updateByExampleSelective(@Param("record") PackageOrdersRelations record, @Param("example") PackageOrdersRelationsExample example);

    int updateByExample(@Param("record") PackageOrdersRelations record, @Param("example") PackageOrdersRelationsExample example);

    int updateByPrimaryKeySelective(PackageOrdersRelations record);

    int updateByPrimaryKey(PackageOrdersRelations record);
}
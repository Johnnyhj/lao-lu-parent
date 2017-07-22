package com.ai.ge.platform.mapper.product;

import com.ai.ge.platform.model.product.ParaGroupMembers;
import com.ai.ge.platform.model.product.ParaGroupMembersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParaGroupMembersMapper {
    int countByExample(ParaGroupMembersExample example);

    int deleteByExample(ParaGroupMembersExample example);

    int insert(ParaGroupMembers record);

    int insertSelective(ParaGroupMembers record);

    List<ParaGroupMembers> selectByExample(ParaGroupMembersExample example);

    int updateByExampleSelective(@Param("record") ParaGroupMembers record, @Param("example") ParaGroupMembersExample example);

    int updateByExample(@Param("record") ParaGroupMembers record, @Param("example") ParaGroupMembersExample example);
}
package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.dto.order.FreightDto;
import com.ai.ge.platform.model.order.Freight;
import com.ai.ge.platform.model.order.FreightExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FreightMapper {
    int countByExample(FreightExample example);

    int deleteByExample(FreightExample example);

    int deleteByPrimaryKey(Long freightId);

    int insert(Freight record);

    int insertSelective(Freight record);

    List<Freight> selectByExample(FreightExample example);

    Freight selectByPrimaryKey(Long freightId);

    int updateByExampleSelective(@Param("record") Freight record, @Param("example") FreightExample example);

    int updateByExample(@Param("record") Freight record, @Param("example") FreightExample example);

    int updateByPrimaryKeySelective(Freight record);

    int updateByPrimaryKey(Freight record);

    List<FreightDto> listBySelective(Freight record);
}
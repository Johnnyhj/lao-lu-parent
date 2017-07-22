package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.model.order.OfferSpec;
import com.ai.ge.platform.model.order.OfferSpecExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfferSpecMapper {
    int countByExample(OfferSpecExample example);

    int deleteByExample(OfferSpecExample example);

    int deleteByPrimaryKey(Long offerSpecId);

    int insert(OfferSpec record);

    int insertSelective(OfferSpec record);

    List<OfferSpec> selectByExample(OfferSpecExample example);

    OfferSpec selectByPrimaryKey(Long offerSpecId);

    int updateByExampleSelective(@Param("record") OfferSpec record, @Param("example") OfferSpecExample example);

    int updateByExample(@Param("record") OfferSpec record, @Param("example") OfferSpecExample example);

    int updateByPrimaryKeySelective(OfferSpec record);

    int updateByPrimaryKey(OfferSpec record);

    List<OfferSpecDto> listBySelective(OfferSpec record);

    List<OfferSpecDto> findListByArea(OfferSpec record);

}
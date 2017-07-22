package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.OfferSpecInfo;
import com.ai.ge.platform.model.order.OfferSpecInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfferSpecInfoMapper {
    int countByExample(OfferSpecInfoExample example);

    int deleteByExample(OfferSpecInfoExample example);

    int deleteByPrimaryKey(Long offerSpecId);

    int insert(OfferSpecInfo record);

    int insertSelective(OfferSpecInfo record);

    List<OfferSpecInfo> selectByExample(OfferSpecInfoExample example);

    OfferSpecInfo selectByPrimaryKey(Long offerSpecId);

    int updateByExampleSelective(@Param("record") OfferSpecInfo record, @Param("example") OfferSpecInfoExample example);

    int updateByExample(@Param("record") OfferSpecInfo record, @Param("example") OfferSpecInfoExample example);

    int updateByPrimaryKeySelective(OfferSpecInfo record);

    int updateByPrimaryKey(OfferSpecInfo record);
}
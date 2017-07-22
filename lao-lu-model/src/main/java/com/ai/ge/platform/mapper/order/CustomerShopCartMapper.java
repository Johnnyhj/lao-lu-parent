package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.CustomerShopCart;
import com.ai.ge.platform.model.order.CustomerShopCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerShopCartMapper {
    int countByExample(CustomerShopCartExample example);

    int deleteByExample(CustomerShopCartExample example);

    int deleteByPrimaryKey(Long scId);

    int insert(CustomerShopCart record);

    int insertSelective(CustomerShopCart record);

    List<CustomerShopCart> selectByExample(CustomerShopCartExample example);

    CustomerShopCart selectByPrimaryKey(Long scId);

    int updateByExampleSelective(@Param("record") CustomerShopCart record, @Param("example") CustomerShopCartExample example);

    int updateByExample(@Param("record") CustomerShopCart record, @Param("example") CustomerShopCartExample example);

    int updateByPrimaryKeySelective(CustomerShopCart record);

    int updateByPrimaryKey(CustomerShopCart record);
}
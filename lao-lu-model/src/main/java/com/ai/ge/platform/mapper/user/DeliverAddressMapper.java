package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.model.user.DeliverAddress;
import com.ai.ge.platform.model.user.DeliverAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliverAddressMapper {
    int countByExample(DeliverAddressExample example);

    int deleteByExample(DeliverAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeliverAddress record);

    int insertSelective(DeliverAddress record);

    List<DeliverAddress> selectByExample(DeliverAddressExample example);

    DeliverAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeliverAddress record, @Param("example") DeliverAddressExample example);

    int updateByExample(@Param("record") DeliverAddress record, @Param("example") DeliverAddressExample example);

    int updateByPrimaryKeySelective(DeliverAddress record);

    int updateByPrimaryKey(DeliverAddress record);

    int deleteByPlatformuserid(@Param("platformUserId") Long platformUserId);

    int insertDeliverAddresses(List<DeliverAddress> deliverAddresses);
}
package com.ai.ge.platform.mapper.arrears;

import com.ai.ge.platform.model.arrears.ArrearsUserInfo;
import com.ai.ge.platform.model.arrears.ArrearsUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrearsUserInfoMapper {
    int countByExample(ArrearsUserInfoExample example);

    int deleteByExample(ArrearsUserInfoExample example);

    int deleteByPrimaryKey(Long auId);

    int insert(ArrearsUserInfo record);

    int insertSelective(ArrearsUserInfo record);

    List<ArrearsUserInfo> selectByExample(ArrearsUserInfoExample example);

    ArrearsUserInfo selectByPrimaryKey(Long auId);

    int updateByExampleSelective(@Param("record") ArrearsUserInfo record, @Param("example") ArrearsUserInfoExample example);

    int updateByExample(@Param("record") ArrearsUserInfo record, @Param("example") ArrearsUserInfoExample example);

    int updateByPrimaryKeySelective(ArrearsUserInfo record);

    int updateByPrimaryKey(ArrearsUserInfo record);
}
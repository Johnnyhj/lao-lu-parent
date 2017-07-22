package com.ai.ge.platform.mapper.order;

import com.ai.ge.platform.model.order.PackageBasicInfo;
import com.ai.ge.platform.model.order.PackageBasicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PackageBasicInfoMapper {
    int countByExample(PackageBasicInfoExample example);

    int deleteByExample(PackageBasicInfoExample example);

    int deleteByPrimaryKey(Long packageId);

    int insert(PackageBasicInfo record);

    int insertSelective(PackageBasicInfo record);

    List<PackageBasicInfo> selectByExample(PackageBasicInfoExample example);

    PackageBasicInfo selectByPrimaryKey(Long packageId);

    int updateByExampleSelective(@Param("record") PackageBasicInfo record, @Param("example") PackageBasicInfoExample example);

    int updateByExample(@Param("record") PackageBasicInfo record, @Param("example") PackageBasicInfoExample example);

    int updateByPrimaryKeySelective(PackageBasicInfo record);

    int updateByPrimaryKey(PackageBasicInfo record);
}
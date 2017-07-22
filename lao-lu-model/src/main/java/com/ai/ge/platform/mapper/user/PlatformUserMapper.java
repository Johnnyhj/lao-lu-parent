package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.dto.user.PlatformUserDto;
import com.ai.ge.platform.model.user.PlatformUser;
import com.ai.ge.platform.model.user.PlatformUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlatformUserMapper {
    int countByExample(PlatformUserExample example);

    int deleteByExample(PlatformUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PlatformUser record);

    int insertSelective(PlatformUser record);

    List<PlatformUser> selectByExample(PlatformUserExample example);

    PlatformUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlatformUser record, @Param("example") PlatformUserExample example);

    int updateByExample(@Param("record") PlatformUser record, @Param("example") PlatformUserExample example);

    int updateByPrimaryKeySelective(PlatformUser record);

    int updateByPrimaryKey(PlatformUser record);

    List<PlatformUserDto> listBySelective(PlatformUser record);


}
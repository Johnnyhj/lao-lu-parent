package com.ai.ge.platform.mapper.user;

import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysResourceMapper {
    int countByExample(SysResourceExample example);

    int deleteByExample(SysResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    List<SysResource> selectByExample(SysResourceExample example);

    SysResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    List<SysResource> listForTree();

    List<SysResource> listObjectByUsername(@Param("userName") String userName, @Param("resourceType") String
            resourceType);

    List<SysResource> listObjectByUsernameOrga(@Param("username") String userName, @Param("resourceType") String
            resourceType);
}
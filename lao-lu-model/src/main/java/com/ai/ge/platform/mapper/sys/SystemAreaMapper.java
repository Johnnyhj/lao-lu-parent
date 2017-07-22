package com.ai.ge.platform.mapper.sys;

import com.ai.ge.platform.dto.sys.SystemAreaDto;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.sys.SystemAreaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SystemAreaMapper {
    int countByExample(SystemAreaExample example);

    int deleteByExample(SystemAreaExample example);

    int deleteByPrimaryKey(Long areaId);

    int insert(SystemArea record);

    int insertSelective(SystemArea record);

    List<SystemArea> selectByExample(SystemAreaExample example);

    SystemArea selectByPrimaryKey(Long areaId);

    int updateByExampleSelective(@Param("record") SystemArea record, @Param("example") SystemAreaExample example);

    int updateByExample(@Param("record") SystemArea record, @Param("example") SystemAreaExample example);

    int updateByPrimaryKeySelective(SystemArea record);

    int updateByPrimaryKey(SystemArea record);

    SystemAreaDto selectParentSystemArea(Long areaId);


    SystemArea selectByareaName(@Param("areaName")String areaName);

    SystemArea getParentArea(@Param("parAreaId")Long parAreaId);

    /**
     * 根据地区名称返回对应的地区ID
     * @param areaName
     * @return
     */
    List<Map<String, Long>> listAreaIdName(@Param("areaName") List<String> areaName);

    /**
     * 根据id查询该区域的父区域和自己
     * @param areaId
     * @return
     */
    List<SystemArea> listChildrenAndParentArea(@Param("userType") Short userType, @Param("areaId") Long areaId);
}
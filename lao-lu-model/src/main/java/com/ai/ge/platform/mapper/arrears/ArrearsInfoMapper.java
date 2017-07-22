package com.ai.ge.platform.mapper.arrears;

import com.ai.ge.platform.model.arrears.ArrearsInfo;
import com.ai.ge.platform.model.arrears.ArrearsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrearsInfoMapper {
    int countByExample(ArrearsInfoExample example);

    int deleteByExample(ArrearsInfoExample example);

    int deleteByPrimaryKey(Long arrearsId);

    int insert(ArrearsInfo record);

    int insertSelective(ArrearsInfo record);

    List<ArrearsInfo> selectByExample(ArrearsInfoExample example);

    ArrearsInfo selectByPrimaryKey(Long arrearsId);

    int updateByExampleSelective(@Param("record") ArrearsInfo record, @Param("example") ArrearsInfoExample example);

    int updateByExample(@Param("record") ArrearsInfo record, @Param("example") ArrearsInfoExample example);

    int updateByPrimaryKeySelective(ArrearsInfo record);

    int updateByPrimaryKey(ArrearsInfo record);

    ArrearsInfo isExist(ArrearsInfo ArrearsInfo);

    int updateArrears(@Param("status") Integer status,@Param("arrearsPhone")String arrearsPhone);

    int resetArrears(@Param("status") Integer status);

    List<ArrearsInfo> selectNoneedCallArrears(@Param("status") Integer status);

    int removeNoneedCallArrears(@Param("list")List<ArrearsInfo> list);
}
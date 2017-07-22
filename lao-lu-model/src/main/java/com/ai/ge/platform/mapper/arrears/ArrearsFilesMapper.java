package com.ai.ge.platform.mapper.arrears;

import com.ai.ge.platform.model.arrears.ArrearsFiles;
import com.ai.ge.platform.model.arrears.ArrearsFilesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArrearsFilesMapper {
    int countByExample(ArrearsFilesExample example);

    int deleteByExample(ArrearsFilesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArrearsFiles record);

    int insertSelective(ArrearsFiles record);

    List<ArrearsFiles> selectByExample(ArrearsFilesExample example);

    ArrearsFiles selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArrearsFiles record, @Param("example") ArrearsFilesExample example);

    int updateByExample(@Param("record") ArrearsFiles record, @Param("example") ArrearsFilesExample example);

    int updateByPrimaryKeySelective(ArrearsFiles record);

    int updateByPrimaryKey(ArrearsFiles record);
}
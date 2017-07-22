package com.ai.ge.platform.mapper.arrears;

import com.ai.ge.platform.model.arrears.RemindPayLog;
import com.ai.ge.platform.model.arrears.RemindPayLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemindPayLogMapper {
    int countByExample(RemindPayLogExample example);

    int deleteByExample(RemindPayLogExample example);

    int deleteByPrimaryKey(Long rpId);

    int insert(RemindPayLog record);

    int insertSelective(RemindPayLog record);

    List<RemindPayLog> selectByExample(RemindPayLogExample example);

    RemindPayLog selectByPrimaryKey(Long rpId);

    int updateByExampleSelective(@Param("record") RemindPayLog record, @Param("example") RemindPayLogExample example);

    int updateByExample(@Param("record") RemindPayLog record, @Param("example") RemindPayLogExample example);

    int updateByPrimaryKeySelective(RemindPayLog record);

    int updateByPrimaryKey(RemindPayLog record);
}
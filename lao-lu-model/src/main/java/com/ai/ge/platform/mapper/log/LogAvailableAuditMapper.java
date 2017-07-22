package com.ai.ge.platform.mapper.log;

import com.ai.ge.platform.model.log.LogAvailableAudit;
import com.ai.ge.platform.model.log.LogAvailableAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogAvailableAuditMapper {
    int countByExample(LogAvailableAuditExample example);

    int deleteByExample(LogAvailableAuditExample example);

    int deleteByPrimaryKey(Long auditId);

    int insert(LogAvailableAudit record);

    int insertSelective(LogAvailableAudit record);

    List<LogAvailableAudit> selectByExample(LogAvailableAuditExample example);

    LogAvailableAudit selectByPrimaryKey(Long auditId);

    int updateByExampleSelective(@Param("record") LogAvailableAudit record, @Param("example") LogAvailableAuditExample example);

    int updateByExample(@Param("record") LogAvailableAudit record, @Param("example") LogAvailableAuditExample example);

    int updateByPrimaryKeySelective(LogAvailableAudit record);

    int updateByPrimaryKey(LogAvailableAudit record);
}
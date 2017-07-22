package com.ai.ge.platform.service.log;

import com.ai.ge.platform.model.log.LogAuthProcess;
import com.ai.ge.platform.model.log.LogAuthProcessWithBLOBs;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.dto.log.LogAuthProcessDto;
import com.ai.ge.platform.dto.sys.SysRoleDto;

import java.util.List;

/**
 * Created by guochunhao on 16/9/19.
 */
public interface LogAuthProcessService extends LoggerStorage {

    /**
     * 保存鉴权日志
     * @param record 日志对象
     */
    void saveLogAuthProcess(LogAuthProcessWithBLOBs record);

    /**
     * 对用户操作的相关日志记录
     *
     * @param user 用户
     * @param type 操作类型
     */
    void recordUserLog(String oldVal, SysUser user, short type, int remarkType);



    /**
     * 对角色操作的相关日志记录
     * @param role
     */
    void recordRoleLog(String oldVal, SysRoleDto role, short type, int remarkType);

    /**
     * 对权限操作的相关日志记录
     * @param sysResource
     */
    void recordSysResourceLog(String oldVal, SysResource sysResource, short type, int remarkType);

    /**
     * 根据条件查询日志记录
     *
     * @param logAuthProcess 查询条件
     * @return 日志列表
     */
    List<LogAuthProcessDto> findAll(LogAuthProcessWithBLOBs logAuthProcess);

    /**
     * 删除日志
     *
     * @param logAuthProcess
     * @return
     */
    int deleteLog(LogAuthProcess logAuthProcess);

    /**
     * 查看日志详情
     *
     * @param processId
     * @return
     */
    LogAuthProcessDto queryLogDetail(Long processId);
}

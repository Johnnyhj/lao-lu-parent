package com.ai.ge.platform.serviceimpl.log;

import com.ai.ge.pay.weixin.wxpay.utils.JackJson;
import com.ai.ge.platform.constant.LogAuthRemarkEnum;
import com.ai.ge.platform.dto.log.LogAuthProcessDto;
import com.ai.ge.platform.dto.sys.SysRoleDto;
import com.ai.ge.platform.mapper.log.LogAuthProcessMapper;
import com.ai.ge.platform.model.log.LogAuthProcess;
import com.ai.ge.platform.model.log.LogAuthProcessWithBLOBs;
import com.ai.ge.platform.model.log.LoggerStorageObject;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.service.log.LogAuthProcessService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.util.RequestThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by guochunhao on 16/9/19.
 */
@Service
public class LogAuthProcessServiceImpl implements LogAuthProcessService {

    private static final Logger logger = LoggerFactory.getLogger(LogAuthProcessServiceImpl.class);

    @Resource
    private LogAuthProcessMapper logAuthProcessMapper;

    @Resource
    private RedisSpringProxy redisService;

    @Override
    public void saveObject(LoggerStorageObject object) {

        if (null == object) {
            logger.info("注入object对象为空");
            return;
        }

        if (object instanceof LogAuthProcessWithBLOBs) {
            logAuthProcessMapper.insertSelective((LogAuthProcessWithBLOBs) object);
        } else {
            logger.info("注入object对象非LogAuthProcessWithBLOBs实例..." + object.getClass().getName());
        }

    }

    @Override
    public void saveLogAuthProcess(LogAuthProcessWithBLOBs record) {

        LoggerStorageFactory.add(this, record);

    }

    /**
     * 对用户操作的相关日志记录
     * @param user
     */
    public void recordUserLog(String oldVal, SysUser user, short type, int remarkType)
    {
        // 获取登录用户
        SysUser sysUser = (SysUser) RequestThreadLocal.getHttpThreadWrapper().getRequest().getAttribute("SYSTEM_CURRENT_USER");

        // 记录 创建用户 日志
        LogAuthProcessWithBLOBs logAuthProcess = new LogAuthProcessWithBLOBs();

        logAuthProcess.setAuthSysUserId(user.getId());
        logAuthProcess.setSysUserId(sysUser.getId());
        logAuthProcess.setOldVal(oldVal);
        logAuthProcess.setNewVal(JackJson.fromObjectToJson(user));
        logAuthProcess.setCreateTime(new Date());
        logAuthProcess.setOperateType(type);
        logAuthProcess.setRemark(LogAuthRemarkEnum.getLogAuthEnumType(remarkType).typeName);

        this.saveLogAuthProcess(logAuthProcess);

    }

    /**
     * 对角色操作的相关日志记录
     * @param role
     */
    public void recordRoleLog(String oldVal, SysRoleDto role, short type, int remarkType)
    {
        // 获取登录用户
        SysUser sysUser = (SysUser) RequestThreadLocal.getHttpThreadWrapper().getRequest().getAttribute("SYSTEM_CURRENT_USER");

        // 记录 创建用户 日志
        LogAuthProcessWithBLOBs logAuthProcess = new LogAuthProcessWithBLOBs();
        logAuthProcess.setSysUserId(sysUser.getId());
        logAuthProcess.setOldVal(oldVal);
        logAuthProcess.setNewVal(JackJson.fromObjectToJson(role));
        logAuthProcess.setCreateTime(new Date());
        logAuthProcess.setRoleId(role.getId());
        logAuthProcess.setRoleName(role.getRole());
        logAuthProcess.setAuthType((short) 2);
        logAuthProcess.setOperateType(type);
        logAuthProcess.setRemark(LogAuthRemarkEnum.getLogAuthEnumType(remarkType).typeName);

        this.saveLogAuthProcess(logAuthProcess);

    }

    /**
     * 对权限操作的相关日志记录
     * @param sysResource
     */
    public void recordSysResourceLog(String oldVal, SysResource sysResource, short type, int remarkType)
    {
        // 获取登录用户
        SysUser sysUser = (SysUser) RequestThreadLocal.getHttpThreadWrapper().getRequest().getAttribute("SYSTEM_CURRENT_USER");

        // 记录 创建用户 日志
        LogAuthProcessWithBLOBs logAuthProcess = new LogAuthProcessWithBLOBs();
        logAuthProcess.setSysUserId(sysUser.getId());
        logAuthProcess.setOldVal(oldVal);
        logAuthProcess.setNewVal(JackJson.fromObjectToJson(sysResource));
        logAuthProcess.setCreateTime(new Date());
        logAuthProcess.setResourceId(sysResource.getId());
        logAuthProcess.setResourceName(sysResource.getName());
        logAuthProcess.setAuthType((short) 1);
        logAuthProcess.setOperateType(type);
        logAuthProcess.setRemark(LogAuthRemarkEnum.getLogAuthEnumType(remarkType).typeName);

        this.saveLogAuthProcess(logAuthProcess);
    }

    /**
     * 根据条件查询日志记录
     * @param queryCond 查询条件
     * @return 日志列表
     */
    public List<LogAuthProcessDto> findAll(LogAuthProcessWithBLOBs logAuthProcess) {
        List<LogAuthProcessDto> list = logAuthProcessMapper.findAllLog(logAuthProcess);

        return list;

    }

    /**
     * 删除日志
     * @param logAuthProcess
     * @return
     */
    public int deleteLog(LogAuthProcess logAuthProcess) {
        return logAuthProcessMapper.deleteByPrimaryKey(logAuthProcess.getProcessId());
    }

    /**
     * 查看日志详情
     * @param logAuthProcess
     * @return
     */
    public LogAuthProcessDto queryLogDetail(Long processId) {
        return logAuthProcessMapper.queryLogDetailByProcessId(processId);
    }
}

package com.ai.ge.platform.serviceimpl.sys;

import com.ai.ge.common.smssend.SmssendService;
import com.ai.ge.platform.mapper.sys.SystemWarnProcessMapper;
import com.ai.ge.platform.service.log.LogSmsSendService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.service.sys.WarningService;
import com.ai.ge.common.smssend.bss.FaceResponse;
import com.ai.ge.platform.model.sys.SystemWarnProcess;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * Created by Zhaocy3 on 2016/3/15.
 */
@Service
public class WarningServiceImpl implements WarningService
{
    private static final Logger logger = LoggerFactory.getLogger(WarningServiceImpl.class);
    @Resource
    private SysDataService sysDataService;

    @Resource
    private SmssendService smssendService;

    @Resource
    private SystemWarnProcessMapper systemWarnProcessMapper;

    @Override
    public void sendWarningSms(String content, String type, Exception e) {

        //打印堆栈信息
        String warnMessage = null;
        try {
            if (null != e) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                e.printStackTrace(ps);
                warnMessage = baos.toString();
                ps.close();
                baos.close();
            }
        } catch (Exception ex) {
        }

        if (warnMessage == null) {
            warnMessage = content;
        } else if (warnMessage.length() > 3000) {
            warnMessage = warnMessage.substring(0, 3000);
        }

        SystemWarnProcess record = new SystemWarnProcess();
        record.setChannel(type);
        record.setProcessResult("0");
        record.setWarnMessage(warnMessage);
        record.setCreateTime(new Date());

        systemWarnProcessMapper.insert(record);

        content = content + ". 告警单号:" + record.getSystemWarnProcessId();

        String phones = sysDataService.getSmsTmp("sms_warning_phone");
        if (null != phones) {
            //中文逗号替换英文逗号
            phones = phones.replaceAll("，", ",");
            for (String s : phones.split(",")) {
                if (StringUtils.isEmpty(s)) {
                    continue;
                }
                FaceResponse resp = smssendService.sendSMS(s, content);

                if (null == resp || !"0".equals(resp.getResult())) {
                    logger.error("发送告警短信失败，数据库[SYSTEM_WARN_PROCESS]表ID[" + record.getPrcessId() + "]");
                    return;
                }
                SystemWarnProcess record1 = new SystemWarnProcess();
                record1.setProcessResult("1");
                record1.setPrcessId(record.getPrcessId());
                systemWarnProcessMapper.updateByPrimaryKeySelective(record1);
            }
        }

    }
}

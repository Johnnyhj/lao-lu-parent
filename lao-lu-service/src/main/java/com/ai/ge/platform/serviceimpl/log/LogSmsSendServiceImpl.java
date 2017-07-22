package com.ai.ge.platform.serviceimpl.log;

import com.ai.ge.platform.mapper.log.LogMessageSendMapper;
import com.ai.ge.platform.model.log.LogMessageSend;
import com.ai.ge.platform.model.log.LoggerStorageObject;
import com.ai.ge.platform.service.log.LogSmsSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 短信日志记录
 */
@Service
public class LogSmsSendServiceImpl implements LogSmsSendService {

    private static final Logger logger = LoggerFactory.getLogger(LogSmsSendServiceImpl.class);
    @Resource
    private LogMessageSendMapper logMessageSendMapper;


    @Override
    public void saveLogSmsSend(String phone, String content, String respMessage) {
        LogMessageSend smsLog = new LogMessageSend();
        smsLog.setReceiveNum(phone);
        smsLog.setSendText(content);
        smsLog.setType((short) 1);

        //if (null != resp && "0".equals(resp.getResult())) {
        //    smsLog.setRemarks(JackJson.fromObjectToJson(resp));
        //    smsLog.setStatus((short) 1);
        //} else if (null != resp) {
        //    smsLog.setFailReason(resp.getDescription());
        //    smsLog.setRemarks(JackJson.fromObjectToJson(resp));
        //    smsLog.setStatus((short) 0);
        //} else {
        //    smsLog.setStatus((short) 0);
        //}
        //smsLog.setCreateTime(new Date());

        LoggerStorageFactory.add(this, smsLog);
    }


    @Override
    public void saveObject(LoggerStorageObject object) {
        if (null == object) {
            logger.info("注入object对象为空");
            return;
        }

        if (object instanceof LogMessageSend) {
            logMessageSendMapper.insert((LogMessageSend) object);
        } else {
            logger.info("注入object对象非LogOrders实例..." + object.getClass().getName());
        }
    }
}

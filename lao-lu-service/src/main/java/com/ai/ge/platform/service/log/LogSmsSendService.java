package com.ai.ge.platform.service.log;

/**
 * 发送短信日志
 */
public interface LogSmsSendService extends LoggerStorage{



    /**
     *
     * @param phone 发送短信号码
     * @param content 短信内容
     * @param respMessage 调用发送短信网关返回内容
     */
    void saveLogSmsSend(String phone,String content,String respMessage);

}

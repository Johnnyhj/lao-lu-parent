package com.ai.ge.platform.service.log;

import com.ai.ge.platform.model.log.LogMessageSend;

import java.util.List;

/**
 * Created by count on 17/3/7.
 */
public interface MessageService
{
    /**
     * 根据条件查询 (消息列表查询 详情查询)
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<LogMessageSend> findAll(LogMessageSend record) throws Exception;

    /**
     * 更新消息
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateMessage(LogMessageSend record) throws Exception;

    /**
     * 删除消息
     *
     * @param messageSendId
     * @return
     * @throws Exception
     */
    int deleteMessage(Long messageSendId) throws Exception;

    /**
     * 批量删除消息
     *
     * @param list
     * @return
     * @throws Exception
     */
    int batchDeleteMessage(List<LogMessageSend> list) throws Exception;
}

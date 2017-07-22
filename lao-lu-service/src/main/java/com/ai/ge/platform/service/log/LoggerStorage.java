package com.ai.ge.platform.service.log;

import com.ai.ge.platform.model.log.LoggerStorageObject;

/**
 * 日志记录存储接口
 */
public interface LoggerStorage {
    /**
     * 存储日志
     *
     * @param object
     */
    void saveObject(LoggerStorageObject object);

}

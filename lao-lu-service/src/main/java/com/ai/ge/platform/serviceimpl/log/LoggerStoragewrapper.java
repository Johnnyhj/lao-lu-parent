package com.ai.ge.platform.serviceimpl.log;

import com.ai.ge.platform.model.log.LoggerStorageObject;
import com.ai.ge.platform.service.log.LoggerStorage;

/**
 * Created by sx on 2016/3/7.
 */
public class LoggerStoragewrapper {
    private LoggerStorage loggerStorage;
    private LoggerStorageObject object;

    public LoggerStoragewrapper(LoggerStorage loggerStorage, LoggerStorageObject object) {
        this.loggerStorage = loggerStorage;
        this.object = object;
    }

    public LoggerStorage getLoggerStorage() {
        return loggerStorage;
    }

    public LoggerStorageObject getObject() {
        return object;
    }
}

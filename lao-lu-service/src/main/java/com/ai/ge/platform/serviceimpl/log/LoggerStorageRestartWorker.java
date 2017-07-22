package com.ai.ge.platform.serviceimpl.log;

import com.ai.ge.platform.service.log.LoggerStorageRestart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 遇到错误时重启日志存储线程
 */
public class LoggerStorageRestartWorker<T> {
    private static final Logger logger = LoggerFactory.getLogger(LoggerStorageRestartWorker.class);

    private LoggerStorageRestart runnable;

    public LoggerStorageRestartWorker(LoggerStorageRestart runnable) {
        this.runnable = runnable;
    }

    public void restart(LinkedBlockingQueue<T> loggerStorages) {
        runnable.reset(loggerStorages);

        new Thread(runnable).start();
    }
}

package com.ai.ge.platform.service.log;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sx on 2016/3/9.
 */
public interface LoggerStorageRestart<T extends Object> extends Runnable {
    /**
     * 重置日志队列
     *
     * @param linkedBlockingQueue
     */
    void reset(LinkedBlockingQueue<T> linkedBlockingQueue);

}

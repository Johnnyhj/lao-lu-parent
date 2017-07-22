package com.ai.ge.platform.serviceimpl.log;

import com.ai.ge.platform.model.log.LoggerStorageObject;
import com.ai.ge.platform.service.log.LoggerStorage;
import com.ai.ge.platform.service.log.LoggerStorageRestart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 日志记录工厂
 */
public final class LoggerStorageFactory implements LoggerStorageRestart<LoggerStoragewrapper>
{

    private static final Logger logger = LoggerFactory.getLogger(LoggerStorageFactory.class);

    private static LinkedBlockingQueue<LoggerStoragewrapper> loggerStorages = new
            LinkedBlockingQueue<LoggerStoragewrapper>();

    static {
        new Thread(new LoggerStorageFactory()).start();
    }

    /**
     * 添加日志记录接口和日志记录对象
     *
     * @param loggerStorage
     * @param object
     */
    public static void add(LoggerStorage loggerStorage, LoggerStorageObject object) {
        try {
            loggerStorages.put(new LoggerStoragewrapper(loggerStorage, object));
        } catch (InterruptedException e) {
            logger.error("添加日志记录接口和日志记录对象队列时发生异常：", e);
        }
    }

    /**
     * 重置日志队列
     *
     * @param loggerStorages
     */
    public void resetLoggerStoragewrapperQueue(LinkedBlockingQueue<LoggerStoragewrapper> loggerStorages) {
        loggerStorages = loggerStorages;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                LoggerStoragewrapper loggerStoragewrapper = loggerStorages.take();
                loggerStoragewrapper.getLoggerStorage().saveObject(loggerStoragewrapper.getObject());
            }
        } catch (Exception e) {
            logger.error("保存日志记录时发生异常：", e);
            //e.printStackTrace();

            logger.info("保存日志记录时发生异常，正在重启......");

            LoggerStorageRestartWorker restart = new LoggerStorageRestartWorker(this);
            restart.restart(loggerStorages);

            logger.info("保存日志记录时发生异常，重启成功");
        }
    }

    @Override
    public void reset(LinkedBlockingQueue<LoggerStoragewrapper> linkedBlockingQueue) {
        loggerStorages = linkedBlockingQueue;
    }
}

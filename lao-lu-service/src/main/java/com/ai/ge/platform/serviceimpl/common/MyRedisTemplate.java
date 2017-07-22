package com.ai.ge.platform.serviceimpl.common;

import com.ai.ge.platform.service.sys.WarningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Created by Zhaocy3 on 2016/3/15.
 */
public class MyRedisTemplate<K, V> extends RedisTemplate<K, V>
{
    private static final Logger logger = LoggerFactory.getLogger(MyRedisTemplate.class);

    private static long warningTime = 0;

    @Resource
    private WarningService warningService;
    /**
     * 重写redis执行方法
     * 捕获到异常时正常返回null值，并短信告警
     *
     * @param action
     * @param <T>
     * @return
     */
    public <T> T execute(RedisCallback<T> action)
    {
        try
        {
            return execute(action, isExposeConnection());
        }
        catch (Exception e)
        {
            logger.error("Redis error.");
            logger.error(e.getMessage());
            if(System.currentTimeMillis() - warningTime > 1000*60*60)
            {
                warningTime = System.currentTimeMillis();
                logger.error(e.getMessage(), e);
                //TODO 发送告警短信
                warningService.sendWarningSms("告警：Redis发生异常","redis", e);
            }
            return null;
        }

    }
}

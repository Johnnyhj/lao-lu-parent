package com.ai.ge.platform.controller.indexmain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by count on 17/5/10.
 *
 * 刷新 redis 缓存
 */
@Service
@AbilityRegister(name = "flushall")
public class FlushRedisMain implements IAbility
{
    @Autowired
    private RedisSpringProxy redisService;

    @Override
    public Message execute(Message message)
    {
        redisService.flushAll();

        return message;
    }
}

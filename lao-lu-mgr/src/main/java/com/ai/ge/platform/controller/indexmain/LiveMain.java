package com.ai.ge.platform.controller.indexmain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;

/**
 * Created by count on 17/5/10.
 *
 * 心跳测试
 */
@AbilityRegister(name = "live")
public class LiveMain implements IAbility
{
    @Override
    public Message execute(Message message)
    {
        message.setBody("I'm still alive, bang bang bang......");

        return message;
    }
}

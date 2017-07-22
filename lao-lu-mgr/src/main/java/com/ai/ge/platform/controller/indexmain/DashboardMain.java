package com.ai.ge.platform.controller.indexmain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;

/**
 * Created by guochunhao on 17/5/10.
 */

/**
 * 跳转 dashboard 页面
 */
@AbilityRegister(name = "dashboard")
public class DashboardMain implements IAbility
{
    @Override
    public Message execute(Message message)
    {
        message.setView("dashboard1");

        return message;
    }
}

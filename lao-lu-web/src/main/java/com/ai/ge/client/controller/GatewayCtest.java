package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Sam on 17/5/31.
 */
@Service
@AbilityRegister(name = "" ,desc="首页选取省份 提交")
public class GatewayCtest implements IAbility{

    private Logger logger = LoggerFactory.getLogger(GatewayCtest.class);


    @Override
    public Message execute(Message message) {

        //TODO chose 省份
        //TODO 拼接redirect  url
        String appid="";
        message.setView("redirect:"+"https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?" +
                "app_id="+appid+"&scope= auth_userinfo&redirect_uri=http://sam.tunnel.qydev.com/web/core/gateway");
        return message;
    }
}

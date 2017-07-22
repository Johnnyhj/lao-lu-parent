package com.ai.ge.platform.controller.order;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.common.jcaptcha.Constants;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.utils.AbilityUtil;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/28.
 */
@Service
@AbilityRegister(name = "shuaiDan")
public class ShuaiDanMain extends ServiceParamMain implements IAbility
{

    @Override
    public Message execute(Message message)
    {
        Message request = new Message();
        request.setAbilityName("listDelivery");

        message.getRequest().setAttribute("addStatus", Constants.ORDER_STATUS.SHUAI_DAN);

        request.setRequest(message.getRequest());
        request = AbilityUtil.invokeSync(request);
        request.setBody(request.getBody());
        request.setView("shuaidan/listShuaiDan");

        return request;
    }
}

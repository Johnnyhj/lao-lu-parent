package com.ai.ge.platform.controller.platformuser;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.user.PlatformUserDto;
import com.ai.ge.platform.model.user.PlatformUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guochunhao on 17/5/27.
 */
@Service
@AbilityRegister(name = "platformUserDetail")
public class PlatformUserDetailMain extends ServiceParamMain implements IAbility
{
    @Override
    public Message execute(Message message)
    {
        Long id = Long.valueOf(message.getParameter("id"));

        PlatformUser record = new PlatformUser();
        record.setId(id);
        List<PlatformUserDto> list = platformUserService.findListByCond(record);

        message.setBody(list.get(0));
        message.setView("platformuser/platformDetail");

        return message;
    }

}

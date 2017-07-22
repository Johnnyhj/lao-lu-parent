package com.ai.ge.platform.controller.platformuser;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.user.PlatformUserDto;
import com.ai.ge.platform.model.user.PlatformUser;
import com.ai.ge.platform.page.PageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "platformUser")
public class ListPlatformUserMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListPlatformUserMain.class);

    @Override
    public Message execute(Message message)
    {
        PlatformUser platformUser = message.getParam(PlatformUser.class);

        try

        {
            PageContext page = super.setPageContext(message.getRequest());

            List<PlatformUserDto> list = platformUserService.findListByCond(platformUser);

            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("list", list);
            resultMap.put("page", page);

            PageContext.removeContext();

            message.setBody(resultMap);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        message.setView("platformuser/listPlatformUser");

        return message;
    }
}

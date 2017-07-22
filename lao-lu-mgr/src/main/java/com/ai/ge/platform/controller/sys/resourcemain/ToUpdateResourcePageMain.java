package com.ai.ge.platform.controller.sys.resourcemain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.user.SysResource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "updateResourcePage")
public class ToUpdateResourcePageMain extends ServiceParamMain implements IAbility
{

    @Override
    public Message execute(Message message)
    {
        Long id = Long.valueOf(message.getParameter("resourceId"));

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("resource", resourceService.findOne(id));
        resultMap.put("types", SysResource.ResourceType.values());
        resultMap.put("op", "修改");

        message.setBody(resultMap);
        message.setView("resource/edit");

        return message;
    }


}


package com.ai.ge.platform.controller.sys.resourcemain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.user.SysResource;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "resource")
public class ListResourceMain extends ServiceParamMain implements IAbility
{
//    @RequiresPermissions("resource:view")
    @Override
    public Message execute(Message message)
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        List<SysResource> forTree = resourceService.findForTree();

        resultMap.put("resourceList", JSON.toJSONString(forTree));
        resultMap.put("types", SysResource.ResourceType.values());

        message.setBody(resultMap);
        message.setView("resource/list_new");

        return message;
    }
}

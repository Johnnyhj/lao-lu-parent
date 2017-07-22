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
@AbilityRegister(name = "appendChild")
public class ToAddResourcePageMain extends ServiceParamMain implements IAbility
{

    @Override
    public Message execute(Message message)
    {
        Long parentId = Long.valueOf(message.getParameter("parentId"));

        SysResource parent = resourceService.findOne(parentId);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("parent", parent);

        SysResource child = new SysResource();
        child.setParentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());

        resultMap.put("resource", child);
        resultMap.put("op", "新增子节点");
        resultMap.put("types", SysResource.ResourceType.values());

        message.setBody(resultMap);
        message.setView("resource/edit");

        return message;
    }

}


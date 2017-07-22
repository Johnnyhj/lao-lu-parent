package com.ai.ge.platform.controller.indexmain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.service.user.SysResourceService;
import com.ai.ge.platform.shiro.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/10.
 */
@Service
@AbilityRegister(name = "index")
public class IndexMain implements IAbility
{

    @Autowired
    private SysResourceService resourceService;

    @Override
    public Message execute(Message message)
    {
        SysUser loginUser = (SysUser) message.getRequest().getAttribute(Constants.SYSTEM_CURRENT_USER);

        List<SysResource> menus = resourceService.findMenus(loginUser);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("menus", menus);

        message.setBody(resultMap);

        message.setView("material_index_new");

        return message;
    }
}

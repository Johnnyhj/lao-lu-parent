package com.ai.ge.platform.controller.sys.resourcemain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.constant.LogAuthRemarkEnum;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.utils.AbilityUtil;
import org.springframework.stereotype.Service;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "addResource")
public class AddResourceMain extends ServiceParamMain implements IAbility
{
//    @RequiresPermissions("resource:create")
    @Override
    public Message execute(Message message)
    {
        SysResource resource = message.getParam(SysResource.class);

        resourceService.createResource(resource);

        message.setMsg("新增子节点成功");

        // 记录增加权限日志
        logAuthProcessService.recordSysResourceLog("", resource, (short) 1, LogAuthRemarkEnum.addSysResource.value);

        Message request = new Message();
        request.setAbilityName("resource");

        AbilityUtil.invokeSync(request);

        return request;
    }

}

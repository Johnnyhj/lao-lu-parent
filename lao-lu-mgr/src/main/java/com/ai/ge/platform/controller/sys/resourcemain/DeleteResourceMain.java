package com.ai.ge.platform.controller.sys.resourcemain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.pay.weixin.wxpay.utils.JackJson;
import com.ai.ge.platform.constant.LogAuthRemarkEnum;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.utils.AbilityUtil;
import org.springframework.stereotype.Service;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "deleteResource")
public class DeleteResourceMain extends ServiceParamMain implements IAbility
{
//    @RequiresPermissions("resource:create")
    @Override
    public Message execute(Message message)
    {
        Long id = Long.valueOf(message.getParameter("resourceId"));
        SysResource one = resourceService.findOne(id);
        String oldValJson = JackJson.fromObjectToJson(one);

        resourceService.deleteResource(id);

        // 记录增加权限日志
        SysResource resource = new SysResource();
        resource.setId(id);
        logAuthProcessService.recordSysResourceLog(oldValJson, resource, (short) 3, LogAuthRemarkEnum.deleteSysResource.value);


        Message request = new Message();
        request.setAbilityName("resource");

        AbilityUtil.invokeSync(request);

        return request;
    }

}

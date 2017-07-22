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
@AbilityRegister(name = "updateResource")
public class UpdateResourceMain extends ServiceParamMain implements IAbility
{
//    @RequiresPermissions("resource:create")
    @Override
    public Message execute(Message message)
    {
        SysResource resource = message.getParam(SysResource.class);

        String oldValJson = JackJson.fromObjectToJson(resource);

        resourceService.updateResource(resource);

//        redirectAttributes.addFlashAttribute("resultMsg", "修改成功");

        // 记录修改权限日志
        logAuthProcessService.recordSysResourceLog(oldValJson, resource, (short) 2, LogAuthRemarkEnum.modifySysResource.value);

        Message request = new Message();
        request.setAbilityName("resource");

        AbilityUtil.invokeSync(request);

        return request;
    }

}

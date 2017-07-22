package com.ai.ge.platform.controller.sys.sysdatamain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.constant.LogAuthRemarkEnum;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.sys.SystemDataDictionary;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.util.RequestThreadLocal;
import com.ai.ge.utils.AbilityUtil;
import net.sf.json.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "updateData")
public class UpdateDataMain extends ServiceParamMain implements IAbility
{
    @RequiresPermissions("sysdata:update")
    @Override
    public Message execute(Message message)
    {
        SystemDataDictionary data = message.getParam(SystemDataDictionary.class);

        SysUser sysUser = (SysUser) RequestThreadLocal.getHttpThreadWrapper().getRequest().getAttribute("SYSTEM_CURRENT_USER");

        SystemDataDictionary dic = sysDataService.getByDdId(data.getDdId());

        sysDataService.updateSysData(data);

        message.setMsg("修改成功");

        //记录操作日志
        logAuthProcessService.recordUserLog(JSONArray.fromObject(dic).toString(), sysUser, (short) 1, LogAuthRemarkEnum.modifySysResource.value);

        Message request = new Message();
        request.setAbilityName("sysData");

        AbilityUtil.invokeSync(request);

        return request;
    }
}

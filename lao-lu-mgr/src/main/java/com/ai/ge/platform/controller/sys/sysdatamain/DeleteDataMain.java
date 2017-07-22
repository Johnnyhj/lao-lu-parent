package com.ai.ge.platform.controller.sys.sysdatamain;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.utils.AbilityUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "deleteData")
public class DeleteDataMain extends ServiceParamMain implements IAbility
{
    private static final Logger logger = LoggerFactory.getLogger(DeleteDataMain.class);

    @RequiresPermissions("sysdata:delete")
    @Override
    public Message execute(Message message)
    {
        Long ddId = Long.valueOf(message.getParameter("ddId"));

        // 调用其他能力的 messgae
        Message request = new Message();

        try
        {
            sysDataService.deleteSysData(ddId);

            request.setMsg("删除成功");
            request.setCode(AbilityConstant.R_SUCCESS);

        } catch (Exception e)
        {
            e.printStackTrace();

            request.setMsg("删除失败");
            request.setCode(AbilityConstant.R_SUCCESS);

        }

        request.setAbilityName("sysData");
        request.setRequest(message.getRequest());

        request = AbilityUtil.invokeSync(request);

        return request;
    }

}

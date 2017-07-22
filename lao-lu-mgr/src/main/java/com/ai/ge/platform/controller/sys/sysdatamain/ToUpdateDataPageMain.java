package com.ai.ge.platform.controller.sys.sysdatamain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.sys.SystemDataDictionary;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "toUpdateDataPage")
public class ToUpdateDataPageMain extends ServiceParamMain implements IAbility
{

    @RequiresPermissions("sysdata:update")
    @Override
    public Message execute(Message message)
    {
        Long ddId = Long.valueOf(message.getParameter("ddId"));

        SystemDataDictionary dic = sysDataService.getByDdId(ddId);

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("data", dic);
        resultMap.put("op", "修改");

        message.setBody(resultMap);
        message.setView("sysdata/dataEdit_new");

        return message;
    }

}


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
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "toCreateDataPage")
public class ToAddDataPageMain extends ServiceParamMain implements IAbility
{

    @RequiresPermissions("sysdata:create")
    @Override
    public Message execute(Message message)
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("data", new SystemDataDictionary());
        resultMap.put("op", "新增");

        message.setBody(resultMap);
        message.setView("sysdata/dataEdit_new");

        return message;
    }

}


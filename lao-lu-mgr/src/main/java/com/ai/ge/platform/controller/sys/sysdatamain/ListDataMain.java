package com.ai.ge.platform.controller.sys.sysdatamain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.sys.SystemDataDictionary;
import com.ai.ge.platform.page.PageContext;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "sysData")
public class ListDataMain extends ServiceParamMain implements IAbility
{
    @RequiresPermissions("sysdata:view")
    @Override
    public Message execute(Message message)
    {
        PageContext page = super.setPageContext(message.getRequest());

        SystemDataDictionary sysData = message.getParam(SystemDataDictionary.class);

        List<SystemDataDictionary> dataList = sysDataService.listAll(sysData);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("dataList", dataList);
        resultMap.put("page", page);

        PageContext.removeContext();

        message.setBody(resultMap);
        message.setView("sysdata/dataList_new");

        return message;
    }
}

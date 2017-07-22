package com.ai.ge.platform.controller.sys.sysdatamain;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.sys.SystemDataDictionary;
import com.ai.ge.utils.AbilityUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "addData")
public class AddDataMain extends ServiceParamMain implements IAbility
{

    private static final Logger logger = LoggerFactory.getLogger(AddDataMain.class);

    @RequiresPermissions("sysdata:create")
    @Override
    public Message execute(Message message)
    {
        SystemDataDictionary data = message.getParam(SystemDataDictionary.class);

        String resultMsg = "新增成功";
        try
        {
            sysDataService.saveSysData(data);

            message.setCode(AbilityConstant.R_SUCCESS);
        } catch (Exception e)
        {
            e.printStackTrace();

            logger.error(e.getMessage());
            resultMsg = "新增失败";

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        message.setMsg(resultMsg);

        Message request = new Message();
        request.setAbilityName("sysData");

        AbilityUtil.invokeSync(request);

        message.setView("sysdata/dataList_new");

        return message;
    }

}

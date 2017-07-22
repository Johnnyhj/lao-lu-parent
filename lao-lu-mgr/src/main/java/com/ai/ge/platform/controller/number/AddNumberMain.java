package com.ai.ge.platform.controller.number;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.product.NumberInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/28.
 */
@Service
@AbilityRegister(name = "addNumber")
public class AddNumberMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(AddNumberMain.class);

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;
        String resultMsg = "新增成功";

        try
        {
            NumberInfo numberInfo = message.getParam(NumberInfo.class);

            phoneNumService.insertNumber(numberInfo);

            message.setCode(resultCode);
            message.setMsg(resultMsg);
            message.setView("redirect:listNumber");

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = e.getMessage();

            message.setCode(resultCode);
            message.setMsg(resultMsg);

            return message;

        }

        return message;
    }

}

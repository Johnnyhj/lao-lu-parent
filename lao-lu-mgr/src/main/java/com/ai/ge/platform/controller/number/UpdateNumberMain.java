package com.ai.ge.platform.controller.number;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.model.product.NumberInfo;
import com.ai.ge.utils.AbilityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/28.
 */
@Service
@AbilityRegister(name = "updateNumber")
public class UpdateNumberMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(UpdateNumberMain.class);

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;
        String resultMsg = "更新成功";

        Message request = new Message();

        try
        {
            NumberInfo record = message.getParam(NumberInfo.class);

            phoneNumService.updateNumber(record, true);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = "更新失败";

        } finally
        {
            request.setAbilityName("listNumber");

            message.getRequest().setAttribute("addDto", new NumberInfoDto());

            request.setRequest(message.getRequest());
            request = AbilityUtil.invokeSync(request);
            request.setBody(request.getBody());
            request.setCode(resultCode);
            request.setMsg(resultMsg);

        }
        return request;
    }
}

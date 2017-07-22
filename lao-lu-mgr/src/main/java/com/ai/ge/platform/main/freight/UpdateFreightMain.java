package com.ai.ge.platform.main.freight;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.model.order.Freight;
import com.ai.ge.platform.service.order.FreightService;
import com.ai.ge.utils.AbilityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * <pre>
 * 	2017-06-20 guochunhao
 * </pre>
 *
 * @author guochunhao
 *
 */
@Service
@AbilityRegister(name = "updateFreight")
public class UpdateFreightMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(UpdateFreightMain.class);

    @Resource
    private FreightService freightService;

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;
        String resultMsg = "更新成功";

        Message request = new Message();

        try
        {
            Freight freight = message.getParam(Freight.class);

            freightService.updateFreight(freight);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = "更新失败";

        } finally
        {
            request.setAbilityName("listFreight");

            message.getRequest().setAttribute("addDto", new Freight());

            request.setRequest(message.getRequest());
            request = AbilityUtil.invokeSync(request);
            request.setBody(request.getBody());
            request.setCode(resultCode);
            request.setMsg(resultMsg);

        }
        return request;
    }
}

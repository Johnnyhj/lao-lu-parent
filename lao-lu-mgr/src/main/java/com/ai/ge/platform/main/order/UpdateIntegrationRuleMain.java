package com.ai.ge.platform.main.order;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.utils.AbilityUtil;

import com.ai.ge.platform.model.order.IntegrationRule;
import com.ai.ge.platform.page.PageContext;
import com.ai.ge.platform.service.order.IntegrationRuleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@AbilityRegister(name = "updateIntegrationRule")
public class UpdateIntegrationRuleMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(UpdateIntegrationRuleMain.class);

    @Resource
    private IntegrationRuleService integrationRuleService;

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;
        String resultMsg = "更新成功";

        Message request = new Message();

        try
        {
            IntegrationRule integrationRule = message.getParam(IntegrationRule.class);

            integrationRuleService.updateIntegrationRule(integrationRule);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = "更新失败";

        } finally
        {
            request.setAbilityName("listIntegrationRule");

            message.getRequest().setAttribute("addDto", new IntegrationRule());

            request.setRequest(message.getRequest());
            request = AbilityUtil.invokeSync(request);
            request.setBody(request.getBody());
            request.setCode(resultCode);
            request.setMsg(resultMsg);

        }
        return request;
    }
}

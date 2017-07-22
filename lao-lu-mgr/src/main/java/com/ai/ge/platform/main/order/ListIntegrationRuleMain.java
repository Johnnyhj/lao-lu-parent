package com.ai.ge.platform.main.order;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.IntegrationRuleDto;
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
 * integrationRulecontroller
 *
 * <pre>
 * 	2017-06-20 guochunhao
 * </pre>
 *
 * @author guochunhao
 *
 */
@Service
@AbilityRegister(name = "listIntegrationRule")
public class ListIntegrationRuleMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListIntegrationRuleMain.class);

    @Resource
    private IntegrationRuleService integrationRuleService;

    @Override
    public Message execute(Message message)
    {
        IntegrationRule record = message.getParam(IntegrationRule.class);

        try {
            // 如果需要分页，则放开此段代码
            PageContext page = super.setPageContext(message.getRequest());

            record = setSearchParam(message, record);

            List<IntegrationRuleDto> list = integrationRuleService.findByCond(record);

            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("list", list);

            // 如果需要分页，则放开此段代码
            resultMap.put("page", page);
            PageContext.removeContext();

            message.setBody(resultMap);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        message.setView("integrationRule/listIntegrationRule");

        return message;
    }

    /**
    * 设置列表页面查询参数
    *
    * @param message
    * @param record
    */
    private IntegrationRule setSearchParam(Message message, IntegrationRule record)
    {
        // 从新增页面和修改页面跳转过来的查询dto用最新的
        IntegrationRule addDto = (IntegrationRule) message.getRequest().getAttribute("addDto");

        if (null != addDto)
        {
            record = addDto;

            return record;
        }

        // 查询条件
        String tempOfferSpecName = message.getParameter("tempOfferSpecName");

        return record;
    }
}

package com.ai.ge.platform.main.order;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.IntegrationRuleDto;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.model.order.OfferSpec;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.shiro.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
@AbilityRegister(name = "toAddIntegrationRulePage")
public class ToAddIntegrationRulePageMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ToAddIntegrationRulePageMain.class);

    @Override
    public Message execute(Message message)
    {
        try
        {

            // 获取当前登录用户，查询套餐信息
            OfferSpec offerSpec = new OfferSpec();
            SysUser user = (SysUser) message.getRequest().getAttribute(Constants.SYSTEM_CURRENT_USER);
            offerSpec.setUserType(user.getUserType());
            offerSpec.setProvinceAearId(user.getProvinceAearId());
            offerSpec.setCityAearId(user.getCityAearId());

            List<OfferSpecDto> offerSpecList = offerSpecService.findListByCond(offerSpec);


            // 所有的区域
            List<SystemArea> firstLevelAreaList = systemAreaService.listChildrenAndParentArea(getUserType(message), getAreaId(message));

            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("object", new IntegrationRuleDto());
            resultMap.put("op", "新增");
            resultMap.put("areaList", firstLevelAreaList);
            resultMap.put("offerSpecList", offerSpecList);

            message.setBody(resultMap);
            message.setCode(AbilityConstant.R_SUCCESS);
            message.setView("integrationRule/editIntegrationRule");

            } catch (Exception e)
            {
                e.printStackTrace();
                logger.error(e.getMessage());

                message.setCode(AbilityConstant.R_ERROR_SYSTEM);
            }

        return message;
    }

}

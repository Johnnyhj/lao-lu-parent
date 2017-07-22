package com.ai.ge.platform.controller.offerspec;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.model.sys.SystemArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "toUpdateOfferSpecPageMain")
public class ToUpdateOfferSpecPageMain extends ServiceParamMain implements IAbility
{

    private Logger logger = LoggerFactory.getLogger(ToUpdateOfferSpecPageMain.class);

    @Override
    public Message execute(Message message)
    {
        Long offerSpecId = Long.valueOf(message.getParameter("offerSpecId"));

        try
        {
            List<SystemArea> firstLevelAreaList = systemAreaService.listChildrenAndParentArea(getUserType(message), getAreaId(message));

            Map<String, Object> resultMap = new HashMap<String, Object>();

            resultMap.put("object", offerSpecService.findOfferSepcDto(offerSpecId));
            resultMap.put("op", "修改");
            resultMap.put("areaList", firstLevelAreaList);

            message.setBody(resultMap);

            message.setCode(AbilityConstant.R_SUCCESS);
            message.setView("offerspec/editOfferSpec");

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }

}

package com.ai.ge.platform.controller.offerspec;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.model.sys.SystemArea;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "toAddOfferSpecPageMain")
public class ToAddOfferSpecPageMain extends ServiceParamMain implements IAbility
{
    @Override
    public Message execute(Message message)
    {
        List<SystemArea> firstLevelAreaList = systemAreaService.listChildrenAndParentArea(getUserType(message), getAreaId(message));

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("object", new OfferSpecDto());
        resultMap.put("op", "新增");
        resultMap.put("areaList", firstLevelAreaList);

        message.setBody(resultMap);
        message.setView("offerspec/editOfferSpec");

        return message;
    }

}

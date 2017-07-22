package com.ai.ge.platform.controller.number;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.model.sys.SystemArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/28.
 */
@Service
@AbilityRegister(name = "toAddNumberPageMain")
public class ToAddNumberPageMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ToAddNumberPageMain.class);

    @Override
    public Message execute(Message message)
    {
        try
        {
            // 所有的区域
            List<SystemArea> firstLevelAreaList = systemAreaService.listChildrenAndParentArea(getUserType(message), getAreaId(message));

            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("object", new NumberInfoDto());
            resultMap.put("areaList", firstLevelAreaList);
            resultMap.put("op", "新增");


            message.setBody(resultMap);
            message.setCode(AbilityConstant.R_SUCCESS);
            message.setView("number/editNumber");

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }

}

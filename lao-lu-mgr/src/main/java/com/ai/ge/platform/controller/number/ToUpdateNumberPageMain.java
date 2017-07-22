package com.ai.ge.platform.controller.number;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.model.sys.SystemArea;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guochunhao on 17/5/27.
 */
@Service
@AbilityRegister(name = "toUpdateNumberPage")
public class ToUpdateNumberPageMain extends ServiceParamMain implements IAbility
{

    private Logger logger = LoggerFactory.getLogger(ToUpdateNumberPageMain.class);

    @Override
    public Message execute(Message message)
    {
        Long id = Long.valueOf(message.getParameter("id"));

        try
        {
            NumberInfoDto numberInfoDto = new NumberInfoDto();
            numberInfoDto.setId(id);

            // 查询号码
            List<NumberInfoDto> list = phoneNumService.listNumberInfoDto(numberInfoDto);

            Map<String, Object> resultMap = new HashMap<String, Object>();

            // 所有的区域
            List<SystemArea> firstLevelAreaList = systemAreaService.listChildrenAndParentArea(getUserType(message), getAreaId(message));

            resultMap.put("areaList", firstLevelAreaList);
            resultMap.put("op", "更新");

            if (CollectionUtils.isNotEmpty(list))
            {
                resultMap.put("object", list.get(0));
            }

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

package com.ai.ge.platform.main.freight;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.FreightDto;
import com.ai.ge.platform.model.sys.SystemArea;
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
@AbilityRegister(name = "toAddFreightPage")
public class ToAddFreightPageMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ToAddFreightPageMain.class);

    @Override
    public Message execute(Message message)
    {
        try
        {
            // 所有的区域
            List<SystemArea> firstLevelAreaList = systemAreaService.listChildrenAndParentArea(getUserType(message), getAreaId(message));

            List<SystemArea> destinationArea = systemAreaService.listChildrenAndParentArea(null, null);

            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("object", new FreightDto());
            resultMap.put("areaList", firstLevelAreaList);
            resultMap.put("destinationArea", destinationArea);
            resultMap.put("op", "新增");


            message.setBody(resultMap);
            message.setCode(AbilityConstant.R_SUCCESS);
            message.setView("freight/editFreight");

            } catch (Exception e)
            {
                e.printStackTrace();
                logger.error(e.getMessage());

                message.setCode(AbilityConstant.R_ERROR_SYSTEM);
            }

        return message;
    }

}

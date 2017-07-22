package com.ai.ge.platform.main.freight;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.FreightDto;
import com.ai.ge.platform.model.order.Freight;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.service.order.FreightService;
import org.apache.commons.collections.CollectionUtils;
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
@AbilityRegister(name = "toUpdateFreightPage")
public class ToUpdateFreightPageMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ToUpdateFreightPageMain.class);

    @Resource
    private FreightService freightService;

    @Override
    public Message execute(Message message)
    {
        Long primaryKey = Long.valueOf(message.getParameter("freightId"));

        try
        {
            Freight freight = new Freight();
            freight.setFreightId(primaryKey);

            List<FreightDto> list = freightService.findByCond(freight);

            // 所有的区域
            List<SystemArea> firstLevelAreaList = systemAreaService.listChildrenAndParentArea(getUserType(message), getAreaId(message));
            List<SystemArea> destinationArea = systemAreaService.listChildrenAndParentArea(null, null);

            Map<String, Object> resultMap = new HashMap<String, Object>();

            resultMap.put("op", "更新");
            resultMap.put("areaList", firstLevelAreaList);
            resultMap.put("destinationArea", destinationArea);

            if (CollectionUtils.isNotEmpty(list))
            {
                resultMap.put("object", list.get(0));
            }

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

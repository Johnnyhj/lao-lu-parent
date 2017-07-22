package com.ai.ge.platform.main.freight;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.FreightDto;
import com.ai.ge.platform.model.order.Freight;
import com.ai.ge.platform.page.PageContext;
import com.ai.ge.platform.service.order.FreightService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * freightcontroller
 *
 * <pre>
 * 	2017-06-20 guochunhao
 * </pre>
 *
 * @author guochunhao
 *
 */
@Service
@AbilityRegister(name = "listFreight")
public class ListFreightMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListFreightMain.class);

    @Resource
    private FreightService freightService;

    @Override
    public Message execute(Message message)
    {
        Freight record = message.getParam(Freight.class);

        try {
            record = setSearchParam(message, record);

            // 如果需要分页，则放开此段代码
            PageContext page = super.setPageContext(message.getRequest());

            List<FreightDto> list = freightService.findByCond(record);

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

        message.setView("freight/listFreight");

        return message;
    }

    /**
    * 设置列表页面查询参数
    *
    * @param message
    * @param record
    */
    private Freight setSearchParam(Message message, Freight record)
    {
        // 从新增页面和修改页面跳转过来的查询dto用最新的
        Freight addDto = (Freight) message.getRequest().getAttribute("addDto");

        if (null != addDto)
        {
            record = addDto;

            return record;
        }

        // 查询条件 输入的是城市名，需要根据城市名查找到该城市对应的id
        String tempOriginalAreaName = message.getParameter("tempOriginalAreaName");
        String tempDestinationAreaName = message.getParameter("tempDestinationAreaName");

        List<String> cityName = new ArrayList<String>();

        if (StringUtils.isNotEmpty(tempOriginalAreaName))
        {
            cityName.add(tempOriginalAreaName);
        }

        if (StringUtils.isNotEmpty(tempDestinationAreaName))
        {
            cityName.add(tempDestinationAreaName);
        }

        if (CollectionUtils.isNotEmpty(cityName))
        {
            // 市区信息
            List<Map<String, Long>> cityMapList = systemAreaService.listAreaIdName(cityName);

            // 如果没搜到对应的城市id，则说明输入框里输入的值写错了
            if (CollectionUtils.isEmpty(cityMapList))
            {
                record.setOriginalProvinceAearId(-99L);
                record.setOriginalCityAearId(-99L);

                record.setDestinationProvinceAearId(-99L);
                record.setDestinationCityAearId(-99L);

                return record;
            }

            Map<String, Long> cityMapVal = new HashMap<String, Long>();
            for (Map<String, Long> entry : cityMapList) {
                cityMapVal.put(String.valueOf(entry.get("AREA_NAME")), Long.parseLong(String.valueOf(entry.get("AREA_ID"))));
            }

            if (StringUtils.isNotEmpty(tempOriginalAreaName))
            {
                record.setOriginalProvinceAearId(cityMapVal.get(tempOriginalAreaName));
                record.setOriginalCityAearId(cityMapVal.get(tempOriginalAreaName));
            }
            else
            {
                record.setOriginalProvinceAearId(null);
                record.setOriginalCityAearId(null);
            }

            if (StringUtils.isNotEmpty(tempDestinationAreaName))
            {
                record.setDestinationProvinceAearId(cityMapVal.get(tempDestinationAreaName));
                record.setDestinationCityAearId(cityMapVal.get(tempDestinationAreaName));
            }
            else
            {
                record.setDestinationProvinceAearId(null);
                record.setDestinationCityAearId(null);
            }
        }

        return record;
    }
}

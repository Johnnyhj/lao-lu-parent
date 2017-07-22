package com.ai.ge.platform.controller.number;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.page.PageContext;
import com.ai.ge.platform.shiro.Constants;
import org.apache.commons.lang.StringUtils;
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
@AbilityRegister(name = "listNumber")
public class ListNumberMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListNumberMain.class);

    @Override
    public Message execute(Message message)
    {
        NumberInfoDto numberInfoDto = message.getParam(NumberInfoDto.class);

        try {
            PageContext page = super.setPageContext(message.getRequest());

            // 设置查询参数，主要是为了解决从新增或者修改页面完成之后跳转列表页面，
            // 新增或者修改页面之前填写的值自动填写列表页面搜索框里的内容
            numberInfoDto = setSearchParam(message, numberInfoDto);

            // 获取当前登录用户，通过用户的类型根据区域过滤数据
            SysUser user = (SysUser) message.getRequest().getAttribute(Constants.SYSTEM_CURRENT_USER);
            numberInfoDto.setUserType(user.getUserType());
            numberInfoDto.setProvinceAearId(user.getProvinceAearId());
            numberInfoDto.setCityAearId(user.getCityAearId());

            List<NumberInfoDto> list = phoneNumService.listNumberInfoDto(numberInfoDto);
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("list", list);
            resultMap.put("page", page);

            PageContext.removeContext();
            message.getRequest().removeAttribute("addDto");

            message.setBody(resultMap);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        message.setView("number/listNumber");

        return message;
    }

    /**
     * 设置列表页面查询参数
     *
     * @param message
     * @param record
     */
    private NumberInfoDto setSearchParam(Message message, NumberInfoDto record)
    {
        String tempNumber = message.getParameter("tempNumber");

        if (StringUtils.isNotEmpty(tempNumber))
        {
            record.setNumber(tempNumber);
        }


        String tempStatus = message.getParameter("tempStatus");

        if (StringUtils.isNotEmpty(tempStatus))
        {
            record.setStatus(Short.parseShort(tempStatus));
        }

        // 从新增页面和修改页面跳转过来的查询dto用最新的
        NumberInfoDto addDto = (NumberInfoDto) message.getRequest().getAttribute("addDto");

        if (null != addDto)
        {
            record = addDto;
        }

        return record;

    }
}

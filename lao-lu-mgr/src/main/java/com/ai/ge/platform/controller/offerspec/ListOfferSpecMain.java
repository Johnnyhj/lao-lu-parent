package com.ai.ge.platform.controller.offerspec;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.model.order.OfferSpec;
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
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "listOfferSpec")
public class ListOfferSpecMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListOfferSpecMain.class);

    @Override
    public Message execute(Message message)
    {
        OfferSpec record = message.getParam(OfferSpec.class);

        try {
            PageContext page = super.setPageContext(message.getRequest());

            record = setSearchParam(message, record);

            // 获取当前登录用户，通过用户的类型根据区域过滤数据
            SysUser user = (SysUser) message.getRequest().getAttribute(Constants.SYSTEM_CURRENT_USER);
            record.setUserType(user.getUserType());
            record.setProvinceAearId(user.getProvinceAearId());
            record.setCityAearId(user.getCityAearId());

            List<OfferSpecDto> list = offerSpecService.findListByCond(record);

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

        message.setView("offerspec/listOfferSpec");

        return message;
    }

    /**
     * 设置列表页面查询参数
     *
     * @param message
     * @param record
     */
    private OfferSpec setSearchParam(Message message, OfferSpec record)
    {
        // 从新增页面和修改页面跳转过来的查询dto用最新的
        OfferSpec addDto = (OfferSpec) message.getRequest().getAttribute("addDto");

        if (null != addDto)
        {
            record = addDto;
        }

        // 查询条件
        String tempName = message.getParameter("tempName");
        if (StringUtils.isNotEmpty(tempName))
        {
            record.setName(tempName);
        }
        else
        {
            record.setName(null);
        }

        return record;
    }
}

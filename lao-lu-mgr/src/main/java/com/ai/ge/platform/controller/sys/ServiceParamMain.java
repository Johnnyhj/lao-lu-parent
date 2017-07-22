package com.ai.ge.platform.controller.sys;

import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.page.PageContext;
import com.ai.ge.platform.service.delivery.DeliveryService;
import com.ai.ge.platform.service.log.LogAuthProcessService;
import com.ai.ge.platform.service.offerspec.OfferSpecService;
import com.ai.ge.platform.service.order.OrderService;
import com.ai.ge.platform.service.phonenum.PhoneNumService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.service.sys.SystemAreaService;
import com.ai.ge.platform.service.user.PlatformUserService;
import com.ai.ge.platform.service.user.SysResourceService;
import com.ai.ge.platform.shiro.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by count on 17/5/12.
 */
@Service
public class ServiceParamMain
{
    @Resource
    protected SysResourceService resourceService;

    @Resource
    protected LogAuthProcessService logAuthProcessService;

    @Resource
    protected SysDataService sysDataService;

    @Resource
    protected PlatformUserService platformUserService;

    @Resource
    protected OrderService orderService;

    @Resource
    protected OfferSpecService offerSpecService;

    @Resource
    protected SystemAreaService systemAreaService;

    @Resource
    protected DeliveryService deliveryService;

    @Resource
    protected PhoneNumService phoneNumService;

    /**
     * 设置分页及排序信息
     *
     * @param request HttpServletRequest
     * @return PageContext
     */
    protected PageContext setPageContext(HttpServletRequest request)
    {
        PageContext page = PageContext.createPage();

        String currentPage = request.getParameter("page");//jqgrid 自带当前页参数“page”
        String pageSize = request.getParameter("rows");//jqgrid 自带当前页显示记录数“rows”

        page.setCurrentPage(StringUtils.isBlank(currentPage) ? 1 : Integer.parseInt(currentPage));
        page.setPageSize(StringUtils.isBlank(pageSize) ? 10 : Integer.parseInt(pageSize));

        return page;
    }

    /**
     * 获取 用户
     *
     * @param message
     * @return
     */
    protected SysUser getSysUser(Message message)
    {
        SysUser sysUser = (SysUser) message.getRequest().getAttribute(Constants.SYSTEM_CURRENT_USER);

        return sysUser;
    }

    /**
     * 获取 userType
     *
     * @param message
     * @return
     */
    protected Short getUserType(Message message)
    {
        return getSysUser(message).getUserType();
    }

    /**
     * 获取 userId
     *
     * @param message
     * @return
     */
    protected Long getUserId(Message message)
    {
        if (null == getSysUser(message))
        {
            return null;
        }

        return getSysUser(message).getId();
    }

    /**
     * 获取 区域信息
     *
     * @param message
     * @return
     */
    protected Long getAreaId(Message message)
    {
        if (1 == getUserType(message))
        {
            return getSysUser(message).getProvinceAearId();
        }
        else if (2 == getUserType(message))
        {
            return getSysUser(message).getCityAearId();
        }
        else
        {
            return null;
        }
    }

}

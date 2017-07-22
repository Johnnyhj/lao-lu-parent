package com.ai.ge.platform.controller;

import com.ai.ge.platform.controller.common.CommonController;
import com.ai.ge.platform.dto.log.DashBoardDto;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.user.SysResourceService;
import com.ai.ge.platform.shiro.Constants;
import com.ai.ge.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * 首页
 */
@Controller(value = "indexControllerSelf")
@RequestMapping("/mgr/index")
public class IndexController extends CommonController
{

    @Resource
    private SysResourceService resourceService;
    @Resource
    private RedisSpringProxy redisService;

    /**
     *
     * @param request
     * @param model
     * @return
     *
     * 完成
     */
    @RequestMapping
    public String index(HttpServletRequest request, Model model) {
        SysUser loginUser = (SysUser) request.getAttribute(Constants.SYSTEM_CURRENT_USER);

        List<SysResource> menus = resourceService.findMenus(loginUser);

        model.addAttribute("menus", menus);

        return "material_index";
//        return "material_index_new";
    }

    /**
     * Dashboard
     * @return
     *
     * 完成
     */
    @RequestMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        return "dashboard1";
    }

    /**
     * 心跳监测
     *
     * @param response
     * @throws IOException
     *
     * 完成
     */
    @RequestMapping(value = "/live", method = {RequestMethod.GET, RequestMethod.POST})
    public void imLive(HttpServletResponse response) throws IOException {
        response.getWriter().print("I'm still alive, bang bang bang......");
    }

    /**
     *
     * @param response
     *
     * 完成
     */
    @RequestMapping("/flushall")
    public void flushall(HttpServletResponse response) {
        redisService.flushAll();

        printJson(new ObjectResult(), response);
    }

    private String moneyFormat(Object money) {
        if (money == null || money.toString().equals("0")) {
            return "0.00";
        }

        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(money);
    }

    private DashBoardDto getDashBoardDto(HttpServletRequest request){
        DashBoardDto dashBoardDto = new DashBoardDto();
        SysUser sysUser = (SysUser) request.getAttribute(Constants.SYSTEM_CURRENT_USER);
        dashBoardDto.setId(sysUser.getId());

        return dashBoardDto;
    }

    private Date getSelDate(String date) {
        Date selDate = DateUtil.getDateFromStr(date, DateUtil.DATE_FORMAT_YYYY_MM_DD);
//        return DateUtil.getDateBefore(selDate, 30);
        return selDate;
    }

}

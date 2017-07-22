package com.ai.ge.platform.filter;

import com.ai.ge.platform.cache.SessionStoreCache;
import com.ai.ge.platform.model.sys.SystemAuthorization;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.service.user.UserService;
import com.ai.ge.util.CommonUtil;
import com.ai.ge.util.DESEncryptUtil;
import com.ai.ge.util.RequestUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截所有请求
 */
public class RequestAllInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Resource
    private SysDataService sysDataService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        //记录cookie参数
        HttpSession session = request.getSession();
        SystemAuthorization authUser = (SystemAuthorization) session.getAttribute(SessionStoreCache.SESSION_USER);
        //String uri = request.getRequestURI();
        String channelKey = "_c";//sysDataService.getByKeyType("cookie.user.channel.key", SysDataService
        //.WEB_APP, "_c");
        String phoneKey = "_p";//sysDataService.getByKeyType("cookie.user.phone.key", SysDataService
        //.WEB_APP, "_p");
        String encrypt = "_FLOW_MARKET_COOKIE_";//sysDataService.getByKeyType("cookie.user.encrypt", SysDataService
        //.WEB_APP, "_FLOW_MARKET_COOKIE_");
        String channel = RequestUtil.getChannelByHost(request);

        if (StringUtils.isBlank(CommonUtil.getCookie(request, channelKey))) {

            CommonUtil.setCookie(response, channelKey, DESEncryptUtil.encrypt(channel, encrypt));
        } else {
            CommonUtil.setCookie(response, channelKey, DESEncryptUtil.encrypt(channel, encrypt));
        }

        //当用户没有登录时
        //则只记录当前渠道信息，并删除用户信息
        if (null == authUser) {
            CommonUtil.delCookie(response, phoneKey, DESEncryptUtil.encrypt("1001", encrypt));
        } else {
            //当用户登录的情况下，则记录渠道和用户信息
            CommonUtil.setCookie(response, phoneKey, DESEncryptUtil.encrypt(authUser.getPhoneNum(), encrypt));
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}

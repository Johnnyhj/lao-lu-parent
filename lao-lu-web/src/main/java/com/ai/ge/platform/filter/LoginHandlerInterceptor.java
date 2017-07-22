package com.ai.ge.platform.filter;

import com.ai.ge.platform.cache.SessionStoreCache;
import com.ai.ge.platform.model.sys.SystemAuthorization;
import com.ai.ge.platform.result.ObjectResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截，拦截需要登录的路径
 */
public class LoginHandlerInterceptor extends AbstractHandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        HttpSession session = request.getSession();
        SystemAuthorization authUser = (SystemAuthorization) session.getAttribute(SessionStoreCache.SESSION_USER);
        if (null != authUser) {
            return true;
        }

        ObjectResult objectResult = new ObjectResult("99", "当前用户未登录");

        response.sendRedirect(request.getContextPath() + "/app-inner/login/login.html");

        printJson(objectResult, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

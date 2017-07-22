package com.ai.ge.platform.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截所有请求，记录用户访问记录
 */
public class RequestHandlerInterceptor implements HandlerInterceptor {

//    @Resource
//    private LogCustomerOperationService logCustomerOperationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
//        request.setAttribute(LogCustomerOperationService.CURRENT_TIME, new Date());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
//        logCustomerOperationService.saveLogCustomerOperation(request);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

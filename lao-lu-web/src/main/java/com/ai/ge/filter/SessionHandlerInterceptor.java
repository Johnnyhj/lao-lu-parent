package com.ai.ge.filter;

import com.ai.ge.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sam on 17/6/20.
 */
public class SessionHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SessionHandlerInterceptor.class);


    private String[] excludes = {"core/gateway","core/response","core/payednotify.do"};


    private boolean isExclude(String uri) {
        if (null == excludes) {
            return false;
        } else {
            for (String excludeUrl : excludes) {
                if (uri.indexOf(excludeUrl) >= 0) {
                    return true;
                }
            }
            if (uri.endsWith(".html") || uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".jpg")
                    || uri.endsWith(".jpeg") || uri.endsWith(".png") || uri.endsWith(".gif") || uri.endsWith(".map")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
//        if (matcherIgnoreUrl(request)) {
//            return true;
//        }
        String servletPath = request.getRequestURI();
        if (isExclude(servletPath)) {
            return true;
        }

        HttpSession session = request.getSession(false);
        if(session == null||null== SessionUtil.getAttribute(request.getSession(true), "user")){
            printJson("{\n" +
                    "\"code\": \"1001\",\n" +
                    "\"msg\": \"用户未登录\"\n" +
                    "}", response);
            return false;
        }
        return true;
    }

//    protected boolean matcherIgnoreUrl(HttpServletRequest request) {
//        List<String> ignoreUrl = getIgnoreUrl();
//
//        if (CollectionUtils.isEmpty(ignoreUrl)) {
//            return false;
//        }
//
//        String uri = request.getRequestURI();
//        String contextPath = request.getContextPath();
//
//        for (String ignore : ignoreUrl) {
//            if (matcher.match(contextPath + ignore, uri)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    protected void printJson(String json, HttpServletResponse response) {
        if (response == null) {
            return;
        }

        try {
            response.reset();
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

//    protected List<String> getIgnoreUrl() {
//        List<SystemDataDictionary> ignoreUrls = sysDataService.listByType("check_access_token_ignore_url");
//        if (CollectionUtils.isEmpty(ignoreUrls)) {
//            return null;
//        }
//
//        return new ArrayList<String>(CollectionUtils.collect(ignoreUrls, new BeanToPropertyValueTransformer("value", true)));
//    }
}

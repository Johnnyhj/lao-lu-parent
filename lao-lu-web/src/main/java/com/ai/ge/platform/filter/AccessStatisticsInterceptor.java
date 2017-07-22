package com.ai.ge.platform.filter;

import com.ai.ge.platform.model.sys.SystemAccessBlackList;
import com.ai.ge.platform.model.sys.SystemAccessBlackListExample;
import com.ai.ge.platform.model.sys.SystemAccessInfo;
import com.ai.ge.platform.model.sys.SystemAccessWhiteList;
import com.ai.ge.platform.service.sys.SystemAccessBlackListService;
import com.ai.ge.platform.service.sys.SystemAccessInfoService;
import com.ai.ge.platform.service.sys.SystemAccessWhiteListService;
import com.ai.ge.util.CommonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 访问记录日志
 */
public class AccessStatisticsInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(AccessStatisticsInterceptor.class);
    @Resource
    private SystemAccessInfoService accessInfoService;
    @Resource
    private SystemAccessWhiteListService whiteListService;
    @Resource
    private SystemAccessBlackListService blackListService;

    @PostConstruct
    public void init() throws ServletException {
        //启动保存IP访问入库数据线程
        accessInfoService.startup();
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        try {
            String ip = CommonUtil.getRemortIp(request);
            //统计IP访问记录
            StringBuffer reqUrl = request.getRequestURL();
            logger.debug("ip:"+ip+" url:"+ reqUrl.toString());
            if (StringUtils.isNotBlank(request.getQueryString())) {
                reqUrl.append('?').append(request.getQueryString());
            }
            //白名单
            List<SystemAccessWhiteList> whiteListObjects = whiteListService.selectByExample(null);
            boolean white = false;
            if (!CollectionUtils.isEmpty(whiteListObjects)) {
                for (SystemAccessWhiteList object : whiteListObjects) {
                    if (ip.equals(object.getWlIp())) {
                        white = true;
                        break;
                    }
                }
            }
            //用户访问IP存在于白名单中
            if (white) {
                return true;
            }
            //用户存在于黑名单中直接返回错误码
            /*List<SystemAccessBlackList> blackListObjects = blackListService.selectByExample(null);
            boolean black = false;
            if (!CollectionUtils.isEmpty(blackListObjects)) {
                for (SystemAccessBlackList object : blackListObjects) {
                    if (ip.equals(object.getBlIp())) {
                        black = true;
                        break;
                    }
                }
            }*/

            SystemAccessBlackListExample example = new SystemAccessBlackListExample();
            example.createCriteria().andBlIpEqualTo(ip);
            List<SystemAccessBlackList> blackListObjects = blackListService.selectByExample(example);
            boolean black = false;
            if (CollectionUtils.isNotEmpty(blackListObjects)) {
                black = true;
            }

            //用户存在于黑名单中直接返回错误码
            if (black) {
                response.sendError(403);
                return false;
            }
            accessStatistics(request, ip, reqUrl.toString());
        } catch (Exception e) {
            logger.error("访问记录统计入库报错", e);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private boolean accessBlackList(HttpServletResponse servletResponse, String ip) throws IOException {
        List<SystemAccessBlackList> blackListObjects = blackListService.selectByExample(null);
        boolean black = false;
        if (!CollectionUtils.isEmpty(blackListObjects)) {
            for (SystemAccessBlackList object : blackListObjects) {
                if (ip.equals(object.getBlIp())) {
                    black = true;
                    break;
                }
            }
        }
        //用户存在于黑名单中直接返回错误码
        if (black) {
            servletResponse.sendError(403);
            return true;
        }
        return false;
    }

    private boolean accessWhiteList(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, String ip)
            throws IOException, ServletException {
        List<SystemAccessWhiteList> whiteListObjects = whiteListService.selectByExample(null);
        boolean white = false;
        if (!CollectionUtils.isEmpty(whiteListObjects)) {
            for (SystemAccessWhiteList object : whiteListObjects) {
                if (ip.equals(object.getWlIp())) {
                    white = true;
                    break;
                }
            }
        }
        //用户访问IP存在于白名单中
        if (white) {
            filterChain.doFilter(servletRequest, servletResponse);
            return true;
        }
        return false;
    }

    private void accessStatistics(HttpServletRequest request, String ip, String reqUrl) {
        SystemAccessInfo systemAccessInfo = new SystemAccessInfo();
        systemAccessInfo.setAccIp(ip);
        systemAccessInfo.setAccTime(new Date());
        systemAccessInfo.setAccMethod(request.getMethod());
        systemAccessInfo.setReqUrl(reqUrl);
        accessInfoService.insert(systemAccessInfo);
    }

}

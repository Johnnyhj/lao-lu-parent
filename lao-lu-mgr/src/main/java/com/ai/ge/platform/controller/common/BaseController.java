package com.ai.ge.platform.controller.common;

import com.ai.ge.filter.StringEscapeEditor;
import com.ai.ge.platform.cache.SessionStoreCache;
import com.ai.ge.platform.cache.UserCache;
import com.ai.ge.platform.constant.CommonConstant;
import com.ai.ge.platform.model.sys.SystemAuthorization;
import com.ai.ge.platform.page.PageContext;
import com.ai.ge.platform.result.Result;
import com.ai.ge.util.DateUtil;
import com.ai.ge.util.IgnorePropertyPreFilter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    protected Logger logger;

    /**
     * 向客户端返回指定json字符串，忽略Null值
     *
     * @param result
     * @param response
     */
    protected void printJson(Result result, HttpServletResponse response) {
        JSON.DEFFAULT_DATE_FORMAT = DateUtil.DATE_FORMATE_STRING_A;
        String json = JSON.toJSONString(result, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);

        printJson(json, response);
    }

    /**
     * 向客户端返回指定json字符串，忽略Null值
     *
     * @param result
     * @param ignoreProperty 忽略属性
     * @param response
     */
    protected void printJson(Result result, final String[] ignoreProperty, HttpServletResponse response) {
        JSON.DEFFAULT_DATE_FORMAT = DateUtil.DATE_FORMATE_STRING_A;
        String json = JSON.toJSONString(result, new IgnorePropertyPreFilter(ignoreProperty), SerializerFeature
                .WriteDateUseDateFormat);

        printJson(json, response);
    }

    /*protected JsonConfig getJsonConfig(final String[] ignoreProperty) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter(JsonPropertyFilterUtils.getDefaultPropertyFilter(ignoreProperty));
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        return jsonConfig;
    }*/


    /**
     * 向客户端返回指定json字符串
     *
     * @param json     json字符串
     * @param response
     */
    protected void printJson(String json, HttpServletResponse response) {
        if (response == null) {
            return;
        }

        try {
            response.setContentType("application/json;charset=UTF-8");

            if (json == null) {
                response.getWriter().write("{}");
            } else {
                response.getWriter().write(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端返回成功或失败消息的json字符串，如果参数success为true，返回成功消息，否则返回失败消息
     *
     * @param success  成功或失败
     * @param msg      返回页面的提示信息
     * @param response
     */
    protected void printSuccess(boolean success, String msg, HttpServletResponse response) {
        if (response == null) {
            return;
        }

        try {
            response.setContentType("application/json;charset=UTF-8");

            if (msg == null || msg.trim().length() == 0) {
                response.getWriter().write("{\"success\" : " + success + "}");
            } else {
                response.getWriter().write("{\"success\" : " + success + ", \"msg\" : \"" + msg + "\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端返回成功或失败消息的json字符串，如果参数success为true，返回成功消息，否则返回失败消息
     *
     * @param success  成功或失败
     * @param response
     */
    protected void printSuccess(boolean success, HttpServletResponse response) {
        this.printSuccess(success, null, response);
    }

    /**
     * 生成分页本地线程
     *
     * @param currPage 当前页码
     * @param pageSize 页面大小
     */
    protected PageContext createPage(int currPage, int pageSize) {
        PageContext page = PageContext.createPage();
        page.setCurrentPage(currPage);
        page.setPageSize(pageSize);
        return page;
    }

    /**
     * 用于移动客户端客户端返回json
     *
     * @param success
     * @param resMsg
     * @param json
     * @return
     */
    protected String printJsonM(Integer success, String resMsg, String json) {
        if (json == null) {
            return "{\"resultCode\" : \"" + success.toString() + "\", \"resultMsg\" : \"" + resMsg + "\"}";
        } else {
            return "{\"resultCode\" : \"" + success.toString() + "\", \"resultMsg\" : \"" + resMsg + "\" ," + json +
                    "}";
        }
    }

    /**
     * 设置当前登录的用户信息到session中
     *
     * @param session   当前会话
     * @param userCache 当前登录的用户信息
     */
    public static void setSessionUser(HttpSession session, UserCache userCache) {
        if (session == null) {
            return;
        }
        session.setAttribute(CommonConstant.USER_CACHE, userCache);
    }

    protected SystemAuthorization getSystemAuthorization(HttpSession session) {
        if (null == session) {
            return null;
        }

        return (SystemAuthorization) session.getAttribute(SessionStoreCache.SESSION_USER);
    }



    /**
     * 从session中获取当前登录的用户信息
     *
     * @param session 当前会话
     * @return 当前登录的用户信息
     */
    public static UserCache getSessionUser(HttpSession session) {
        if (session == null) {
            return null;
        }

        if (session.getAttribute(CommonConstant.USER_CACHE) == null) {
            setSessionUser(session, new UserCache());
        }
        return (UserCache) session.getAttribute(CommonConstant.USER_CACHE);
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(String.class, new StringEscapeEditor(false, false));
    }


    /**
     * 统一异常处理 \n
     * 向前端返回Json数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/error")
    @ResponseBody
    public Result printException(HttpServletRequest request) {
        Result result = (Result) request.getAttribute("result");

        return result;
    }

    /**
     * 日志测试方法运行时间
     *
     * @param text
     * @param bt
     * @param et
     */
    protected void logger(String text, Long bt, Long et) {
        if (null == et) {
            logger.info("进入 " + text + " " + new Date(bt));
        } else {
            logger.info("退出 " + text + " 所需要时间为 " + (et - bt) + " 毫秒");
        }
    }

    /**
     * 设置分页及排序信息
     *
     * @param request HttpServletRequest
     * @return PageContext
     */
    protected PageContext setPageContext(HttpServletRequest request) {
        PageContext page = PageContext.createPage();

        String currentPage = request.getParameter("page");//jqgrid 自带当前页参数“page”
        String pageSize = request.getParameter("rows");//jqgrid 自带当前页显示记录数“rows”

        page.setCurrentPage(StringUtils.isBlank(currentPage) ? 1 : Integer.parseInt(currentPage));
        page.setPageSize(StringUtils.isBlank(pageSize) ? 10 : Integer.parseInt(pageSize));

        return page;
    }

}

package com.ai.ge.platform.filter;

import com.ai.ge.platform.model.sys.SystemAuthorization;
import com.ai.ge.platform.result.ObjectResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求拦截，拦截需要请求依次排队请求的路径 \n
 * 请求中携带cookie标识，如果cookie标识中的
 */
public class RequestQueueHandlerInterceptor extends AbstractHandlerInterceptor {
    private static final String REQUEST_QUEUE_HANDLER_KEY = "REQUEST_QUEUE_HANDLER_KEY";
    private static final String CURR_PROD_CODE = "CURR_PROD_CODE";


    private static final Logger logger = LoggerFactory.getLogger(RequestQueueHandlerInterceptor.class);
    private static final boolean isDebug = logger.isDebugEnabled();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {

        HttpSession session = request.getSession();
        //商品代码
        String prodCode = request.getParameter("prodCode");

        if (isDebug) {
            logger.debug("当前请求sessionid[" + request.getRequestedSessionId() + "]");
            SystemAuthorization systemAuthorization = new SystemAuthorization();//getSystemAuthorization(request.getSession());
            if (null != systemAuthorization) {
                logger.debug("当前请求手机号码[" + systemAuthorization.getPhoneNum() + "]");
            }

        }

        if (isDebug) {
            logger.debug("商品代码prodCode[" + prodCode + "]");
        }


        if (StringUtils.isBlank(prodCode)) {
            if (isDebug) {
                logger.debug("商品代码prodCode参数为空");
            }
            printJson(new ObjectResult("0", "请求参数不正确"), response);
            return false;
        }

        request.setAttribute(CURR_PROD_CODE, prodCode);

        List<String> currProdCodes = (List<String>) session.getAttribute(REQUEST_QUEUE_HANDLER_KEY);
        if (CollectionUtils.isEmpty(currProdCodes)) {
            currProdCodes = new ArrayList<String>();
        }
        //保存正在订购的商品列表，防止通过不同的prodCode进行刷单
        if (!currProdCodes.contains(prodCode)) {
            currProdCodes.add(prodCode);
            session.setAttribute(REQUEST_QUEUE_HANDLER_KEY, currProdCodes);

            if (isDebug) {
                logger.debug("保存正在订购的商品列表... prodCode[" + prodCode + "]");
            }

            return true;
        }

        if (isDebug) {
            logger.debug("正在订购中，请不要重复订购... prodCode[" + prodCode + "]");
        }

        printJson(new ObjectResult("0", "正在订购中，请不要重复订购"), response);
        return false;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
        HttpSession session = request.getSession();
        String currProdCode = (String) request.getAttribute(CURR_PROD_CODE);
        List<String> currProdCodes = (List<String>) session.getAttribute(REQUEST_QUEUE_HANDLER_KEY);

        if (CollectionUtils.isNotEmpty(currProdCodes) && StringUtils.isNotBlank(currProdCode)) {
            currProdCodes.remove(currProdCode);
            session.setAttribute(REQUEST_QUEUE_HANDLER_KEY, currProdCodes);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
    }

}

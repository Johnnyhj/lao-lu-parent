package com.ai.ge.platform.serviceimpl.auth;

import com.ai.ge.platform.cache.PlatFormUserCache;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.auth.CreditlifeService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.service.user.UserService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpResponseObject;
import com.ai.ge.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 接收从芝麻回调后调用  信用套餐查询接口 获取用户信息后调用
 */
@Service
public class CreditlifeServiceImpl implements CreditlifeService {

    private static Logger logger = LoggerFactory.getLogger(CreditlifeServiceImpl.class);

    @Resource
    private SysDataService sysDataService;


    @Resource
    private UserService userService;
    /**
     * 1、	芝麻业务办理完成后会回调商户指定的地址，并且加上一个参数orderNo
     * 2、	商户接受到orderNo后来芝麻查询相关信息，具体接口参见第四部分订单查询接口
     * 接收从芝麻回调后调用  信用套餐查询接口 获取用户信息后调用
     */
    @Resource(name = "zhimaOrderConfirmHttpRequestProcess")
    private AbstractHttpRequestProcess zhimaOrderConfirmHttpRequestProcess;


    @Override
    public boolean creditlife(String orderNo, String transactionId,HttpServletRequest request) throws BusinessException {
        boolean result = false;

        ZhimaOrderConfirmHttpRequestObject httpRequestObject = new ZhimaOrderConfirmHttpRequestObject();
        ZhimaOrderConfirmHttpResponseObject httpResponseObject = new ZhimaOrderConfirmHttpResponseObject();
        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);

        httpRequestObject.setActionName("信用套餐查询接口");
        String requestUri = sysDataService.getByKeyType("zhima_order_confirm_url", SysDataService.WEB_APP, "https://zmopenapi.zmxy.com.cn/openapi.do");
        httpRequestObject.setRequestUri(requestUri);

        httpRequestObject.setTransactionId(transactionId);
        httpRequestObject.setOrderNo(orderNo);

        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = zhimaOrderConfirmHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理

            logger.error(e.getMessage(), e);
        }

        //TODO httpRequestResult 判空或异常抛出

        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (ZhimaOrderConfirmHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                //正常获取到接口返回数据
                System.out.println(httpResponseObject.getZmScore());
                System.out.println(httpResponseObject.getOpenId());
                //TODO 持久化相关信息
                SessionUtil.setAttribute(request.getSession(),"zmxy",httpResponseObject);
                if(userService.checkUserZMXY(httpResponseObject,(PlatFormUserCache)SessionUtil.getAttribute(request.getSession(),"user"))){
                    return true;
                }else {
                    return false;
                }

            } else {

                //失败处理
            }

        } else {
            //失败处理
        }

        return result;
    }
}

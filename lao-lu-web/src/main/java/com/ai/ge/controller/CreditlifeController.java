package com.ai.ge.controller;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.service.auth.CreditlifeService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.util.CommonUtil;
import com.ai.ge.util.DateUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 接收从芝麻回调后调用  信用套餐查询接口 获取用户信息后调用
 */

//@Controller
//@RequestMapping("/creditlife")
@Service
@AbilityRegister(name = "creditlife")
public class CreditlifeController implements IAbility {



    private static Logger logger = LoggerFactory.getLogger(CreditlifeController.class);

    @Resource
    private CreditlifeService creditlifeService;

    /**
     * 接收从芝麻回调后调用  信用套餐查询接口 获取用户信息后调用
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message) {
        String orderNo = message.getRequest().getParameter("orderNo");

        if (StringUtils.isBlank(orderNo)) {
            //判空

            logger.error("接收从芝麻回调后获取用户信息接口未能获取参数 orderNo");
        }
        String transactionId = DateUtil.getStrFromDate(new Date(), "yyyyMMddhhmmssSSS") + RandomStringUtils.randomNumeric(13);
        //TODO 流水号

        boolean creditlifeResult = false;
        try {
            creditlifeResult = creditlifeService.creditlife(orderNo, transactionId,message.getRequest());
            if(creditlifeResult){
                String reditecturl="redirect:"+ CommonUtil.getConfigValue("order.url");

                logger.info("准备跳转这个页面："+reditecturl);
                message.setView(reditecturl);
            }else{
                String errorurl="redirect:"+ CommonUtil.getConfigValue("error.url");
                logger.info("准备跳转这个页面："+errorurl);
                message.setView(errorurl);
            }


        } catch (BusinessException e) {
            logger.error(e.getMessage());
            String errorurl="redirect:"+ CommonUtil.getConfigValue("error.url");
            logger.info("准备跳转这个页面："+errorurl);
            message.setView(errorurl);
            //异常处理
        }


//        if (creditlifeResult) {
//            //页面重定向业务页面
//        } else {
//            //重定向到
//        }
        return message;
    }



//
//    /**
//     * 接收从芝麻回调后调用  信用套餐查询接口 获取用户信息后调用
//     *
//     * @param request
//     * @param response
//     */
//    @RequestMapping
//    public void creditlife(HttpServletRequest request, HttpServletResponse response) {
//        String orderNo = request.getParameter("orderNo");
//
//        if (StringUtils.isBlank(orderNo)) {
//            //判空
//
//            logger.error("接收从芝麻回调后获取用户信息接口未能获取参数 orderNo");
//        }
//        String transactionId = DateUtil.getStrFromDate(new Date(), "yyyyMMddhhmmssSSS") + RandomStringUtils.randomNumeric(13);
//        //TODO 流水号
//
//        boolean creditlifeResult = false;
//        try {
//            creditlifeResult = creditlifeService.creditlife(orderNo, transactionId);
//
//
//        } catch (BusinessException e) {
//            logger.error(e.getMessage());
//
//            //异常处理
//        }
//
//
//        if (creditlifeResult) {
//            //页面重定向业务页面
//        } else {
//            //重定向到
//        }
//    }


}

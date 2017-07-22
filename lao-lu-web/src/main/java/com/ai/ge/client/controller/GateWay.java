package com.ai.ge.client.controller;

/**
 * Created by Sam on 17/5/26.
 */

import com.ai.ge.ali.factory.AlipayAPIClientFactory;
import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.constant.AlipayServiceEnvConstants;
import com.ai.ge.platform.cache.PlatFormUserCache;
import com.ai.ge.platform.exception.LoginException;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.user.PlatformUser;
import com.ai.ge.platform.service.user.PlatformUserService;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpResponseObject;
import com.ai.ge.util.CommonUtil;
import com.ai.ge.util.RequestUtil;
import com.ai.ge.util.SessionUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
@AbilityRegister(name = "gateway")
public class GateWay implements IAbility{

    private static final Logger logger = LoggerFactory.getLogger(GateWay.class);

    @Resource
    private PlatformUserService platformUserService;

    protected static boolean isDebug = true;

    @Override
    public Message execute(Message message) {
        HttpServletRequest request = message.getRequest();
        String reditecturl="redirect:"+ CommonUtil.getConfigValue("alipay.app.gateway");
        String code = request.getParameter("code");
        if(isDebug&&"test".equals(code)){
            if(null==SessionUtil.getAttribute(request.getSession(),"user")) {
                PlatFormUserCache cache = new PlatFormUserCache();
                cache.setId(5l);
                cache.setAlipayUserId("2088512163431987");
                cache.setUserId("20880061938451633126159730219798");
                cache.setRealName("长云");
                cache.setProvinceId(11l);
                PlatformUser platFormUser = new PlatformUser();
                platFormUser.setRealName("张三");
                platFormUser.setCertNo("301010198008088888");
                cache.setPlatformUser(platFormUser);
                ZhimaOrderConfirmHttpResponseObject httpResponseObject = new ZhimaOrderConfirmHttpResponseObject();
                httpResponseObject.setOpenId("07909449496");
                httpResponseObject.setZmScore("666");
                httpResponseObject.setCertCity("88");
                SessionUtil.setAttribute(request.getSession(true),"zmxy",httpResponseObject);
                SessionUtil.setAttribute(request.getSession(true), "user", cache);
                reditecturl="redirect:"+ CommonUtil.getConfigValue("domain.url")+"/"+cache.getProvinceId();
                logger.info("跳转首页地址：" + reditecturl);
                message.setView(reditecturl);
                return message;
            }
        }

        if(null!=SessionUtil.getAttribute(request.getSession(),"user")){
            PlatFormUserCache cache = (PlatFormUserCache)SessionUtil.getAttribute(request.getSession(), "user");
            logger.info("未从支付宝获取，获取用户会话省份信息：" + cache.getProvinceId());
            reditecturl="redirect:"+ CommonUtil.getConfigValue("domain.url")+"/"+cache.getProvinceId();
            logger.info("跳转首页地址：" + reditecturl);
            message.setView(reditecturl);
            return message;
        }
        //1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        //2. 获得authCode
        String authCode = params.get("auth_code");
        if(StringUtils.isEmpty(authCode)){
            message.setView(reditecturl);
            return message;
        }
        try {
            //3. 利用authCode获得authToken
            AlipaySystemOauthTokenRequest oauthTokenRequest = new AlipaySystemOauthTokenRequest();
            oauthTokenRequest.setCode(authCode);
            oauthTokenRequest.setGrantType(AlipayServiceEnvConstants.GRANT_TYPE);
            AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient
                    .execute(oauthTokenRequest);
            //成功获得authToken
            if (null != oauthTokenResponse && oauthTokenResponse.isSuccess()) {

                //4. 利用authToken获取用户信息 //获取支付宝钱包分享信息
                AlipayUserUserinfoShareRequest userinfoShareRequest = new AlipayUserUserinfoShareRequest();
                AlipayUserUserinfoShareResponse userinfoShareResponse = alipayClient.execute(
                        userinfoShareRequest, oauthTokenResponse.getAccessToken());
                if (null != userinfoShareResponse && userinfoShareResponse.isSuccess()) {
                    PlatformUser platformUser = platformUserService.login(userinfoShareResponse.getBody(),request);
                    message.setCode(AbilityConstant.R_SUCCESS);
                    message.setMsg("获取用户信息成功");
                    logger.info("获取用户信息成功：" + userinfoShareResponse.getBody());

                    AlipayOpenPublicGisQueryRequest alipayMobilePublicGisGetRequest = new AlipayOpenPublicGisQueryRequest();
                    alipayMobilePublicGisGetRequest.setBizContent("{" + "\"user_id\":\""+platformUser.getUserId()+"\"" + "  }");
                    AlipayOpenPublicGisQueryResponse alipayOpenPublicGisQueryResponse = alipayClient.execute(alipayMobilePublicGisGetRequest);

                    if (null != alipayOpenPublicGisQueryResponse && alipayOpenPublicGisQueryResponse.isSuccess()) {
                        logger.info("获取用户地理信息：" + alipayOpenPublicGisQueryResponse.getBody());
                    }
                    SystemArea location = platformUserService.getProvince(alipayOpenPublicGisQueryResponse.getBody());

                    logger.info("获取用户省份信息：" + location.getAreaId());
                    reditecturl="redirect:"+ CommonUtil.getConfigValue("domain.url")+"/"+location.getAreaId();
                    logger.info("跳转首页地址：" + reditecturl);
                    message.setView(reditecturl);

                } else {
                    message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                    message.setMsg("获取用户信息失败");
                    logger.error("获取用户信息失败");

                }
            } else {
                message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                message.setMsg("authCode换取authToken失败");
                logger.error("authCode换取authToken失败");
            }
        } catch (AlipayApiException alipayApiException) {
            alipayApiException.printStackTrace();
            logger.error(alipayApiException.getMessage());
            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }catch (LoginException loginException){
            loginException.printStackTrace();
            logger.error(loginException.getMessage());
            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }
        return message;
    }


}

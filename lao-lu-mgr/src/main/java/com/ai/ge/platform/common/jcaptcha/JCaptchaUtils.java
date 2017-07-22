/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ai.ge.platform.common.jcaptcha;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

/**
 * JCaptcha工具类
 * 提供相应的API来验证当前请求输入的验证码是否正确
 */
public class JCaptchaUtils {

    private static final Logger logger = LoggerFactory.getLogger(JCaptchaUtils.class);

    private static EcManageableImageCaptchaService captchaService
            = new EcManageableImageCaptchaService(new FastHashMapCaptchaStore(), new GMailEngine(), 180, 100000, 75000);


    public static boolean validateResponse(HttpServletRequest request, String userCaptchaResponse) {
        if (request.getSession(false) == null) return false;

        boolean validated = false;
        try {
            String id = request.getSession().getId();
            validated = captchaService.validateResponseForID(id, userCaptchaResponse).booleanValue();
        } catch (CaptchaServiceException e) {
            logger.error(e.getMessage(), e);
        }

        if (logger.isDebugEnabled()) {
            if (validated) {
                logger.debug("验证码校验通过");
            } else {
                logger.debug("验证码校验失败");
            }

        }
        return validated;
    }

    public static BufferedImage getImageChallengeForID(String id) {
        return captchaService.getImageChallengeForID(id);
    }

    public static boolean hasCaptcha(HttpServletRequest request, String userCaptchaResponse) {
        if (request.getSession(false) == null) return false;
        boolean validated = false;
        try {
            String id = request.getSession().getId();
            validated = captchaService.hasCapcha(id, userCaptchaResponse);
        } catch (CaptchaServiceException e) {
            logger.error(e.getMessage(), e);
        }
        return validated;
    }

}

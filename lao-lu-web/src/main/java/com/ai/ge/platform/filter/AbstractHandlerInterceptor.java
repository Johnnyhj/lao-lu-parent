package com.ai.ge.platform.filter;

import com.ai.ge.platform.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *
 */
public abstract class AbstractHandlerInterceptor extends BaseController implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AbstractHandlerInterceptor.class);




}

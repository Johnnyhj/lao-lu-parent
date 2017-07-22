package com.ai.ge.controller;

import com.ai.ge.arrears.constant.ArrearsConstants;
import com.ai.ge.arrears.service.ArrearsService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.serviceimpl.redis.RedisSpringProxyImpl;
import com.ai.ge.util.CommonUtil;
import com.ai.ge.util.FtpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Sam on 17/5/23.
 */
@Controller
@RequestMapping(value = "test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @Resource
    private RedisSpringProxy redisSpringProxy;

    @Resource
    private ArrearsService arrearsService;

    @RequestMapping(value = "scan")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
//        redisSpringProxy.delete(ArrearsConstants.ARREAR_SIZE);
//        redisSpringProxy.delete(ArrearsConstants.HANDLE_SIZE);
//        arrearsService.scanArrearslist();
//        redisSpringProxy.delete("key");
//        long s = redisSpringProxy.lPush("key","111");
//        s = redisSpringProxy.lPush("key","111");
//        s = redisSpringProxy.lPush("key","111");

    }

}

package com.ai.ge.client.controller;

import com.ai.ge.arrears.service.ArrearsService;
import com.ai.ge.arrears.serviceimpl.ProcessCenter;
import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.mapper.user.DeliverAddressMapper;
import com.ai.ge.platform.model.user.DeliverAddress;
import com.ai.ge.platform.model.user.PlatformUser;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.user.PlatformUserService;
import com.ai.ge.util.CommonUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Sam on 17/5/26.
 * 手动催缴
 */
@Service
@AbilityRegister(name = "test")
public class Test implements IAbility{



    @Resource
    private PlatformUserService platformUserService;

    @Override
    public Message execute(Message message) {

        String json ="{\n" +
                "    \"sign\":\"ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE\",\n" +
                "    \"alipay_open_public_gis_query_response\":{\n" +
                "        \"province\":\"\",\n" +
                "        \"longitude\":\"115.2562865\",\n" +
                "        \"latitude\":\"30.6552\",\n" +
                "        \"code\":\"10000\",\n" +
                "        \"accuracy\":\"50\",\n" +
                "        \"msg\":\"Success\",\n" +
                "        \"city\":\"杭州市\"\n" +
                "    }\n" +
                "}";

        platformUserService.getProvince(json);
        message.setCode(0);
        return message;
    }



}

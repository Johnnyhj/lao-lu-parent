package com.ai.ge.arrears.serviceimpl;

import com.ai.ge.arrears.constant.ArrearsConstants;
import com.ai.ge.arrears.service.ArrearsService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.serviceimpl.redis.RedisSpringProxyImpl;
import com.ai.ge.util.CommonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

/**
 * Created by Sam on 17/5/24.
 */
public class ArrearsDispenser implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(ArrearsDispenser.class);

    /**
     * 拆分子文件
     */
    private String file;

    private String redisFlag;

    private ArrearsService arrearsService;


    public ArrearsDispenser(String file, String redisFlag, ArrearsService arrearsService) {
        this.file = file;
        this.redisFlag = redisFlag;
        this.arrearsService = arrearsService;
    }


    @Override
    public void run() {
        Thread.currentThread().setName(this.getClass().getSimpleName());
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(file)));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"), 10 * 1024 * 1024);// 10M缓存

            //TODO  新增每个文件filename 子flag   如遇异常  单独处理
            while (in.ready()) {
                String line = in.readLine();
                if(!StringUtils.isEmpty(line)) {
                    CommonUtil.threadPool.execute(new ArrearsActuator(line,redisFlag, arrearsService));
                }
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

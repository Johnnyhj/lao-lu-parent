package com.ai.ge.arrears.serviceimpl;

import com.ai.ge.arrears.constant.ArrearsConstants;
import com.ai.ge.arrears.service.ArrearsService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Sam on 17/6/5.
 */
public class Downloader implements Runnable{

    private String filename;
    private RedisSpringProxy redisSpringProxy;


    public Downloader(String filename, RedisSpringProxy redisSpringProxy) {
        this.filename = filename;
        this.redisSpringProxy = redisSpringProxy;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.getClass().getSimpleName());
        String filepath  = filename.replace(".txt","");
        CopyFileUtil copyFile = new CopyFileUtil(new FTPClient(), ArrearsConstants.FTP_SERVER, ArrearsConstants.FTP_USERNAME,
                ArrearsConstants.FTP_PASSWORD, ArrearsConstants.FTP_PORT, ArrearsConstants.REMOTEPATH + filename,
                ArrearsConstants.LOCLPATH+ filename, redisSpringProxy);
        try {
            //下载文件
            copyFile.continueDownload();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

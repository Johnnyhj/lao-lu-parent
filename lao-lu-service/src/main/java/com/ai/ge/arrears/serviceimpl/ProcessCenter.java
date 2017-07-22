package com.ai.ge.arrears.serviceimpl;

import com.ai.ge.arrears.constant.ArrearsConstants;
import com.ai.ge.arrears.service.ArrearsService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.util.CommonUtil;
import org.apache.commons.net.ftp.FTPClient;

/**
 * handler center
 * Created by Sam on 17/5/27.
 */
public class ProcessCenter implements Runnable{


    private String filename;
    private ArrearsService arrearsService;
    private RedisSpringProxy redisSpringProxy;


    public ProcessCenter(String filename, ArrearsService arrearsService, RedisSpringProxy redisSpringProxy) {
        this.filename = filename;
        this.arrearsService = arrearsService;
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
            if(!downloadExist()) {
                CommonUtil.threadPool.execute(new Downloader(filename, redisSpringProxy));
            }
            while (downloadExist()){
                sleep();
            }
            //下载完成
            //TODO 判断本地文件  远处文件大小  不满足直接退出
            //TODO 解压压缩文件
            //读取文件行数
            Integer lineNumbers = arrearsService.getFileNumbers(ArrearsConstants.LOCLPATH + filename);
            //拆分规则为  localpath/filename.txt ----->  localpath/filename+split/filename_CHIP_123.txt  123为序列
            Integer filecount = arrearsService.splitLargeFile(ArrearsConstants.LOCLPATH + filename, lineNumbers, filename.replace(".txt", ""));
            //开始处理
            arrearsService.resetArrears(ArrearsConstants.NONEEDCALL);
            redisSpringProxy.save(ArrearsConstants.ARREAR_SIZE + filepath, lineNumbers);

            //分发器线程判断
            if(!dispenserExist()){
                for (int i = 0; i < filecount; i++) {
                    //redis   拆分子文件 key  filename+flag+i  ====>   filename.txt  --->  filename_CHIP_123 123为序列
                    CommonUtil.threadPool.execute(new ArrearsDispenser(ArrearsConstants.LOCLPATH + filepath + ArrearsConstants.SPLIT_FLAG + filepath+ ArrearsConstants.CHIP_FILE_FLAG + i, filepath+ ArrearsConstants.CHIP_FILE_FLAG + i, arrearsService));
                }

            }


            //TODO  建议守护线程处理 否则容易
            //检查分发、处理线程是否处理完毕
            long totalsize = redisSpringProxy.lPush(ArrearsConstants.HANDLE_SIZE,CommonUtil.genRandomNum(4));
            //全部处理完毕
            if(totalsize==redisSpringProxy.read(ArrearsConstants.ARREAR_SIZE, Long.class)){
                //迁移催缴成功清单
                arrearsService.transfer();
                //TODO 调用催缴
                redisSpringProxy.delete(ArrearsConstants.ARREAR_SIZE);
                redisSpringProxy.delete(ArrearsConstants.HANDLE_SIZE);
            }else{
                Integer batchCount = Integer.parseInt(CommonUtil.getConfigValue("file.split.batchcount"));
                Integer filecounts = lineNumbers % batchCount == 0 ? lineNumbers / batchCount : lineNumbers / batchCount + 1;
                for (int i = 0; i < filecounts; i++) {
                    if (!(i < filecounts - 1 && redisSpringProxy.read(filename + ArrearsConstants.CHIP_FILE_FLAG + i, Integer.class) == batchCount)) {
                        //该文件未处理完毕 需要重新处理
                        CommonUtil.threadPool.execute(new ArrearsDispenser(ArrearsConstants.LOCLPATH + filepath + ArrearsConstants.SPLIT_FLAG + filepath+ ArrearsConstants.CHIP_FILE_FLAG + i, filepath+ ArrearsConstants.CHIP_FILE_FLAG + i, arrearsService));
                    }
                    if (!(i == filecounts - 1 && redisSpringProxy.read(filename + ArrearsConstants.CHIP_FILE_FLAG + i, Integer.class) == lineNumbers % batchCount)) {
                        //该文件未处理完毕 需要重新处理
                        CommonUtil.threadPool.execute(new ArrearsDispenser(ArrearsConstants.LOCLPATH + filepath + ArrearsConstants.SPLIT_FLAG + filepath+ ArrearsConstants.CHIP_FILE_FLAG + i, filepath+ ArrearsConstants.CHIP_FILE_FLAG + i, arrearsService));

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sleep() throws InterruptedException {
        Thread.sleep(ArrearsConstants.CENTRAL_PROCESSING_INTERVAL);
    }

    private boolean downloadExist(){
        for(Thread key:Thread.getAllStackTraces().keySet()){
            if(key.getName().equals("Downloader")){
                return true;
            }
        }
        return false;
    }

    private boolean dispenserExist(){
        for(Thread key:Thread.getAllStackTraces().keySet()){
            if(key.getName().equals("ArrearsDispenser")){
                return true;
            }
        }
        return false;
    }
}

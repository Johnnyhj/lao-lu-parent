package com.ai.ge.arrears.serviceimpl;

import com.ai.ge.arrears.constant.ArrearsConstants;
import com.ai.ge.arrears.service.ArrearsService;
import com.ai.ge.platform.mapper.arrears.ArrearsCallSuccessInfoMapper;
import com.ai.ge.platform.mapper.arrears.ArrearsFilesMapper;
import com.ai.ge.platform.mapper.arrears.ArrearsInfoMapper;
import com.ai.ge.platform.model.arrears.ArrearsCallSuccessInfo;
import com.ai.ge.platform.model.arrears.ArrearsFiles;
import com.ai.ge.platform.model.arrears.ArrearsFilesExample;
import com.ai.ge.platform.model.arrears.ArrearsInfo;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.util.CommonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 17/5/24.
 */
@Service
public class ArrearsServiceImpl implements ArrearsService {


    private static final Logger logger = LoggerFactory.getLogger(ArrearsServiceImpl.class);


    @Resource
    private ArrearsInfoMapper arrearsInfoMapper;


    @Resource
    private ArrearsCallSuccessInfoMapper arrearsCallSuccessInfoMapper;

    @Resource
    private RedisSpringProxy redisSpringProxy;

    @Resource
    private ArrearsFilesMapper arrearsFilesMapper;

    @Override
    public void scanArrearslist(String s) throws IOException, ParseException,Exception {
        scanFiles(s);
    }


    /**
     * scan files
     * @param s 输入文件名
     * @throws Exception
     */
    protected void scanFiles(String s) throws Exception {
        CopyFileUtil copyFile = new CopyFileUtil(new FTPClient(), ArrearsConstants.FTP_SERVER, ArrearsConstants.FTP_USERNAME,
                ArrearsConstants.FTP_PASSWORD, ArrearsConstants.FTP_PORT, ArrearsConstants.REMOTEPATH,
                ArrearsConstants.LOCLPATH , redisSpringProxy);
        List<String> fileList = copyFile.getFileList(ArrearsConstants.REMOTEPATH);
        if(StringUtils.isEmpty(s)) {
            List<ArrearsFiles> list = arrearsFilesMapper.selectByExample(new ArrearsFilesExample());
            for(String file :fileList){
                if(!list.contains(file))
                    //正常处理逻辑  只处理一个
                    CommonUtil.threadPool.execute(new ProcessCenter(file,this,redisSpringProxy));
                    break;
            }
        }else {
            if(!fileList.contains(s))
                throw new Exception("不存在该文件");
            else
                CommonUtil.threadPool.execute(new ProcessCenter(s,this,redisSpringProxy));
        }
        System.out.println("ArrearsServiceImpl.scanFiles");
    }


    /**
     * actuator arrearsString
     * @param arrearsString
     */
    @Override
    public void actuator(String arrearsString,String redisFlag) {
        logger.info("处理欠费字符串:"+arrearsString);
        //格式化处理
        if(!StringUtils.isEmpty(arrearsString)){
            ArrearsInfo arrearsInfo = formation(arrearsString);
            comparison(arrearsInfo);
            ckfinsh(redisFlag);
        }

    }

    /**
     * 格式化
     * @param arrearsString
     * @return
     */
    protected ArrearsInfo formation(String arrearsString){
        String[] arrears = arrearsString.split("\\|");
        ArrearsInfo arrearsInfo = new ArrearsInfo();
        arrearsInfo.setAccount(Long.parseLong(arrears[0]));
        arrearsInfo.setArrearsPhone(arrears[1]);
        arrearsInfo.setIdentityType(Short.decode(arrears[2]));
        arrearsInfo.setIdentityNum(arrears[3]);
        arrearsInfo.setName(arrears[4]);
        arrearsInfo.setArrearsMonth(Integer.parseInt(arrears[5]));
        arrearsInfo.setArrearsMoney(Integer.parseInt(arrears[6]));
        arrearsInfo.setAccountMoney(Integer.parseInt(arrears[7]));
        arrearsInfo.setStatus(ArrearsConstants.NEEDCALL);
        return arrearsInfo;
    }


    /**
     * 比对
     * @param arrearsInfo
     */
    protected void comparison(ArrearsInfo arrearsInfo){
        if(null==arrearsInfoMapper.isExist(arrearsInfo))
            arrearsInfoMapper.insert(arrearsInfo);
        else
            arrearsInfoMapper.updateArrears(ArrearsConstants.NEEDCALL,arrearsInfo.getArrearsPhone());
    }


    @Override
    public void resetArrears(Integer status) {
        arrearsInfoMapper.resetArrears(status);
    }

    protected void ckfinsh(String redisFlag){
        long totalsize = redisSpringProxy.lPush(ArrearsConstants.HANDLE_SIZE,CommonUtil.genRandomNum(4));
        long chipsize = redisSpringProxy.lPush(redisFlag,CommonUtil.genRandomNum(4));
        //全部处理完毕
        if(totalsize==redisSpringProxy.read(ArrearsConstants.ARREAR_SIZE, Long.class)){
            //迁移催缴成功清单
            transfer();
            //TODO 调用催缴
            redisSpringProxy.delete(ArrearsConstants.ARREAR_SIZE);
            redisSpringProxy.delete(ArrearsConstants.HANDLE_SIZE);
        }

    }

    protected boolean ckthread(){
        //TODO 检查分发、处理线程是否处理完毕
        return false;
    }


    /**
     * 迁移催缴成功清单
     */
    @Override
    public void transfer(){
        List<ArrearsInfo> arrearsInfoList = arrearsInfoMapper.selectNoneedCallArrears(ArrearsConstants.NONEEDCALL);
        if(!CollectionUtils.isEmpty(arrearsInfoList)){
            arrearsCallSuccessInfoMapper.insertArrearsCalls(copyArrears(arrearsInfoList));
            arrearsInfoMapper.removeNoneedCallArrears(arrearsInfoList);
            transfer();
        }
    }

    /**
     * copyArrears
     * @param arrearsInfoList
     * @return
     */
    protected List<ArrearsCallSuccessInfo> copyArrears(List<ArrearsInfo> arrearsInfoList){
        List<ArrearsCallSuccessInfo> list = new ArrayList<ArrearsCallSuccessInfo>();
        for(ArrearsInfo arrearsInfo:arrearsInfoList) {
            ArrearsCallSuccessInfo arrearsCallSuccessInfo = new ArrearsCallSuccessInfo();
            arrearsCallSuccessInfo.setArrearsId(arrearsInfo.getArrearsId());
            arrearsCallSuccessInfo.setAccount(arrearsInfo.getAccount());
            arrearsCallSuccessInfo.setAccountMoney(arrearsInfo.getAccountMoney());
            arrearsCallSuccessInfo.setArrearsMonth(arrearsInfo.getArrearsMonth());
            arrearsCallSuccessInfo.setName(arrearsInfo.getName());
            arrearsCallSuccessInfo.setArrearsPhone(arrearsInfo.getArrearsPhone());
            arrearsCallSuccessInfo.setArrearsTime(arrearsInfo.getArrearsTime());
            arrearsCallSuccessInfo.setIdentityType(arrearsInfo.getIdentityType());
            arrearsCallSuccessInfo.setArrearsMoney(arrearsInfo.getArrearsMoney());
            arrearsCallSuccessInfo.setIdentityNum(arrearsInfo.getIdentityNum());
            list.add(arrearsCallSuccessInfo);
        }
        return list;
    }

    @Override
    public int getFileNumbers(String filepath) {
        Integer lineNumbers = 0;
        Integer maxlines = 0;
        //执行两次
        for(int i = 0;i<2;i++){
            lineNumbers=ReadFileUtil.getFileLineCounts(filepath);
            maxlines=lineNumbers>=maxlines?lineNumbers:maxlines;
        }
        return maxlines;
    }


    @Override
    public int splitLargeFile(String filepath, Integer lineNumbers,String filename) {
        Integer batchCount = Integer.parseInt(CommonUtil.getConfigValue("file.split.batchcount"));
        Integer filecounts = lineNumbers%batchCount==0?lineNumbers/batchCount:lineNumbers/batchCount+1;
        ReadFileUtil.splitTxtLagre(batchCount,filepath,filepath.replace(".txt",ArrearsConstants.SPLIT_FLAG),filename.replace(".txt",ArrearsConstants.CHIP_FILE_FLAG));
        return filecounts;
    }
}




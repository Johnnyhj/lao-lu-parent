package com.ai.ge.platform.serviceimpl.log;

import com.ai.ge.platform.dto.log.LogDataBatchFeedbackDto;
import com.ai.ge.platform.mapper.log.LogDataBatchFeedbackDetailMapper;
import com.ai.ge.platform.mapper.log.LogDataBatchFeedbackMapper;
import com.ai.ge.platform.model.log.LogDataBatchFeedback;
import com.ai.ge.platform.model.log.LogDataBatchFeedbackDetail;
import com.ai.ge.platform.service.log.LogDataBatchFeedbackService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaBatchFeedbackHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.request.BatchFeedback;
import com.ai.ge.util.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */

@Service
@Transactional
public class LogDataBatchFeedbackServiceImpl implements LogDataBatchFeedbackService {

    private static Logger logger = LoggerFactory.getLogger(LogDataBatchFeedbackServiceImpl.class);

    @Resource
    private LogDataBatchFeedbackMapper logDataBatchFeedbackMapper;

    @Resource
    private LogDataBatchFeedbackDetailMapper logDataBatchFeedbackDetailMapper;

    @Resource
    private SysDataService sysDataService;

    @Override
    public LogDataBatchFeedbackDto getObjectByObject(LogDataBatchFeedback object) {
        return null;
    }

    @Override
    public int saveOrUpdateObject(LogDataBatchFeedbackDto object) {
        int i = 0;
        if (null == object.getLogFeedbackId()) {

            i += logDataBatchFeedbackMapper.insertSelective(object);

            if (CollectionUtils.isNotEmpty(object.getLogDataBatchFeedbackDetails())) {
                i += logDataBatchFeedbackDetailMapper.insertBatch(object.getLogDataBatchFeedbackDetails(), object.getLogFeedbackId());
            }

        } else {
            i += logDataBatchFeedbackMapper.updateByPrimaryKeySelective(object);
            if (CollectionUtils.isNotEmpty(object.getLogDataBatchFeedbackDetails())) {
                i += logDataBatchFeedbackDetailMapper.deleteBylogFeedbackId(object.getLogFeedbackId());
                i += logDataBatchFeedbackDetailMapper.insertBatch(object.getLogDataBatchFeedbackDetails(), object.getLogFeedbackId());
            }
        }


        return i;
    }

    @Override
    public LogDataBatchFeedbackDto saveDataBatchFeedback(HttpRequestContext httpRequestContext, String directory) throws BusinessException {
        ZhimaBatchFeedbackHttpRequestObject httpRequestObject = (ZhimaBatchFeedbackHttpRequestObject) httpRequestContext.getHttpRequestObject();
        List<BatchFeedback> batchFeedbacks = httpRequestObject.getBatchFeedbacks();

        LogDataBatchFeedbackDto logDataBatchFeedbackDto = new LogDataBatchFeedbackDto();
        logDataBatchFeedbackDto.setPushSeq(httpRequestObject.getTransactionId());

        saveOrUpdateObject(logDataBatchFeedbackDto);

        String output = getDirectory(directory) + File.separator + getDataBatchFeedbackFileName() + ".json";
        BufferedOutputStream bw = null;

        try {
            bw = new BufferedOutputStream(new FileOutputStream(output));
            for (BatchFeedback batchFeedback : batchFeedbacks) {
                IOUtils.write(JSON.toJSONString(batchFeedback, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty), bw, CharEncoding.UTF_8);
                IOUtils.write("\n", bw);
            }
        } catch (IOException e) {
            throw new BusinessException(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(bw);
        }

        logDataBatchFeedbackDto.setSourceFilePath(output);
        logDataBatchFeedbackDto.setFileCreateTime(new Date());
        logDataBatchFeedbackDto.setCreateStatus(0);

        saveOrUpdateObject(logDataBatchFeedbackDto);
        return logDataBatchFeedbackDto;
    }

    @Override
    public LogDataBatchFeedbackDto saveSplitDataBatchFeedback(LogDataBatchFeedbackDto logDataBatchFeedbackDto, String directory) {
        directory = getDirectory(directory);

        //分割成45M
        int dataNum = 0, maxDataNum = sysDataService.getIntegerByKeyType("data_batch_feedback_file_split", SysDataService.WEB_APP, "45") * 1024 * 1024;

        int multiple = 1, splitStatus = 1, dataLineNum = 0;
        Integer logFeedbackId = logDataBatchFeedbackDto.getLogFeedbackId();
        String suffix = ".json";
        String outputName = getSplitDataBatchFeedbackFileName(getDirectory(directory), multiple, suffix);
        String header = "{\n" +
                "    \"records\": [";

        String foot = "]\n" +
                "}";

        List<LogDataBatchFeedbackDetail> logDataBatchFeedbackDetails = new ArrayList<LogDataBatchFeedbackDetail>();

        logDataBatchFeedbackDto.setLogDataBatchFeedbackDetails(logDataBatchFeedbackDetails);
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;


        try {
            inputStream = new BufferedInputStream(new FileInputStream(logDataBatchFeedbackDto.getSourceFilePath()));

            outputStream = new BufferedOutputStream(new FileOutputStream(outputName));
            LineIterator iterator = IOUtils.lineIterator(inputStream, CharEncoding.UTF_8);

            IOUtils.write(header, outputStream, CharEncoding.UTF_8);

            while (iterator.hasNext()) {
                String lineText = iterator.nextLine();
                dataNum += lineText.length();


                if (dataNum >= maxDataNum) {
                    IOUtils.write("\n", outputStream, CharEncoding.UTF_8);
                    IOUtils.write(foot, outputStream, CharEncoding.UTF_8);
                    outputStream.flush();

                    //拆分明细记录
                    saveLogDataBatchFeedbackDetailBySplite(logDataBatchFeedbackDto, outputName, 0, dataLineNum, multiple);

                    multiple++;

                    dataNum = dataLineNum = 0;

                    outputName = getSplitDataBatchFeedbackFileName(getDirectory(directory), multiple, suffix);
                    outputStream = new BufferedOutputStream(new FileOutputStream(outputName));


                    IOUtils.write(header, outputStream, CharEncoding.UTF_8);
                }

                if (0 != dataLineNum) {
                    IOUtils.write("," + lineText, outputStream, CharEncoding.UTF_8);
                } else {
                    IOUtils.write(lineText, outputStream, CharEncoding.UTF_8);
                }

                IOUtils.write("\n", outputStream, CharEncoding.UTF_8);

                dataLineNum++;
            }

            IOUtils.write("\n", outputStream, CharEncoding.UTF_8);
            IOUtils.write(foot, outputStream, CharEncoding.UTF_8);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            //拆分部分成功
            if (1 < multiple) {
                splitStatus = 2;
            }
            logDataBatchFeedbackDto.setSplitFailReason(e.getMessage());
            saveLogDataBatchFeedbackDetailBySplite(logDataBatchFeedbackDto, outputName, 1, dataLineNum, multiple);
        } finally {
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(inputStream);
        }

        if (1 == splitStatus) {
            splitStatus = 0;
            saveLogDataBatchFeedbackDetailBySplite(logDataBatchFeedbackDto, outputName, 0, dataLineNum, multiple);
        }

        logDataBatchFeedbackDto.setSplitStatus(splitStatus);
        logDataBatchFeedbackDto.setLogDataBatchFeedbackDetails(logDataBatchFeedbackDetails);

        saveOrUpdateObject(logDataBatchFeedbackDto);
        return logDataBatchFeedbackDto;
    }

    @Override
    public void publishByLogBatchFeedbackDetail(LogDataBatchFeedbackDetail logDataBatchFeedbackDetail, int pushStatus, String failReason) {
        logDataBatchFeedbackDetail.setPushStatus(pushStatus);
        logDataBatchFeedbackDetailMapper.updateByPrimaryKeySelective(logDataBatchFeedbackDetail);
    }

    @Override
    public void publishByLogBatchFeedback(LogDataBatchFeedbackDto logDataBatchFeedbackDto, int pushStatus, String failReason) {
        logDataBatchFeedbackMapper.updateByPrimaryKeySelective(logDataBatchFeedbackDto);
    }

    @Override
    public void publishByLogBatchFeedback(LogDataBatchFeedbackDto logDataBatchFeedbackDto) {

    }

    protected String getDirectory(String directory) {
        if (StringUtils.isNotBlank(directory)) {
            return directory;
        }
        return sysDataService.getByKeyType("data_batch_feedback_file_path", SysDataService.WEB_APP);
    }


    protected String getDataBatchFeedbackFileName() {
        return DateUtil.getStrFromDate(new Date(), DateUtil.DATE_FORMATE_STRING_G);
    }


    protected String getSplitDataBatchFeedbackFileName(String directory, int multiple, String suffix) {
        return directory + File.separator + getDataBatchFeedbackFileName() + '.' + multiple + suffix;

    }


    protected void saveLogDataBatchFeedbackDetailBySplite(LogDataBatchFeedbackDto logDataBatchFeedbackDto, String splitFilePath, int splitStatus, int dataNum, int splitBlock) {
        List<LogDataBatchFeedbackDetail> logDataBatchFeedbackDetails = logDataBatchFeedbackDto.getLogDataBatchFeedbackDetails();

        LogDataBatchFeedbackDetail logDataBatchFeedbackDetail = new LogDataBatchFeedbackDetail();
        logDataBatchFeedbackDetail.setSplitFilePath(splitFilePath);
        logDataBatchFeedbackDetail.setSplitStatus(splitStatus);
        logDataBatchFeedbackDetail.setDataNum(dataNum);
        logDataBatchFeedbackDetail.setLogFeedbackId(logDataBatchFeedbackDto.getLogFeedbackId());
        logDataBatchFeedbackDetail.setSplitBlock(splitBlock);

        logDataBatchFeedbackDetails.add(logDataBatchFeedbackDetail);
    }
}

package com.ai.ge.platform.serviceimpl.sys;


import com.ai.ge.platform.model.sys.SystemAccessInfo;
import com.ai.ge.platform.service.sys.SystemAccessInfoService;
import com.ai.ge.platform.mapper.sys.SystemAccessInfoMapper;
import com.ai.ge.platform.model.sys.SystemAccessInfoExample;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


@Service
@Transactional
public class SystemAccessInfoServiceImpl implements SystemAccessInfoService
{

    private static BlockingQueue<SystemAccessInfo> listObjects = new LinkedBlockingQueue<SystemAccessInfo>();


    private Logger logger = Logger.getLogger(SystemAccessInfoServiceImpl.class);
    @Resource
    private SystemAccessInfoMapper systemAccessInfoMapper;


    public int countByExample(SystemAccessInfoExample example) {
        return systemAccessInfoMapper.countByExample(example);
    }

    public int deleteByExample(SystemAccessInfoExample example) {
        return systemAccessInfoMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long contLogId) {
        return systemAccessInfoMapper.deleteByPrimaryKey(contLogId);
    }

    public int insert(SystemAccessInfo record) {
        try {
            listObjects.put(record);
            return 1;
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
            return 0;
        }
    }

    public int insertSelective(SystemAccessInfo record) {
        return systemAccessInfoMapper.insertSelective(record);
    }

    public List<SystemAccessInfo> selectByExample(SystemAccessInfoExample example) {
        return systemAccessInfoMapper.selectByExample(example);
    }

    public SystemAccessInfo selectByPrimaryKey(Long contLogId) {
        return systemAccessInfoMapper.selectByPrimaryKey(contLogId);
    }

    public int updateByExample(SystemAccessInfo record,
                               SystemAccessInfoExample example) {
        return systemAccessInfoMapper.updateByExample(record, example);
    }

    public int updateByExampleSelective(SystemAccessInfo record,
                                        SystemAccessInfoExample example) {
        return systemAccessInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByPrimaryKey(SystemAccessInfo record) {
        return systemAccessInfoMapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(SystemAccessInfo record) {
        return systemAccessInfoMapper.updateByPrimaryKeySelective(record);
    }


    public List<Map<String, Object>> statisticsAccIp(Map<String, Object> params) {
        return systemAccessInfoMapper.statisticsAccIp(params);
    }


    @PostConstruct
    public void startup() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {

            @Override
            public void run() {
                SystemAccessInfo object = null;

                while (true) {
                    try {
                        object = listObjects.take();
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                    try {
                        if (null != object) {
                            systemAccessInfoMapper.insert(object);
                        }
                    } catch (Exception e) {
                        logger.error("批量保存访问记录 " + e.getMessage(), e);
                    }
                }


            }
        });
    }
}

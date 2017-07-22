package com.ai.ge.platform.serviceimpl.sys;


import com.ai.ge.platform.service.sys.SystemAccessBlackListService;
import com.ai.ge.platform.mapper.sys.SystemAccessBlackListMapper;
import com.ai.ge.platform.model.sys.SystemAccessBlackList;
import com.ai.ge.platform.model.sys.SystemAccessBlackListExample;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class SystemAccessBlackListServiceImpl implements SystemAccessBlackListService
{

    private Logger logger = Logger.getLogger(SystemAccessBlackListServiceImpl.class);

    @Resource
    private SystemAccessBlackListMapper systemAccessBlackListMapper;


    public int deleteByExample(SystemAccessBlackListExample example) {
        return systemAccessBlackListMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long contLogId) {
        return systemAccessBlackListMapper.deleteByPrimaryKey(contLogId);
    }

    public int insert(SystemAccessBlackList record) {
        return systemAccessBlackListMapper.insert(record);
    }

    public int insertSelective(SystemAccessBlackList record) {
        return systemAccessBlackListMapper.insertSelective(record);
    }

    public List<SystemAccessBlackList> selectByExample(SystemAccessBlackListExample example) {
        return systemAccessBlackListMapper.selectByExample(example);
    }

    public SystemAccessBlackList selectByPrimaryKey(Long contLogId) {
        return systemAccessBlackListMapper.selectByPrimaryKey(contLogId);
    }

    public int updateByExample(SystemAccessBlackList record,
                               SystemAccessBlackListExample example) {
        return systemAccessBlackListMapper.updateByExample(record, example);
    }

    public int updateByExampleSelective(SystemAccessBlackList record,
                                        SystemAccessBlackListExample example) {
        return systemAccessBlackListMapper.updateByExampleSelective(record, example);
    }

    public int updateByPrimaryKey(SystemAccessBlackList record) {
        return systemAccessBlackListMapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(SystemAccessBlackList record) {
        return systemAccessBlackListMapper.updateByPrimaryKeySelective(record);
    }


    public int deleteByUnlockTime(Map<String, Object> params) {
        return systemAccessBlackListMapper.deleteByUnlockTime(params);
    }


}

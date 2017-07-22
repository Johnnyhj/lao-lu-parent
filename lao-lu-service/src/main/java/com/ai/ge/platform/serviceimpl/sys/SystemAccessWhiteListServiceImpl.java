package com.ai.ge.platform.serviceimpl.sys;


import com.ai.ge.platform.mapper.sys.SystemAccessWhiteListMapper;
import com.ai.ge.platform.model.sys.SystemAccessWhiteList;
import com.ai.ge.platform.model.sys.SystemAccessWhiteListExample;
import com.ai.ge.platform.service.sys.SystemAccessWhiteListService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SystemAccessWhiteListServiceImpl implements SystemAccessWhiteListService {


    private Logger logger = Logger.getLogger(SystemAccessWhiteListServiceImpl.class);
	@Resource
	private SystemAccessWhiteListMapper systemAccessWhiteListMapper;

	
	public int countByExample(SystemAccessWhiteListExample example) {
		return systemAccessWhiteListMapper.countByExample(example);
	}
	
	public int deleteByExample(SystemAccessWhiteListExample example) {
		return systemAccessWhiteListMapper.deleteByExample(example);
	}
	
	public int deleteByPrimaryKey(Long contLogId) {
		return systemAccessWhiteListMapper.deleteByPrimaryKey(contLogId);
	}
	
	public int insert(SystemAccessWhiteList record) {
		return systemAccessWhiteListMapper.insert(record);
    }
	
	public int insertSelective(SystemAccessWhiteList record) {
		return systemAccessWhiteListMapper.insertSelective(record);
	}
	
	public List<SystemAccessWhiteList> selectByExample(SystemAccessWhiteListExample example) {
		return systemAccessWhiteListMapper.selectByExample(example);
	}
	
	public SystemAccessWhiteList selectByPrimaryKey(Long contLogId) {
		return systemAccessWhiteListMapper.selectByPrimaryKey(contLogId);
	}
	
	public int updateByExample(SystemAccessWhiteList record,
							   SystemAccessWhiteListExample example) {
		return systemAccessWhiteListMapper.updateByExample(record, example);
	}
	
	public int updateByExampleSelective(SystemAccessWhiteList record,
										SystemAccessWhiteListExample example) {
		return systemAccessWhiteListMapper.updateByExampleSelective(record, example);
	}
	
	public int updateByPrimaryKey(SystemAccessWhiteList record) {
		return systemAccessWhiteListMapper.updateByPrimaryKey(record);
	}
	
	public int updateByPrimaryKeySelective(SystemAccessWhiteList record) {
		return systemAccessWhiteListMapper.updateByPrimaryKeySelective(record);
	}


}

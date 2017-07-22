package com.ai.ge.platform.serviceimpl.sys;

import com.ai.ge.platform.mapper.sys.SystemDataDictionaryMapper;
import com.ai.ge.platform.model.sys.SystemDataDictionaryExample;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.model.sys.SystemDataDictionary;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据字典
 */
@Service
public class SysDataServiceImpl implements SysDataService
{

    @Resource
    private SystemDataDictionaryMapper systemDataDictionaryMapper;

    @Override
    public String getSmsTmp(String dataKey) {
        if (dataKey == null) {
            return null;
        }
        List<SystemDataDictionary> dataList = systemDataDictionaryMapper.selectByExample(null);
        if (dataList == null) {
            return null;
        }

        for (SystemDataDictionary systemDataDictionary : dataList) {
            if (dataKey.equals(systemDataDictionary.getKey())) {
                return systemDataDictionary.getValue();
            }
        }

        return null;
    }

    @Override
    public List<SystemDataDictionary> listByType(String dataType) {
        SystemDataDictionaryExample example = new SystemDataDictionaryExample();
        example.createCriteria().andTypeEqualTo(dataType);
        return systemDataDictionaryMapper.selectByExample(example);
    }

    @Override
    public List<SystemDataDictionary> listAll(SystemDataDictionary sysData) {
        //SystemDataDictionaryExample example = new SystemDataDictionaryExample();
        //example.setOrderByClause("dd_id asc");
        return systemDataDictionaryMapper.listAll(sysData);
    }

    public String getByKeyType(String dataKey, String dataType, String defaultValue) {
        String value = this.getByKeyType(dataKey, dataType);
        return value == null ? defaultValue : value;
    }

    @Override
    public Integer getIntegerByKeyType(String dataKey, String dataType, String defaultValue) {
        String value = getByKeyType(dataKey, dataType, defaultValue);
        return StringUtils.isBlank(value) ? Integer.parseInt(defaultValue) : Integer.parseInt(value);
    }

    public String getByKeyType(String dataKey, String dataType) {
        if (dataKey == null || dataType == null) {
            return null;
        }

        SystemDataDictionary example = new SystemDataDictionary();
        example.setKey(dataKey);
        example.setType(dataType);

        List<SystemDataDictionary> dataList = null;
        try {
            dataList = systemDataDictionaryMapper.getByKeyType(example);
        } catch (Exception ex) {
            return null;
        }
        if (dataList == null) {
            return null;
        }

        for (SystemDataDictionary systemDataDictionary : dataList) {
            if (dataKey.equals(systemDataDictionary.getKey())) {
                return systemDataDictionary.getValue();
            }
        }

        return null;
    }

    @Override
    public SystemDataDictionary getByDdId(Long ddId) {
        return systemDataDictionaryMapper.selectByPrimaryKey(ddId);
    }

    @Override
    public int saveSysData(SystemDataDictionary sysData) {
        return systemDataDictionaryMapper.insertSelective(sysData);
    }

    @Override
    public int updateSysData(SystemDataDictionary sysData) {
        return systemDataDictionaryMapper.updateByPrimaryKeySelective(sysData);
    }

    @Override
    public int deleteSysData(Long ddId) {
        return systemDataDictionaryMapper.deleteByPrimaryKey(ddId);
    }
}

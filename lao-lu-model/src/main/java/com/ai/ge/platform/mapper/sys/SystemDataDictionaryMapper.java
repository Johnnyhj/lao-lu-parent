package com.ai.ge.platform.mapper.sys;

import com.ai.ge.platform.model.sys.SystemDataDictionaryExample;
import com.ai.ge.cache.annotation.CacheOperate;
import com.ai.ge.cache.annotation.ECSCache;
import com.ai.ge.platform.model.sys.SystemDataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemDataDictionaryMapper {
    int countByExample(SystemDataDictionaryExample example);

    @ECSCache(prefix = "SystemDataDictionary", operate = CacheOperate.REMOVE)
    int deleteByExample(SystemDataDictionaryExample example);

    @ECSCache(prefix = "SystemDataDictionary", operate = CacheOperate.REMOVE)
    int deleteByPrimaryKey(Long ddId);

    @ECSCache(prefix = "SystemDataDictionary", operate = CacheOperate.REMOVE)
    int insert(SystemDataDictionary record);

    @ECSCache(prefix = "SystemDataDictionary", operate = CacheOperate.REMOVE)
    int insertSelective(SystemDataDictionary record);

    @ECSCache(prefix = "SystemDataDictionary")
    List<SystemDataDictionary> selectByExample(SystemDataDictionaryExample example);

    @ECSCache(prefix = "SystemDataDictionary")
    SystemDataDictionary selectByPrimaryKey(Long ddId);

    @ECSCache(prefix = "SystemDataDictionary", operate = CacheOperate.REMOVE)
    int updateByExampleSelective(@Param("record") SystemDataDictionary record, @Param("example")
    SystemDataDictionaryExample example);

    @ECSCache(prefix = "SystemDataDictionary", operate = CacheOperate.REMOVE)
    int updateByExample(@Param("record") SystemDataDictionary record, @Param("example") SystemDataDictionaryExample
            example);

    @ECSCache(prefix = "SystemDataDictionary", operate = CacheOperate.REMOVE)
    int updateByPrimaryKeySelective(SystemDataDictionary record);

    @ECSCache(prefix = "SystemDataDictionary", operate = CacheOperate.REMOVE)
    int updateByPrimaryKey(SystemDataDictionary record);

    List<SystemDataDictionary> listAll(@Param("record") SystemDataDictionary record);

    List<SystemDataDictionary> getByKeyType(@Param("record") SystemDataDictionary record);
}
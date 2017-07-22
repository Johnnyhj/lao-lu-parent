package com.ai.ge.platform.mapper.sys;

import com.ai.ge.cache.annotation.ECSCache;
import com.ai.ge.platform.model.sys.SystemAccessBlackList;
import com.ai.ge.platform.model.sys.SystemAccessBlackListExample;
import com.ai.ge.cache.annotation.CacheOperate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SystemAccessBlackListMapper {
    int countByExample(SystemAccessBlackListExample example);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int deleteByExample(SystemAccessBlackListExample example);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int deleteByPrimaryKey(Long id);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int insert(SystemAccessBlackList record);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int insertSelective(SystemAccessBlackList record);
    @ECSCache(prefix = "SystemAccessBlackList")
    List<SystemAccessBlackList> selectByExample(SystemAccessBlackListExample example);
    @ECSCache(prefix = "SystemAccessBlackList")
    SystemAccessBlackList selectByPrimaryKey(Long id);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int updateByExampleSelective(@Param("record") SystemAccessBlackList record, @Param("example") SystemAccessBlackListExample example);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int updateByExample(@Param("record") SystemAccessBlackList record, @Param("example") SystemAccessBlackListExample example);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int updateByPrimaryKeySelective(SystemAccessBlackList record);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int updateByPrimaryKey(SystemAccessBlackList record);
    @ECSCache(prefix = "SystemAccessBlackList", operate = CacheOperate.REMOVE)
    int deleteByUnlockTime(Map<String, Object> params);
}
package com.ai.ge.platform.mapper.sys;

import com.ai.ge.cache.annotation.CacheOperate;
import com.ai.ge.cache.annotation.ECSCache;
import com.ai.ge.platform.model.sys.SystemAccessWhiteList;
import com.ai.ge.platform.model.sys.SystemAccessWhiteListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemAccessWhiteListMapper {
    int countByExample(SystemAccessWhiteListExample example);
    @ECSCache(prefix = "SystemAccessWhiteList", operate = CacheOperate.REMOVE)
    int deleteByExample(SystemAccessWhiteListExample example);
    @ECSCache(prefix = "SystemAccessWhiteList", operate = CacheOperate.REMOVE)
    int deleteByPrimaryKey(Long id);
    @ECSCache(prefix = "SystemAccessWhiteList", operate = CacheOperate.REMOVE)
    int insert(SystemAccessWhiteList record);
    @ECSCache(prefix = "SystemAccessWhiteList", operate = CacheOperate.REMOVE)
    int insertSelective(SystemAccessWhiteList record);
    @ECSCache(prefix = "SystemAccessWhiteList")
    List<SystemAccessWhiteList> selectByExample(SystemAccessWhiteListExample example);
    @ECSCache(prefix = "SystemAccessWhiteList")
    SystemAccessWhiteList selectByPrimaryKey(Long id);
    @ECSCache(prefix = "SystemAccessWhiteList", operate = CacheOperate.REMOVE)
    int updateByExampleSelective(@Param("record") SystemAccessWhiteList record, @Param("example") SystemAccessWhiteListExample example);
    @ECSCache(prefix = "SystemAccessWhiteList", operate = CacheOperate.REMOVE)
    int updateByExample(@Param("record") SystemAccessWhiteList record, @Param("example") SystemAccessWhiteListExample example);
    @ECSCache(prefix = "SystemAccessWhiteList", operate = CacheOperate.REMOVE)
    int updateByPrimaryKeySelective(SystemAccessWhiteList record);
    @ECSCache(prefix = "SystemAccessWhiteList", operate = CacheOperate.REMOVE)
    int updateByPrimaryKey(SystemAccessWhiteList record);

}
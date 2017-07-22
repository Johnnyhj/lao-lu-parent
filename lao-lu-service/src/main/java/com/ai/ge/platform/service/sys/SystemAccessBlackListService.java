package com.ai.ge.platform.service.sys;


import com.ai.ge.platform.model.sys.SystemAccessBlackList;
import com.ai.ge.platform.model.sys.SystemAccessBlackListExample;

import java.util.List;
import java.util.Map;

public interface SystemAccessBlackListService {

    List<SystemAccessBlackList> selectByExample(SystemAccessBlackListExample example);

    int deleteByUnlockTime(Map<String, Object> params);

    int insert(SystemAccessBlackList record);
}

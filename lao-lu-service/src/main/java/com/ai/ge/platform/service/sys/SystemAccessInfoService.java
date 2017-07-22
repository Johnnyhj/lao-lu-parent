package com.ai.ge.platform.service.sys;


import com.ai.ge.platform.model.sys.SystemAccessInfo;

import java.util.List;
import java.util.Map;

public interface SystemAccessInfoService {
    List<Map<String, Object>> statisticsAccIp(Map<String, Object> params);

    void startup();

    int insert(SystemAccessInfo record);
}

package com.ai.ge.platform.service.sys;

import com.ai.ge.platform.model.sys.SystemDataDictionary;

import java.util.List;

/**
 * Created by Zhaocy3 on 2016/3/15.
 */
public interface SysDataService {

    String WEB_APP = "webApp";
    String MGR_APP = "mgrApp";
    String MONITOR_APP = "monitorApp";

    String QRTZ_APP = "qrtzApp";

    String PAY = "pay";

    /**
     * 接口地址
     */
    String INTERFACE_URL = "interface_url";

    /**
     * 模板文件
     */
    String TEMPLATE = "template";


    String getSmsTmp(String dataKey);

    List<SystemDataDictionary> listByType(String dataType);

    List<SystemDataDictionary> listAll(SystemDataDictionary sysData);

    String getByKeyType(String dataKey, String dataType, String defaultValue);

    Integer getIntegerByKeyType(String dataKey, String dataType, String defaultValue);

    String getByKeyType(String dataKey, String dataType);

    SystemDataDictionary getByDdId(Long ddId);

    int saveSysData(SystemDataDictionary sysData);

    int updateSysData(SystemDataDictionary sysData);

    int deleteSysData(Long ddId);
}

package com.ai.ge.platform.service.sys;

import com.ai.ge.platform.model.sys.SystemInterfaceConfig;

import java.util.Map;

/**
 * Created by sx on 2016/3/16.
 */
public interface SystemInterfaceConfigService {
    Map<String, SystemInterfaceConfig> listObject();
}

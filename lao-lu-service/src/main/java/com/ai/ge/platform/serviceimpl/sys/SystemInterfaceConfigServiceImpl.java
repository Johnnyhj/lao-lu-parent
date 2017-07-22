package com.ai.ge.platform.serviceimpl.sys;

import com.ai.ge.platform.constant.RedisKey;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SystemInterfaceConfigService;
import com.ai.ge.platform.mapper.sys.SystemInterfaceConfigMapper;
import com.ai.ge.platform.model.sys.SystemInterfaceConfig;
import com.ai.ge.platform.model.sys.SystemInterfaceConfigExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sx on 2016/3/16.
 */

@Service
@Transactional
public class SystemInterfaceConfigServiceImpl implements SystemInterfaceConfigService
{

    @Resource
    private RedisSpringProxy redisService;

    @Resource
    private SystemInterfaceConfigMapper systemInterfaceConfigMapper;


    @Override
    public Map<String, SystemInterfaceConfig> listObject() {
        Map<String, SystemInterfaceConfig> configs = redisService.read(RedisKey.QUERY_ALL_SYSTEM_INTERFACE_CONFIG,
                Map.class, String.class, SystemInterfaceConfig.class);
        //if (null == configs) {
            configs = new HashMap<String, SystemInterfaceConfig>();
            List<SystemInterfaceConfig> listObjects = systemInterfaceConfigMapper.selectByExample(new
                    SystemInterfaceConfigExample());
            for (SystemInterfaceConfig config : listObjects) {
                configs.put(config.getInterfaceConfigCode(), config);
            }
            redisService.save(RedisKey.QUERY_ALL_SYSTEM_INTERFACE_CONFIG, configs);
            return configs;
        //}
        //
        //return configs;
    }
}

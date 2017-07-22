package com.ai.ge.platform.serviceimpl.sys;

import com.ai.ge.platform.mapper.sys.SystemAreaMapper;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.sys.SystemAreaExample;
import com.ai.ge.platform.service.sys.SystemAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据字典
 */
@Service
public class SystemAreaServiceImpl implements SystemAreaService
{

    @Resource
    private SystemAreaMapper systemAreaMapper;

    @Override
    public List<SystemArea> listSystemArea(Short areaLevel, Long parAreaId) {

        List<SystemArea> rv = new ArrayList<SystemArea>();
        SystemAreaExample systemAreaExample = new SystemAreaExample();
        if (null != areaLevel && null == parAreaId)
        {
            systemAreaExample.createCriteria().andAreaLevelEqualTo(areaLevel).andAreaStatusNotEqualTo((new Integer(1).shortValue()));
        }

        if (null != parAreaId && null == areaLevel)
        {
            systemAreaExample.createCriteria().andParAreaIdEqualTo(parAreaId).andAreaStatusNotEqualTo((new Integer(1).shortValue()));
        }

        if (null != parAreaId && null != areaLevel)
        {
            systemAreaExample.createCriteria().andParAreaIdEqualTo(parAreaId).andAreaLevelEqualTo(areaLevel).andAreaStatusNotEqualTo((new Integer(1).shortValue()));
        }

        if (null == parAreaId && null == areaLevel)
        {
            systemAreaExample.createCriteria().andAreaStatusNotEqualTo((new Integer(1).shortValue()));
        }

        systemAreaExample.setOrderByClause("AREA_ID asc");
        rv = systemAreaMapper.selectByExample(systemAreaExample);

        return rv;
    }

    public SystemArea listSystemAreaById(Long areaId){
        return systemAreaMapper.selectByPrimaryKey(areaId);
    }

    /**
     * 根据id查询父区域
     *
     * @param userType
     * @param areaId
     * @return
     */
    @Override
    public List<SystemArea> listChildrenAndParentArea(Short userType, Long areaId)
    {
        return systemAreaMapper.listChildrenAndParentArea(userType, areaId);
    }

    /**
     * 根据区域名查询区域id
     * @param areaName
     * @return
     */
    @Override
    public List<Map<String, Long>> listAreaIdName(List<String> areaName)
    {
        return systemAreaMapper.listAreaIdName(areaName);
    }
}

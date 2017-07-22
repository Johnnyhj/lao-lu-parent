package com.ai.ge.platform.service.sys;

import com.ai.ge.platform.model.sys.SystemArea;

import java.util.List;
import java.util.Map;

/**
 * Created by wangying6 on 2016/3/15.
 */
public interface SystemAreaService {

    List<SystemArea> listSystemArea(Short areaLevel,Long parAreaId);

    SystemArea listSystemAreaById(Long areaId);

    /**
     * 根据id查询父区域
     * @param userType
     * @param areaId
     * @return
     */
    List<SystemArea> listChildrenAndParentArea(Short userType, Long areaId);

    /**
     * 根据区域名查询区域id
     * @param areaName
     * @return
     */
    List<Map<String, Long>> listAreaIdName(List<String> areaName);
}

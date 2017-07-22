package com.ai.ge.platform.mapper.schedule;

import java.util.List;
import java.util.Map;

public interface SchedulerManageMapper {

	/**
	 * 列出Quartz实例中所有的触发器
	 * @param param 查询参数
	 * @return List<Map<String, Object>>
	 */
    List<Map<String, Object>> queryQuartzTriggersList(Map<String, Object> param);

	/**
	 * 查询JobDeatil明细列表
	 * @param param 查询参数
	 * @return List<Map<String, Object>>
	 */
    List<Map<String, Object>> queryJobDetailList(Map<String, Object> param);

	/**
	 * queryJobClassList
	 * @param param 查询参数
	 * @return List<Map<String, Object>>
	 */
    List<Map<String, Object>> queryJobClassList(Map<String, Object> param);
    
    
}
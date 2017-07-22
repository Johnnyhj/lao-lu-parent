package com.ai.ge.platform.service.order;
import com.ai.ge.platform.dto.order.IntegrationRuleDto;
import com.ai.ge.platform.model.order.IntegrationRule;
import java.util.List;

/**
 * 
 * integrationRuleservice接口
 * 
 * <pre>
 * 	2017-06-20 guochunhao
 * </pre>
 * 
 * @author  guochunhao
 *
 */
public interface IntegrationRuleService{

 	/**
	 * 
	 * <pre>
	 * 	2017-06-20 guochunhao
	 * 	查询列表
	 * </pre>
	 * 
	 * @param integrationRule
	 * @return
	 */
    List<IntegrationRuleDto> findByCond(IntegrationRule integrationRule);

    /**
	 * 
	 * <pre>
	 * 	2017-06-20 guochunhao
	 * 	新增
	 * </pre>
	 * 
	 * @param integrationRule
	 */
	int addIntegrationRule(IntegrationRule integrationRule);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-20 guochunhao
	 * 	修改
	 * </pre>
	 * 
	 * @param integrationRule
	 */
	int updateIntegrationRule(IntegrationRule integrationRule);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-20 guochunhao
	 * 	删除
	 * </pre>
	 * 
	 * @param integrationRuleId
	 */
	int deleteIntegrationRule(Long integrationRuleId);
}

package com.ai.ge.platform.serviceimpl.order;

import com.ai.ge.platform.dto.order.IntegrationRuleDto;
import com.ai.ge.platform.exception.ParamException;
import com.ai.ge.platform.mapper.order.IntegrationRuleMapper;
import com.ai.ge.platform.model.order.Freight;
import com.ai.ge.platform.model.order.IntegrationRule;
import com.ai.ge.platform.service.order.IntegrationRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * integrationRuleservice实现类
 * 
 * <pre>
 * 	2017-06-20
 * </pre>
 * 
 * @author  guochunhao
 *
 */
@Service
public class IntegrationRuleServiceImpl implements IntegrationRuleService {

	@Resource
	private IntegrationRuleMapper integrationRuleMapper;

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
	@Override
	public List<IntegrationRuleDto> findByCond(IntegrationRule integrationRule) {

         return integrationRuleMapper.listBySelective(integrationRule);
	}

    /**
     *
     * <pre>
     * 	2017-06-20 guochunhao
     * 	新增
     * </pre>
     *
     * @param integrationRule
     */
	@Override
	public int addIntegrationRule(IntegrationRule integrationRule) {

        validateParam(integrationRule);

        return integrationRuleMapper.insertSelective(integrationRule);

	}

    /**
     *
     * <pre>
     * 	2017-06-20 guochunhao
     * 	修改
     * </pre>
     *
     * @param integrationRule
     */
	@Override
	public int updateIntegrationRule(IntegrationRule integrationRule) {

        validateParam(integrationRule);

        return integrationRuleMapper.updateByPrimaryKeySelective(integrationRule);

    }

    /**
     *
     * <pre>
     * 	2017-06-20 guochunhao
     * 	删除
     * </pre>
     *
     * @param integrationRuleId
     */
	@Override
	public int deleteIntegrationRule(Long integrationRuleId) {

		return integrationRuleMapper.deleteByPrimaryKey(integrationRuleId);
	}

    /**
     * 校验参数
     * @param record
     */
	private void validateParam(IntegrationRule record)
	{
		// 参数校验
        if (null == record.getStatus())
        {
            throw new ParamException("缺少参数状态");
        }

        if (null == record.getIsDefault())
        {
            throw new ParamException("缺少参数默认值");
        }

        if (null == record.getOfferSpecId())
        {
            throw new ParamException("缺少参数套餐");
        }

        if (null == record.getProvinceAearId())
        {
            throw new ParamException("缺少参数省份ID");
        }

        // 履约规则
        if (1 == record.getRuleType() && null == record.getPerformanceTimes())
        {
            throw new ParamException("当类型是履约时，必须设置共履约次数");
        }

        // 积分规则
        if (0 == record.getRuleType() && null == record.getIntegration())
        {
            throw new ParamException("当类型是积分时，必须设置积分");
        }

	}
 	
}
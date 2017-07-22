package com.ai.ge.platform.serviceimpl.order;

import com.ai.ge.platform.dto.delivery.DeliveryInfoDto;
import com.ai.ge.platform.dto.order.FreightDto;
import com.ai.ge.platform.exception.ParamException;
import com.ai.ge.platform.mapper.order.FreightMapper;
import com.ai.ge.platform.model.order.Freight;
import com.ai.ge.platform.service.order.FreightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * freightservice实现类
 * 
 * <pre>
 * 	2017-06-20
 * </pre>
 * 
 * @author  guochunhao
 *
 */
@Service
public class FreightServiceImpl implements FreightService {

	@Resource
	private FreightMapper freightMapper;

    /**
     *
     * <pre>
     * 	2017-06-20 guochunhao
     * 	查询列表
     * </pre>
     *
     * @param freight
     * @return
     */
	@Override
	public List<FreightDto> findByCond(Freight freight) {

        // mapper 里添加方法 listBySelective
         return freightMapper.listBySelective(freight);
	}

    /**
     *
     * <pre>
     * 	2017-06-20 guochunhao
     * 	新增
     * </pre>
     *
     * @param freight
     */
	@Override
	public int addFreight(Freight freight) {

        validateParam(freight);

        return freightMapper.insertSelective(freight);

	}

    /**
     *
     * <pre>
     * 	2017-06-20 guochunhao
     * 	修改
     * </pre>
     *
     * @param freight
     */
	@Override
	public int updateFreight(Freight freight) {

        validateParam(freight);

        return freightMapper.updateByPrimaryKeySelective(freight);

    }

    /**
     *
     * <pre>
     * 	2017-06-20 guochunhao
     * 	删除
     * </pre>
     *
     * @param freightId
     */
	@Override
	public int deleteFreight(Long freightId) {

		return freightMapper.deleteByPrimaryKey(freightId);
	}

	private void validateParam(Freight record)
	{
		// 参数校验
		if (null == record.getMoney())
		{
			throw new ParamException("缺少参数运费");
		}

		if (null == record.getStatus())
		{
			throw new ParamException("缺少参数状态");
		}

		if (null == record.getIsDefault())
		{
			throw new ParamException("缺少参数默认值");
		}

	}
 	
}
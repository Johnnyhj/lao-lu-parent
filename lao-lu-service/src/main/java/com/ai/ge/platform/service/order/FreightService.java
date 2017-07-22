package com.ai.ge.platform.service.order;
import com.ai.ge.platform.dto.order.FreightDto;
import com.ai.ge.platform.model.order.Freight;
import java.util.List;

/**
 * 
 * freightservice接口
 * 
 * <pre>
 * 	2017-06-20 guochunhao
 * </pre>
 * 
 * @author  guochunhao
 *
 */
public interface FreightService{

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
    List<FreightDto> findByCond(Freight freight);

    /**
	 * 
	 * <pre>
	 * 	2017-06-20 guochunhao
	 * 	新增
	 * </pre>
	 * 
	 * @param freight
	 */
	int addFreight(Freight freight);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-20 guochunhao
	 * 	修改
	 * </pre>
	 * 
	 * @param freight
	 */
	int updateFreight(Freight freight);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-20 guochunhao
	 * 	删除
	 * </pre>
	 * 
	 * @param freightId
	 */
	int deleteFreight(Long freightId);
}

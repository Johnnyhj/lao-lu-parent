package com.ai.ge.platform.service.offerspec;

import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.model.order.OfferSpec;

import java.util.List;

/**
 * Created by guochunhao on 17/5/19.
 */
public interface OfferSpecService
{
    /**
     * 查询套餐列表
     * @param record
     * @return
     */
    List<OfferSpecDto> findListByCond(OfferSpec record);

    /**
     * 查询套餐详情信息
     *
     * @param offerSpecId
     * @return
     */
    OfferSpecDto findOfferSepcDto(Long offerSpecId);

    /**
     * 修改套餐信息
     *
     * @param record
     * @return
     */
    int updateOfferSepc(OfferSpecDto record);

    /**
     * 新增套餐信息
     *
     * @param record
     * @return
     */
    int insertOfferSepc(OfferSpecDto record);

    /**
     * 按地区查询套餐列表
     * @param record
     * @return
     */
    List<OfferSpecDto> findListByArea(Long provinceAreaId,Long cityAreaId);
}

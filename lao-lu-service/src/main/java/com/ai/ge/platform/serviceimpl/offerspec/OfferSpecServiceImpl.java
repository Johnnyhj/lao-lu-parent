package com.ai.ge.platform.serviceimpl.offerspec;

import com.ai.ge.platform.dto.delivery.DeliveryInfoDto;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.exception.ParamException;
import com.ai.ge.platform.mapper.order.OfferSpecInfoMapper;
import com.ai.ge.platform.mapper.order.OfferSpecMapper;
import com.ai.ge.platform.mapper.sys.SystemAreaMapper;
import com.ai.ge.platform.model.order.OfferSpec;
import com.ai.ge.platform.model.order.OfferSpecInfo;
import com.ai.ge.platform.model.order.OfferSpecInfoExample;
import com.ai.ge.platform.service.offerspec.OfferSpecService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guochunhao on 17/5/24.
 */
@Service
public class OfferSpecServiceImpl implements OfferSpecService
{
    @Resource
    private OfferSpecMapper offerSpecMapper;

    @Resource
    private OfferSpecInfoMapper offerSpecInfoMapper;

    @Resource
    private SystemAreaMapper systemAreaMapper;

    /**
     * 查询套餐列表
     *
     * @param record
     * @return
     */
    @Override
    public List<OfferSpecDto> findListByCond(OfferSpec record)
    {
        return offerSpecMapper.listBySelective(record);
    }

    /**
     * 查询套餐详情信息
     *
     * @param offerSpecId
     * @return
     */
    @Override
    public OfferSpecDto findOfferSepcDto(Long offerSpecId)
    {
        OfferSpec record = new OfferSpec();
        record.setOfferSpecId(offerSpecId);

        List<OfferSpecDto> list = findListByCond(record);

        if (CollectionUtils.isNotEmpty(list))
        {
            OfferSpecDto dto = list.get(0);

            // 查询区域
            dto.setSystemArea(systemAreaMapper.selectParentSystemArea(dto.getProvinceAearId()));

            return dto;
        }

        return new OfferSpecDto();
    }

    /**
     * 修改套餐信息
     *
     * @param record
     * @return
     */
    @Override
    @Transactional
    public int updateOfferSepc(OfferSpecDto record)
    {
        validateParam(record);

        offerSpecMapper.updateByPrimaryKeySelective(record);

        record.getOfferSpecInfo().setProvinceAearId(record.getProvinceAearId());
        record.getOfferSpecInfo().setCityAearId(record.getCityAearId());

        offerSpecInfoMapper.updateByPrimaryKeySelective(record.getOfferSpecInfo());

        return 1;
    }

    /**
     * 新增套餐信息
     *
     * @param record
     * @return
     */
    @Override
    @Transactional
    public int insertOfferSepc(OfferSpecDto record)
    {
        validateParam(record);

        offerSpecMapper.insertSelective(record);

        record.getOfferSpecInfo().setProvinceAearId(record.getProvinceAearId());
        record.getOfferSpecInfo().setCityAearId(record.getCityAearId());

        offerSpecInfoMapper.insertSelective(record.getOfferSpecInfo());

        return 1;
    }

    public List<OfferSpecDto> findListByArea(Long provinceAreaId,Long cityAreaId){

        List<OfferSpecDto> rv = new ArrayList<OfferSpecDto>();

        OfferSpec record = new OfferSpec();
        record.setProvinceAearId(provinceAreaId);
        record.setCityAearId(cityAreaId);
        rv = offerSpecMapper.findListByArea(record);

        for(OfferSpecDto dto : rv){
            OfferSpecInfoExample example = new OfferSpecInfoExample();
            example.createCriteria().andOfferSpecIdEqualTo(dto.getOfferSpecId());
            List<OfferSpecInfo> list = offerSpecInfoMapper.selectByExample(example);
            if(list.size()>0)
                dto.setOfferSpecInfo(list.get(0));
        }

        return rv;
    }

    /**
     * 参数校验
     *
     * @param record
     */
    private void validateParam(OfferSpecDto record)
    {
        if (null == record.getOfferSpecId())
        {
            throw new ParamException("缺少参数销售品规格ID");
        }

        if (null == record.getName())
        {
            throw new ParamException("缺少参数物名称");
        }

        if (null == record.getManageCode())
        {
            throw new ParamException("缺少参数管理编码");
        }

        if (null == record.getAgreementTypeCd())
        {
            throw new ParamException("缺少参数协议种类CD");
        }

        if (null == record.getOfferTypeCd())
        {
            throw new ParamException("缺少参数销售品类型CD");
        }

        if (null == record.getProvinceAearId())
        {
            throw new ParamException("缺少参数物所属地区");
        }
        else
        {
            record.setAreaId(Integer.parseInt(record.getProvinceAearId().toString()));
        }


        if (null == record.getOfferSpecInfo().getOfferSpecId())
        {
            throw new ParamException("OfferSpecInfo缺少参数销售品规格ID");
        }

        if (null == record.getOfferSpecInfo().getCompOffer())
        {
            throw new ParamException("缺少参数是否多产品销售品");
        }

        if (null == record.getOfferSpecInfo().getBusiTypeCd())
        {
            throw new ParamException("缺少参数业务分类编码");
        }

        if (null == record.getOfferSpecInfo().getFeeType())
        {
            throw new ParamException("缺少参数预后标识");
        }

        if (null == record.getOfferSpecInfo().getLifecycleRuleCd())
        {
            throw new ParamException("缺少参数生失效规则CD");
        }

        if (null == record.getOfferSpecInfo().getTimeUnitCd())
        {
            throw new ParamException("缺少参数时长单位编码");
        }

        if (null == record.getOfferSpecInfo().getCostDesc())
        {
            throw new ParamException("缺少参数套餐月费描述");
        }

        if (null == record.getOfferSpecInfo().getFlowDesc())
        {
            throw new ParamException("缺少参数流量描述");
        }

        if (null == record.getOfferSpecInfo().getCallDesc())
        {
            throw new ParamException("缺少参数语音通话描述");
        }

        if (null == record.getOfferSpecInfo().getSaleDesc())
        {
            throw new ParamException("缺少参数套餐赠送描述");
        }
    }
}

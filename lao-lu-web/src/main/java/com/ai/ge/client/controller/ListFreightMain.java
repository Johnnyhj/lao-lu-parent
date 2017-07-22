package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.mapper.order.FreightMapper;
import com.ai.ge.platform.model.order.Freight;
import com.ai.ge.platform.model.order.FreightExample;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.service.offerspec.OfferSpecService;
import com.ai.ge.platform.service.order.OrderService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "listfreight")
public class ListFreightMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListFreightMain.class);

    @Resource
    protected OrderService orderService;

    @Resource
    protected  FreightMapper freightMapper;

    @Resource
    protected OfferSpecService offerSpecService;

    @Resource
    private RedisSpringProxy redisService;
    /**
     * 查询运费
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            //收货城市
            Long custCityAearId = null;
            //发货省份
            Long offspecProvinceAearId = null;

            String orderId = message.getParameter("order_id");
            Orders order = new Orders();
            if(null!=orderId&&!"".equalsIgnoreCase(orderId)){//根据订单号直接差订单
                Orders record = new Orders();
                record.setOrderId(Long.parseLong(orderId));
                List<Orders> list = orderService.findListByCond(record);
                //生成前段页面所需省市字段
                for(Orders o:list) {
                    custCityAearId = o.getCityAearId();
                    order = o;
                    break;
                }
            }

            String key = "AI-WEB_OFFERSPECDTO_BYID_"+order.getOfferSpecId();
            OfferSpecDto offerSepcDto = redisService.read(key, OfferSpecDto.class);
            if(null == offerSepcDto){
                offerSepcDto = offerSpecService.findOfferSepcDto(order.getOfferSpecId());
                redisService.save(key,offerSepcDto);
            }
            offspecProvinceAearId = offerSepcDto.getOfferSpecInfo().getProvinceAearId();

            logger.debug("发货省:"+offspecProvinceAearId+" 收货市:"+custCityAearId);

            key = "AI-WEB_FREIGHT_BYAREA_BYAREA_"+offspecProvinceAearId+"_"+custCityAearId;
            Freight freight = redisService.read(key,Freight.class);
            if(null==freight){
                FreightExample example = new FreightExample();
                example.createCriteria().andOriginalProvinceAearIdEqualTo(offspecProvinceAearId).andDestinationCityAearIdEqualTo(custCityAearId).andStatusEqualTo(Short.parseShort("1"));
                List<Freight> freightList = freightMapper.selectByExample(example);
                if(null!=freightList&&freightList.size()>0){
                    freight = freightList.get(0);
                    message.setBody(freight.getMoney());
                    redisService.save(key, freight);
                }else{//使用默认的
                    key = "AI-WEB_FREIGHT_BYAREA_BYDEFAULT";
                    freight = redisService.read(key,Freight.class);
                    if(null==freight){
                        example = new FreightExample();
                        example.createCriteria().andIsDefaultEqualTo(Short.parseShort("1"));
                        freightList = freightMapper.selectByExample(example);
                        if(null!=freightList&&freightList.size()>0){
                            freight = freightList.get(0);
                            logger.debug("使用默认邮费:"+freight.getMoney());
                            message.setBody(freight.getMoney());
                            redisService.save(key, freight);
                        }else{//邮费获取失败
                            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                            return message;
                        }
                    }else
                        message.setBody(freight.getMoney());
                }
            }else
                message.setBody(freight.getMoney());

            message.setCode(AbilityConstant.R_SUCCESS);
        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }
}

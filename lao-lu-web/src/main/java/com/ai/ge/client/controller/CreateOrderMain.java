package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.cache.PlatFormUserCache;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.mapper.order.FreightMapper;
import com.ai.ge.platform.mapper.product.NumberInfoMapper;
import com.ai.ge.platform.model.order.Freight;
import com.ai.ge.platform.model.order.FreightExample;
import com.ai.ge.platform.model.order.OfferSpecInfo;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.model.product.NumberInfo;
import com.ai.ge.platform.model.product.NumberInfoExample;
import com.ai.ge.platform.service.offerspec.OfferSpecService;
import com.ai.ge.platform.service.order.OrderService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.user.UserService;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpResponseObject;
import com.ai.ge.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "createorder")
public class CreateOrderMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(CreateOrderMain.class);

    @Resource
    protected OrderService orderService;

    @Resource
    protected OfferSpecService offerSpecService;

    @Resource
    private UserService userService;

    @Resource
    private NumberInfoMapper numberInfoMapper;

    @Resource
    protected FreightMapper freightMapper;

    @Resource
    private RedisSpringProxy redisService;
    /**
     * 生成订单
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            PlatFormUserCache cache = (PlatFormUserCache) SessionUtil.getAttribute(message.getRequest().getSession(true), "user");

//            cache = new PlatFormUserCache();
//            cache.setId(1234567L);
//            cache.setAlipayUserId("2088102168705518");
//            cache.setRealName("真实用户名Test");
//            cache.setUserId("20881048382687909220349571918351");

            Orders orders = message.getParam(Orders.class);
            if(null!=cache&&null!=cache.getPlatformUser())
                orders.setCertNo(cache.getPlatformUser().getCertNo());
            orders.setCertTypeValue("0");
            if(null!=cache&&null!=cache.getAlipayUserId())
                orders.setCustId(cache.getAlipayUserId().toString());

            //芝麻信用是否符合要求
            ZhimaOrderConfirmHttpResponseObject zhimaOrderConfirmHttpResponseObject= (ZhimaOrderConfirmHttpResponseObject) SessionUtil.getAttribute(message.getRequest().getSession(true), "zmxy");
            if(!userService.checkUserZMXY(zhimaOrderConfirmHttpResponseObject,orders.getOfferSpecId())){//信用不符合要求
                logger.error("用户芝麻信用分不足");
                message.setBody("用户芝麻信用分不足");
                message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                return message;
            }

            String key = "AI-WEB_OFFERSPECDTO_BYID_"+orders.getOfferSpecId();
            List<OfferSpecDto> list = new ArrayList<OfferSpecDto>();
            OfferSpecDto dto = redisService.read(key, OfferSpecDto.class);
            if(null == dto){
                dto = offerSpecService.findOfferSepcDto(orders.getOfferSpecId());
                if(null!=dto) {
                    redisService.save(key, dto);
                    list.add(dto);
                }
            }else
                list.add(dto);

            if(list.size()<1){//套餐不存在
                logger.error("用户订购套餐不存在.用户选择套餐:"+orders.getOfferSpecId());
                message.setBody("用户订购套餐不存在.用户选择套餐:" + orders.getOfferSpecId());
                message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                return message;
            }
            OfferSpecDto oSdto = list.get(0);
            OfferSpecInfo offerSpecInfo = oSdto.getOfferSpecInfo();

            //套餐地区和电话号码地区是否一致
            NumberInfoExample example = new NumberInfoExample();
            example.createCriteria().andNumberEqualTo(orders.getTelPhone());

            NumberInfo numberInfo = null;

            //从会话中获取号码信息
            List<NumberInfo> numberInfoList = (List<NumberInfo>) message.getRequest().getSession().getAttribute("PHONE_NUM_LIST_BY_REDIS");
            if(null != numberInfoList){
                for(NumberInfo number : numberInfoList){
                    if(number.getNumber().equals(orders.getTelPhone())){
                        numberInfo = number;
                    }
                }
            }
            //会话中获取不到，则从数据库查询
            if(null == numberInfo){
                List<NumberInfo> numberlist = numberInfoMapper.selectByExample(example);
                if(numberlist.size()<1){//电话号码不存在
                    logger.error("用户订购电话号码不存在.用户选择电话号码:"+orders.getTelPhone());
                    message.setBody("用户订购电话号码不存在.用户选择电话号码:"+orders.getTelPhone());
                    message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                    return message;
                }
                numberInfo = numberlist.get(0);
            }

            //以套餐配置的省市为标准
            if(null!=offerSpecInfo.getProvinceAearId()&&null!=offerSpecInfo.getCityAearId()){//套餐省市都有
                if(!(null!=numberInfo.getProvinceAearId()&&null!=numberInfo.getCityAearId()&&
                        offerSpecInfo.getProvinceAearId()==numberInfo.getProvinceAearId()&&
                        offerSpecInfo.getCityAearId()==numberInfo.getCityAearId())){
                    logger.error("用户选择电话号码和套餐地区不符.电话号码地区:"+numberInfo.getProvinceAearId()+"-"+numberInfo.getCityAearId()+"   套餐地区:"+offerSpecInfo.getProvinceAearId()+"-"+offerSpecInfo.getCityAearId());
                    message.setBody("用户选择电话号码和套餐地区不符.电话号码地区:"+numberInfo.getProvinceAearId()+"-"+numberInfo.getCityAearId()+"   套餐地区:"+offerSpecInfo.getProvinceAearId()+"-"+offerSpecInfo.getCityAearId());
                    message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                    return message;
                }
            }else if(null!=offerSpecInfo.getProvinceAearId()&&null==offerSpecInfo.getCityAearId()){//套餐只有省
                if(!(null!=numberInfo.getProvinceAearId()&&
                        offerSpecInfo.getProvinceAearId()==numberInfo.getProvinceAearId())){
                    logger.error("用户选择电话号码和套餐地区不符.电话号码地区:"+numberInfo.getProvinceAearId()+"-"+numberInfo.getCityAearId()+"   套餐地区:"+offerSpecInfo.getProvinceAearId()+"-"+offerSpecInfo.getCityAearId());
                    message.setBody("用户选择电话号码和套餐地区不符.电话号码地区:"+numberInfo.getProvinceAearId()+"-"+numberInfo.getCityAearId()+"   套餐地区:"+offerSpecInfo.getProvinceAearId()+"-"+offerSpecInfo.getCityAearId());
                    message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                    return message;
                }
            }else if(null==offerSpecInfo.getProvinceAearId()&&null!=offerSpecInfo.getCityAearId()){//套餐只有市
                if(!(null!=numberInfo.getCityAearId()&&
                        offerSpecInfo.getCityAearId()==numberInfo.getCityAearId())){
                    logger.error("用户选择电话号码和套餐地区不符.电话号码地区:"+numberInfo.getProvinceAearId()+"-"+numberInfo.getCityAearId()+"   套餐地区:"+offerSpecInfo.getProvinceAearId()+"-"+offerSpecInfo.getCityAearId());
                    message.setBody("用户选择电话号码和套餐地区不符.电话号码地区:"+numberInfo.getProvinceAearId()+"-"+numberInfo.getCityAearId()+"   套餐地区:"+offerSpecInfo.getProvinceAearId()+"-"+offerSpecInfo.getCityAearId());
                    message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                    return message;
                }
            }

            Float money =  Float.parseFloat(String.valueOf(oSdto.getOfferSpecInfo().getRpmonth()))/100;
            orders.setOrdersMoney(money);
            //获取运费金额
            //收货城市
            Long custCityAearId = orders.getCityAearId();
            //发货省份
            Long offspecProvinceAearId = offerSpecInfo.getProvinceAearId();
            logger.debug("发货省:"+offspecProvinceAearId+" 收货市:"+custCityAearId);
            //运费对象
            key = "AI-WEB_FREIGHT_BYAREA_BYAREA_"+offspecProvinceAearId+"_"+custCityAearId;
            Freight freight = null;
            List<Freight> freightList = new ArrayList<Freight>();
            freight = redisService.read(key, Freight.class);
            if(null==freight){
                FreightExample freightExample = new FreightExample();
                freightExample.createCriteria().andOriginalProvinceAearIdEqualTo(offspecProvinceAearId).andDestinationCityAearIdEqualTo(custCityAearId).andStatusEqualTo(Short.parseShort("1"));
                freightList = freightMapper.selectByExample(freightExample);
                if(null!=freightList&&freightList.size()>0){
                    freight = freightList.get(0);
                    redisService.save(key,freight);
                }else {//使用默认的
                    key = "AI-WEB_FREIGHT_BYAREA_BYDEFAULT";
                    freight = redisService.read(key, Freight.class);
                    if(null==freight){
                        freightExample = new FreightExample();
                        freightExample.createCriteria().andIsDefaultEqualTo(Short.parseShort("1"));
                        freightList = freightMapper.selectByExample(freightExample);
                        if(null!=freightList&&freightList.size()>0){
                            freight = freightList.get(0);
                            redisService.save(key,freight);
                        }else{//邮费获取失败
                        }
                    }
                }
            }
            if(freight == null){
                logger.error("运费获取失败");
                message.setCode(AbilityConstant.R_ERROR_SYSTEM);
            }

            orders.setExpressMoney(freight.getMoney());
            orders.setTotalMoney(orders.getOrdersMoney()+orders.getExpressMoney());
            orders.setPayMoney(orders.getOrdersMoney()+orders.getExpressMoney());

            orderService.addOrders(orders);
            message.setBody(orders.getOrderId());
            message.setCode(AbilityConstant.R_SUCCESS);

        } catch (Exception e)
        {
            //e.printStackTrace();
            logger.error(e.getMessage(),e);
            message.setMsg(e.getMessage());
            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }
}

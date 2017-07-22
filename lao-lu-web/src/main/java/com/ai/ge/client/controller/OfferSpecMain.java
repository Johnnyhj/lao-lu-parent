package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.model.order.OfferSpec;
import com.ai.ge.platform.service.offerspec.OfferSpecService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "offerspec")
public class OfferSpecMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(OfferSpecMain.class);

    @Resource
    protected OfferSpecService offerSpecService;

    @Resource
    private RedisSpringProxy redisService;

    /**
     * 查询现有套餐
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            //解析参数
            Long provinceAreaId = null;
            Long cityAreaId = null;
            Long offerSpecId = null;
            String strRequestJson = readParamFromRequest(message.getRequest());



            if(strRequestJson.indexOf("{")>=0)
            {
                JSONObject jSONObj= JSONObject.fromObject(strRequestJson);
                String alipayUserId = (String)jSONObj.get("alipay_user_id");

                Object o = null;
                o = jSONObj.get("province_area_id");
                if(null!=o)
                    provinceAreaId = jSONObj.getLong("province_area_id");

                o = jSONObj.get("city_area_id");
                if(null!=o)
                    cityAreaId = jSONObj.getLong("city_area_id");

                o = jSONObj.get("offer_spec_id");
                if(null!=o)
                    offerSpecId = jSONObj.getLong("offer_spec_id");

                System.out.println(provinceAreaId+"=="+cityAreaId+"=="+offerSpecId);
            }else{
                // 参数格式：
                // alipay_user_id=&area_code=&area_level=&offer_spec_id=3020002676
                Map<String,Long> paramMap = new HashMap<String,Long>();
                if(null != strRequestJson){
                    for(String params:strRequestJson.split("&")){
                        String[] param = params.split("=");
                        if(param.length>=2){
                            try{
                                paramMap.put(param[0],Long.valueOf(param[1]));
                            }catch (Exception e){}
                        }
                    }
                    provinceAreaId = paramMap.get("province_area_id");
                    cityAreaId = paramMap.get("city_area_id");
                    offerSpecId = paramMap.get("offer_spec_id");


                }
            }


            logger.debug("provinceAreaId="+provinceAreaId);
            logger.debug("cityAreaId="+cityAreaId);
            logger.debug("offerSpecId="+offerSpecId);


            List<OfferSpecDto> list = new ArrayList<OfferSpecDto>();
            if(null==offerSpecId && null!=provinceAreaId ){//按地区条件检索
                String key = "AI-WEB_OFFERSPECDTO_BYAREA_"+provinceAreaId+"_"+cityAreaId;
                list = (List<OfferSpecDto>)redisService.read(key, Object.class);
                if(null == list) {
                    list = offerSpecService.findListByArea(provinceAreaId, cityAreaId);
                    redisService.save(key,list);
                }
            }else if(null != offerSpecId){
                String key = "AI-WEB_OFFERSPECDTO_BYOFFERSPECID_"+offerSpecId;
                OfferSpecDto offerSpecDto = redisService.read(key, OfferSpecDto.class);
                if(null!=offerSpecDto){
                    list.add(offerSpecDto);
                }else{
                    OfferSpec dto = new OfferSpec();
                    dto.setOfferSpecId(offerSpecId);
                    list = offerSpecService.findListByCond(dto);
                    redisService.save(key, list.get(0));
                }
            }

            message.setBody(list);
            message.setCode(AbilityConstant.R_SUCCESS);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
        }

        return message;
    }

    private String readParamFromRequest(HttpServletRequest request){
        String rv = null;

        try{
            java.io.InputStream in = request.getInputStream();
            int len = request.getContentLength();
            byte [] buffer  = new byte[len];
            in.read(buffer);
            rv  = new String(buffer,"UTF-8");

            logger.debug("【入参】\r\n" + rv);
        }catch(Exception e){
            logger.error("读取参数失败");
            rv = null;
        }

        return rv;
    }
}

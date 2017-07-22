package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.model.product.NumberInfo;
import com.ai.ge.platform.service.phonenum.PhoneNumService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "occupyphonenum")
public class OccupyPhoneNumMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(OccupyPhoneNumMain.class);

    @Resource
    protected PhoneNumService phoneNumService;

    @Resource
    private RedisSpringProxy redisService;
    /**
     * 电话号码预占
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        try {
            //解析参数
            String strRequestJson = readParamFromRequest(message.getRequest());
            JSONObject jSONObj= JSONObject.fromObject(strRequestJson);
            String alipayUserId = (String)jSONObj.get("alipay_user_id");
            String areaCode = (String)jSONObj.get("area_code");
            long numberId = ((Integer)jSONObj.get("number_id")).longValue();

            HashMap<String,Integer> rv = new HashMap<String,Integer>();

            //从Redis中删除已经预占的号码
            List<NumberInfo> numberInfoList = (List<NumberInfo>) message.getRequest().getSession().getAttribute("PHONE_NUM_LIST_BY_REDIS");
            if(null != numberInfoList){
                for(NumberInfo numberInfo : numberInfoList){
                    if(numberInfo.getId().longValue() == numberId){
                        String redisKeyNumberInfo = "AI-WEB-NUMBERINFO-LIST_" + numberInfo.getProvinceAearId() + "_" + numberInfo.getCityAearId();
                        redisService.sRem(redisKeyNumberInfo, numberInfo);
                        break;
                    }
                }
            }

            rv.put("occupy_flag",phoneNumService.occpyPhoneNumber(numberId));
            message.setBody(rv);
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

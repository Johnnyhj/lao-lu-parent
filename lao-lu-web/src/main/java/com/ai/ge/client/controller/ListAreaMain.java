package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SystemAreaService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "listarea")
public class ListAreaMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListAreaMain.class);

    @Resource
    protected SystemAreaService systemAreaService;

    @Resource
    private RedisSpringProxy redisService;

    /**
     * 查询地区
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
            Short areaLevel = null;
            Long parAreaId = null;

            Object obj = jSONObj.get("area_level");
            if(null!=obj)
                areaLevel =  ((Integer)jSONObj.getInt("area_level")).shortValue();
            obj = jSONObj.get("par_area_id");
            if(null!=obj)
                parAreaId =  jSONObj.getLong("par_area_id");

            String key = "AI-WEB_AREA_BYLEVELAREAID_"+areaLevel+"_"+parAreaId;
            List<SystemArea> list = (List<SystemArea>)redisService.read(key, Object.class);
            if(null == list){
                list =systemAreaService.listSystemArea(areaLevel,parAreaId);
                redisService.save(key,list);
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

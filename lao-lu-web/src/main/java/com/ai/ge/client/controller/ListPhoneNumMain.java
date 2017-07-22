package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.service.phonenum.PhoneNumService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "listphonenum")
public class ListPhoneNumMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(ListPhoneNumMain.class);

    @Resource
    protected PhoneNumService phoneNumService;

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
            String strRequestJson = readParamFromRequest(message.getRequest());
            JSONObject jSONObj= JSONObject.fromObject(strRequestJson);
            String alipayUserId = (String)jSONObj.get("alipay_user_id");
            int numberCount = jSONObj.getInt("number_count");
            Long provinceAreaId = null;
            Long cityAreaId = null;

            Object obj = jSONObj.get("province_area_id");
            if(null!=obj)
                provinceAreaId =  jSONObj.getLong("province_area_id");
            obj = jSONObj.get("city_area_id");
            if(null!=obj)
                cityAreaId =  jSONObj.getLong("city_area_id");

            message.setBody(phoneNumService.findListRand(numberCount, provinceAreaId, cityAreaId));
            message.setCode(AbilityConstant.R_SUCCESS);

            message.getRequest().getSession().setAttribute("PHONE_NUM_LIST_BY_REDIS",message.getBody());

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

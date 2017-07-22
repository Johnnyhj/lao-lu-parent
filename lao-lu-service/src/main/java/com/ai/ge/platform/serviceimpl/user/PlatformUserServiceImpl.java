package com.ai.ge.platform.serviceimpl.user;

import com.ai.ge.platform.cache.PlatFormUserCache;
import com.ai.ge.platform.dto.user.PlatformUserDto;
import com.ai.ge.platform.dto.user.PlatformUserGis;
import com.ai.ge.platform.exception.LoginException;
import com.ai.ge.platform.mapper.sys.SystemAreaMapper;
import com.ai.ge.platform.mapper.user.DeliverAddressMapper;
import com.ai.ge.platform.mapper.user.PlatformUserMapper;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.sys.SystemAreaExample;
import com.ai.ge.platform.model.user.DeliverAddress;
import com.ai.ge.platform.model.user.PlatformUser;
import com.ai.ge.platform.model.user.PlatformUserExample;
import com.ai.ge.platform.service.user.PlatformUserService;
import com.ai.ge.util.SessionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guochunhao on 17/5/28.
 */
@Service
public class PlatformUserServiceImpl implements PlatformUserService
{
    @Resource
    private PlatformUserMapper platformUserMapper;

    @Resource
    private DeliverAddressMapper deliverAddressMapper;

    @Resource
    private SystemAreaMapper systemAreaMapper;

    @Override
    public List<PlatformUserDto> findListByCond(PlatformUser record)
    {
        return platformUserMapper.listBySelective(record);
    }


    @Override
    public PlatformUser login(String json,HttpServletRequest request) throws LoginException {
        PlatformUser platformUser = formartRespons(json);
        PlatFormUserCache cache = new PlatFormUserCache();
        cache.setAlipayUserId(platformUser.getAlipayUserId());
        cache.setUserId(platformUser.getUserId());
        cache.setId(platformUser.getId());
        cache.setRealName(platformUser.getRealName());
        SessionUtil.setAttribute(request.getSession(true),"user",cache);
        return  platformUser;
    }

    protected PlatformUser formartRespons(String json) throws LoginException{
        PlatformUser platformUser =  new PlatformUser();
        JSONObject response = JSONObject.parseObject(json);
        if(!response.containsKey("alipay_user_userinfo_share_response")){
            throw new LoginException("支付宝用户信息为空");
        }
        JSONObject jsonObject =  response.getJSONObject("alipay_user_userinfo_share_response");
        platformUser= (PlatformUser)JSONObject.toJavaObject(jsonObject,PlatformUser.class);
        //判断是否已经存在   不存在入库  存在不操作
        platformUser = mogerUser(platformUser);
        if(jsonObject.containsKey("deliver_address_list")){
//            mogerDeliverAddress(jsonObject,platformUser.getId());
        }
        return  platformUser;
    }

    protected void mogerDeliverAddress(JSONObject jsonObject,long id){
        //remove old list
        deliverAddressMapper.deleteByPlatformuserid(id);
        JSONArray jsonArray = jsonObject.getJSONArray("deliver_address_list");
        List<DeliverAddress> list = new ArrayList<DeliverAddress>();
        for(Object o:jsonArray){
            DeliverAddress deliverAddress = JSONObject.toJavaObject((JSONObject)o, DeliverAddress.class);
            deliverAddress.setPlatformUserId(id);
            list.add(deliverAddress);
        }
        deliverAddressMapper.insertDeliverAddresses(list);

    }


    protected PlatformUser mogerUser(PlatformUser platformUser){
        PlatformUserExample example = new PlatformUserExample();
        example.createCriteria().andUserIdEqualTo(platformUser.getUserId()).andAlipayUserIdEqualTo(platformUser.getAlipayUserId());
        List<PlatformUser> list =  platformUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
             platformUserMapper.insertSelective(platformUser);
        }else{
            platformUser.setId(list.get(0).getId());
//            platformUserMapper.updateByPrimaryKey(platformUser);
        }
        return platformUser;
    }

    @Override
    public SystemArea getProvince(String json) {
        JSONObject response = JSONObject.parseObject(json);
        JSONObject jsonObject =  response.getJSONObject("alipay_open_public_gis_query_response");
        PlatformUserGis gis= (PlatformUserGis)JSONObject.toJavaObject(jsonObject,PlatformUserGis.class);
        if(gis.getMsg().equals("Success")){
            //成功
            if(null!=gis.getProvince()&& !StringUtils.isEmpty(gis.getProvince())){
                //省份不为空
                SystemArea area = systemAreaMapper.selectByareaName(gis.getProvince());
                return area;
            }else{
                SystemArea soncity = systemAreaMapper.selectByareaName(gis.getCity());
                if(soncity.getParAreaId()!=0){
                    soncity = getParentArea(soncity);
                }
                return soncity;
            }
        }else{
            //选择默认区域
            SystemAreaExample systemAreaExample = new SystemAreaExample();
            systemAreaExample.createCriteria().andAreaLevelEqualTo((short)1).andAreaStatusEqualTo((short)2);
            List<SystemArea> list = systemAreaMapper.selectByExample(systemAreaExample);
            return list.get(0);
        }
    }

    protected SystemArea getParentArea(SystemArea area){
        area = systemAreaMapper.getParentArea(area.getParAreaId());
        if(area.getParAreaId()!=0){
            getParentArea(area);
        }
        return area;
    }


    public static void main(String[] args) {
        String json = "{\n" +
                "    \"sign\":\"ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE\",\n" +
                "    \"alipay_open_public_gis_query_response\":{\n" +
                "        \"sub_msg\":\"系统繁忙\",\n" +
                "        \"code\":\"20000\",\n" +
                "        \"sub_code\":\"isp.unknow-error\",\n" +
                "        \"msg\":\"Service Currently Unavailable\"\n" +
                "    }\n" +
                "}";
        JSONObject response = JSONObject.parseObject(json);
        JSONObject jsonObject =  response.getJSONObject("alipay_open_public_gis_query_response");
        PlatformUserGis gis= (PlatformUserGis)JSONObject.toJavaObject(jsonObject,PlatformUserGis.class);
        if(gis.getMsg().equals("Success")){
            //成功
            if(null!=gis.getProvince()){
                //省份不为空

            }
        }else{

        }

    }

}

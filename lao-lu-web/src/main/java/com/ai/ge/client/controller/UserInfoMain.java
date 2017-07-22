package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.cache.PlatFormUserCache;
import com.ai.ge.platform.mapper.order.IntegrationRuleMapper;
import com.ai.ge.platform.mapper.user.PlatformUserMapper;
import com.ai.ge.platform.model.order.IntegrationRule;
import com.ai.ge.platform.model.order.IntegrationRuleExample;
import com.ai.ge.platform.model.user.PlatformUser;
import com.ai.ge.platform.model.user.PlatformUserExample;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SystemAreaService;
import com.ai.ge.platform.service.user.PlatformUserService;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpResponseObject;
import com.ai.ge.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangying on 17/5/12.
 */
@Service
@AbilityRegister(name = "userinfo")
public class UserInfoMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(UserInfoMain.class);

    @Resource
    protected SystemAreaService systemAreaService;

    @Resource
    protected PlatformUserService platformUserService;

    @Resource
    protected IntegrationRuleMapper integrationRuleMapper;

    @Resource
    private RedisSpringProxy redisService;

    @Resource
    private PlatformUserMapper platformUserMapper;

    /**
     * 查询用户信息
     * @param message
     * @return
     */
    @Override
    public Message execute(Message message)
    {
        PlatFormUserCache rv = new PlatFormUserCache();
        try {
            //当前用户所在地区
            String province_area_id = message.getParameter("province_area_id");
            Long provinceAreaId = Long.parseLong(province_area_id);

            PlatFormUserCache cache = (PlatFormUserCache) SessionUtil.getAttribute(message.getRequest().getSession(true), "user");
            cache.setProvinceId(provinceAreaId);
//            PlatFormUserCache cache = new PlatFormUserCache();
//            cache.setId(1234567L);
//            cache.setAlipayUserId("2088102168705518");
//            cache.setRealName("真实用户名Test");
//            cache.setUserId("20881048382687909220349571918351");

            rv.setProvinceId(provinceAreaId);
            rv.setUserId(cache.getUserId());
//            rv.setRealName(cache.getRealName());
            rv.setAlipayUserId(cache.getAlipayUserId());
            rv.setId(cache.getId());

            ZhimaOrderConfirmHttpResponseObject zhimaOrderConfirmHttpResponseObject= (ZhimaOrderConfirmHttpResponseObject) SessionUtil.getAttribute(message.getRequest().getSession(true), "zmxy");
            if(null!=zhimaOrderConfirmHttpResponseObject) {
                String userName = zhimaOrderConfirmHttpResponseObject.getName();
                if (null != userName && !"".equalsIgnoreCase(userName)) {
                    int o = userName.length();
                    String u = userName.substring(0, 1);
                    for (int i = 1; i < o; o--) {
                        u += "*";
                    }
                    userName = u;
                }

                String certNo = zhimaOrderConfirmHttpResponseObject.getCertNo();
                //身份证号，证件号默认0 更新到数据库
                PlatformUser record = new PlatformUser();
                record.setUpdateTime(new Date());
                record.setCertNo(certNo);
                record.setCertTypeValue("0");
                PlatformUserExample example = new PlatformUserExample();
                example.createCriteria().andAlipayUserIdEqualTo(cache.getAlipayUserId());
                platformUserMapper.updateByExampleSelective(record,example);

                if(null!=cache) {
                    record = new PlatformUser();
                    record.setCertNo(zhimaOrderConfirmHttpResponseObject.getCertNo());
                    cache.setPlatformUser(record);
                    SessionUtil.setAttribute(message.getRequest().getSession(true), "user", cache);
                }else{
                    cache = new PlatFormUserCache();
                    record = new PlatformUser();
                    record.setCertNo(zhimaOrderConfirmHttpResponseObject.getCertNo());
                    cache.setPlatformUser(record);
                    SessionUtil.setAttribute(message.getRequest().getSession(true), "user", cache);
                }

                if (null != certNo && !"".equalsIgnoreCase(certNo) && certNo.length() == 18)
                    certNo = certNo.substring(0, 1) + "****************" + certNo.substring(17);

                record = new PlatformUser();
                record.setCertNo(certNo);
                record.setRealName(userName);
                rv.setPlatformUser(record);

                //获取用户芝麻信用
                rv.setZmScore(Long.parseLong(zhimaOrderConfirmHttpResponseObject.getZmScore()));
            }

            //获取省要求的芝麻信用
            String key = "AI-WEB_INTEGRATIONRULES_BYPROVINCEID_"+provinceAreaId;
            List<IntegrationRule> integrationRules = new ArrayList<IntegrationRule>();
            IntegrationRule ir = redisService.read(key, IntegrationRule.class);
            if(null==ir){
                IntegrationRuleExample example = new IntegrationRuleExample();
                example.createCriteria().andProvinceAearIdEqualTo(provinceAreaId).andStatusEqualTo(Short.parseShort("1"));
                integrationRules = integrationRuleMapper.selectByExample(example);
                if(integrationRules.size()>0)
                    redisService.save(key,integrationRules.get(0));
            }else
                integrationRules.add(ir);

            if(null!=integrationRules&&integrationRules.size()>0){
                IntegrationRule integrationRule = integrationRules.get(0);
                rv.setProvinceZmScore(Long.parseLong(integrationRule.getIntegration()));

            }else{//获取默认的芝麻信用分
                key = "AI-WEB_INTEGRATIONRULES_BYDEFAULT";
                integrationRules = new ArrayList<IntegrationRule>();
                ir = redisService.read(key, IntegrationRule.class);
                if(null == ir){
                    IntegrationRuleExample example = new IntegrationRuleExample();
                    example.createCriteria().andIsDefaultEqualTo(Short.parseShort("1"));
                    integrationRules = integrationRuleMapper.selectByExample(example);
                    if(integrationRules.size()>0)
                        redisService.save(key, integrationRules.get(0));
                }else
                    integrationRules.add(ir);

                if(null!=integrationRules&&integrationRules.size()>0){
                    IntegrationRule integrationRule = integrationRules.get(0);
                    //默认芝麻信用
                    rv.setProvinceZmScore(Integer.parseInt(integrationRule.getIntegration()));
                }
            }

            //到数据库获取用户身份证
//            PlatformUser record = new PlatformUser();
//            record.setAlipayUserId(cache.getAlipayUserId());
//            List<PlatformUserDto> list = platformUserService.findListByCond(record);
//            if(null!=list&&list.size()>0)
//                cache.setPlatformUser(list.get(0));

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

package com.ai.ge.platform.serviceimpl.user;

import com.ai.ge.platform.cache.PlatFormUserCache;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.dto.user.SysUserDto;
import com.ai.ge.platform.dto.user.SysUserOrganizationDto;
import com.ai.ge.platform.dto.user.SysUserRoleReleationDto;
import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.mapper.order.IntegrationRuleMapper;
import com.ai.ge.platform.mapper.sys.SystemAreaMapper;
import com.ai.ge.platform.mapper.user.*;
import com.ai.ge.platform.model.order.IntegrationRule;
import com.ai.ge.platform.model.order.IntegrationRuleExample;
import com.ai.ge.platform.model.order.OfferSpecInfo;
import com.ai.ge.platform.model.user.*;
import com.ai.ge.platform.service.offerspec.OfferSpecService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.user.SysRoleService;
import com.ai.ge.platform.service.user.UserService;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpResponseObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private PasswordHelper passwordHelper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Resource
    private SysUserRoleReleationMapper sysUserRoleReleationMapper;

    @Resource
    private SysUserOrganizationMapper sysUserOrganizationMapper;

    @Resource
    private SysOrganizationMapper sysOrganizationMapper;

    @Resource
    private SystemAreaMapper systemAreaMapper;

    @Resource
    protected OfferSpecService offerSpecService;

    @Resource
    protected IntegrationRuleMapper integrationRuleMapper;

    @Resource
    private RedisSpringProxy redisService;

    @Override
    public void checkUserNameUnique(String userName) throws DataException {
        if (StringUtils.isBlank(userName)) {
            throw new DataException("用户名为空");
        }

        userName = StringUtils.trim(userName);

        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(userName);


        int i = sysUserMapper.countByExample(sysUserExample);

        if (i > 0) {
            throw new DataException("用户已存在");
        }
    }

    @Override
    public void checkPhoneUnique(String phone, Long userId) throws DataException {
        if (StringUtils.isBlank(phone)) {
            throw new DataException("手机号为空");
        }

        phone = StringUtils.trim(phone);

        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andTelPhoneEqualTo(phone);

        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

        if (CollectionUtils.isNotEmpty(sysUsers))
        {
            // 创建用户
            if (null == userId)
            {
                throw new DataException("该手机号对应用户已存在");
            }
            else
            {
                // 更新
                if (sysUsers.size() == 1)
                {
                    if (sysUsers.get(0).getId().longValue() != userId.longValue()) {
                        throw new DataException("该手机号对应用户已存在");
                    }
                }

                if (sysUsers.size() > 1) {
                    throw new DataException("该手机号对应用户已存在");
                }
            }

        }

    }

    /**
     * 创建用户
     *
     * @param user
     */
    public SysUser createUser(SysUser user) {

        //加密密码
        passwordHelper.encryptPassword(user);
        sysUserMapper.insertSelective(user);
        return user;
    }

    @Transactional
    @Override
    public void createUser(SysUserDto user) {
        passwordHelper.encryptPassword(user);
        sysUserMapper.insertSelective(user);

        // 插入用户角色关联数据
        insertUserRoleRelation(user, user.getId());
    }

    @Override
    public SysUser updateUser(SysUser user) {
        user.setUpdateTime(new Date());
        sysUserMapper.updateByPrimaryKeySelective(user);

        return user;
    }

    @Override
    public void updateUser(SysUserDto user) {
        user.setUpdateTime(new Date());
        sysUserMapper.updateByPrimaryKeySelective(user);

        // 删除用户角色关系表
        deleteUserRoleRelation(user.getId());
        deleteUserOrgaRelation(user.getId());

        // 插入用户角色关系表
        insertUserRoleRelation(user, user.getId());

    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteUser(Long userId) {
        // 删除用户角色关系表
        deleteUserRoleRelation(userId);

        deleteUserOrgaRelation(userId);
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword
     * @return 1 表示更新成功
     *          0 表示更新失败
     *          2 原密码输入错误
     */
    public void changePassword(Long userId, String newPassword) {
        SysUser user = findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);

        updateUser(user);
    }

    @Override
    public SysUser findOne(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public SysUserDto findUser(Long userId) {
        SysUserDto userDto = new SysUserDto();

        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }

    @Override
    public SysUserDto findUserWithRole(Long userId) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);

        SysUserDto sysUserDto = sysUserMapper.selectSysUserRoleOrga(params);

        // 根据查询到的user，查询该user对应的区域信息
        // 如果是省级管理员，则用 sysUserDto.provinceAearId 关联查询  如果是地市级别管理员，则用sysUserDto.provinceAearId关联查询
        Long areaId = sysUserDto.getProvinceAearId();
        if (2 == sysUserDto.getUserType())
        {
            areaId = sysUserDto.getCityAearId();
        }

        sysUserDto.setSystemArea(systemAreaMapper.selectByPrimaryKey(areaId));

        return sysUserDto;
    }

    @Override
    public List<SysUser> findAll() {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserTypeIn(Arrays.asList((short) 0, (short)1, (short)2, (short)3));

        return sysUserMapper.selectByExample(sysUserExample);
    }

    @Override
    public List<SysUserDto> searchSysUser(Map<String, Object> params) {
        return sysUserMapper.searchSysUser(params);
    }

    @Override
    public List<SysUserDto> searchSysUserArea(Map<String, Object> params) {
        return sysUserMapper.searchSysUserArea(params);
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public SysUser findByUsername(String username) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(sysUsers)) {
            return null;
        }
        return sysUsers.get(0);
    }

    /**
     * 根据用户名查找其角色
     *
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        SysUser user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        Set<String> roles = sysRoleService.findRolesByUsername(username);
        roles.addAll(sysOrganizationMapper.findRoles(username));
        return roles;
    }

    /**
     * 根据用户名查找其角色
     *
     * @param username
     * @return
     */
    public List<SysRole> findRolesObject(String username) {
        Set<String> roles = findRoles(username);
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRoleIn(new ArrayList<String>(roles));

        return sysRoleMapper.selectByExample(sysRoleExample);
    }

    /**
     * 根据用户名查找其权限
     *
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        SysUser user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        Set<String> permissions = sysRoleService.findPermissionsByUsername(username);
        permissions.addAll(sysOrganizationMapper.findPermissions(username));
        return permissions;
        //return sysRoleService.findPermissions(user.getListRoleIds().toArray(new Long[0]));
    }

    @Override
    public List<SysResource> findPermissionsObject(String username, String type) {
        Set<String> permissions = findPermissions(username);
        if (CollectionUtils.isEmpty(permissions)) {
            return null;
        }


        SysResourceExample sysResourceExample = new SysResourceExample();
        SysResourceExample.Criteria criteria = sysResourceExample.createCriteria();

        criteria.andPermissionIn(new ArrayList<String>(permissions));
        if (StringUtils.isNotBlank(type)) {
            criteria.andTypeEqualTo(type);
        }
        return sysResourceMapper.selectByExample(sysResourceExample);
    }

    /**
     * 删除用户角色关系表数据
     *
     * @param userId
     */
    private void deleteUserRoleRelation(Long userId) {
        SysUserRoleReleationExample roleReleationExample = new SysUserRoleReleationExample();
        roleReleationExample.createCriteria().andSysUserIdEqualTo(userId);
        sysUserRoleReleationMapper.deleteByExample(roleReleationExample);
    }

    /**
     * 删除用户部门关系表数据
     *
     * @param userId
     */
    private void deleteUserOrgaRelation(Long userId) {
        SysUserOrganizationExample sysUserOrganizationExample = new SysUserOrganizationExample();
        sysUserOrganizationExample.createCriteria().andUserIdEqualTo(userId);
        sysUserOrganizationMapper.deleteByExample(sysUserOrganizationExample);
    }

    /**
     * 插入用户角色关系表
     *
     * @param sysUserDto
     */
    private void insertUserRoleRelation(SysUserDto sysUserDto, Long userId) {
        List<SysUserRoleReleationDto> sysUserRoleReleations = sysUserDto.getSysUserRoleReleations();

        if (CollectionUtils.isNotEmpty(sysUserRoleReleations)) {
            for (SysUserRoleReleationDto releation : sysUserRoleReleations) {
                releation.setSysUserId(userId);
                sysUserRoleReleationMapper.insertSelective(releation);
            }
        }

        SysUserOrganizationDto primaryUserOrgaRel = sysUserDto.getPrimaryUserOrgaRel();
        if (null != primaryUserOrgaRel) {
            primaryUserOrgaRel.setUserId(userId);
            sysUserOrganizationMapper.insert(primaryUserOrgaRel);
        }
    }

    /**
     * 根据手机号修改密码
     *
     * @param password
     */
    @Override
    public void changePasswordByPhone(String phone, String password) throws DataException {
        // 根据手机号查询用户
        if (StringUtils.isBlank(phone)) {
            throw new DataException("手机号为空");
        }

        phone = StringUtils.trim(phone);

        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andTelPhoneEqualTo(phone);

        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

        if (CollectionUtils.isEmpty(sysUsers))
        {
            throw new DataException("该手机号不存在对应的账号!");
        }

        if (sysUsers.size() > 2)
        {
            throw new DataException("该手机号存在多个对应的账号!");
        }

        if (sysUsers.size() == 1)
        {
            SysUser sysUser = sysUsers.get(0);

            // 修改密码
            changePassword(sysUser.getId(), password);
        }
    }

    /**
     * 通过区域查找用户
     *
     * @param queryCond
     * @return
     * @throws Exception
     */
    @Override
    public List<SysUser> findUserByArea(Map<String, Object> queryCond) throws Exception
    {
        List<SysUser> list;

        try
        {
            list = sysUserMapper.selectUserByArea(queryCond);
        } catch (Exception e)
        {
            e.printStackTrace();

            throw new Exception("根据区域查询用户失败!");
        }

        return list;

    }


    /*================================================ 以下是web端接口 ==================================================================*/

    /**
     * 根据条件查询
     *
     * @param sysUser
     * @return
     */
    @Override
    public SysUserDto findByCond(SysUser sysUser)
    {
        List<SysUserDto> list = sysUserMapper.selectBySelective(sysUser);
        if (CollectionUtils.isEmpty(list))
        {
            return null;
        }

        return list.get(0);
    }

    public boolean checkUserZMXY(ZhimaOrderConfirmHttpResponseObject zhimaOrderConfirmHttpResponseObject,Long offerSpecId){
        int zmScore = -1;//用户当前芝麻分
        int score = -1; //销售品要求芝麻分

        try {
            String key = "AI-WEB_OFFERSPECDTO_BYID_"+offerSpecId;
            List<OfferSpecDto> list = new ArrayList<OfferSpecDto>();
            OfferSpecDto dto = redisService.read(key, OfferSpecDto.class);
            if(null == dto){
                dto = offerSpecService.findOfferSepcDto(offerSpecId);
                if(null!=dto) {
                    redisService.save(key, dto);
                    list.add(dto);
                }
            }else
                list.add(dto);

            if(list.size()<1){//套餐不存在
                logger.error("用户订购套餐不存在.用户选择套餐:"+offerSpecId);
                return false;
            }
            OfferSpecDto oSdto = list.get(0);
            OfferSpecInfo offerSpecInfo = oSdto.getOfferSpecInfo();

            //查询销售品所需信用
            key = "AI-WEB_INTEGRATIONRULES_BYPROVINCEID_"+offerSpecInfo.getProvinceAearId();
            List<IntegrationRule> integrationRules = new ArrayList<IntegrationRule>();
            IntegrationRule ir = redisService.read(key, IntegrationRule.class);
            if(null==ir){
                IntegrationRuleExample example = new IntegrationRuleExample();
                example.createCriteria().andProvinceAearIdEqualTo(offerSpecInfo.getProvinceAearId()).andStatusEqualTo(Short.parseShort("1"));
                integrationRules = integrationRuleMapper.selectByExample(example);
                if(integrationRules.size()>0)
                    redisService.save(key,integrationRules.get(0));
            }else
                integrationRules.add(ir);


            if(null!=integrationRules&&integrationRules.size()>0){
                IntegrationRule integrationRule = integrationRules.get(0);
                score = Integer.parseInt(integrationRule.getIntegration());
            }else{//获取默认的芝麻信用分
                IntegrationRuleExample example = new IntegrationRuleExample();
                example.createCriteria().andIsDefaultEqualTo(Short.parseShort("1"));
                integrationRules = integrationRuleMapper.selectByExample(example);
                if(null!=integrationRules&&integrationRules.size()>0){
                    IntegrationRule integrationRule = integrationRules.get(0);
                    //默认芝麻信用
                    score = Integer.parseInt(integrationRule.getIntegration());
                }
            }
            if (null != zhimaOrderConfirmHttpResponseObject.getZmScore())
                zmScore = Integer.parseInt(zhimaOrderConfirmHttpResponseObject.getZmScore());
        }catch(Exception e){
            e.printStackTrace();
        }

        zhimaOrderConfirmHttpResponseObject.getCertCity();

        logger.debug("用户当前芝麻信用："+zmScore+" 系统要求芝麻信用："+score);
        if(score>-1&&zmScore>=score)
            return true;
        else
            return false;
    }

    public boolean checkUserZMXY(ZhimaOrderConfirmHttpResponseObject zhimaOrderConfirmHttpResponseObject,PlatFormUserCache cache){
        int zmScore = -1;//用户当前芝麻分
        int score = -1; //销售品要求芝麻分

        try {
            //查询销售品所需信用
            IntegrationRuleExample example = new IntegrationRuleExample();
            example.createCriteria().andProvinceAearIdEqualTo(cache.getProvinceId()).andStatusEqualTo(Short.parseShort("1"));
            List<IntegrationRule> integrationRules = integrationRuleMapper.selectByExample(example);

            if(null!=integrationRules&&integrationRules.size()>0){
                IntegrationRule integrationRule = integrationRules.get(0);
                score = Integer.parseInt(integrationRule.getIntegration());
            }else{//获取默认的芝麻信用分
                example = new IntegrationRuleExample();
                example.createCriteria().andIsDefaultEqualTo(Short.parseShort("1"));
                integrationRules = integrationRuleMapper.selectByExample(example);
                if(null!=integrationRules&&integrationRules.size()>0){
                    IntegrationRule integrationRule = integrationRules.get(0);
                    //默认芝麻信用
                    score = Integer.parseInt(integrationRule.getIntegration());
                }
            }

            if (null != zhimaOrderConfirmHttpResponseObject.getZmScore())
                zmScore = Integer.parseInt(zhimaOrderConfirmHttpResponseObject.getZmScore());
        }catch(Exception e){
            e.printStackTrace();
        }

        logger.debug("用户当前芝麻信用："+zmScore+" 系统要求芝麻信用："+score);
        if(score>-1&&zmScore>=score)
            return true;
        else
            return false;
    }
}

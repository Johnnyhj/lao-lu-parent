package com.ai.ge.platform.service.user;

import com.ai.ge.platform.cache.PlatFormUserCache;
import com.ai.ge.platform.dto.user.SysUserDto;
import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpResponseObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sx on 2016/3/14.
 */
public interface UserService {
    /**
     * 校验用户名唯一
     *
     * @param userName
     */
    void checkUserNameUnique(String userName) throws DataException;

    /**
     * 校验手机号唯一
     *
     * @param phone
     */
    void checkPhoneUnique(String phone, Long userId) throws DataException;

    /**
     * 创建用户
     *
     * @param user
     */
    SysUser createUser(SysUser user);

    void createUser(SysUserDto user);

    SysUser updateUser(SysUser user);

    void updateUser(SysUserDto user);

    int updateByPrimaryKeySelective(SysUser record);

    void deleteUser(Long userId);

    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword
     */
    void changePassword(Long userId, String newPassword);


    SysUser findOne(Long userId);

    SysUserDto findUser(Long userId);

    SysUserDto findUserWithRole(Long userId);

    List<SysUser> findAll();

    /**
     * 根据检索条件查找用户
     *
     * @param params
     * @return
     */
    List<SysUserDto> searchSysUser(Map<String, Object> params);

    /**
     * 根据检索条件查找用户 (条件中包含登录用户的区域权限)
     *
     * @param params
     * @return
     */
    List<SysUserDto> searchSysUserArea(Map<String, Object> params);

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    SysUser findByUsername(String username);

    /**
     * 根据用户名查找其角色
     *
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     *
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);

    /**
     * 根据用户名查找其权限
     *
     * @param username
     * @param type     权限类别
     * @return
     */
    List<SysResource> findPermissionsObject(String username, String type);

    void changePasswordByPhone(String phone, String password) throws DataException;

    /**
     * 通过区域查找用户
     *
     * @param queryCond
     * @return
     */
    List<SysUser> findUserByArea(Map<String, Object> queryCond) throws Exception;

    /*============================================== 以下是web端接口 ==================================================*/

    /**
     * 根据条件检索用户
     *
     * @param sysUser
     * @return
     */
    SysUserDto findByCond(SysUser sysUser);

    /**
     * 判断用户所在地区芝麻信用
     * @param zhimaOrderConfirmHttpResponseObject
     * @param cache
     * @return
     */
    boolean checkUserZMXY(ZhimaOrderConfirmHttpResponseObject zhimaOrderConfirmHttpResponseObject,PlatFormUserCache cache);

    /**
     * 判断用户选择销售品芝麻信用
     * @param zhimaOrderConfirmHttpResponseObject
     * @param offerSpecId
     * @return
     */
    boolean checkUserZMXY(ZhimaOrderConfirmHttpResponseObject zhimaOrderConfirmHttpResponseObject,Long offerSpecId);
}

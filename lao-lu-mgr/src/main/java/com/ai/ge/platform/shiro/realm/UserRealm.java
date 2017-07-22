package com.ai.ge.platform.shiro.realm;

import com.ai.ge.platform.constant.RedisKey;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 自定义
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RedisSpringProxy redisService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();

        String rolesKey = RedisKey.MGR_QUERY_USER_ROLE + "roles_" + username;
        String permissionsKey = RedisKey.MGR_QUERY_USER_ROLE + "permissions_" + username;
        Set<String> roles = redisService.read(rolesKey, Set.class, String.class);
        if (null == roles) {
            roles = userService.findRoles(username);
            redisService.save(rolesKey, roles);
        }
        Set<String> permissions = redisService.read(permissionsKey, Set.class, String.class);
        if (null == permissions) {
            permissions = userService.findPermissions(username);
            redisService.save(permissionsKey, permissions);
        }



        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //Set<String>
        authorizationInfo.setRoles(roles);
        //Set<String>
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();

        SysUser user = userService.findByUsername(username);

        if(user == null) {
            throw new UnknownAccountException("当前用户不存在");//没找到帐号
        }

        if(new Short((short) 1).equals(user.getLocked())) {
            throw new LockedAccountException("账号被锁定"); //帐号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}

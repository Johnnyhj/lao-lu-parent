package com.ai.ge.platform.filter;

import com.ai.ge.platform.constant.RedisKey;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.shiro.Constants;
import com.ai.ge.platform.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 当前系统过滤器，将当前登录用户放到request中去
 */
public class SysUserFilter extends PathMatchingFilter {

    @Resource
    private UserService userService;
    @Resource
    private RedisSpringProxy redisService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws
            Exception {

        String username = (String) SecurityUtils.getSubject().getPrincipal();

        String key = RedisKey.MGR_QUERY_USER_INFO + username;

        SysUser sysUser = redisService.read(key, SysUser.class);
        if (null == sysUser) {
            sysUser = userService.findByUsername(username);
            redisService.save(key, sysUser);
        }

                //SysUser
        request.setAttribute(Constants.SYSTEM_CURRENT_USER, sysUser);
        return true;
    }
}

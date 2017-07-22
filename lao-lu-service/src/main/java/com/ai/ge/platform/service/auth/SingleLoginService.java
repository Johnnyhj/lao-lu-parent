package com.ai.ge.platform.service.auth;

import com.ai.ge.platform.model.auth.SystemAuthorization;

/**
 * Created by guochunhao on 16/12/8.
 */
public interface SingleLoginService
{
    /**
     * 获取中控的用户登录信息
     * @return
     */
    SystemAuthorization getUserInfo();
}

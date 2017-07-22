package com.ai.ge.platform.service.user;

import com.ai.ge.platform.dto.user.PlatformUserDto;
import com.ai.ge.platform.exception.LoginException;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.user.PlatformUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by guochunhao on 17/5/18.
 */
public interface PlatformUserService
{
    List<PlatformUserDto> findListByCond(PlatformUser record);

    PlatformUser login(String json,HttpServletRequest request) throws LoginException;

    SystemArea getProvince(String json);

}

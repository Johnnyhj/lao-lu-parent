package com.ai.ge.platform.controller.sys.loginmain;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.utils.AbilityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by count on 17/5/10.
 *
 * 登录接口
 */
@AbilityRegister(name = "login")
public class LoginMain implements IAbility
{
    @Override
    public Message execute(Message message)
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        String exceptionClassName = (String) message.getRequest().getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        }
        else if (LockedAccountException.class.getName().equals(exceptionClassName))
        {
            error = "该账号不存在，请联系系统管理员。";
        }
        else
        {
            if (exceptionClassName != null)
            {
                error = "其他错误：" + exceptionClassName;
            }
        }


        resultMap.put("error", error);

        if (null == SecurityUtils.getSubject().getPrincipal()) {
            if ("XMLHttpRequest".equals(message.getRequest().getHeader("X-Requested-With"))) {

                invokeIndex();

                return null;
            }

            message.setView("login");
            return message;
        }


        if (null == error)
        {
            invokeIndex();

        } else
        {
            message.setView("login");
        }

        //消息状态码
        message.setCode(AbilityConstant.R_SUCCESS);

        return message;
    }

    private void invokeIndex()
    {
        // 调用登录接口能力
        Message request = new Message();
        request.setAbilityName("index");
        AbilityUtil.invokeSync(request);
    }
}

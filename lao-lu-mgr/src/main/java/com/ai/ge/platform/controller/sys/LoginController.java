package com.ai.ge.platform.controller.sys;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model
            model) throws IOException {
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        }
        else if (LockedAccountException.class.getName().equals(exceptionClassName))
        {
            error = "该账号被锁定，请被联系系统管理员。";
        }
        else
        {
            if (exceptionClassName != null)
            {
                error = "其他错误：" + exceptionClassName;
            }
        }


        model.addAttribute("error", error);
        if (null == SecurityUtils.getSubject().getPrincipal()) {
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                response.setHeader("sessionstatus", "timeout");
                response.setHeader("redirectUrl", request.getContextPath() + "/mgr/index");

                return null;
            }

            return "login";
        }


        return null == error ? "redirect:mgr/index" : "login";
    }


}

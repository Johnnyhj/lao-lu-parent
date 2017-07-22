package com.ai.ge.test;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhacy3 on 2017/5/3.
 */
//可以不添加@Service，但需要使用Spring自动注入能力时必需添加该注解
@Service
//能力注册为helloworld的能力
//调用是使用http://localhost:8080/web/core/helloworld即可调用到该能力
@AbilityRegister(name="helloworld", desc = "hello world")
public class TestMain implements IAbility {

    //自动注入
    @Autowired
    private Test01 test01;

    @Override
    public Message execute(Message message) {

        //http请求参数组装成java bean对象
        Test01 t = message.getParam(Test01.class);

        //直接获取请求参数
        String a = message.getParameter("a");

        //http请求request
        //message.getRequest();

        //API调用其他能力
        //Message request = new Message();
        //request.setAbilityName("test");
        //AbilityUtil.invokeSync(request);

        //===========业务处理=============================
        //**********************************************
        test01.test();
        //===========业务处理=============================

        //消息状态码
        message.setCode(AbilityConstant.R_SUCCESS);
        //返回的消息体
        message.setBody("hello world");

        //非ajax请求时的跳转页面
        //redirect:http://www.baidu.com ==> 重定向到baidu
        //view/index ==> 跳转到view文件夹下index.jsp页面
        //message.setView("redirect:http://www.baidu.com");

        return message;
    }
}

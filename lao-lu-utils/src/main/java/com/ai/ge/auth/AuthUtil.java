package com.ai.ge.auth;

import java.util.Map;

/**
 * Created by Zhaocy3 on 2016/3/8.
 */
public class AuthUtil {

    public static String getSign(Map<String, String> Params, String key)
    {
        String text = Params.get("");
        SignUtil.sign(text,key,"UTF-8");
        return null;
    }
}

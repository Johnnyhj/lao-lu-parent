package com.ai.ge.ali.executor;

import com.ai.ge.ali.exception.AliException;
import com.ai.ge.constant.AlipayServiceEnvConstants;

/**
 * 开通服务窗开发者功能处理器
 *
 */
public class InAlipayVerifyExecutor implements ActionExecutor {


    @Override
    public String execute() throws AliException {
        return this.setResponse();
    }

    /**
     * 设置response返回数据
     * 
     * @return
     */
    private String setResponse() throws AliException {
        //固定响应格式，必须按此格式返回
        StringBuilder builder = new StringBuilder();
        builder.append("<success>").append(Boolean.TRUE.toString()).append("</success>");
        builder.append("<biz_content>").append(AlipayServiceEnvConstants.PUBLIC_KEY)
            .append("</biz_content>");
        return builder.toString();
    }
}

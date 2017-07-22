package com.ai.ge.platform.model.wx;

import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.result.Result;

/**
 *
 */
public class WxProcessResp extends Result {
    /**
     * 响应消息返回
     */
    private String respText;

    public String getRespText() {
        return respText;
    }

    public void setRespText(String respText) {
        this.respText = respText;
    }


    public WxProcessResp(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    public WxProcessResp(String respText) {
        super(ObjectResult.SUCCESS_CODE, null);
        this.respText = respText;
    }
}

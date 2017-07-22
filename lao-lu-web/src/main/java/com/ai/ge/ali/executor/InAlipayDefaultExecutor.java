package com.ai.ge.ali.executor;

import com.ai.ge.ali.exception.AliException;
import net.sf.json.JSONObject;

/**
 * 默认执行器(该执行器仅发送ack响应)
 *
 */
public class InAlipayDefaultExecutor implements ActionExecutor {

    /** 业务参数 */
    private JSONObject bizContent;

    public InAlipayDefaultExecutor(JSONObject bizContent) {
        this.bizContent = bizContent;
    }

    public InAlipayDefaultExecutor() {
        super();
    }


    @Override
    public String execute() throws AliException {

        //取得发起请求的支付宝账号id
        final String fromUserId = bizContent.getString("FromUserId");

        return AlipayMsgBuildUtil.buildBaseAckMsg(fromUserId);
    }
}

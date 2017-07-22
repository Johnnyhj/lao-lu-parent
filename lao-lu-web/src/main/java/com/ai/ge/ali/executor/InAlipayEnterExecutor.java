package com.ai.ge.ali.executor;

import com.ai.ge.ali.exception.AliException;
import net.sf.json.JSONObject;

/**
 * 普通进入服务窗事件处理器
 * 用户进入服务窗，可在此处理器处理开发者需要的业务逻辑
 *
 */
public class InAlipayEnterExecutor implements ActionExecutor {

    /** 业务参数 */
    private JSONObject bizContent;

    public InAlipayEnterExecutor(JSONObject bizContent) {
        this.bizContent = bizContent;
    }

    public InAlipayEnterExecutor() {
        super();
    }

    /** 
     *
     */
    @Override
    public String execute() throws AliException {
        //自身业务处理,这里只是简单打印下
        //建议开发者自行处理采用异步方式，参见InAlipayChatTextExecutor
        System.out.println("欢迎光临！");

        // 同步返回ack响应
        return this.setResponse();
    }

    /**
     * 设置response返回数据
     * 
     * @return
     */
    private String setResponse() throws AliException {

        //取得发起请求的支付宝账号id
        String fromUserId = bizContent.getString("FromUserId");

        return AlipayMsgBuildUtil.buildBaseAckMsg(fromUserId);
    }
}

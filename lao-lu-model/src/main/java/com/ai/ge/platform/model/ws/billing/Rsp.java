package com.ai.ge.platform.model.ws.billing;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 响应结果公共字段
 */
public class Rsp {
    /**
     * 处理结果代码\n
     * 在处理正确情况下为0，否则是错误代码
     */
    @XStreamAlias("IRESULT")
    private Long iresult;
    /**
     * 处理结果信息\n
     * 在处理异常情况下为错误信息，包括错误内容提示、可能的错误原因、解决操作
     */
    @XStreamAlias("SMSG")
    private String smsg;

    public Long getIresult() {
        return iresult;
    }

    public void setIresult(Long iresult) {
        this.iresult = iresult;
    }

    public String getSmsg() {
        return smsg;
    }

    public void setSmsg(String smsg) {
        this.smsg = smsg;
    }
}

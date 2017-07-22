package com.ai.ge.platform.result;

/**
 * 系统鉴权接口
 */
public class SystemAuthResult {
    /**
     * 结果码 1:success;
     * 2001：授权缺少参数ticket；2002：授权参数ticket异常;
     * 3001:缺少参数；3002：参数格式不正确；3003：解密失败；3004：电子签名校验失败
     * 3005：渠道编码不存在；3006；渠道编码重复
     * 8001:请求超时
     * 9001：未知异常
     */
    private int resultCode = 1;

    /**
     * 结果信息
     */
    private String resultMsg;
    /**
     * token
     */
    private String token;
    /**
     * 到期时间，单位秒
     */
    private Integer expires;

    public SystemAuthResult() {
    }

    public SystemAuthResult(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public SystemAuthResult(String token, Integer expires) {
        this.token = token;
        this.expires = expires;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpires() {
        return expires;
    }

    public void setExpires(Integer expires) {
        this.expires = expires;
    }
}

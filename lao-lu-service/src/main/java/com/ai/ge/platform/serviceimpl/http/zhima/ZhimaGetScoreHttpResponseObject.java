package com.ai.ge.platform.serviceimpl.http.zhima;

/**
 * 查询芝麻用户的芝麻信用评分
 */
public class ZhimaGetScoreHttpResponseObject extends ZhimaHttpResponseObject {
    /**
     * 用户的芝麻信用评分。分值范围[350,950]。如果用户数据不足，无法评分时，返回字符串"N/A"。
     */
    private String zmScore;

    public String getZmScore() {
        return zmScore;
    }

    public void setZmScore(String zmScore) {
        this.zmScore = zmScore;
    }
}

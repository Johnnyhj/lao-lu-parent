package com.ai.ge.platform.serviceimpl.http.zhima;

/**
 * 查询芝麻用户的芝麻信用评分
 */
public class ZhimaGetScoreHttpRequestObject extends ZhimaHttpRequestObject {
    /**
     * 产品码
     */
    private String productCode = "w1010100100000000001";


    /**
     * 芝麻会员在商户端的身份标识。
     */
    private String openId;


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}

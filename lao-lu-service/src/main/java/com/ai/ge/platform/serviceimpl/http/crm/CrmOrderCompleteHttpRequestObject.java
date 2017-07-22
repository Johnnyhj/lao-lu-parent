package com.ai.ge.platform.serviceimpl.http.crm;

import com.ai.ge.platform.service.http.HttpRequestObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * CRM 工单竣工
 */
public class CrmOrderCompleteHttpRequestObject extends HttpRequestObject {

    private String version = "1.0";

    @JSONField(name = "app_code")
    private String appCode;

    /**
     * 未激活号码列表
     */
    private List<String> numbers;

    private Integer timestamp;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }


}

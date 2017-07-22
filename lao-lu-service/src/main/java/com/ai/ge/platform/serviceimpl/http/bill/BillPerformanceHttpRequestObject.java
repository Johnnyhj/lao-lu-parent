package com.ai.ge.platform.serviceimpl.http.bill;

import com.ai.ge.platform.service.http.HttpRequestObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 计费用户履约
 */
public class BillPerformanceHttpRequestObject extends HttpRequestObject {

    private String version = "1.0";

    @JSONField(name = "app_code")
    private String appCode;


    private List<String> numbers;

    private String month;

    private int timestamp;


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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}

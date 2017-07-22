package com.ai.ge.platform.result;

import com.ai.ge.platform.dto.order.WebServiceContext;

import java.util.HashMap;
import java.util.Map;

/**
 * WebService接口调用返回结果集
 */
public class WebServiceResult extends ObjectResult {

    public static final String SUCCESS_CODE = "1";
    public static final String ERROR_CODE = "0";
    public static final String CONFIRM_CODE = "2";


    private WebServiceContext webServiceContext;

    private Map<String, Object> extend = new HashMap<String, Object>();

    public WebServiceContext getWebServiceContext() {
        return webServiceContext;
    }

    public void setWebServiceContext(WebServiceContext webServiceContext) {
        this.webServiceContext = webServiceContext;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public void put(String key, Object value) {
        extend.put(key, value);
    }

}

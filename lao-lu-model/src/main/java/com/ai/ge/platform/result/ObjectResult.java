package com.ai.ge.platform.result;

import com.ai.ge.platform.page.Page;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Object返回结果集
 */
public class ObjectResult extends Result implements Serializable {

    private static final long serialVersionUID = -6420927950045992538L;

    public static final String SUCCESS_CODE = "0";
    public static final String ERROR_CODE = "1";

    public ObjectResult() {
        setResultCode(SUCCESS_CODE);
    }

    public ObjectResult(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    @JSONField(serialize = false, deserialize = false)
    private Object object;

    @JSONField(serialize = false, deserialize = false)
    private Page page;


    @Override
    @JSONField(name = "result_code")
    public String getResultCode() {
        return super.getResultCode();
    }

    @Override
    @JSONField(name = "result_msg")
    public String getResultMsg() {
        return super.getResultMsg();
    }

    @Override
    @JSONField(serialize = false, deserialize = false)
    public String getParams() {
        return super.getParams();
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


    public static ObjectResult getParamsErrorObjectResult() {
        return getErrorObjectResult("请求参数错误");
    }

    public static ObjectResult getErrorObjectResult(String resultMsg) {
        ObjectResult objectResult = new ObjectResult(SUCCESS_CODE, resultMsg);

        return objectResult;
    }

    public static ObjectResult getSuccessObjectResult(Object object) {
        ObjectResult objectResult = new ObjectResult();
        objectResult.setObject(object);

        return objectResult;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

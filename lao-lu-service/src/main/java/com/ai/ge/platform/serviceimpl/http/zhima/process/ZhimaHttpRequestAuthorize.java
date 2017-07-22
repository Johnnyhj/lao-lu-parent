package com.ai.ge.platform.serviceimpl.http.zhima.process;

import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpRequestAuthObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaHttpRequestObject;
import com.antgroup.zmxy.openplatform.api.request.ZhimaAuthInfoAuthorizeRequest;
import org.apache.commons.httpclient.HttpMethodBase;
import org.springframework.stereotype.Component;

/**
 * 芝麻信用 页面授权
 * <p>
 * https://b.zmxy.com.cn/technology/openDoc.htm?relInfo=zhima.auth.info.authorize@1.0@1.3
 */

@Component("zhimaHttpRequestAuthorize")
public class ZhimaHttpRequestAuthorize extends AbstractHttpRequestProcess {

    protected String getRequestUri() {
        //https://zmopenapi.zmxy.com.cn/openapi.do
        return sysDataService.getByKeyType("", SysDataService.WEB_APP, "https://zmopenapi.zmxy.com.cn/openapi.do");
    }



    @Override
    public void checkResponseMessage(HttpResponseObject httpResponseObject) throws BusinessException {

    }

    @Override
    protected LogInterfaceCallWithBLOBs getLogByCallProcess(HttpRequestContext httpRequestContext, Exception ex) {
        return null;
    }

    @Override
    public void executeMethod(HttpMethodBase method, HttpRequestContext httpRequestContext) throws Exception {
        ZhimaHttpRequestObject httpRequestObject = (ZhimaHttpRequestObject) httpRequestContext.getHttpRequestObject();
        ZhimaHttpRequestAuthObject httpRequestAuthObject = (ZhimaHttpRequestAuthObject) httpRequestContext.getHttpRequestAuthObject();


        ZhimaAuthInfoAuthorizeRequest zhimaRequest = new ZhimaAuthInfoAuthorizeRequest();



        //super.executeMethod(method, httpRequestContext);
    }
}

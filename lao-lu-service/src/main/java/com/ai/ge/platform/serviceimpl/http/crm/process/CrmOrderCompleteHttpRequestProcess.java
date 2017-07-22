package com.ai.ge.platform.serviceimpl.http.crm.process;

import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.crm.response.CrmOrderComplete;
import com.ai.ge.platform.serviceimpl.http.ws.Envelope;
import com.ai.ge.util.XmlObjectTransformUtils;
import org.apache.commons.httpclient.HttpMethodBase;
import org.springframework.stereotype.Component;


/**
 *
 */

@Component("crmOrderCompleteHttpRequestProcess")
public class CrmOrderCompleteHttpRequestProcess extends AbstractHttpRequestProcess {
    @Override
    public void checkResponseMessage(HttpResponseObject httpResponseObject) throws BusinessException {
//        List<CrmOrderComplete> crmOrderCompletes = ((CrmOrderCompleteHttpResponseObject) httpResponseObject).getCrmOrderCompletes();
        if(null!=httpResponseObject){
            CrmOrderComplete crmOrderComplete = ((CrmOrderCompleteHttpResponseObject) httpResponseObject).getCrmOrderComplete();
            if (null!=crmOrderComplete) {
                crmOrderComplete.getPhoneNumber();
            }
        }
    }

    @Override
    protected LogInterfaceCallWithBLOBs getLogByCallProcess(HttpRequestContext httpRequestContext, Exception ex) {
        LogInterfaceCallWithBLOBs logInterfaceCall = httpRequestContext.getLogInterfaceCall();

        //如果捕捉到异常信息
        if (null != ex) {
            logInterfaceCall.setFailReason(ex.getMessage());
        } else {
            HttpResponseObject httpResponseObject = httpRequestContext.getHttpResponseObject();
            CrmOrderCompleteHttpResponseObject crmOrderCompleteHttpResponseObject = (CrmOrderCompleteHttpResponseObject) httpResponseObject;

            if (ObjectResult.SUCCESS_CODE.equals(crmOrderCompleteHttpResponseObject.getResultCode())) {

                //校验返回签名
                logInterfaceCall.setResult((short) 1);
            } else {
                String failReason = crmOrderCompleteHttpResponseObject.getResultMsg();

                logInterfaceCall.setResult((short) 0);
                logInterfaceCall.setFailReason(failReason);
            }
        }
        return logInterfaceCall;
    }


    @Override
    protected HttpResponseObject transform(String responseMessage) {
        responseMessage = responseMessage.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
        Envelope envelope = XmlObjectTransformUtils.transform(responseMessage,Envelope.class);
        return envelope.getBody().getOneCheckInfoRsp().getOneCheckInfoRet().getCrmOrderCompleteHttpResponseObject();
    }

    @Override
    public void addRequestHeader(HttpMethodBase method) {
        //webservice  soap 1.2
//        method.addRequestHeader("SOAPAction", "");
//        method.addRequestHeader("Content-Type", "application/soap+xml; charset=UTF-8;");
        //webservice  soap 1.1
        method.addRequestHeader("SOAPAction", "");
        method.addRequestHeader("Content-Type", "text/xml; charset=UTF-8;");
    }


    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><queryOneCheckInfoResponse xmlns=\"http://crm.crmwsi\"><queryOneCheckInfoReturn><?xml version=\"1.0\" encoding=\"UTF-8\"?><queryCustInfoResponse><result>1</result>" +
                "<resultMsg>查询号码不存在或已拆机，客户不存在或为非在用状态</resultMsg></queryCustInfoResponse></queryOneCheckInfoReturn></queryOneCheckInfoResponse></soapenv:Body></soapenv:Envelope>";


        s = s.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
        System.out.println(s);
        Envelope envelope = XmlObjectTransformUtils.transform(s,Envelope.class);
        System.out.println("CrmOrderCompleteHttpRequestProcess.main");

    }



}

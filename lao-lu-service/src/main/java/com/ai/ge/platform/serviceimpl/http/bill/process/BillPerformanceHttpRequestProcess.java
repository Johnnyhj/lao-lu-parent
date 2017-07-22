package com.ai.ge.platform.serviceimpl.http.bill.process;

import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.bill.response.BillPerformance;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.ws.BalanceQueryRsp;
import com.ai.ge.platform.serviceimpl.http.ws.Envelope;
import com.ai.ge.platform.serviceimpl.http.ws.MultiRef;
import com.ai.ge.util.XmlObjectTransformUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.HttpMethodBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

@Component("billPerformanceHttpRequestProcess")
public class BillPerformanceHttpRequestProcess extends AbstractHttpRequestProcess {
    @Override
    public void checkResponseMessage(HttpResponseObject httpResponseObject) throws BusinessException {
        List<BillPerformance> billPerformances = ((BillPerformanceHttpResponseObject) httpResponseObject).getBillPerformances();
        if(!CollectionUtils.isEmpty(billPerformances)){
            billPerformances.get(0).getAccountId();
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
            BillPerformanceHttpResponseObject billPerformanceHttpResponseObject = (BillPerformanceHttpResponseObject) httpResponseObject;


            if (ObjectResult.SUCCESS_CODE.equals(billPerformanceHttpResponseObject.getResultCode())) {

                //校验返回签名
                logInterfaceCall.setResult((short) 1);
            } else {
                String failReason = billPerformanceHttpResponseObject.getResultMsg();

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

        List<MultiRef> list = envelope.getBody().getMultiRefs();
        List<BillPerformance> billPerformances =new ArrayList<BillPerformance>();
        BillPerformanceHttpResponseObject billPerformanceHttpResponseObject = new BillPerformanceHttpResponseObject();
        for(MultiRef multiRef:list){
            if(null !=multiRef.getResult()){

                billPerformanceHttpResponseObject.setPrivte_code(multiRef.getResult());
                billPerformanceHttpResponseObject.setPrivte_msg(multiRef.getMsg());
                billPerformanceHttpResponseObject.setPrivte_exception(multiRef.getCode());
            }
        }
        for(MultiRef multiRef:list){
            if(billPerformanceHttpResponseObject.getPrivte_code().equals("0")&&null==multiRef.getResult()){
                BillPerformance billPerformance = new BillPerformance();
                billPerformance.setAccountBalance(multiRef.getAccountBalance());
                billPerformance.setAccountId(multiRef.getAccountId());
                billPerformance.setAccountName(multiRef.getAccountName());
                billPerformance.setBalanceType(multiRef.getBalanceType());
                billPerformance.setExpirdate(multiRef.getExpirdate());
                billPerformances.add(billPerformance);
            }
        }
        billPerformanceHttpResponseObject.setBillPerformances(billPerformances);
        return billPerformanceHttpResponseObject;

//        return  envelope.getBody().getBalanceQueryRsp().getBillPerformanceHttpResponseObject();
//        return envelope.getBody().getBillPerformanceHttpResponseObject();
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
        String responseMessage ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "   <soapenv:Body>\n" +
                "      <ns1:accountBalanceQueryResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://server.web\">\n" +
                "         <accountBalanceQueryReturn href=\"#id0\"/>\n" +
                "      </ns1:accountBalanceQueryResponse>\n" +
                "      <multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:AccountBalanceQueryResponse\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns2=\"http://po.web.com\">\n" +
                "         <result xsi:type=\"xsd:string\">0</result>\n" +
                "         <code xsi:type=\"xsd:string\"/>\n" +
                "         <msg xsi:type=\"xsd:string\"/>\n" +
                "         <accountBalanceSet soapenc:arrayType=\"ns2:AccountBalanceSetType[2]\" xsi:type=\"soapenc:Array\">\n" +
                "            <accountBalanceSet href=\"#id1\"/>\n" +
                "            <accountBalanceSet href=\"\t\"/>\n" +
                "         </accountBalanceSet>\n" +
                "      </multiRef>\n" +
                "      <multiRef id=\"id2\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns3:AccountBalanceSetType\" xmlns:ns3=\"http://po.web.com\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "         <accountID xsi:type=\"xsd:string\">510015305564</accountID>\n" +
                "         <accountName xsi:type=\"xsd:string\">金彦君</accountName>\n" +
                "         <accountBalance xsi:type=\"xsd:string\">6514</accountBalance>\n" +
                "         <expireDate xsi:type=\"xsd:string\"></expireDate>\n" +
                "         <balanceType xsi:type=\"xsd:string\">普通帐户余额</balanceType>\n" +
                "      </multiRef>\n" +
                "      <multiRef id=\"id1\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns4:AccountBalanceSetType\" xmlns:ns4=\"http://po.web.com\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "         <accountID xsi:type=\"xsd:string\">510015305564</accountID>\n" +
                "         <accountName xsi:type=\"xsd:string\">金彦君</accountName>\n" +
                "         <accountBalance xsi:type=\"xsd:string\">301</accountBalance>\n" +
                "         <expireDate xsi:type=\"xsd:string\"></expireDate>\n" +
                "         <balanceType xsi:type=\"xsd:string\">普通帐户余额</balanceType>\n" +
                "      </multiRef>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        responseMessage = responseMessage.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
        Envelope envelope = XmlObjectTransformUtils.transform(responseMessage,Envelope.class);


        List<MultiRef> list = envelope.getBody().getMultiRefs();
        List<BillPerformance> billPerformances =new ArrayList<BillPerformance>();
        BillPerformanceHttpResponseObject billPerformanceHttpResponseObject = new BillPerformanceHttpResponseObject();
        for(MultiRef multiRef:list){
            if(null !=multiRef.getResult()){

                billPerformanceHttpResponseObject.setPrivte_code(multiRef.getResult());
                billPerformanceHttpResponseObject.setPrivte_msg(multiRef.getMsg());
                billPerformanceHttpResponseObject.setPrivte_exception(multiRef.getCode());
            }else {
                BillPerformance billPerformance = new BillPerformance();
                billPerformance.setAccountBalance(multiRef.getAccountBalance());
                billPerformance.setAccountId(multiRef.getAccountId());
                billPerformance.setAccountName(multiRef.getAccountName());
                billPerformance.setBalanceType(multiRef.getBalanceType());
                billPerformance.setExpirdate(multiRef.getExpirdate());
                billPerformances.add(billPerformance);
            }
        }
        billPerformanceHttpResponseObject.setBillPerformances(billPerformances);

        System.out.println("BillPerformanceHttpRequestProcess.main");


    }
}

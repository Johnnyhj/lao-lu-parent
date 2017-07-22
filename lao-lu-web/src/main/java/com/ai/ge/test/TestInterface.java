package com.ai.ge.test;

import com.ai.ge.pay.weixin.wxpay.utils.MD5Util;
import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.http.HttpRequestObject;
import com.ai.ge.platform.service.http.HttpResponseObject;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.bill.response.BillPerformance;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.crm.response.CrmOrderComplete;
import com.ai.ge.util.DateUtil;
import com.ai.ge.util.XmlObjectTransformUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sam on 17/6/15.
 */
public class TestInterface {

    public  static HttpClient httpClient;

    public static void main(String[] args) {
        MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams param = new HttpConnectionManagerParams();
//        int soTimeout =  35000;
//        int timeout = 15000;
//        param.setConnectionTimeout(timeout);
//        param.setSoTimeout(soTimeout);
        httpConnectionManager.setParams(param);
        httpClient = new HttpClient(httpConnectionManager);

        //测试CRM  竣工接口
//        getCRMService();
        //测试 计费
//        getBillService();


        getWeatherService();

    }

    public static void getCRMService(){
        CrmOrderCompleteHttpResponseObject httpResponseObject = new CrmOrderCompleteHttpResponseObject();
        CrmOrderCompleteHttpRequestObject httpRequestObject = new CrmOrderCompleteHttpRequestObject();
//
        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
        httpRequestObject.setActionName("CRM 订单竣工查询接口");
        httpRequestObject.setRequestUri("http://localhost:8011/ai-credit-web/testpile/crm/complete/ws");
        httpRequestObject.setVersion("1.0");
        httpRequestObject.setAppCode("ai-credit");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("number","15150584078");
        params.put("numberType",48);
        params.put("areaCode","025");
        params.put("channelId","");
        params.put("staffCode","");
        params.put("password","1");
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        params.put("time_stamp",timestamp);
        String sign = MD5Util.MD5Encode("15150584078" + 48 + "025" + "" + "" + "1" + timestamp + "", "utf-8");
        params.put("sign", "sign");
        String requeststr= getCRMTemplateText("crm_complete_templ",params);
        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = process(httpRequestContext);
        } catch (BusinessException e) {
//            //异常处理
            System.out.println(e.getMessage());
        }
//        //TODO httpRequestResult 判空或异常抛出
        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (CrmOrderCompleteHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();
            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getPrivte_code())) {
                CrmOrderComplete crmOrderComplete = httpResponseObject.getCrmOrderComplete();
//                //正常获取到接口返回数据
                String s = crmOrderComplete.getPhoneNumber() + "  " + crmOrderComplete.getOlNbr();
                System.out.println(s);
            } else {
                System.out.println(httpResponseObject.getResultMsg());
            }
        }
    }

    public static void getBillService(){
        BillPerformanceHttpRequestObject httpRequestObject = new BillPerformanceHttpRequestObject();
        BillPerformanceHttpResponseObject httpResponseObject = new BillPerformanceHttpResponseObject();
//
        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
        httpRequestObject.setActionName("CRM 订单竣工查询接口");
        httpRequestObject.setRequestUri("http://localhost:8011/ai-credit-web/testpile/bill/performance/ws");
        httpRequestObject.setVersion("1.0");
        httpRequestObject.setAppCode("ai-credit");
        //业务数据，待查询履约号码列表
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ValueType","1");
        params.put("Value","13814840233");
        params.put("AreaCode","025");
        params.put("QueryType","1");
        params.put("ProductSpecID","1");
        params.put("SystemID","1");
        params.put("SerialID","1");
        params.put("ContactID", "1");
        String requeststr= getBillTemplateText("bill_performance_templ", params);
        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = process(httpRequestContext);
        } catch (BusinessException e) {
//            //异常处理
            System.out.println(e.getMessage());
        }
//        //TODO httpRequestResult 判空或异常抛出
        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (BillPerformanceHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();
            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getPrivte_code())) {
                BillPerformance billPerformance = httpResponseObject.getBillPerformances().get(0);
//                //正常获取到接口返回数据
                String s = billPerformance.getAccountId() + "  " + billPerformance.getAccountBalance();
                System.out.println(s);
            } else {
                System.out.println(httpResponseObject.getResultMsg());
            }
        }
    }

    public static void getWeatherService(){
        BillPerformanceHttpRequestObject httpRequestObject = new BillPerformanceHttpRequestObject();
        BillPerformanceHttpResponseObject httpResponseObject = new BillPerformanceHttpResponseObject();
//
        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
        httpRequestObject.setActionName("CRM 订单竣工查询接口");
        httpRequestObject.setRequestUri("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");
//        httpRequestObject.setVersion("1.0");
//        httpRequestObject.setAppCode("ai-credit");
        //业务数据，待查询履约号码列表
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("byProvinceName","江苏省");
        String requeststr= getWeatherTemplateText("bill_performance_templ", params);
        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = process(httpRequestContext);
        } catch (BusinessException e) {
//            //异常处理
            System.out.println(e.getMessage());
        }
//        //TODO httpRequestResult 判空或异常抛出
        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (BillPerformanceHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();
            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getPrivte_code())) {
                BillPerformance billPerformance = httpResponseObject.getBillPerformances().get(0);
//                //正常获取到接口返回数据
                String s = billPerformance.getAccountId() + "  " + billPerformance.getAccountBalance();
                System.out.println(s);
            } else {
                System.out.println(httpResponseObject.getResultMsg());
            }
        }
    }


    public static String getCRMTemplateText(String tempFile, Map<String, Object> params) {
        try {
            String templateText ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><queryCondition><number>${number}</number><numberType>${numberType}</numberType><areaCode>${areaCode}</areaCode><channelId>${channelId}</channelId><staffCode>${staffCode}</staffCode><password>${password}</password><time_stamp>${time_stamp}</time_stamp><sign>${sign}</sign></queryCondition>";
            Template template = new Template(null, new StringReader(templateText), null, CharEncoding.UTF_8);
            StringWriter sw = new StringWriter();
            template.process(params, sw);
            String s = sw.toString();

            return s;
        } catch (IOException e) {
            String message = "freemarker模板文件未找到错误";
            throw new DataException(message);
        } catch (TemplateException e) {
            String message = "加载freemarker模板文件错误";
            throw new DataException(message);
        }
    }

    public static String getBillTemplateText(String tempFile, Map<String, Object> params) {
        try {
            String templateText ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><AccountBalanceQuery><ValueType>${ValueType}</ValueType><Value>${Value}</Value><AreaCode>${AreaCode}</AreaCode><QueryType>${QueryType}</QueryType><ProductSpecID>${ProductSpecID}</ProductSpecID><SystemID>${SystemID}</SystemID><SerialID>${SerialID}</SerialID><ContactID>${ContactID}</ContactID></AccountBalanceQuery>";
            Template template = new Template(null, new StringReader(templateText), null, CharEncoding.UTF_8);
            StringWriter sw = new StringWriter();
            template.process(params, sw);
            String s = sw.toString();

            return s;
        } catch (IOException e) {
            String message = "freemarker模板文件未找到错误";
            throw new DataException(message);
        } catch (TemplateException e) {
            String message = "加载freemarker模板文件错误";
            throw new DataException(message);
        }
    }

    public static String getWeatherTemplateText(String tempFile, Map<String, Object> params) {
        try {
            String templateText ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://WebXml.com.cn/\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                    "<web:getSupportCity>" +
                    "" +
                    "<web:byProvinceName>${byProvinceName}}</web:byProvinceName>" +
                    "</web:getSupportCity>\n" +
                    "</soapenv:Body>" +
                    "</soapenv:Envelope>";
            Template template = new Template(null, new StringReader(templateText), null, CharEncoding.UTF_8);
            StringWriter sw = new StringWriter();
            template.process(params, sw);
            String s = sw.toString();

            return s;
        } catch (IOException e) {
            String message = "freemarker模板文件未找到错误";
            throw new DataException(message);
        } catch (TemplateException e) {
            String message = "加载freemarker模板文件错误";
            throw new DataException(message);
        }
    }

    /**
     * 执行Http请求调用
     *
     * @param method
     */
    public static void executeMethod(HttpMethodBase method, HttpRequestContext httpRequestContext) throws Exception {
        try {
            System.out.println("开始请求Http请求时间[" + DateUtil.getStrFromDate(new Date(), DateUtil.DATE_FORMATE_STRING_A) +
                    "]，地址[" + method.getURI() + "]......");
            if (method instanceof PostMethod) {
                NameValuePair[] parameters = ((PostMethod) method).getParameters();
                if (ArrayUtils.isNotEmpty(parameters)) {
                    System.out.println("请求参数");
                    for (NameValuePair parameter : parameters) {
                        System.out.println("name = " + parameter.getName() + " , value = " + parameter.getValue());
                    }
                }
            }

            String queryString = method.getQueryString();
            if (StringUtils.isNotBlank(queryString)) {
                System.out.println("URL请求参数"+queryString);
            }
            if (method instanceof PostMethod) {
                RequestEntity requestEntity = ((PostMethod) method).getRequestEntity();
                if (null != requestEntity) {
                    System.out.println("请求体 ");
                    System.out.println(requestEntity.toString());
                }
            }
            httpClient.executeMethod(method);
            int statusCode = method.getStatusCode();

            if (HttpStatus.SC_OK != statusCode) {
                //返回码不是200
                String message = "服务器未能成功返回，状态码是" + statusCode;

                    System.out.println(message);
                throw new IOException(message);
            }
            executeMethodPost(method, httpRequestContext);

            System.out.println("成功接收Http请求数据......");
        } catch (IOException e) {
//            executeMethodException(method, e, httpRequestContext);
            System.out.println(e.getMessage());
        } finally {
            method.releaseConnection();
        }
    }
    public static void executeMethodPost(HttpMethodBase method, HttpRequestContext httpRequestContext)
            throws Exception {
        String responseMessage = getResponseBodyAsString(method);
        Integer statusCode = method.getStatusCode();
        long timeByCall = httpRequestContext.getHttpResponseObject().getTimeByCall();


        httpRequestContext.getHttpResponseObject().setResponseMessage(responseMessage);


        HttpResponseObject httpResponseObject = null;
        try {
            System.out.println(responseMessage);

            httpResponseObject = transform(responseMessage);

            checkResponseMessage(httpResponseObject);
        } catch (Exception e) {
            System.out.println("解析响应包异常，响应包[" + responseMessage + "]");
//            LoggerStorageFactory.add(this, logInterfaceCall);
            throw new BusinessException("服务器正忙，请稍后再试");
        }
        httpRequestContext.setHttpResponseObject(httpResponseObject);
    }

    public static String getResponseBodyAsString(HttpMethodBase method) throws IOException {
        String response = new String(method.getResponseBody(), method.getResponseCharSet());
        response = StringEscapeUtils.unescapeXml(response);
        return response;
    }

    public static HttpResponseObject transform(String responseMessage) {
        return XmlObjectTransformUtils.transform(responseMessage, HttpResponseObject.class);
    }
    public static void checkResponseMessage(HttpResponseObject httpResponseObject) throws BusinessException {
        CrmOrderComplete crmOrderComplete = ((CrmOrderCompleteHttpResponseObject) httpResponseObject).getCrmOrderComplete();
        if (null!=crmOrderComplete) {
            crmOrderComplete.getPhoneNumber();
        }
    }

    public static HttpMethodBase getHttpMethod(HttpRequestContext httpRequestContext) {
        HttpRequestObject httpRequestObject = httpRequestContext.getHttpRequestObject();
        return new PostMethod(httpRequestObject.getRequestUri());
    }

    public static  void addRequestHeader(HttpMethodBase method) {
        //webservice  soap 1.2
//        method.addRequestHeader("Content-Type", "application/soap+xml; charset=gbk");
//        method.addRequestHeader("Content-Type", "application/soap+xml; charset=gbk;");
        //webservice  soap 1.1
        method.addRequestHeader("Content-Type", "text/xml; charset=UTF-8;");
        method.addRequestHeader("SOAPAction", "");
    }

    public static HttpRequestResult process(HttpRequestContext httpRequestContext) throws BusinessException {
        HttpRequestResult httpRequestResult = new HttpRequestResult();

        HttpMethodBase method = getHttpMethod(httpRequestContext);
        addRequestHeader(method);
        HttpRequestObject httpRequestObject = httpRequestContext.getHttpRequestObject();
        if (method instanceof EntityEnclosingMethod && StringUtils.isNotBlank(httpRequestObject.getRequestMessage())) {
            StringRequestEntity stringRequestEntity = null;
            String contentType = httpRequestContext.getContentType(), charset = httpRequestContext.getCharset();
            if (StringUtils.isNotBlank(contentType) && StringUtils.isNotBlank(charset)) {
                try {
                    stringRequestEntity = new StringRequestEntity(httpRequestObject
                            .getRequestMessage(), contentType, charset);
                } catch (UnsupportedEncodingException e) {
                    System.out.println(e.getMessage());

                    stringRequestEntity = new StringRequestEntity(httpRequestObject
                            .getRequestMessage());
                }
            } else {
                stringRequestEntity = new StringRequestEntity(httpRequestObject
                        .getRequestMessage());
            }
            ((EntityEnclosingMethod) method).setRequestEntity(stringRequestEntity);
        }

        /**
         * post请求参数
         */
        addParameter(method, httpRequestContext.getParameters());


        long timeByCall = System.currentTimeMillis();
        httpRequestContext.getHttpResponseObject().setTimeByCall(timeByCall);
        try {
            executeMethod(method, httpRequestContext);
        } catch (Exception e) {

            throw new BusinessException(e.getMessage());
        }
        System.out.println("接收接口调用返回数据处理......");


        httpRequestResult.setResultCode(HttpRequestResult.SUCCESS_CODE);
        httpRequestResult.setHttpRequestContext(httpRequestContext);
        return httpRequestResult;
    }

    public static void addParameter(HttpMethodBase method, Map<String, String> parameter) {
        if (MapUtils.isNotEmpty(parameter) && method instanceof PostMethod) {
            PostMethod postMethod = (PostMethod) method;
            for (Map.Entry<String, String> stringEntry : parameter.entrySet()) {
                postMethod.addParameter(stringEntry.getKey(), stringEntry.getValue());
            }
        }
    }
}

package com.ai.ge.creadit.controller.test_pile;

import com.ai.ge.pay.weixin.wxpay.utils.MD5Util;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.bill.response.BillPerformance;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.crm.response.CrmOrderComplete;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaBatchFeedbackHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaBatchFeedbackHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaGetScoreHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaGetScoreHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaOrderConfirmHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaSingleFeedbackHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaSingleFeedbackHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.request.BatchFeedback;
import com.ai.ge.util.DateUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 测试接口
 */

@Controller
@RequestMapping("/test/interface")
public class TestInterfaceController {

    private static Logger logger = LoggerFactory.getLogger(TestInterfaceController.class);

    /**
     * 1、	芝麻业务办理完成后会回调商户指定的地址，并且加上一个参数orderNo
     * 2、	商户接受到orderNo后来芝麻查询相关信息，具体接口参见第四部分订单查询接口
     *
     * TODO 参见 CreditlifeController
     */
    @Resource(name = "zhimaOrderConfirmHttpRequestProcess")
    private AbstractHttpRequestProcess zhimaOrderConfirmHttpRequestProcess;

    /**
     * 查询芝麻用户的芝麻信用评分
     */
    @Resource(name = "zhimaGetScoreHttpRequestProcess")
    private AbstractHttpRequestProcess zhimaGetScoreHttpRequestProcess;

    /**
     * 单条数据反馈服务接口
     */
    @Resource(name = "zhimaSingleFeedbackHttpRequestProcess")
    private AbstractHttpRequestProcess zhimaSingleFeedbackHttpRequestProcess;

    /**
     * 批量数据反馈服务接口
     */
    @Resource(name = "zhimaBatchFeedbackHttpRequestProcess")
    private AbstractHttpRequestProcess zhimaBatchFeedbackHttpRequestProcess;

    /**
     * CRM 订单竣工查询接口
     */
    @Resource(name = "crmOrderCompleteHttpRequestProcess")
    private AbstractHttpRequestProcess crmOrderCompleteHttpRequestProcess;


    /**
     * 批量查询用户是否履约接口
     */
    @Resource(name = "billPerformanceHttpRequestProcess")
    private AbstractHttpRequestProcess billPerformanceHttpRequestProcess;


    @Resource
    private SysDataService sysDataService;


    /**
     * 1、	信用套餐查询接口
     *
     * @param request
     * @param response
     */
    @Deprecated
    @RequestMapping("/zhima/order/confirm")
    public void getOrderConfirm(HttpServletRequest request, HttpServletResponse response) {
        //TODO 参见 CreditlifeController 业务流程实现
        //TODO 以下示例废弃



        ZhimaOrderConfirmHttpRequestObject httpRequestObject = new ZhimaOrderConfirmHttpRequestObject();
        ZhimaOrderConfirmHttpResponseObject httpResponseObject = new ZhimaOrderConfirmHttpResponseObject();
        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);

        httpRequestObject.setActionName("信用套餐查询接口");
        String requestUri = sysDataService.getByKeyType("zhima_order_confirm_url", SysDataService.WEB_APP, "https://zmopenapi.zmxy.com.cn/openapi.do");
        httpRequestObject.setRequestUri(requestUri);

        String transactionId = DateUtil.getStrFromDate(new Date(), "yyyyMMddhhmmssSSS") + RandomStringUtils.randomNumeric(13);

        httpRequestObject.setTransactionId(transactionId);
        httpRequestObject.setOrderNo("268810000007909449496");

        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = zhimaOrderConfirmHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理

            logger.error(e.getMessage(), e);
        }

        //TODO httpRequestResult 判空或异常抛出

        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (ZhimaOrderConfirmHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                //正常获取到接口返回数据
                System.out.println(httpResponseObject.getZmScore());
                System.out.println(httpResponseObject.getOpenId());

            } else {

                //失败处理
            }

        } else {
            //失败处理
        }

    }


    /**
     * 查询芝麻用户的芝麻信用评分
     *
     * @param request
     * @param response
     */
    @RequestMapping("/zhima/scope")
    public void testZhimaScope(HttpServletRequest request, HttpServletResponse response) {
        ZhimaGetScoreHttpRequestObject httpRequestObject = new ZhimaGetScoreHttpRequestObject();
        ZhimaGetScoreHttpResponseObject httpResponseObject = new ZhimaGetScoreHttpResponseObject();

        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);

        httpRequestObject.setActionName("查询芝麻用户的芝麻信用评分");
        String requestUri = sysDataService.getByKeyType("zhima_score_url", SysDataService.WEB_APP, "https://zmopenapi.zmxy.com.cn/openapi.do");
        httpRequestObject.setRequestUri(requestUri);


        String transactionId = DateUtil.getStrFromDate(new Date(), "yyyyMMddhhmmssSSS") + RandomStringUtils.randomNumeric(13);

        httpRequestObject.setTransactionId(transactionId);
        httpRequestObject.setOpenId("268810000007909449496");

        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = zhimaGetScoreHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理

            logger.error(e.getMessage(), e);
        }

        //TODO httpRequestResult 判空或异常抛出

        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (ZhimaGetScoreHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                //正常获取到接口返回数据
                System.out.println(httpResponseObject.getZmScore());

            } else {

                //失败处理
            }

        } else {
            //失败处理
        }
    }

    /**
     * 批量数据反馈服务接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/zhima/batch/feedback")
    public void testZhimaBatchFeedback(HttpServletRequest request, HttpServletResponse response) {
        ZhimaBatchFeedbackHttpRequestObject httpRequestObject = new ZhimaBatchFeedbackHttpRequestObject();
        ZhimaBatchFeedbackHttpResponseObject httpResponseObject = new ZhimaBatchFeedbackHttpResponseObject();

        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);

        httpRequestObject.setActionName("批量数据反馈服务");
        String requestUri = sysDataService.getByKeyType("zhima_batch_feedback_url", SysDataService.WEB_APP, "https://zmopenapi.zmxy.com.cn/openapi.do");
        httpRequestObject.setRequestUri(requestUri);


        String transactionId = DateUtil.getStrFromDate(new Date(), "yyyyMMddhhmmssSSS") + RandomStringUtils.randomNumeric(13);
        //流水号，用来区别多次反馈同样的数据，流水号与反馈数据绑定
        httpRequestObject.setTransactionId(transactionId);
        //反馈数据

        List<BatchFeedback> batchFeedbacks = new ArrayList<BatchFeedback>();

        for (int i = 0; i < 10000; i++) {
            BatchFeedback bf = new BatchFeedback();
            bf.setBizDate("2016-02-06");
            bf.setUserCredentialsType("0");
            bf.setUserCredentialsNo("283992829383728372");
            bf.setUserName("张三");
            bf.setOrderNo("201602050099");
            bf.setPhoneNo("1XX12345678");
            bf.setOrderStartDate("2016-01-01");
            bf.setOrderEndDate("2016-01-01");
            bf.setOrderStatus("1");
            bf.setBillNo("3");
            bf.setBillInstallment("201603");
            bf.setBillDesc("账单");
            bf.setBillType("111");
            bf.setBillAmt("200");
            bf.setBillLastDate("2016-04-25");
            bf.setBillStatus("0");
            bf.setBillPayoffDate("2016-04-19");
            bf.setBillTypeOvdAmt("38");
            bf.setBillTypeOvdDate("2016-02-25");

            batchFeedbacks.add(bf);
        }

        httpRequestObject.setBatchFeedbacks(batchFeedbacks);

        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = zhimaBatchFeedbackHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理

            logger.error(e.getMessage(), e);
        }

        //TODO httpRequestResult 判空或异常抛出

        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (ZhimaBatchFeedbackHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                //正常数据反馈成功
                System.out.println("批量数据反馈服务接口反馈成功");

            } else {

                //失败处理
            }

        } else {
            //失败处理
        }
    }

    /**
     * 单条数据反馈服务接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/zhima/single/feedback")
    public void testZhimaSingleFeedback(HttpServletRequest request, HttpServletResponse response) {
        ZhimaSingleFeedbackHttpRequestObject httpRequestObject = new ZhimaSingleFeedbackHttpRequestObject();
        ZhimaSingleFeedbackHttpResponseObject httpResponseObject = new ZhimaSingleFeedbackHttpResponseObject();

        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);

        httpRequestObject.setActionName("单条数据反馈服务");
        String requestUri = sysDataService.getByKeyType("zhima_single_feedback_url", SysDataService.WEB_APP, "https://zmopenapi.zmxy.com.cn/openapi.do");
        httpRequestObject.setRequestUri(requestUri);


        String transactionId = DateUtil.getStrFromDate(new Date(), "yyyyMMddhhmmssSSS") + RandomStringUtils.randomNumeric(13);
        //流水号，用来区别多次反馈同样的数据，流水号与反馈数据绑定
        httpRequestObject.setTransactionId(transactionId);
        //反馈数据
        BatchFeedback bf = new BatchFeedback();
        bf.setBizDate("2016-02-06");
        bf.setUserCredentialsType("0");
        bf.setUserCredentialsNo("283992829383728372");
        bf.setUserName("张三");
        bf.setOrderNo("201602050099");
        bf.setPhoneNo("1XX12345678");
        bf.setOrderStartDate("2016-01-01");
        bf.setOrderEndDate("2016-01-01");
        bf.setOrderStatus("1");
        bf.setBillNo("3");
        bf.setBillInstallment("201603");
        bf.setBillDesc("账单");
        bf.setBillType("111");
        bf.setBillAmt("200");
        bf.setBillLastDate("2016-04-25");
        bf.setBillStatus("0");
        bf.setBillPayoffDate("2016-04-19");
        bf.setBillTypeOvdAmt("38");
        bf.setBillTypeOvdDate("2016-02-25");


        httpRequestObject.setBatchFeedback(bf);

        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = zhimaSingleFeedbackHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理

            logger.error(e.getMessage(), e);
        }

        //TODO httpRequestResult 判空或异常抛出

        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (ZhimaSingleFeedbackHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                //正常数据反馈成功
                System.out.println("单条数据反馈服务接口反馈成功");

            } else {

                //失败处理
            }

        } else {
            //失败处理
        }
    }


    /**
     * CRM 订单竣工查询接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/crm/complete")
    public void testCrmComplete(HttpServletRequest request, HttpServletResponse response) {

        CrmOrderCompleteHttpResponseObject httpResponseObject = new CrmOrderCompleteHttpResponseObject();
        CrmOrderCompleteHttpRequestObject httpRequestObject = new CrmOrderCompleteHttpRequestObject();

        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);

        httpRequestObject.setActionName("CRM 订单竣工查询接口");
        httpRequestObject.setRequestUri(sysDataService.getByKeyType("crm_complete_url", SysDataService.WEB_APP, ""));


        httpRequestObject.setVersion("1.0");
        httpRequestObject.setAppCode("ai-credit");
        //业务数据，未激活号码列表
        httpRequestObject.setNumbers(Arrays.asList("18000000000", "18000000001", "18000000002", "18000000003"));
        httpRequestObject.setTimestamp((int) (System.currentTimeMillis() / 1000));

        httpRequestObject.setRequestMessage(JSON.toJSONString(httpRequestObject));

        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = crmOrderCompleteHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理

            logger.error(e.getMessage(), e);
        }

        //TODO httpRequestResult 判空或异常抛出

        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (CrmOrderCompleteHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
//                List<CrmOrderComplete> crmOrderCompletes = httpResponseObject.getCrmOrderCompletes();
//
//                //正常获取到接口返回数据
//                for (CrmOrderComplete crmOrderComplete : crmOrderCompletes) {
//                    String s = crmOrderComplete.getPhoneNumber() + "  " + crmOrderComplete.getOlNbr();
//                    System.out.println(s);
//
//                }

            } else {

                //失败处理
            }

        } else {
            //失败处理
        }

    }

    /**
     * 批量查询用户是否履约接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/bill/performance")
    public void testBillPerformance(HttpServletRequest request, HttpServletResponse response) {
        BillPerformanceHttpRequestObject httpRequestObject = new BillPerformanceHttpRequestObject();
        BillPerformanceHttpResponseObject httpResponseObject = new BillPerformanceHttpResponseObject();

        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);

        httpRequestObject.setActionName("批量查询用户是否履约接口");
        httpRequestObject.setRequestUri(sysDataService.getByKeyType("bill_performance_url", SysDataService.WEB_APP, ""));


        httpRequestObject.setVersion("1.0");
        httpRequestObject.setAppCode("ai-credit");
        //业务数据，待查询履约号码列表
        //每次最多查询50个用户
        httpRequestObject.setNumbers(Arrays.asList("18000000000", "18000000001", "18000000002", "18000000003"));
        httpRequestObject.setTimestamp((int) (System.currentTimeMillis() / 1000));
        httpRequestObject.setMonth("201705");

        httpRequestObject.setRequestMessage(JSON.toJSONString(httpRequestObject));

        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = billPerformanceHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理

            logger.error(e.getMessage(), e);

        }

        //TODO httpRequestResult 判空或异常抛出

        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (BillPerformanceHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                BillPerformance billPerformance = httpResponseObject.getBillPerformances().get(0);
                //正常获取到接口返回数据
            } else {

                //失败处理
            }

        } else {
            //失败处理
        }

    }







    /**
     * CRM 订单竣工查询接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/crm/completeTest")
    public void testCrmCompleteTest(HttpServletRequest request, HttpServletResponse response) {
        CrmOrderCompleteHttpResponseObject httpResponseObject = new CrmOrderCompleteHttpResponseObject();
        CrmOrderCompleteHttpRequestObject httpRequestObject = new CrmOrderCompleteHttpRequestObject();
        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
        httpRequestObject.setActionName("CRM 订单竣工查询接口");
        httpRequestObject.setRequestUri(sysDataService.getByKeyType("crm_complete_url_test", SysDataService.WEB_APP, ""));
        httpRequestObject.setVersion("1.0");
        httpRequestObject.setAppCode("ai-credit");
//        //业务数据，未激活号码列表
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("number","18903612189");
        params.put("numberType",48);
        params.put("areaCode","0451");
        params.put("channelId","");
        params.put("staffCode","");
        params.put("password","");
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        params.put("time_stamp","1497338309000");
//        String sign = MD5Util.MD5Encode("18903612189"+48+"0451"+""+""+""+timestamp+sysDataService.getByKeyType("common_ws_key",SysDataService.WEB_APP),"utf-8");
        params.put("sign","B2EF9C7B10EB0985365F913420CCB84A");
        String requeststr= crmOrderCompleteHttpRequestProcess.getTemplateText("crm_complete_templ",params);
        httpRequestObject.setRequestMessage(requeststr);
        HttpRequestResult httpRequestResult = null;
        try {
            httpRequestResult = crmOrderCompleteHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理
            logger.error(e.getMessage(), e);
        }
        //TODO httpRequestResult 判空或异常抛出
        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (CrmOrderCompleteHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();
            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getPrivte_code())) {
                CrmOrderComplete crmOrderComplete = httpResponseObject.getCrmOrderComplete();
                //正常获取到接口返回数据
                String s = crmOrderComplete.getPhoneNumber() + "  " + crmOrderComplete.getOlNbr();
                System.out.println(s);

            } else {
                //失败处理
                System.out.println(httpResponseObject.getResultMsg());

            }

        } else {
            //失败处理
        }
    }

    /**
     * 批量查询用户是否履约接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/bill/performanceTest")
    public void testBillPerformancetest(HttpServletRequest request, HttpServletResponse response) {
        BillPerformanceHttpRequestObject httpRequestObject = new BillPerformanceHttpRequestObject();
        BillPerformanceHttpResponseObject httpResponseObject = new BillPerformanceHttpResponseObject();
        HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
        httpRequestObject.setActionName("批量查询用户是否履约接口");
        httpRequestObject.setRequestUri(sysDataService.getByKeyType("bill_performance_url_test", SysDataService.WEB_APP, ""));
        httpRequestObject.setVersion("1.0");
        httpRequestObject.setAppCode("ai-credit");
        //业务数据，待查询履约号码列表
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("valueType","1");
        params.put("value","13359991357");
        params.put("areaCode","0451");
        params.put("queryType","1");
        params.put("productSpecID","1");
        params.put("systemID","100010");
        params.put("serialID","");
        params.put("contactID","");
        String requeststr= billPerformanceHttpRequestProcess.getTemplateText("bill_performance_templ",params);
        HttpRequestResult httpRequestResult = null;
        httpRequestObject.setRequestMessage(requeststr);
        try {
            httpRequestResult = billPerformanceHttpRequestProcess.process(httpRequestContext);
        } catch (BusinessException e) {
            //异常处理
            logger.error(e.getMessage(), e);
        }
        //TODO httpRequestResult 判空或异常抛出
        if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
            HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
            httpResponseObject = (BillPerformanceHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();
            if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getPrivte_code())) {
                BillPerformance billPerformance = httpResponseObject.getBillPerformances().get(0);
                System.out.println(billPerformance.getAccountId());
                System.out.println(billPerformance.getAccountName());
            } else {
                //失败处理
            }

        } else {
            //失败处理
        }

    }
}

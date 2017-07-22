package com.ai.ge.test;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.pay.weixin.wxpay.utils.MD5Util;
import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.model.order.PerformanceInfo;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.order.OrderService;
import com.ai.ge.platform.service.performance.PerformanceService;
import com.ai.ge.platform.service.phonenum.PhoneNumService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.service.sys.SystemAreaService;
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
import com.ai.ge.platform.serviceimpl.order.OrderServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoaderListener;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhacy3 on 2017/5/3.
 */
//可以不添加@Service，但需要使用Spring自动注入能力时必需添加该注解
@Service
//能力注册为helloworld的能力
//调用是使用http://localhost:8080/web/core/helloworld即可调用到该能力
@AbilityRegister(name="mytest", desc = "hello world")
public class MyTestMain implements IAbility {

    private Logger logger = Logger.getLogger(MyTestMain.class);
    //自动注入
    @Resource
    private PhoneNumService phoneNumServiceImpl;
    @Resource
    private OrderService orderServiceImpl;
    @Resource
    private SysDataService sysDataService;
    @Resource
    private AbstractHttpRequestProcess crmOrderCompleteHttpRequestProcess;
    @Resource
    private PerformanceService performanceService;
    @Resource
    private PerformanceService performanceServiceImpl;
    @Resource
    private AbstractHttpRequestProcess billPerformanceHttpRequestProcess;
    @Resource
    private RedisSpringProxy redisService;
    @Resource
    private PhoneNumService phoneNumService;
    @Resource
    private SystemAreaService systemAreaService;

    @Override
    public Message execute(Message message) {
        logger.debug("redisService:"+redisService);
        if(null==orderServiceImpl){
            orderServiceImpl  = ContextLoaderListener.getCurrentWebApplicationContext().getBean("orderServiceImpl", OrderServiceImpl.class);
        }
        //直接获取请求参数
        String a = message.getParameter("type");

        if(null==a)
            return message;

        String timeout = message.getParameter("timeout");
        String performanceDate = message.getParameter("performanceDate");//履约日期 2017-09-09
        Long tm = null;
        if(timeout!=null)
            tm = Long.parseLong(timeout);
        logger.debug("请求类型:"+a);
        logger.debug("超时时间:"+timeout);
        logger.debug("履约日期:"+performanceDate);
        //释放电话号码
        if(a.equalsIgnoreCase("releaseNumber")) {
            int count = phoneNumServiceImpl.releaseNumber(tm);
            logger.debug("释放" + count + "个电话号码");
        }else if(a.equalsIgnoreCase("updatePaymentTimeoutOrders")){
            int count = orderServiceImpl.updatePaymentTimeoutOrders(tm);
            logger.debug("处理"+count+"条超时订单");
        }else if(a.equalsIgnoreCase("crmComplete")){//CRM竣工
            crmComplete();
        }else if(a.equalsIgnoreCase("performance")){//履约
            performance(performanceDate);
        }

        //消息状态码
        message.setCode(AbilityConstant.R_SUCCESS);
        //返回的消息体
        message.setBody("hello world");

        //非ajax请求时的跳转页面
        //redirect:http://www.baidu.com ==> 重定向到baidu
        //view/index ==> 跳转到view文件夹下index.jsp页面
        //message.setView("redirect:http://www.baidu.com");

        return message;
    }

    private void crmComplete(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("CRM竣工查询定时任务开始：" + sdf.format(new Date()));
        try {
            //查询待报竣状态订单
            List<Orders> orders = orderServiceImpl.findListByStatus(2);

            //请求接口
            CrmOrderCompleteHttpResponseObject httpResponseObject = new CrmOrderCompleteHttpResponseObject();
            CrmOrderCompleteHttpRequestObject httpRequestObject = new CrmOrderCompleteHttpRequestObject();
            HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
            httpRequestObject.setActionName("CRM 订单竣工查询接口");
            httpRequestObject.setRequestUri(sysDataService.getByKeyType("crm_complete_url_test", SysDataService.WEB_APP, ""));
            httpRequestObject.setVersion("1.0");
            httpRequestObject.setAppCode("ai-credit");
            //业务数据，未激活号码单次循环
            for(Orders order : orders){
                String telphone = order.getTelPhone();
                String areaCode = "";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("number",telphone);
                params.put("numberType",48);
                //查询电话号码地区
                NumberInfoDto record = new NumberInfoDto();
                record.setNumber(telphone);
                List<NumberInfoDto> numberInfoDtoList = phoneNumService.listNumberInfoDto(record);
                if(null!=numberInfoDtoList&&numberInfoDtoList.size()>0){
                    SystemArea systemArea =systemAreaService.listSystemAreaById(numberInfoDtoList.get(0).getCityAearId());
                    areaCode = systemArea.getAreaCode();
                    params.put("areaCode",areaCode);
                }else{
                    logger.error("未查到电话号码信息.order:"+order.getOrderId());
                    continue;
                }
                //测试
                params.put("number","18903612189");
                params.put("areaCode","0451");

                params.put("channelId", "");//暂时不传值
                params.put("staffCode", "");//暂时不传值
                params.put("password","");//暂时不传值
                int timestamp = (int) (System.currentTimeMillis() / 1000);
                params.put("time_stamp", timestamp);
                String sign = MD5Util.MD5Encode(telphone + 48 + areaCode + "" + "" + "" + timestamp + sysDataService.getByKeyType("common_ws_key", SysDataService.WEB_APP), "utf-8");
                params.put("sign",sign);

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
                        logger.debug("报竣接口返回:"+s);
                        performanceService.initPerformance(crmOrderComplete.getPhoneNumber(), crmOrderComplete.getOlNbr());
                    } else {
                        //失败处理
                        System.out.println(httpResponseObject.getResultMsg());
                    }

                } else {
                    logger.error("报竣查询失败.order:"+order.getOrderId());
                }
            }
        } catch (Exception e) {

            logger.error("CRM竣工定时任务异常", e);
        }
        logger.error("CRM竣工定时任务结束：" + sdf.format(new Date()));
    }

    /**
     * /ai-credit-web/core/mytest?type=performance&performanceDate=2017-08-09
     * @param performanceDate
     */
    private void performance(String performanceDate){
        Date currentDate =null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 定时任务日志时间戳格式
        try{
            currentDate = sdf.parse(performanceDate);
        }catch(Exception e){
            e.printStackTrace();
        }


        sdf = new SimpleDateFormat("yyyyMM");// 定时任务日志时间戳格式
        String billInstallment = sdf.format(currentDate);


        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("履约定时任务开始：" + sdf.format(currentDate));
        try {
            //查询正在履约的履约计划 status:1
            List<PerformanceInfo> performanceInfos = performanceServiceImpl.findListByStatus(Short.parseShort("1"));

            {
                BillPerformanceHttpRequestObject httpRequestObject = new BillPerformanceHttpRequestObject();
                BillPerformanceHttpResponseObject httpResponseObject = new BillPerformanceHttpResponseObject();
                HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
                httpRequestObject.setActionName("批量查询用户是否履约接口");
                httpRequestObject.setRequestUri(sysDataService.getByKeyType("bill_performance_url_test", SysDataService.WEB_APP, ""));
                httpRequestObject.setVersion("1.0");
                httpRequestObject.setAppCode("ai-credit");

                for (PerformanceInfo performanceInfo : performanceInfos){
                    //业务数据，待查询履约号码列表
                    int timestamp = (int) (System.currentTimeMillis() / 1000);
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("valueType","1");
                    params.put("value",performanceInfo.getPerformanceCode());
                    //查询电话号码地区
                    NumberInfoDto record = new NumberInfoDto();
                    record.setNumber(performanceInfo.getPerformanceCode());
                    List<NumberInfoDto> numberInfoDtoList = phoneNumService.listNumberInfoDto(record);
                    if(null!=numberInfoDtoList&&numberInfoDtoList.size()>0){
                        SystemArea systemArea =systemAreaService.listSystemAreaById(numberInfoDtoList.get(0).getCityAearId());
                        String areaCode = systemArea.getAreaCode();
                        params.put("areaCode",areaCode);
                    }else{
                        logger.error("未查到电话号码信息.performanceInfoId:"+performanceInfo.getPerformanceId());
                        continue;
                    }

                    //测试
//                    params.put("number","18903612189");
//                    params.put("areaCode","0451");


                    params.put("queryType","1");
                    params.put("productSpecID", "1");
                    params.put("systemID", "100010");
                    params.put("serialID", "");
                    params.put("contactID", "");
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
                            int common = 0;//普通
                            int special = 0;//专项
                            for(BillPerformance billPerformance : httpResponseObject.getBillPerformances()){
                                if(billPerformance.getBalanceType().indexOf("普通")>-1)
                                    common = billPerformance.getAccountBalance();
                                else
                                    special = billPerformance.getAccountBalance();

                                System.out.println(billPerformance.getAccountId());
                                System.out.println(billPerformance.getAccountName());
                                System.out.println(billPerformance.getBalanceType());
                                System.out.println(billPerformance.getAccountBalance());
                            }
                            try {
                                if(common>0&&special>0)
                                    performanceServiceImpl.processPerformanceForTest(performanceInfo.getPerformanceCode(), "Y",currentDate);
                                else
                                    performanceServiceImpl.processPerformanceForTest(performanceInfo.getPerformanceCode(),"N",currentDate);
                            }catch(Exception e){
                                logger.error(e.getMessage(), e);
                                logger.error("履约业务执行失败.履约号码:"+performanceInfo.getPerformanceCode());
                            }
                        } else {
                            //失败处理
                            logger.error("履约失败.履约号码:"+performanceInfo.getPerformanceCode());
                        }

                    } else {
                        logger.error("履约失败.履约号码:"+performanceInfo.getPerformanceCode());
                    }
                }

            }


        } catch (Exception e) {
            logger.error("履约定时任务异常", e);
        }
        logger.error("履约定时任务结束：" + sdf.format(new Date()));
    }
    /*
    private void crmComplete(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("CRM竣工查询定时任务开始：" + sdf.format(new Date()));
        try {
            //查询待报竣状态订单
            List<Orders> orders = orderServiceImpl.findListByStatus(2);

            List<String> telphones = new ArrayList<String>();
            for(Orders o : orders)
                telphones.add(o.getTelPhone());
            logger.debug("查询出"+telphones.size()+"条等待报竣订单");
            //请求接口
            CrmOrderCompleteHttpResponseObject httpResponseObject = new CrmOrderCompleteHttpResponseObject();
            CrmOrderCompleteHttpRequestObject httpRequestObject = new CrmOrderCompleteHttpRequestObject();
            HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
            httpRequestObject.setActionName("CRM 订单竣工查询接口");
            httpRequestObject.setRequestUri(sysDataService.getByKeyType("crm_complete_url", SysDataService.WEB_APP, ""));
            httpRequestObject.setVersion("1.0");
            httpRequestObject.setAppCode("ai-credit");
            //业务数据，未激活号码列表
            httpRequestObject.setNumbers(telphones);
            httpRequestObject.setTimestamp((int) (System.currentTimeMillis() / 1000));
            httpRequestObject.setRequestMessage(JSON.toJSONString(httpRequestObject));

            HttpRequestResult httpRequestResult = null;
            try {
                httpRequestResult = crmOrderCompleteHttpRequestProcess.process(httpRequestContext);
            } catch (BusinessException e) {
                //异常处理
                logger.error(e.getMessage(), e);
            }
            if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
                HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
                httpResponseObject = (CrmOrderCompleteHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

                if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                    CrmOrderComplete crmOrderCompletes = httpResponseObject.getCrmOrderComplete();
//                    logger.debug("本次查询CRM已报竣订单个数"+crmOrderCompletes.size());
                    List<String> crmOrderCompletePhone = new ArrayList<String>();
                    //正常获取到接口返回数据,遍历已激活号码
//                    for (CrmOrderComplete crmOrderComplete : crmOrderCompletes) {
////                        String s = crmOrderComplete.getPhoneNumber() + "  " + crmOrderComplete.getOlNbr();
////                        crmOrderCompletePhone.add(crmOrderComplete.getPhoneNumber());
//                        logger.debug("号码"+crmOrderComplete.getPhoneNumber()+"开始履约");
//                        performanceService.initPerformance(crmOrderComplete.getPhoneNumber());
//                    }
                }else{
                    logger.error("报竣查询失败");
                }
            }else{
                logger.error("报竣查询失败");
            }
        } catch (Exception e) {
            logger.error("CRM竣工定时任务异常", e);
        }
        logger.error("CRM竣工定时任务结束：" + sdf.format(new Date()));
    }


    private void performance(String performanceDate){
        Date currentDate =null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 定时任务日志时间戳格式
        try{
            currentDate = sdf.parse(performanceDate);
        }catch(Exception e){
            e.printStackTrace();
        }


        sdf = new SimpleDateFormat("yyyyMM");// 定时任务日志时间戳格式
        String billInstallment = sdf.format(currentDate);


        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("履约定时任务开始：" + sdf.format(currentDate));
        try {
            //查询正在履约的履约计划 status:1
            List<PerformanceInfo> performanceInfos = performanceServiceImpl.findListByStatus(Short.parseShort("1"));

            //生成电话号码列表List<List:最多50个>
            List<List<String>> phoneNumList = new ArrayList<List<String>>();
            List<String> pl = new ArrayList<String>();
            for(int i=0;i<performanceInfos.size();i++){
                if(i!=0&&((i+1)%50)==0) {//每次最多查询50个用户
                    pl.add(performanceInfos.get(i).getPerformanceCode());
                    phoneNumList.add(pl);
                    pl=new ArrayList<String>();
                }else
                    pl.add(performanceInfos.get(i).getPerformanceCode());
            }
            if(pl.size()>0)
                phoneNumList.add(pl);

            //业务数据，待查询履约号码列表
            //每次最多查询50个用户
            {
                BillPerformanceHttpRequestObject httpRequestObject = new BillPerformanceHttpRequestObject();
                BillPerformanceHttpResponseObject httpResponseObject = new BillPerformanceHttpResponseObject();
                HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);
                httpRequestObject.setActionName("批量查询用户是否履约接口");
                httpRequestObject.setRequestUri(sysDataService.getByKeyType("bill_performance_url", SysDataService.WEB_APP, ""));
                httpRequestObject.setVersion("1.0");
                httpRequestObject.setAppCode("ai-credit");
                for (List<String> plist : phoneNumList){
                    httpRequestObject.setNumbers(plist);
                    httpRequestObject.setTimestamp((int) (System.currentTimeMillis() / 1000));
                    httpRequestObject.setMonth(billInstallment);//账单月份
                    httpRequestObject.setRequestMessage(JSON.toJSONString(httpRequestObject));

                    HttpRequestResult httpRequestResult = null;
                    try {
                        httpRequestResult = billPerformanceHttpRequestProcess.process(httpRequestContext);
                    } catch (BusinessException e) {
                        //异常处理
                        logger.error(e.getMessage(), e);

                    }

                    if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
                        HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
                        httpResponseObject = (BillPerformanceHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

                        if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                            List<BillPerformance> billPerformances = httpResponseObject.getBillPerformances();

                            //正常获取到接口返回数据
//                            for (BillPerformance billPerformance : billPerformances) {//billPerformance.getIsCredit():值Y/N
//                                String s = billPerformance.getPhoneNumber() + "  " + billPerformance.getIsCredit();
//                                System.out.println(s);
//                                try {
//                                    performanceServiceImpl.processPerformanceForTest(billPerformance.getPhoneNumber(), billPerformance.getIsCredit(), currentDate);
//                                }catch(Exception e){
//                                    logger.error("号码："+billPerformance.getPhoneNumber()+" 账期："+sdf.format(currentDate)+" 履约失败");
//                                }
//                            }

                        } else {

                            //失败处理
                        }

                    } else {
                        //失败处理
                    }

                }

            }


        } catch (Exception e) {
            logger.error("履约定时任务异常", e);
        }
        logger.error("履约定时任务结束：" + sdf.format(new Date()));
    }
    */
}

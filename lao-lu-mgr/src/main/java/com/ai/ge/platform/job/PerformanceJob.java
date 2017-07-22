package com.ai.ge.platform.job;


import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.model.order.PerformanceInfo;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.phonenum.PhoneNumService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.service.sys.SystemAreaService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.bill.response.BillPerformance;
import com.ai.ge.platform.serviceimpl.order.OrderServiceImpl;
import com.ai.ge.platform.serviceimpl.performance.PerformanceServiceImpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoaderListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 履约任务
 */
public class PerformanceJob implements Job
{

    /**
     * 日志记录器
     */
    private Logger logger = Logger.getLogger(PerformanceJob.class);

    private OrderServiceImpl orderServiceImpl  = ContextLoaderListener.getCurrentWebApplicationContext().getBean("orderServiceImpl", OrderServiceImpl.class);
    private SysDataService sysDataService  = ContextLoaderListener.getCurrentWebApplicationContext().getBean("sysDataService", SysDataService.class);
    private AbstractHttpRequestProcess crmOrderCompleteHttpRequestProcess = ContextLoaderListener.getCurrentWebApplicationContext().getBean("crmOrderCompleteHttpRequestProcess", AbstractHttpRequestProcess.class);
    private PerformanceServiceImpl performanceServiceImpl = ContextLoaderListener.getCurrentWebApplicationContext().getBean("performanceServiceImpl", PerformanceServiceImpl.class);
    private AbstractHttpRequestProcess billPerformanceHttpRequestProcess = ContextLoaderListener.getCurrentWebApplicationContext().getBean("billPerformanceHttpRequestProcess", AbstractHttpRequestProcess.class);
    private static Boolean executeLock = false;
    private PhoneNumService phoneNumService = ContextLoaderListener.getCurrentWebApplicationContext().getBean("phoneNumService", PhoneNumService.class);
    private SystemAreaService systemAreaService = ContextLoaderListener.getCurrentWebApplicationContext().getBean("systemAreaService", SystemAreaService.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");// 定时任务日志时间戳格式
        String billInstallment = sdf.format(new Date());

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("履约定时任务开始：" + sdf.format(new Date()));
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
                                    performanceServiceImpl.processPerformance(performanceInfo.getPerformanceCode(),"Y");
                                else
                                    performanceServiceImpl.processPerformance(performanceInfo.getPerformanceCode(),"N");
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
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");// 定时任务日志时间戳格式
        String billInstallment = sdf.format(new Date());

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("履约定时任务开始：" + sdf.format(new Date()));
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
                            for (BillPerformance billPerformance : billPerformances) {//billPerformance.getIsCredit():值Y/N
                                String s = billPerformance.getPhoneNumber() + "  " + billPerformance.getIsCredit();
                                System.out.println(s);
                                try {
                                    performanceServiceImpl.processPerformance(billPerformance.getPhoneNumber(),billPerformance.getIsCredit());
                                }catch(Exception e){
                                    logger.error("号码："+billPerformance.getPhoneNumber()+" 账期："+billInstallment+" 履约失败");
                                }
                            }

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




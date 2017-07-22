package com.ai.ge.platform.job;


import com.ai.ge.pay.weixin.wxpay.utils.MD5Util;
import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.order.OrderService;
import com.ai.ge.platform.service.performance.PerformanceService;
import com.ai.ge.platform.service.phonenum.PhoneNumService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.service.sys.SystemAreaService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.crm.response.CrmOrderComplete;
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

public class CrmCompleteJob implements Job
{

    /**
     * 日志记录器
     */
    private Logger logger = Logger.getLogger(CrmCompleteJob.class);

    private OrderService orderServiceImpl  = ContextLoaderListener.getCurrentWebApplicationContext().getBean("orderService", OrderService.class);
    private SysDataService sysDataService  = ContextLoaderListener.getCurrentWebApplicationContext().getBean("sysDataService", SysDataService.class);
    private AbstractHttpRequestProcess crmOrderCompleteHttpRequestProcess = ContextLoaderListener.getCurrentWebApplicationContext().getBean("crmOrderCompleteHttpRequestProcess", AbstractHttpRequestProcess.class);
    private PerformanceService performanceService = ContextLoaderListener.getCurrentWebApplicationContext().getBean("performanceService", PerformanceService.class);
    private PhoneNumService phoneNumService = ContextLoaderListener.getCurrentWebApplicationContext().getBean("phoneNumService", PhoneNumService.class);
    private SystemAreaService systemAreaService = ContextLoaderListener.getCurrentWebApplicationContext().getBean("systemAreaService", SystemAreaService.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("CRM竣工查询定时任务开始：" + sdf.format(new Date()));

        try
        {
            //查询待报竣状态订单
            List<Orders> orders = orderServiceImpl.findListByStatus(2);

            logger.debug("查询出"+orders.size()+"条等待报竣订单");
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
                    if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getPrivte_code())) {//报竣成功
                        CrmOrderComplete crmOrderComplete = httpResponseObject.getCrmOrderComplete();
                        //正常获取到接口返回数据
                        String s = crmOrderComplete.getPhoneNumber() + "  " + crmOrderComplete.getOlNbr();
                        logger.debug("报竣成功,接口返回:"+s);
                        performanceService.initPerformance(crmOrderComplete.getPhoneNumber(), crmOrderComplete.getOlNbr());
                    } else if ("".equals(httpResponseObject.getPrivte_code())){//报竣失败
                        CrmOrderComplete crmOrderComplete = httpResponseObject.getCrmOrderComplete();
                        //正常获取到接口返回数据
                        String s = crmOrderComplete.getPhoneNumber() + "  " + crmOrderComplete.getOlNbr();
                        logger.debug("报竣失败,接口返回:"+s);

                        Orders o = new Orders();
                        o.setOrderId(order.getOrderId());
                        o.setStatus(Short.parseShort("7"));//未竣工
                        o.setOlNbr(crmOrderComplete.getOlNbr());
                        record.setUpdateTime(new Date());
                        orderServiceImpl.updateOrders(o);
                    }else{
                        //未查到待报竣号码
                        logger.debug("未查到待报竣号码:"+telphone+" order:"+order.getOrderId());
                    }

                } else {
                    logger.error("报竣查询失败.order:"+order.getOrderId());
                }
            }

            logger.debug("CRM竣工查询定时任务结束：" + sdf.format(new Date()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("CRM竣工定时任务异常", e);
        }
    }

    /*
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定时任务日志时间戳格式
        logger.debug("CRM竣工查询定时任务开始：" + sdf.format(new Date()));

        try
        {
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
                    List<CrmOrderComplete> crmOrderCompletes = httpResponseObject.getCrmOrderCompletes();
                    logger.debug("本次查询CRM已报竣订单个数"+crmOrderCompletes.size());
                    List<String> crmOrderCompletePhone = new ArrayList<String>();
                    //正常获取到接口返回数据,遍历已激活号码
                    for (CrmOrderComplete crmOrderComplete : crmOrderCompletes) {
                        //                            String s = crmOrderComplete.getPhoneNumber() + "  " + crmOrderComplete.getOlNbr();
                        //                            crmOrderCompletePhone.add(crmOrderComplete.getPhoneNumber());
                        performanceService.initPerformance(crmOrderComplete.getPhoneNumber());
                    }
                }else{
                    logger.error("报竣查询失败");
                }
            }else{
                logger.error("报竣查询失败");
            }

            logger.debug("CRM竣工查询定时任务结束：" + sdf.format(new Date()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("CRM竣工定时任务异常", e);
        }
    }
*/
}

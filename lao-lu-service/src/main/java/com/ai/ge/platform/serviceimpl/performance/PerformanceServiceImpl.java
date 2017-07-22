package com.ai.ge.platform.serviceimpl.performance;

import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.mapper.order.*;
import com.ai.ge.platform.mapper.user.PlatformUserMapper;
import com.ai.ge.platform.model.order.*;
import com.ai.ge.platform.model.user.PlatformUser;
import com.ai.ge.platform.model.user.PlatformUserExample;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.performance.PerformanceService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.serviceimpl.exception.BusinessException;
import com.ai.ge.platform.serviceimpl.http.AbstractHttpRequestProcess;
import com.ai.ge.platform.serviceimpl.http.HttpRequestContext;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaSingleFeedbackHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.zhima.ZhimaSingleFeedbackHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.request.BatchFeedback;
import com.ai.ge.util.DateUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangying6 on 17/5/19.
 */
@Service
public class PerformanceServiceImpl implements PerformanceService
{
    /**
     * 日志记录器
     */
    private Logger logger = Logger.getLogger(PerformanceServiceImpl.class);

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private OfferSpecInfoMapper OfferSpecInfoMapper;

    @Resource
    private PerformanceInfoMapper performanceInfoMapper;

    @Resource
    private PerformanceLogMapper performanceLogMapper;

    @Resource
    private PlatformUserMapper platformUserMapper;

    @Resource
    private SysDataService sysDataService;

    @Resource(name = "zhimaSingleFeedbackHttpRequestProcess")
    private AbstractHttpRequestProcess zhimaSingleFeedbackHttpRequestProcess;

    @Resource
    private IntegrationRuleMapper integrationRuleMapper;

    @Resource
    private RedisSpringProxy redisService;

    /**
     * 计费出账日
     */
    private static String balanceDay = "5";
    /**
     * 平台履约日
     */
    private static String performanceDay = "9";
    /**
     * 根据报竣电话号码生成履约计划，生成第一期账单，成功后修改订单状态
     * @param telphone 报竣电话号码
     */
    @Override
    @Transactional
    public void initPerformance(String telphone,String olNbr) throws Exception{
        Orders order = null;
        OfferSpecInfo offerSpecInfo = null;
        PlatformUser platformUser = null;
        Date currentTime = new Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

        //根据电话获取订单
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andTelPhoneEqualTo(telphone).andStatusEqualTo(Short.parseShort("2"));
        List<Orders> orderses = ordersMapper.selectByExample(ordersExample);
        if(null==orderses||orderses.size()==0){
            logger.error("根据报竣电话号码生成履约计划失败:根据电话号码【"+telphone+"】查询不到订单");
            throw new Exception();
        }else
            order = orderses.get(0);
        //获得套餐
        offerSpecInfo = OfferSpecInfoMapper.selectByPrimaryKey(order.getOfferSpecId());
        //获得用户
        PlatformUserExample platformUserExample = new PlatformUserExample();
        platformUserExample.createCriteria().andAlipayUserIdEqualTo(order.getCustId().toString());
        List<PlatformUser> platformUsers = platformUserMapper.selectByExample(platformUserExample);
        if(null==platformUsers||platformUsers.size()==0){
            logger.error("获取用户信息失败:user_id【"+order.getCustId()+"】");
            throw new Exception();
        }else
            platformUser = platformUsers.get(0);

        //生成履约计划
        PerformanceInfo pi = new PerformanceInfo();
        pi.setOrderId(order.getOrderId());
        pi.setStatus(Short.parseShort("1"));//待履约
        pi.setPerformTimes(Short.parseShort("0"));//长期
        pi.setCompleteTimes(Short.parseShort("0"));
        pi.setOfferSpecId(order.getOfferSpecId());
        pi.setPerformanceCode(telphone);
        pi.setPerformanceMoney((new Long(offerSpecInfo.getRpmonth())).floatValue());
        pi.setProvinceAearId(order.getProvinceAearId());
        performanceInfoMapper.insertSelective(pi);
        //生成履约订单（履约日志订单初始化 order_status:3 bill_status:null）
        PerformanceLog pLog = createPerformanceLogToOrder(pi,currentTime,platformUser,order,offerSpecInfo);
        //订单创建传给芝麻信用
        BatchFeedback batchFeedback = createBatchFeedbackToOrder(currentTime,platformUser,order,offerSpecInfo,telphone);
        //反馈芝麻信用
        String transactionId = zhimaSingleFeedback(batchFeedback);
        if(null==transactionId){//反馈芝麻失败
            pLog.setIsSend(0L);
        }else{
            pLog.setIsSend(1L);
            pLog.setBillTransactionid(transactionId);
        }
        performanceLogMapper.insertSelective(pLog);
        //生成下期账单
        pLog = createPerformanceLogToNextBill(pi,currentTime,platformUser,order,offerSpecInfo);
        performanceLogMapper.insertSelective(pLog);
        //下期账单传递给芝麻信用
        batchFeedback = createBatchFeedbackToNextBill(currentTime,platformUser,order,offerSpecInfo,pLog,telphone);
        //反馈芝麻信用
        transactionId = zhimaSingleFeedback(batchFeedback);
        PerformanceLog pl= new PerformanceLog();
        pl.setOlId(pLog.getOlId());
        if(null==transactionId){//反馈芝麻失败
            pl.setIsSend(0L);
        }else{
            pl.setIsSend(1L);
            pl.setBillTransactionid(transactionId);
        }
        performanceLogMapper.updateByPrimaryKeySelective(pl);

        //更新订单状态
        Orders record = new Orders();
        record.setStatus(Short.parseShort("3"));//待发货
        record.setOlNbr(olNbr);
        record.setUpdateTime(new Date());
        OrdersExample example = new OrdersExample();
        example.createCriteria().andTelPhoneEqualTo(telphone);
        ordersMapper.updateByExampleSelective(record, example);
    }

    /**
     * 芝麻信用单条数据反馈服务接口
     * @return transactionId 返回流水，如果是null表示反馈失败
     */
    private String zhimaSingleFeedback(BatchFeedback batchFeedback){
        String transactionId = null;

        try{
            ZhimaSingleFeedbackHttpRequestObject httpRequestObject = new ZhimaSingleFeedbackHttpRequestObject();
            ZhimaSingleFeedbackHttpResponseObject httpResponseObject = new ZhimaSingleFeedbackHttpResponseObject();

            HttpRequestContext httpRequestContext = new HttpRequestContext(httpRequestObject, httpResponseObject);

            httpRequestObject.setActionName("单条数据反馈服务");
            String requestUri = sysDataService.getByKeyType("zhima_single_feedback_url", SysDataService.WEB_APP, "https://zmopenapi.zmxy.com.cn/openapi.do");
            httpRequestObject.setRequestUri(requestUri);


            transactionId = DateUtil.getStrFromDate(new Date(), "yyyyMMddhhmmssSSS") + RandomStringUtils.randomNumeric(13);
            //流水号，用来区别多次反馈同样的数据，流水号与反馈数据绑定
            httpRequestObject.setTransactionId(transactionId);
            httpRequestObject.setBatchFeedback(batchFeedback);

            HttpRequestResult httpRequestResult = null;
            try {
                httpRequestResult = zhimaSingleFeedbackHttpRequestProcess.process(httpRequestContext);

                if (HttpRequestResult.SUCCESS_CODE.equals(httpRequestResult.getResultCode())) {
                    HttpRequestContext httpRequestContextByResponse = httpRequestResult.getHttpRequestContext();
                    httpResponseObject = (ZhimaSingleFeedbackHttpResponseObject) httpRequestContextByResponse.getHttpResponseObject();

                    if (ObjectResult.SUCCESS_CODE.equals(httpResponseObject.getResultCode())) {
                        //正常数据反馈成功
                        System.out.println("单条数据反馈服务接口反馈成功");
                    } else {
                        transactionId = null;
                    }

                } else {
                    transactionId = null;
                }
            } catch (BusinessException e) {
                //异常处理
                transactionId = null;
                logger.error(e.getMessage(), e);
            }
        }catch(Exception e){
            transactionId = null;
        }

        return transactionId;
    }

    /**
     * 生成账期
     * 当前时间小于本月出账日，账期是本月出账日
     * 当前时间大于本月出账日，账期就是下月出账日
     * @param current 当前日期
     * @param balanceDay 每月计费平台结算日 5:每月5号
     * @param performanceDay 每月信用平台履约日 9:每月9号
     * @return
     */
    private String createPerformanceMonth(Date current,String balanceDay,String performanceDay){
        String rv = "";
        try {
            //当前月结算日
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
            String ym = dateFormater.format(current);
            Date thisMonthBillDate = dateFormater.parse(ym + "-" + balanceDay);

            if(current.getTime()>thisMonthBillDate.getTime()){//当前时间大于本月结算日,返回账期是下月履约账期
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(current);
                calendar.add(Calendar.MONTH,1);
                dateFormater = new SimpleDateFormat("yyyyMM");
                rv = dateFormater.format(calendar.getTime());
            }else{//返回账期为本月履约账期
                dateFormater = new SimpleDateFormat("yyyyMM");
                rv = dateFormater.format(current);
            }
        }catch (Exception e){
            logger.error("生成账期失败:current="+current.getTime()+",balanceDay="+balanceDay+",performanceDay="+performanceDay+e.getMessage(), e);
        }
        return rv;
    }

    /**
     * 生成账单应还款日
     * @param performanceMonth 账期 201601
     * @param balanceDay 每月计费平台结算日 5:每月5号
     * @return
     */
    private Date createBillLastDate(String performanceMonth,String balanceDay) {
        Date rv = null;
        try {
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
            Date ym = dateFormater.parse(performanceMonth);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(ym);
            calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(balanceDay));
            rv = calendar.getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public List<PerformanceInfo> findListByStatus(Short status)
    {
        PerformanceInfoExample example = new PerformanceInfoExample();
        example.createCriteria().andStatusEqualTo(status);
        return performanceInfoMapper.selectByExample(example);
    }

    /**
     * 履约
     * @param telphone 履约号码
     * @param isSuccess 是否履约 Y/N
     * @throws Exception
     */
    @Override
    @Transactional
    public void processPerformance(String telphone,String isSuccess) throws Exception{
        Orders order = null;
        OfferSpecInfo offerSpecInfo = null;
        PlatformUser platformUser = null;
        Date currentTime = new Date();
        //记录以往欠费个数,补缴完成后更新到履约表履约期数
        long ovdNum =0;
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

        try{
            //根据电话获取订单
            OrdersExample ordersExample = new OrdersExample();
            List<Short> sList = new ArrayList<Short>();
            sList.add(Short.parseShort("3"));
            sList.add(Short.parseShort("4"));
            sList.add(Short.parseShort("5"));
            ordersExample.createCriteria().andTelPhoneEqualTo(telphone).andStatusIn(sList);
            List<Orders> orderses = ordersMapper.selectByExample(ordersExample);
            if(null==orderses||orderses.size()==0){
                logger.error("根据报竣电话号码生成履约计划失败:根据电话号码【"+telphone+"】查询不到订单");
                throw new Exception();
            }else
                order = orderses.get(0);
            //获得套餐
            offerSpecInfo = OfferSpecInfoMapper.selectByPrimaryKey(order.getOfferSpecId());
            //获得用户
            PlatformUserExample platformUserExample = new PlatformUserExample();
            platformUserExample.createCriteria().andAlipayUserIdEqualTo(order.getCustId().toString());
            List<PlatformUser> platformUsers = platformUserMapper.selectByExample(platformUserExample);
            if(null==platformUsers||platformUsers.size()==0){
                logger.error("获取用户信息失败:user_id【"+order.getCustId()+"】");
                throw new Exception();
            }else
                platformUser = platformUsers.get(0);

            PerformanceInfo pi =null;
            PerformanceInfoExample performanceInfoExample = new PerformanceInfoExample();
            performanceInfoExample.createCriteria().andPerformanceCodeEqualTo(telphone);
            List<PerformanceInfo> performanceInfos = performanceInfoMapper.selectByExample(performanceInfoExample);
            if(performanceInfos.size()>0)
                pi = performanceInfos.get(0);
            else{
                logger.error("获取履约计划失败:telphone【"+telphone+"】");
                throw new Exception();
            }

            //判断是否存在本期账单，不存在账单则不进行履约
            //本月账期时间
            String performanceMonth = dateFormater.format(currentTime);
            PerformanceLogExample example = new PerformanceLogExample();
            example.createCriteria().andOrderIdEqualTo(order.getOrderId()).
                    andOfferSpecIdEqualTo(offerSpecInfo.getOfferSpecId()).
                    andPerformanceStatusEqualTo(0L).
                    andPerformanceIdEqualTo(pi.getPerformanceId()).
                    andOrderStatusEqualTo(Short.parseShort("0")).andPerformanceMonthEqualTo(performanceMonth);
            if(performanceLogMapper.selectByExample(example).size()==0){
                logger.error("未发现本期账单:【order.getOrderId()="+order.getOrderId()+"】"+"【offerSpecInfo.getOfferSpecId()="+offerSpecInfo.getOfferSpecId()+"】"
                        +"【pi.getPerformanceId()="+pi.getPerformanceId()+"】"+"【performanceMonth="+performanceMonth+"】"
                        +"【PerformanceStatus=0】"+"【OrderStatus=0】");
                throw new Exception();
            }

            //生成本次履约日志
            if(isSuccess.equalsIgnoreCase("N")){//履约失败,记录履约日志发送信用接口
                //生成本期欠费履约日志
                PerformanceLog pLog = createPerformanceLogToOvdBill(pi,currentTime,platformUser,order,offerSpecInfo);
                performanceLogMapper.insertSelective(pLog);
                //反馈芝麻信用
                String transactionId = zhimaSingleFeedback(createBatchFeedbackToOvdBill(currentTime,platformUser,order,offerSpecInfo,pLog,telphone));
                PerformanceLog pl= new PerformanceLog();
                pl.setOlId(pLog.getOlId());
                if(null==transactionId){//反馈芝麻失败
                    pl.setIsSend(0L);
                }else{
                    pl.setIsSend(1L);
                    pl.setBillTransactionid(transactionId);
                }
                performanceLogMapper.updateByPrimaryKeySelective(pl);
            }else{//履约成功,处理以前的履约失败记录
                //本期成功
                PerformanceLog pLog = createPerformanceLogToRegularBill(pi, currentTime, platformUser, order, offerSpecInfo);
                performanceLogMapper.insertSelective(pLog);
                //反馈芝麻信用
                String transactionId = zhimaSingleFeedback(createBatchFeedbackToRegularBill(currentTime, platformUser, order, offerSpecInfo, pLog, telphone));
                PerformanceLog pl= new PerformanceLog();
                pl.setOlId(pLog.getOlId());
                if(null==transactionId){//反馈芝麻失败
                    pl.setIsSend(0L);
                }else{
                    pl.setIsSend(1L);
                    pl.setBillTransactionid(transactionId);
                }
                performanceLogMapper.updateByPrimaryKeySelective(pl);

                //回溯往期未成功改为成功,查询以往违约的订单
                PerformanceLogExample performanceLogExample = new PerformanceLogExample();
                performanceLogExample.createCriteria().andPerformanceIdEqualTo(pi.getPerformanceId()).
                                                       andOrderSeqEqualTo(order.getOrderSeq()).
                                                       andOrderStatusEqualTo(Short.parseShort("1")).
                                                       andPerformanceStatusEqualTo(1L).andBillPayoffStatusEqualTo(Short.parseShort("1"));;
                List<PerformanceLog> ovdPerformanceLog = performanceLogMapper.selectByExample(performanceLogExample);

                for(PerformanceLog ovdPl : ovdPerformanceLog){
                    ovdNum++;
                    //补缴成功
                    PerformanceLog ovdLog = createPerformanceLogToPayOffBill(ovdPl,currentTime);
                    performanceLogMapper.insertSelective(ovdLog);
                    //修改欠费条目缴费状态 BILL_PAYOFF_STATUS 0:目前不欠费  1:目前欠费待补缴
                    ovdPl.setBillPayoffStatus(Short.parseShort("0"));
                    performanceLogMapper.updateByPrimaryKeySelective(ovdPl);
                    //反馈芝麻信用
                    transactionId = zhimaSingleFeedback(createBatchFeedbackToPayOffBill(currentTime,platformUser,order,offerSpecInfo,ovdLog,telphone));
                    pl= new PerformanceLog();
                    pl.setOlId(ovdLog.getOlId());
                    if(null==transactionId){//反馈芝麻失败
                        pl.setIsSend(0L);
                    }else{
                        pl.setIsSend(1L);
                        pl.setBillTransactionid(transactionId);
                    }
                    performanceLogMapper.updateByPrimaryKeySelective(pl);
                }
                logger.debug("补缴往期个数:"+ovdNum);
            }

            //生成下期账单
            PerformanceLog pLog = createPerformanceLogToNextBill(pi,currentTime,platformUser,order,offerSpecInfo);
            performanceLogMapper.insertSelective(pLog);
            //下期账单传递给芝麻信用
            //反馈芝麻信用
            String transactionId = zhimaSingleFeedback(createBatchFeedbackToNextBill(currentTime,platformUser,order,offerSpecInfo,pLog,telphone));
            PerformanceLog pl= new PerformanceLog();
            pl.setOlId(pLog.getOlId());
            if(null==transactionId){//反馈芝麻失败
                pl.setIsSend(0L);
            }else{
                pl.setIsSend(1L);
                pl.setBillTransactionid(transactionId);
            }
            performanceLogMapper.updateByPrimaryKeySelective(pl);

            //更新订单履约期数和已履约期数
            //履约期数:本期:1+补缴完成往期个数:ovdNum
            pi.setPerformTimes(Short.parseShort(""+(pi.getPerformTimes()+1)));
            if(isSuccess.equalsIgnoreCase("Y"))
                pi.setCompleteTimes(Short.parseShort(""+(pi.getCompleteTimes()+1+ovdNum)));
            performanceInfoMapper.updateByPrimaryKeySelective(pi);

        }catch (Exception e){
            e.printStackTrace();;
            throw e;
        }
    }

    /**
     * 履约 (测试用 模拟定时器触发月份)
     * @param telphone 履约号码
     * @param isSuccess 是否履约 Y/N
     * @throws Exception
     */
    @Override
    @Transactional
    public void processPerformanceForTest(String telphone,String isSuccess,Date currentDate) throws Exception{
        Orders order = null;
        OfferSpecInfo offerSpecInfo = null;
        PlatformUser platformUser = null;
        Date currentTime = currentDate;
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
        //记录以往欠费个数,补缴完成后更新到履约表履约期数
        long ovdNum =0;

        try{
            //根据电话获取订单
            OrdersExample ordersExample = new OrdersExample();
            List<Short> sList = new ArrayList<Short>();
            sList.add(Short.parseShort("3"));
            sList.add(Short.parseShort("4"));
            sList.add(Short.parseShort("5"));
            ordersExample.createCriteria().andTelPhoneEqualTo(telphone).andStatusIn(sList);
            List<Orders> orderses = ordersMapper.selectByExample(ordersExample);
            if(null==orderses||orderses.size()==0){
                logger.error("根据报竣电话号码生成履约计划失败:根据电话号码【"+telphone+"】查询不到订单");
                throw new Exception();
            }else
                order = orderses.get(0);
            //获得套餐
            offerSpecInfo = OfferSpecInfoMapper.selectByPrimaryKey(order.getOfferSpecId());
            //获得用户
            PlatformUserExample platformUserExample = new PlatformUserExample();
            platformUserExample.createCriteria().andAlipayUserIdEqualTo(order.getCustId().toString());
            List<PlatformUser> platformUsers = platformUserMapper.selectByExample(platformUserExample);
            if(null==platformUsers||platformUsers.size()==0){
                logger.error("获取用户信息失败:user_id【"+order.getCustId()+"】");
                throw new Exception();
            }else
                platformUser = platformUsers.get(0);

            PerformanceInfo pi =null;
            PerformanceInfoExample performanceInfoExample = new PerformanceInfoExample();
            performanceInfoExample.createCriteria().andPerformanceCodeEqualTo(telphone);
            List<PerformanceInfo> performanceInfos = performanceInfoMapper.selectByExample(performanceInfoExample);
            if(performanceInfos.size()>0)
                pi = performanceInfos.get(0);
            else{
                logger.error("获取履约计划失败:telphone【"+telphone+"】");
                throw new Exception();
            }

            //判断是否存在本期账单，不存在账单则不进行履约
            //本月账期时间
            String performanceMonth = dateFormater.format(currentTime);
            PerformanceLogExample example = new PerformanceLogExample();
            example.createCriteria().andOrderIdEqualTo(order.getOrderId()).
                                     andOfferSpecIdEqualTo(offerSpecInfo.getOfferSpecId()).
                                     andPerformanceStatusEqualTo(0L).
                                     andPerformanceIdEqualTo(pi.getPerformanceId()).
                                     andOrderStatusEqualTo(Short.parseShort("0")).andPerformanceMonthEqualTo(performanceMonth);
            if(performanceLogMapper.selectByExample(example).size()==0){
                logger.error("未发现本期账单:【order.getOrderId()="+order.getOrderId()+"】"+"【offerSpecInfo.getOfferSpecId()="+offerSpecInfo.getOfferSpecId()+"】"
                        +"【pi.getPerformanceId()="+pi.getPerformanceId()+"】"+"【performanceMonth="+performanceMonth+"】"
                        +"【PerformanceStatus=0】"+"【OrderStatus=0】");
                throw new Exception();
            }


            //生成本次履约日志
            if(isSuccess.equalsIgnoreCase("N")){//履约失败,记录履约日志发送信用接口

                //生成本期欠费履约日志
                PerformanceLog pLog = createPerformanceLogToOvdBill(pi,currentTime,platformUser,order,offerSpecInfo);
                performanceLogMapper.insertSelective(pLog);
                //反馈芝麻信用
                String transactionId = zhimaSingleFeedback(createBatchFeedbackToOvdBill(currentTime,platformUser,order,offerSpecInfo,pLog,telphone));
                PerformanceLog pl= new PerformanceLog();
                pl.setOlId(pLog.getOlId());
                if(null==transactionId){//反馈芝麻失败
                    pl.setIsSend(0L);
                }else{
                    pl.setIsSend(1L);
                    pl.setBillTransactionid(transactionId);
                }
                performanceLogMapper.updateByPrimaryKeySelective(pl);
            }else{//履约成功,处理以前的履约失败记录
                //本期成功
                PerformanceLog pLog = createPerformanceLogToRegularBill(pi, currentTime, platformUser, order, offerSpecInfo);
                performanceLogMapper.insertSelective(pLog);
                //反馈芝麻信用
                String transactionId = zhimaSingleFeedback(createBatchFeedbackToRegularBill(currentTime, platformUser, order, offerSpecInfo, pLog, telphone));
                PerformanceLog pl= new PerformanceLog();
                pl.setOlId(pLog.getOlId());
                if(null==transactionId){//反馈芝麻失败
                    pl.setIsSend(0L);
                }else{
                    pl.setIsSend(1L);
                    pl.setBillTransactionid(transactionId);
                }
                performanceLogMapper.updateByPrimaryKeySelective(pl);

                //回溯往期未成功改为成功,查询以往违约的订单
                PerformanceLogExample performanceLogExample = new PerformanceLogExample();
                performanceLogExample.createCriteria().andPerformanceIdEqualTo(pi.getPerformanceId()).
                        andOrderSeqEqualTo(order.getOrderSeq()).
                        andOrderStatusEqualTo(Short.parseShort("1")).
                        andPerformanceStatusEqualTo(1L).andBillPayoffStatusEqualTo(Short.parseShort("1"));
                List<PerformanceLog> ovdPerformanceLog = performanceLogMapper.selectByExample(performanceLogExample);

                for(PerformanceLog ovdPl : ovdPerformanceLog){
                    ovdNum++;
                    //补缴成功
                    PerformanceLog ovdLog = createPerformanceLogToPayOffBill(ovdPl,currentTime);
                    performanceLogMapper.insertSelective(ovdLog);
                    //修改欠费条目缴费状态 BILL_PAYOFF_STATUS 0:目前不欠费  1:目前欠费待补缴
                    ovdPl.setBillPayoffStatus(Short.parseShort("0"));
                    performanceLogMapper.updateByPrimaryKeySelective(ovdPl);
                    //反馈芝麻信用
                    transactionId = zhimaSingleFeedback(createBatchFeedbackToPayOffBill(currentTime,platformUser,order,offerSpecInfo,ovdLog,telphone));
                    pl= new PerformanceLog();
                    pl.setOlId(ovdLog.getOlId());
                    if(null==transactionId){//反馈芝麻失败
                        pl.setIsSend(0L);
                    }else{
                        pl.setIsSend(1L);
                        pl.setBillTransactionid(transactionId);
                    }
                    performanceLogMapper.updateByPrimaryKeySelective(pl);
                }
                logger.debug("补缴往期个数:"+ovdNum);
            }

            //生成下期账单
            PerformanceLog pLog = createPerformanceLogToNextBill(pi,currentTime,platformUser,order,offerSpecInfo);
            performanceLogMapper.insertSelective(pLog);
            //下期账单传递给芝麻信用
            //反馈芝麻信用
            String transactionId = zhimaSingleFeedback(createBatchFeedbackToNextBill(currentTime,platformUser,order,offerSpecInfo,pLog,telphone));
            PerformanceLog pl= new PerformanceLog();
            pl.setOlId(pLog.getOlId());
            if(null==transactionId){//反馈芝麻失败
                pl.setIsSend(0L);
            }else{
                pl.setIsSend(1L);
                pl.setBillTransactionid(transactionId);
            }
            performanceLogMapper.updateByPrimaryKeySelective(pl);

            //更新订单履约期数和已履约期数
            //履约期数:本期:1+补缴完成往期个数:ovdNum
            pi.setPerformTimes(Short.parseShort(""+(pi.getPerformTimes()+1)));
            if(isSuccess.equalsIgnoreCase("Y"))
                pi.setCompleteTimes(Short.parseShort(""+(pi.getCompleteTimes()+1+ovdNum)));
            performanceInfoMapper.updateByPrimaryKeySelective(pi);

        }catch (Exception e){
            e.printStackTrace();;
            throw e;
        }
    }

    /**
     * 芝麻接口生成订单反馈数据
     * @return
     */
    private BatchFeedback createBatchFeedbackToOrder(Date currentTime,
                                                   PlatformUser platformUser,
                                                   Orders order,
                                                   OfferSpecInfo offerSpecInfo,
                                                   String telphone){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        BatchFeedback batchFeedback = new BatchFeedback();
        batchFeedback.setBizDate(dateFormater.format(currentTime));
        batchFeedback.setUserCredentialsType(order.getCertTypeValue());
        batchFeedback.setUserCredentialsNo(order.getCertNo());
        batchFeedback.setUserName(platformUser.getRealName());
        batchFeedback.setOrderNo(order.getOrderSeq());
        batchFeedback.setPhoneNo(telphone);
        batchFeedback.setOrderStartDate(dateFormater.format(offerSpecInfo.getAppStartDt()));
        batchFeedback.setOrderEndDate(dateFormater.format(offerSpecInfo.getAppEndDt()));
        batchFeedback.setOrderStatus("3");
        return batchFeedback;
    }

    /**
     * 芝麻接口生成下期账单反馈数据
     * @return
     */
    private BatchFeedback createBatchFeedbackToNextBill(Date currentTime,
                                                     PlatformUser platformUser,
                                                     Orders order,
                                                     OfferSpecInfo offerSpecInfo, PerformanceLog   pLog,
                                                     String telphone){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        BatchFeedback batchFeedback = new BatchFeedback();
        batchFeedback.setBizDate(dateFormater.format(currentTime));
        batchFeedback.setUserCredentialsType(order.getCertTypeValue());
        batchFeedback.setUserCredentialsNo(order.getCertNo());
        batchFeedback.setUserName(platformUser.getRealName());
        batchFeedback.setOrderNo(order.getOrderSeq());
        batchFeedback.setPhoneNo(telphone);
        batchFeedback.setOrderStartDate(dateFormater.format(offerSpecInfo.getAppStartDt()));
        batchFeedback.setOrderEndDate(dateFormater.format(offerSpecInfo.getAppEndDt()));
        batchFeedback.setOrderStatus("0");
        batchFeedback.setBillNo(pLog.getOlId().toString());
        batchFeedback.setBillInstallment(pLog.getPerformanceMonth());
        batchFeedback.setBillDesc("账单");
        batchFeedback.setBillType("111");
        batchFeedback.setBillAmt(pLog.getPerformanceMoney().toString());
        batchFeedback.setBillLastDate(dateFormater.format(pLog.getBillLastDate()));
        batchFeedback.setBillStatus(pLog.getPerformanceStatus().toString());
        return batchFeedback;
    }

    /**
     * 芝麻接口生成本期账单违约反馈数据
     * @return
     */
    private BatchFeedback createBatchFeedbackToOvdBill(Date currentTime,
                                                        PlatformUser platformUser,
                                                        Orders order,
                                                        OfferSpecInfo offerSpecInfo, PerformanceLog   pLog,
                                                        String telphone){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        BatchFeedback batchFeedback = new BatchFeedback();
        batchFeedback.setBizDate(dateFormater.format(currentTime));
        batchFeedback.setUserCredentialsType(order.getCertTypeValue());
        batchFeedback.setUserCredentialsNo(order.getCertNo());
        batchFeedback.setUserName(platformUser.getRealName());
        batchFeedback.setOrderNo(order.getOrderSeq());
        batchFeedback.setPhoneNo(telphone);
        batchFeedback.setOrderStartDate(dateFormater.format(offerSpecInfo.getAppStartDt()));
        batchFeedback.setOrderEndDate(dateFormater.format(offerSpecInfo.getAppEndDt()));
        batchFeedback.setOrderStatus("1");//欠费
        batchFeedback.setBillNo(pLog.getOlId().toString());
        batchFeedback.setBillInstallment(pLog.getPerformanceMonth());
        batchFeedback.setBillDesc("账单");
        batchFeedback.setBillType("111");
        batchFeedback.setBillAmt(pLog.getPerformanceMoney().toString());
        batchFeedback.setBillLastDate(dateFormater.format(pLog.getBillLastDate()));
        batchFeedback.setBillStatus(pLog.getPerformanceStatus().toString());
        batchFeedback.setBillTypeOvdAmt(offerSpecInfo.getRpmonth().toString());//违约金
        batchFeedback.setBillTypeOvdDate(dateFormater.format(pLog.getBillTypeOvdDate()));
        return batchFeedback;
    }

    /**
     * 芝麻接口生成本期账单正常履约反馈数据
     * @return
     */
    private BatchFeedback createBatchFeedbackToRegularBill(Date currentTime,
                                                       PlatformUser platformUser,
                                                       Orders order,
                                                       OfferSpecInfo offerSpecInfo, PerformanceLog   pLog,
                                                       String telphone){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        BatchFeedback batchFeedback = new BatchFeedback();
        batchFeedback.setBizDate(dateFormater.format(currentTime));
        batchFeedback.setUserCredentialsType(order.getCertTypeValue());
        batchFeedback.setUserCredentialsNo(order.getCertNo());
        batchFeedback.setUserName(platformUser.getRealName());
        batchFeedback.setOrderNo(order.getOrderSeq());
        batchFeedback.setPhoneNo(telphone);
        batchFeedback.setOrderStartDate(dateFormater.format(offerSpecInfo.getAppStartDt()));
        batchFeedback.setOrderEndDate(dateFormater.format(offerSpecInfo.getAppEndDt()));
        batchFeedback.setOrderStatus("0");//订单状态正常
        batchFeedback.setBillNo(pLog.getOlId().toString());
        batchFeedback.setBillInstallment(pLog.getPerformanceMonth());
        batchFeedback.setBillDesc("账单");
        batchFeedback.setBillType("111");
        batchFeedback.setBillAmt("0");
        batchFeedback.setBillLastDate(dateFormater.format(pLog.getBillLastDate()));
        batchFeedback.setBillStatus("2");
        batchFeedback.setBillPayoffDate(dateFormater.format(pLog.getBillLastDate()));
        return batchFeedback;
    }

    /**
     * 芝麻接口生成补缴完成账单反馈数据
     * @return
     */
    private BatchFeedback createBatchFeedbackToPayOffBill(Date currentTime,
                                                           PlatformUser platformUser,
                                                           Orders order,
                                                           OfferSpecInfo offerSpecInfo, PerformanceLog   pLog,
                                                           String telphone){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        BatchFeedback batchFeedback = new BatchFeedback();
        batchFeedback.setBizDate(dateFormater.format(currentTime));
        batchFeedback.setUserCredentialsType(order.getCertTypeValue());
        batchFeedback.setUserCredentialsNo(order.getCertNo());
        batchFeedback.setUserName(platformUser.getRealName());
        batchFeedback.setOrderNo(order.getOrderSeq());
        batchFeedback.setPhoneNo(telphone);
        batchFeedback.setOrderStartDate(dateFormater.format(offerSpecInfo.getAppStartDt()));
        batchFeedback.setOrderEndDate(dateFormater.format(offerSpecInfo.getAppEndDt()));
        batchFeedback.setOrderStatus("0");//订单状态正常
        batchFeedback.setBillNo(pLog.getOlId().toString());
        batchFeedback.setBillInstallment(pLog.getPerformanceMonth());
        batchFeedback.setBillDesc("账单");
        batchFeedback.setBillType("111");
        batchFeedback.setBillAmt("0");
        batchFeedback.setBillLastDate(dateFormater.format(pLog.getBillLastDate()));
        batchFeedback.setBillStatus("2");//缴清
        batchFeedback.setBillPayoffDate(createPerformanceMonth(currentTime,
                                                                PerformanceServiceImpl.balanceDay,
                                                                PerformanceServiceImpl.performanceDay)
                                        );//当做是本期计费日还款
        return batchFeedback;
    }

    /**
     * 履约日志表生成订单日志
     * @return
     */
    private PerformanceLog createPerformanceLogToOrder(PerformanceInfo pi,
                                                       Date currentTime,
                                                       PlatformUser platformUser,
                                                       Orders order,
                                                       OfferSpecInfo offerSpecInfo){
        PerformanceLog pLog = new PerformanceLog();
        pLog.setPerformanceId(pi.getPerformanceId());
        pLog.setOrderId(order.getOrderId());
        pLog.setPerformanceMoney(offerSpecInfo.getRpmonth());
        pLog.setCrateTime(currentTime);
        pLog.setIsSend(0L);
        pLog.setBizDate(currentTime);
        pLog.setUserCredentialsType(Short.parseShort(platformUser.getCertTypeValue()));
        pLog.setCustId(order.getCustId());
        pLog.setOrderSeq(order.getOrderSeq());
        pLog.setOfferSpecId(order.getOfferSpecId());
        pLog.setOrderStatus(Short.parseShort("3"));
        pLog.setBillDesc("订单");
        pLog.setBillMemo("创建订单【"+order.getOrderSeq()+"】");
        return pLog;
    }

    /**
     * 履约日志表生成下期账单日志
     * @return
     */
    private PerformanceLog createPerformanceLogToNextBill(PerformanceInfo pi,
                                                          Date currentTime,
                                                          PlatformUser platformUser,
                                                          Orders order,
                                                          OfferSpecInfo offerSpecInfo){
        PerformanceLog pLog = new PerformanceLog();
        pLog.setPerformanceId(pi.getPerformanceId());
        pLog.setOrderId(order.getOrderId());
        pLog.setPerformanceMoney(offerSpecInfo.getRpmonth());
        pLog.setPerformanceStatus(0L);//账单状态 对应芝麻接口bill_status
        pLog.setPerformanceMonth(createPerformanceMonth(currentTime,this.balanceDay,this.performanceDay));//201601
        pLog.setCrateTime(currentTime);
        pLog.setIsSend(0L);
        pLog.setBizDate(currentTime);
        pLog.setUserCredentialsType(Short.parseShort(platformUser.getCertTypeValue()));
        pLog.setCustId(order.getCustId());
        pLog.setOrderSeq(order.getOrderSeq());
        pLog.setOfferSpecId(order.getOfferSpecId());
        pLog.setOrderStatus(Short.parseShort("0"));
        pLog.setBillDesc("账单");
        pLog.setBillLastDate(createBillLastDate(pLog.getPerformanceMonth(),this.balanceDay));//最迟还款日 下个计费日期Date 2016-02-05
        pLog.setBillType("111");
        pLog.setBillMemo("创建账单【账期:"+pLog.getPerformanceMonth()+"】");
        return pLog;
    }

    /**
     * 履约日志表生成本期账单违约日志
     * @return
     */
    private PerformanceLog createPerformanceLogToOvdBill(PerformanceInfo pi,
                                                         Date currentTime,
                                                         PlatformUser platformUser,
                                                         Orders order,
                                                         OfferSpecInfo offerSpecInfo){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
        PerformanceLog pLog = new PerformanceLog();
        pLog.setPerformanceId(pi.getPerformanceId());
        pLog.setOrderId(order.getOrderId());
        pLog.setPerformanceMoney(offerSpecInfo.getRpmonth());
        pLog.setPerformanceStatus(1L);//账单状态 对应芝麻接口bill_status
        pLog.setPerformanceMonth(dateFormater.format(currentTime));//履约当前时间对应月份201601
        pLog.setCrateTime(currentTime);
        pLog.setIsSend(0L);
        pLog.setBizDate(currentTime);
        pLog.setUserCredentialsType(Short.parseShort(platformUser.getCertTypeValue()));
        pLog.setCustId(order.getCustId());
        pLog.setOrderSeq(order.getOrderSeq());
        pLog.setOfferSpecId(order.getOfferSpecId());
        pLog.setOrderStatus(Short.parseShort("1"));
        pLog.setBillDesc("账单");
        pLog.setBillType("111");
        pLog.setBillLastDate(createBillLastDate(pLog.getPerformanceMonth(),this.balanceDay));//Date 2016-02-05 当月出账日
        pLog.setBillTypeOvdAmt(offerSpecInfo.getRpmonth());//违约金额
        pLog.setBillTypeOvdDate(createBillLastDate(pLog.getPerformanceMonth(),this.balanceDay));//违约开始日期，当月出账日
        pLog.setBillMemo("欠费【账期:"+pLog.getPerformanceMonth()+"】");
        pLog.setBillPayoffStatus(Short.parseShort("1"));
        return pLog;
    }

    /**
     * 履约日志表生成本期账单履约成功日志
     * @return
     */
    private PerformanceLog createPerformanceLogToRegularBill(PerformanceInfo pi,
                                                         Date currentTime,
                                                         PlatformUser platformUser,
                                                         Orders order,
                                                         OfferSpecInfo offerSpecInfo){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
        PerformanceLog pLog = new PerformanceLog();
        pLog.setPerformanceId(pi.getPerformanceId());
        pLog.setOrderId(order.getOrderId());
        pLog.setPerformanceMoney(0L);//成功账单金额写0
        pLog.setPerformanceStatus(2L);//账单状态 对应芝麻接口bill_status 2
        pLog.setPerformanceMonth(dateFormater.format(currentTime));//履约当前时间对应月份201601
        pLog.setCrateTime(currentTime);
        pLog.setIsSend(0L);
        pLog.setBizDate(currentTime);
        pLog.setUserCredentialsType(Short.parseShort(platformUser.getCertTypeValue()));
        pLog.setCustId(order.getCustId());
        pLog.setOrderSeq(order.getOrderSeq());
        pLog.setOfferSpecId(order.getOfferSpecId());
        pLog.setOrderStatus(Short.parseShort("0"));
        pLog.setBillDesc("账单");
        pLog.setBillType("111");
        pLog.setBillLastDate(createBillLastDate(pLog.getPerformanceMonth(),this.balanceDay));//Date 2016-02-05 当月出账日
        pLog.setBillPayoffDate(createBillLastDate(pLog.getPerformanceMonth(), this.balanceDay));//Date 2016-02-05 当月出账日
        pLog.setBillMemo("已履约【账期:"+pLog.getPerformanceMonth()+"】");
        return pLog;
    }

    /**
     * 履约日志表生成补缴账单履约日志
     * @return
     */
    private PerformanceLog createPerformanceLogToPayOffBill(PerformanceLog oldPerformanceLog,
                                                             Date currentTime){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
        PerformanceLog pLog = new PerformanceLog();
        pLog.setPerformanceId(oldPerformanceLog.getPerformanceId());
        pLog.setOrderId(oldPerformanceLog.getOrderId());
        pLog.setPerformanceStatus(2L);//账单状态 对应芝麻接口bill_status 2
        pLog.setPerformanceMonth(oldPerformanceLog.getPerformanceMonth());//201601
        pLog.setCrateTime(currentTime);
        pLog.setIsSend(0L);
        pLog.setPerformanceMoney(0L);
        pLog.setBizDate(currentTime);
        pLog.setUserCredentialsType(oldPerformanceLog.getUserCredentialsType());
        pLog.setCustId(oldPerformanceLog.getCustId());
        pLog.setOrderSeq(oldPerformanceLog.getOrderSeq());
        pLog.setOfferSpecId(oldPerformanceLog.getOfferSpecId());
        pLog.setOrderStatus(Short.parseShort("0"));
        pLog.setBillDesc("账单");
        pLog.setBillType("111");
        pLog.setBillLastDate(oldPerformanceLog.getBillLastDate());//与上一条记录的应还日期一致
        pLog.setBillPayoffDate(createBillLastDate(dateFormater.format(currentTime),this.balanceDay));//Date 2016-02-05 当月出账日
        pLog.setBillMemo("已补缴【账期:"+pLog.getPerformanceMonth()+"】");
        return pLog;
    }

    @Override
    public int synchronizePerformance(){
        int rv =0;
        try{
            PerformanceLogExample performanceLogExample = new PerformanceLogExample();
            performanceLogExample.createCriteria().andIsSendEqualTo(0L);
            List<PerformanceLog> logs = performanceLogMapper.selectByExample(performanceLogExample);
            logger.debug("发现"+logs.size()+"条履约日志需要进行同步");

            for(PerformanceLog pl : logs){
                try {
                    //获得用户
                    PlatformUser platformUser;
                    PlatformUserExample platformUserExample = new PlatformUserExample();
                    platformUserExample.createCriteria().andAlipayUserIdEqualTo(pl.getCustId().toString());
                    List<PlatformUser> platformUsers = platformUserMapper.selectByExample(platformUserExample);
                    if (null == platformUsers || platformUsers.size() == 0) {
                        logger.error("获取用户信息失败:user_id【" + pl.getCustId() + "】");
                        throw new Exception();
                    } else
                        platformUser = platformUsers.get(0);

                    Orders order = ordersMapper.selectByPrimaryKey(pl.getOrderId());
                    //获得套餐
                    OfferSpecInfo offerSpecInfo = OfferSpecInfoMapper.selectByPrimaryKey(order.getOfferSpecId());

                    SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
                    BatchFeedback batchFeedback = new BatchFeedback();
                    batchFeedback.setBizDate(dateFormater.format(pl.getBizDate()));
                    batchFeedback.setUserCredentialsType(pl.getUserCredentialsType() != null ? pl.getUserCredentialsType().toString() : "0");
                    batchFeedback.setUserCredentialsNo(platformUser.getCertTypeValue());
                    batchFeedback.setUserName(platformUser.getRealName());
                    batchFeedback.setOrderNo(pl.getOrderSeq());
                    batchFeedback.setPhoneNo(order.getTelPhone());
                    batchFeedback.setOrderStartDate(dateFormater.format(offerSpecInfo.getAppStartDt()));
                    batchFeedback.setOrderEndDate(dateFormater.format(offerSpecInfo.getAppEndDt()));
                    batchFeedback.setOrderStatus(pl.getOrderStatus() != null ? pl.getOrderStatus().toString() : "");
                    batchFeedback.setBillNo(pl.getOlId().toString());
                    batchFeedback.setBillInstallment(pl.getPerformanceMonth());
                    batchFeedback.setBillDesc(pl.getBillDesc());
                    batchFeedback.setBillType(pl.getBillType());
                    batchFeedback.setBillAmt(null != pl.getPerformanceMoney() ? pl.getPerformanceMoney().toString() : "");
                    batchFeedback.setBillLastDate(null != pl.getBillLastDate() ? dateFormater.format(pl.getBillLastDate()) : "");
                    batchFeedback.setBillStatus(pl.getPerformanceStatus() != null ? pl.getPerformanceStatus().toString() : "");
                    batchFeedback.setBillPayoffDate(null != pl.getBillLastDate() ? dateFormater.format(pl.getBillLastDate()) : "");
                    batchFeedback.setBillTypeOvdAmt(null != pl.getBillTypeOvdAmt() ? pl.getBillTypeOvdAmt().toString() : "");
                    batchFeedback.setBillTypeOvdDate(null != pl.getBillTypeOvdDate() ? dateFormater.format(pl.getBillTypeOvdDate()) : "");

                    String transactionId = zhimaSingleFeedback(batchFeedback);
                    if(null!=transactionId){//更新日志状态
                        PerformanceLog plog= new PerformanceLog();
                        plog.setOlId(pl.getOlId());
                        plog.setIsSend(1L);
                        plog.setBillTransactionid(transactionId);
                        performanceLogMapper.updateByPrimaryKeySelective(plog);
                        rv++;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    logger.error(pl.getOlId()+"同步芝麻信用失败");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public List<PerformanceLog> queryPerformaceByOrderId(Long orderId) {
        List<PerformanceLog> rv = new ArrayList<PerformanceLog>();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
        try{
            //根据订单ID获取履约计划
            PerformanceInfo performanceInfo = null;
            PerformanceInfoExample performanceInfoExample = new PerformanceInfoExample();
            performanceInfoExample.createCriteria().andOrderIdEqualTo(orderId).andStatusEqualTo(Short.parseShort("1"));
            List<PerformanceInfo> infoList = performanceInfoMapper.selectByExample(performanceInfoExample);
            if(null==infoList||infoList.size()==0){//没有查询到履约计划
                return rv;
            }else
                performanceInfo = infoList.get(0);

            //查询履约日志
            List<PerformanceLog> logs = performanceLogMapper.queryPerformaceLogByOrderId(orderId);
            HashMap<String,PerformanceLog> plogMap = new HashMap<String,PerformanceLog>();
            for(PerformanceLog p : logs)
                plogMap.put(p.getPerformanceMonth(),p);
            //获取订单对象
            Orders order = ordersMapper.selectByPrimaryKey(orderId);
            //获取套餐信息
            OfferSpecInfo offerSpecInfo =null;
            String key = "AI-WEB_OFFERSPECDTO_BYOFFERSPECID_"+order.getOfferSpecId();
            OfferSpecDto offerSpecDto = redisService.read(key, OfferSpecDto.class);
            if(null!=offerSpecDto){
                offerSpecInfo = offerSpecDto.getOfferSpecInfo();
            }else
                offerSpecInfo = OfferSpecInfoMapper.selectByPrimaryKey(order.getOfferSpecId());
            //查询履约期数，从配置表查
            int billTimes = 0;//总账期
            IntegrationRuleExample integrationRuleExample = new IntegrationRuleExample();
            integrationRuleExample.createCriteria().andStatusEqualTo(Short.parseShort("1")).andRuleTypeEqualTo(Short.parseShort("1"))
                    .andOfferSpecIdEqualTo(offerSpecInfo.getOfferSpecId()).andProvinceAearIdEqualTo(offerSpecInfo.getProvinceAearId());
            List<IntegrationRule> ruleList = integrationRuleMapper.selectByExample(integrationRuleExample);
            if(ruleList.size()>0){
                billTimes = Integer.parseInt(ruleList.get(0).getIntegration());
            }else{//取默认值
                integrationRuleExample = new IntegrationRuleExample();
                integrationRuleExample.createCriteria().andStatusEqualTo(Short.parseShort("1")).andRuleTypeEqualTo(Short.parseShort("1"))
                        .andIsDefaultEqualTo(Short.parseShort("1"));
                ruleList = integrationRuleMapper.selectByExample(integrationRuleExample);
                if(ruleList.size()>0)
                    billTimes = Integer.parseInt(ruleList.get(0).getIntegration());
            }
            if(billTimes==0)
                return rv;

            //开始履约账期
            PerformanceLogExample example = new PerformanceLogExample();
            example.createCriteria().andOrderIdEqualTo(orderId).andPerformanceStatusEqualTo(0L).andPerformanceIdEqualTo(performanceInfo.getPerformanceId());
            example.setOrderByClause("PERFORMANCE_MONTH asc");
            List<PerformanceLog> plList = performanceLogMapper.selectByExample(example);
            if(plList.size()<1)//没有查询到第一个账单
                return rv;
            PerformanceLog firstPlog = plList.get(0);
            String strMonth = firstPlog.getPerformanceMonth();//第一个账期月份 201707
            Date pMonth = dateFormater.parse(strMonth);
            for(int i=0;i<billTimes;i++){
                PerformanceLog pl = plogMap.get(strMonth);
                if(null==pl){//未到履约时间
                    pl = new PerformanceLog();
                    pl.setPerformanceMonth(strMonth);
                    pl.setPerformanceStatus(0L);//履约状态字段 PERFORMANCE_STATUS 0:未执行到 1:违约 2:缴清
                    rv.add(pl);
                }else
                    rv.add(pl);

                //下一个履约账期
                Calendar calendar = GregorianCalendar.getInstance();
                calendar.setTime(pMonth);
                calendar.add(Calendar.MONTH,1);
                pMonth = calendar.getTime();
                strMonth = dateFormater.format(pMonth);
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error("查询订单履约计划失败");
        }

        return rv;
    }
}

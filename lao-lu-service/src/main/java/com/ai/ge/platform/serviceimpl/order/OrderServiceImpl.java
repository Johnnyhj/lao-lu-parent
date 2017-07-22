package com.ai.ge.platform.serviceimpl.order;

import com.ai.ge.platform.dto.order.OrderOperateDto;
import com.ai.ge.platform.dto.order.OrdersDto;
import com.ai.ge.platform.mapper.order.OrdersLogMapper;
import com.ai.ge.platform.mapper.order.OrdersMapper;
import com.ai.ge.platform.mapper.order.OrdersOperateLogMapper;
import com.ai.ge.platform.mapper.product.NumberInfoMapper;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.model.order.OrdersExample;
import com.ai.ge.platform.model.order.OrdersLog;
import com.ai.ge.platform.model.order.OrdersOperateLog;
import com.ai.ge.platform.model.product.NumberInfo;
import com.ai.ge.platform.model.product.NumberInfoExample;
import com.ai.ge.platform.service.order.OrderService;
import com.ai.ge.util.CommonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by count on 17/5/19.
 */
@Service
public class OrderServiceImpl implements OrderService
{
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private OrdersLogMapper ordersLogMapper;

    @Resource
    private NumberInfoMapper numberInfoMapper;

    @Resource
    private OrdersOperateLogMapper ordersOperateLogMapper;

    @Override
    public OrdersDto findOrdersDto(Long orderId)
    {
        return ordersMapper.selectOrderDetail(orderId);
    }

    @Override
    public List<Orders> findListByCond(Orders record)
    {
        return ordersMapper.listBySelective(record);
    }

    @Override
    @Transactional
    public void addOrders(Orders record){
        //订单入库
        //订单流水 yyyyMMddHHmmssSSS+7位随机数
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderSeq = formatter.format(currentTime);
        orderSeq += currentTime.getTime();
        orderSeq += CommonUtil.genRandomNum(3);
        record.setOrderSeq(orderSeq);
        record.setStatus(Short.parseShort("0"));//待支付

        ordersMapper.insertSelective(record);
        //订单日志
        OrdersLog ordersLog = new OrdersLog();
        ordersLog.setStatus(Short.parseShort("0"));
        ordersLog.setCeateTime(new Date());
        ordersLog.setCustId(record.getCustId());
        ordersLog.setCustmAddress(record.getCustomerAddress());
        ordersLog.setCustmName(record.getCustomerName());
        ordersLog.setCustmPhone(record.getCustomerPhone());
        ordersLog.setExpressMoney(record.getExpressMoney());
        ordersLog.setOrderId(record.getOrderId());
        ordersLog.setOrderSeq(record.getOrderSeq());
        ordersLog.setOrdersMoney(record.getOrdersMoney());
//        ordersLog.setOrdersOutId(record.getOrdersOutId());
//        ordersLog.setPayNo();
        ordersLog.setPayType(Short.parseShort("2"));
        ordersLog.setProdId(record.getProdId());
        ordersLog.setProdSaleAttrId(record.getProdSaleAttrId());
        ordersLog.setProvidId(record.getProvidId());
        ordersLog.setQuantity(record.getQuantity());
        ordersLog.setTotalMoney(record.getTotalMoney());
        ordersLogMapper.insertSelective(ordersLog);

        //号码状态改为 3：订单
        String tn = record.getTelPhone();
        NumberInfo numberInfo = new NumberInfo();
        numberInfo.setStatus(Short.parseShort("3"));
        numberInfo.setUpdateTime(new Date());
        NumberInfoExample numberInfoExample = new NumberInfoExample();
        numberInfoExample.createCriteria().andNumberEqualTo(tn);
        numberInfoMapper.updateByExampleSelective(numberInfo,numberInfoExample);
    }

    /**
     * 查询支付超时订单
     * @param record
     */
    @Override
    @Transactional
    public int updatePaymentTimeoutOrders(Long timeout){
        //超时时间
        Date currentDate = new Date();
        Date timeoutDate = new Date();

        int rv = 0;
        Long tm = currentDate.getTime() - ((null!=timeout)?timeout*1000L:(30 * 60 * 1000L));
        logger.debug("超时时间:"+tm);
        timeoutDate.setTime(tm);//默认半小时未支付

        //释放号码
        OrdersExample example = new OrdersExample();
        example.createCriteria().andStatusEqualTo(Short.parseShort("0")).andUpdateTimeLessThanOrEqualTo(timeoutDate);
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        for(Orders o:ordersList){
            String tn = o.getTelPhone();
            if(null==tn)
                continue;
            NumberInfo numberInfo = new NumberInfo();
            numberInfo.setStatus(Short.parseShort("0"));
            numberInfo.setUpdateTime(new Date());
            NumberInfoExample numberInfoExample = new NumberInfoExample();
            numberInfoExample.createCriteria().andNumberEqualTo(tn);
            numberInfoMapper.updateByExampleSelective(numberInfo, numberInfoExample);
        }

        //订单超时
        Orders record= new Orders();
        record.setStatus(Short.parseShort("6"));
        record.setUpdateTime(currentDate);

        example = new OrdersExample();
        example.createCriteria().andStatusEqualTo(Short.parseShort("0")).andUpdateTimeLessThanOrEqualTo(timeoutDate);
        rv = ordersMapper.updateByExampleSelective(record,example);

        return rv;
    }

    @Override
    public List<Orders> findOrdersByCustId(String custId)
    {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andCustIdEqualTo(custId);
        example.setOrderByClause("CREATE_TIME desc");
        return ordersMapper.selectByExample(example);
    }

    @Override
    public List<Orders> findListByStatus(Integer status) {
        OrdersExample example = new OrdersExample();
        example.createCriteria().andStatusEqualTo(status.shortValue());
        return ordersMapper.selectByExample(example);
    }

    @Override
    public int updateOrderStatusByTelphone(List<String> telphoneList,Integer status){
        try {
            Orders record = new Orders();
            record.setStatus(status.shortValue());
            OrdersExample example = new OrdersExample();
            example.createCriteria().andTelPhoneIn(telphoneList);
            return ordersMapper.updateByExampleSelective(record, example);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 更新订单
     *
     * @param record
     */
    @Override
    public int updateOrders(Orders record)
    {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 取消订单 只有当订单状态为：0 待支付，9 支付失败的时候可以取消，取消状态为6
     * @param orderId
     * @return
     */
    @Transactional
    public  int cancelOrders(Long orderId) {
        int rv = 0;

        Orders record = new Orders();
        record.setOrderId(orderId);
        record.setStatus(Short.parseShort("6"));

        List<Short> statusList = new ArrayList<Short>();
        statusList.add(Short.parseShort("0"));
        statusList.add(Short.parseShort("9"));

        OrdersExample example = new OrdersExample();
        example.createCriteria().andStatusIn(statusList).andOrderIdEqualTo(orderId);

        rv = ordersMapper.updateByExampleSelective(record,example);

        //释放订单电话号码
        Orders order = ordersMapper.selectByPrimaryKey(orderId);
        String tn = order.getTelPhone();

        NumberInfo numberInfo = new NumberInfo();
        numberInfo.setStatus(Short.parseShort("0"));
        numberInfo.setUpdateTime(new Date());
        NumberInfoExample numberInfoExample = new NumberInfoExample();
        numberInfoExample.createCriteria().andNumberEqualTo(tn);
        numberInfoMapper.updateByExampleSelective(numberInfo,numberInfoExample);

        //订单日志
        OrdersLog ordersLog = new OrdersLog();
        ordersLog.setStatus(Short.parseShort("6"));//取消状态
        ordersLog.setCeateTime(new Date());
        ordersLog.setOrderId(record.getOrderId());
        ordersLogMapper.insertSelective(ordersLog);

        return rv;
    }

    @Transactional
    public int updateOrdersFromClient(Orders record) throws Exception {
        //处理电话号码
        //获取原有电话号码
        Orders oldRecord = ordersMapper.selectByPrimaryKey(record.getOrderId());
        if(null==oldRecord){
            logger.error("updateOrdersFromClient 订单不存在.OrderId:"+record.getOrderId());
            throw new Exception("updateOrdersFromClient 订单不存在.OrderId:"+record.getOrderId());
        }
        String oldNumber = oldRecord.getTelPhone();
//        NumberInfoExample numberInfoExample = new NumberInfoExample();
//        numberInfoExample.createCriteria().andNumberEqualTo(tn).andStatusEqualTo(Short.parseShort("3"));
//        List<NumberInfo> numberInfos = numberInfoMapper.selectByExample(numberInfoExample);
//        if(null==numberInfos||numberInfos.size()<1){
//            logger.error("updateOrdersFromClient 获取用户原有电话号码信息失败.电话号码:"+tn);
//            return 0;
//        }
//        NumberInfo oldNumber = new NumberInfo();
//        oldNumber = numberInfos.get(0);

        //原有电话号码和现在提交的不一样 原有电话释放状态=0 现有号码状态=3
        if(!oldNumber.equalsIgnoreCase(record.getTelPhone())){
            //原有电话释放状态=0
            NumberInfo numberInfo = new NumberInfo();
            numberInfo.setStatus(Short.parseShort("0"));
            numberInfo.setUpdateTime(new Date());
            NumberInfoExample numberInfoExample = new NumberInfoExample();
            numberInfoExample.createCriteria().andNumberEqualTo(oldNumber).andStatusEqualTo(Short.parseShort("3"));
            int count = numberInfoMapper.updateByExampleSelective(numberInfo,numberInfoExample);
            if(0==count){
                logger.error("updateOrdersFromClient 释放原有电话号码失败.原有电话:"+oldNumber);
                throw new Exception("updateOrdersFromClient 释放原有电话号码失败.原有电话:"+oldNumber);
            }

            //占用现选号码
            numberInfo = new NumberInfo();
            numberInfo.setStatus(Short.parseShort("3"));
            numberInfo.setUpdateTime(new Date());
            numberInfo.setNumber(record.getTelPhone());
            numberInfoExample = new NumberInfoExample();
            numberInfoExample.createCriteria().andNumberEqualTo(record.getTelPhone()).andStatusEqualTo(Short.parseShort("0"));
            count = numberInfoMapper.updateByExampleSelective(numberInfo,numberInfoExample);
            if(0==count){
                logger.error("updateOrdersFromClient 订单占用电话号码失败.占用电话:"+record.getTelPhone());
                throw new Exception("updateOrdersFromClient 订单占用电话号码失败.占用电话:"+record.getTelPhone());
            }
        }

        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 查询 未竣工 退款中 退款完成 状态的订单列表
     *
     * @param record
     * @return
     */
    @Override
    public List<Orders> listRefund(List<Short> statusList, Orders orders)
    {
        return ordersMapper.listRefund(statusList, orders);
    }

    /**
     * 退款更改状态
     *
     * @param record
     */
    @Transactional
    @Override
    public int updateRefund(Orders record, long sysUserId) throws Exception
    {
        if (null == record.getOrderId() || null == record.getStatus())
        {
            throw new Exception("缺少参数");
        }

        // 查询库里订单和页面传值status是否一样
        List<Orders> list = findListByCond(record);

        if (CollectionUtils.isEmpty(list) || list.size() > 2)
        {
            throw new Exception("订单异常，不允许申请或完成退款");
        }
        else if (list.get(0).getStatus() != record.getStatus())
        {
            throw new Exception("订单异常，不允许申请或完成退款");
        }
        else
        {
            // 如果是 7 未竣工，则改成 10 退款中 状态
            // 如果是 10 退款中， 则改成 8 退款完成 状态
            if (record.getStatus() == (short) 7)
            {
                record.setStatus((short) 10);

                recordOrderOperateLog(list.get(0), sysUserId, "申请退款");
            }
            else if (record.getStatus() == (short) 10)
            {
                record.setStatus((short) 8);

                recordOrderOperateLog(list.get(0), sysUserId, "完成退款");
            }
            else
            {
                throw new Exception("参数异常，不允许申请或完成退款");
            }

            record.setUpdateTime(new Date());
            return ordersMapper.updateByPrimaryKeySelective(record);
        }

    }

    /**
     * 记录订单表操作日志
     *
     * @param userId
     * @param remark
     * @param orders
     */
    @Override
    public int recordOrderOperateLog(Orders orders, long userId, String remark)
    {
        OrdersOperateLog ordersOperateLog = new OrdersOperateLog();
        ordersOperateLog.setOrderId(orders.getOrderId());
        ordersOperateLog.setSysUserId(userId);
        ordersOperateLog.setRemark(remark);
        ordersOperateLog.setCreateTime(new Date());
        ordersOperateLog.setProvinceAearId(orders.getProvinceAearId());
        ordersOperateLog.setCityAearId(orders.getCityAearId());

        return ordersOperateLogMapper.insertSelective(ordersOperateLog);
    }

    /**
     * 查询订单系统操作员
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderOperateDto> listOrderOperateUser(Long orderId)
    {
        return ordersOperateLogMapper.selectOrderOperateUser(orderId);
    }

}


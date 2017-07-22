package com.ai.ge.platform.service.order;

import com.ai.ge.platform.dto.order.OrderOperateDto;
import com.ai.ge.platform.dto.order.OrdersDto;
import com.ai.ge.platform.model.order.Orders;

import java.util.List;

/**
 * Created by guochunhao on 17/5/19.
 */
public interface OrderService
{
    /**
     * 查询订单列表
     * @param record
     * @return
     */
    List<Orders> findListByCond(Orders record);

    /**
     * 查询订单详情信息
     *
     * @param orderId
     * @return
     */
    OrdersDto findOrdersDto(Long orderId);

    /**
     * 新增订单
     * @param record
     */
    void addOrders(Orders record);

    /**
     * 更新订单
     * @param record
     */
    int updateOrders(Orders record);

    List<Orders> findOrdersByCustId(String custId);

    /**
     * 根据状态查询订单列表
     * @param status 状态
     * @return
     */
    List<Orders> findListByStatus(Integer status);

    /**
     * 更新指定号码的订单状态
     * @param status 状态
     * @return
     */
    int updateOrderStatusByTelphone(List<String> telphoneList,Integer status);

    int cancelOrders(Long orderId);

    /**
     * 更新订单(客户端提交)
     * @param record
     */
    int updateOrdersFromClient(Orders record) throws Exception;

    int updatePaymentTimeoutOrders(Long timeout);

    /**
     * 查询 未竣工 退款中 退款完成 状态的订单列表
     * @param statusList
     * @return
     */
    List<Orders> listRefund(List<Short> statusList, Orders orders);

    /**
     * 退款更改状态
     * @param record
     */
    int updateRefund(Orders record, long sysUserId) throws Exception;

    /**
     * 记录订单表操作日志
     *
     * @param userId
     * @param remark
     * @param orders
     */
    int recordOrderOperateLog(Orders orders, long userId, String remark);

    /**
     * 查询订单系统操作员
     * @param orderId
     * @return
     */
    List<OrderOperateDto> listOrderOperateUser(Long orderId);

}

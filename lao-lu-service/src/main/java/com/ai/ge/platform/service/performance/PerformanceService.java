package com.ai.ge.platform.service.performance;

import com.ai.ge.platform.model.order.PerformanceInfo;
import com.ai.ge.platform.model.order.PerformanceLog;

import java.util.Date;
import java.util.List;

/**
 * Created by guochunhao on 17/5/19.
 */
public interface PerformanceService
{
    /**
     * 初始化履约计划，生成第一期账单，修改订单状态
     * @param telphone 报竣电话号码
     * @param olNbr 报竣业务流水号
     * @return
     */
    void initPerformance(String telphone,String olNbr) throws Exception;

    List<PerformanceInfo> findListByStatus(Short status);

    /**
     * 根行据账单情况进履约
     * @param telphone 履约号码
     * @param isSuccess 是否履约 Y/N
     * @return
     */
    void processPerformance(String telphone,String isSuccess) throws Exception;

    void processPerformanceForTest(String telphone,String isSuccess,Date currentDate) throws Exception;

    int synchronizePerformance();

    /**
     * 查询履约情况
     * @param orderId
     * @return
     */
    List<PerformanceLog> queryPerformaceByOrderId(Long orderId);
}

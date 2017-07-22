package com.ai.ge.platform.service.log;

import com.ai.ge.platform.dto.order.OrderContext;

/**
 * Created by sx on 2016/3/8.
 */
public interface LogOrdersService extends LoggerStorage {
    /**
     * 保存日志
     * @param orderContext
     */
    void saveLogOrders(OrderContext orderContext);
}

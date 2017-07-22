package com.ai.ge.platform.dto.order;

import com.ai.ge.platform.model.order.OrdersOperateLog;

/**
 * Created by count on 17/6/26.
 */
public class OrderOperateDto extends OrdersOperateLog
{
    private String username;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}

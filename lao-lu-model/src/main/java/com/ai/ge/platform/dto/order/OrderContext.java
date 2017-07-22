package com.ai.ge.platform.dto.order;


import com.ai.ge.platform.model.sys.SystemAuthorization;

/**
 * 订单流程监听上下文
 */
public class OrderContext {
    private String processName;

    private SystemAuthorization systemAuthorization;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public SystemAuthorization getSystemAuthorization() {
        return systemAuthorization;
    }

    public void setSystemAuthorization(SystemAuthorization systemAuthorization) {
        this.systemAuthorization = systemAuthorization;
    }


}

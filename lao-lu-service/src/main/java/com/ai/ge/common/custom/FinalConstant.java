package com.ai.ge.common.custom;

/**
 * Created by dukun on 2016/7/13.
 */
public interface FinalConstant
{
    /**
     * 查询预约
     */
    String QUERY_RESERVE = "query_reserve";

    interface CustomerMgrType {

        // 操作员
        int OPERATOR = 1;

        // 经理
        int MANAGER = 0;
    }

    interface ReserveStatus {

        // 预约失败
        int FAIL = 0;

        // 预约成功
        int SUCCESS = 1;

        // 经理审批
        int NEED_MANAGER_APPROVAL = 2;

        // 操作员审批
        int NEED_OPERATOR_APPROVAL = 3;
    }

}

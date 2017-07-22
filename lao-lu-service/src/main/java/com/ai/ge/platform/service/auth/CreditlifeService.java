package com.ai.ge.platform.service.auth;

import com.ai.ge.platform.serviceimpl.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;

/**
 * 接收从芝麻回调后调用  信用套餐查询接口 获取用户信息后调用
 */
public interface CreditlifeService {

    /**
     * 接收从芝麻回调后调用  信用套餐查询接口 获取用户信息后调用
     * @param orderNo
     * @param transactionId
     * @return
     * @throws BusinessException
     */
    boolean creditlife(String orderNo, String transactionId,HttpServletRequest request) throws BusinessException;
}

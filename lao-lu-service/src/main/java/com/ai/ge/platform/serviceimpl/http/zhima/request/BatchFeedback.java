package com.ai.ge.platform.serviceimpl.http.zhima.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 批量反馈接口
 */
public class BatchFeedback {
    /**
     * 数据统计日期
     */
    @JSONField(name = "biz_date")
    private String bizDate;
    /**
     * 证件类型
     * <p>
     * 0-身份证；
     * 1-户口簿；
     * 2-护照；
     * 3-军官证；
     * 4-士兵证；
     * 5-港澳居民来往内地通行证；
     * 6-台湾同胞来往内地通行证；
     * 7-临时身份证；
     * 8-外国人居留证；
     * 9-警官证；
     * A-香港身份证；
     * B-澳门身份证；
     * C-台湾身份证；
     * X-其他证件
     */
    @JSONField(name = "user_credentials_type")
    private String userCredentialsType;
    /**
     * 证件号码
     */
    @JSONField(name = "user_credentials_no")
    private String userCredentialsNo;
    /**
     * 姓名
     */
    @JSONField(name = "user_name")
    private String userName;
    /**
     * 业务号
     */
    @JSONField(name = "order_no")
    private String orderNo;
    /**
     * 手机号码
     */
    @JSONField(name = "phone_no")
    private String phoneNo;
    /**
     * 最高透支额度，没有就传 0
     */
    @JSONField(name = "create_amt")
    private String createAmt = "0";

    /**
     * 订单开始时间
     */
    @JSONField(name = "order_start_date")
    private String orderStartDate;
    /**
     * 订单结束时间
     */
    @JSONField(name = "order_end_date")
    private String orderEndDate;
    /**
     * 提醒状态
     * 在原有服务的基础上添加的提醒，填0不影响原有的提醒。针对预付类业务。
     * <p>
     * <p>
     * "对用户的提醒方式：
     * 0-不提醒；
     * 1-低额提醒(小于10元)；
     * 2-余额提醒(下月余额不足)；
     * 3-逾期停机提醒；"
     */
    @JSONField(name = "remind_status")
    private String remindStatus = "0";

    /**
     * 当前业务状态
     */
    @JSONField(name = "order_status")
    private String orderStatus;
    /**
     * 账单号
     */
    @JSONField(name = "bill_no")
    private String billNo;
    /**
     * 账单月份
     */
    @JSONField(name = "bill_installment")
    private String billInstallment;
    /**
     * 账单描述
     */
    @JSONField(name = "bill_desc")
    private String billDesc;
    /**
     * 账单类型
     */
    @JSONField(name = "bill_type")
    private String billType;
    /**
     * 账单应还金额
     */
    @JSONField(name = "bill_amt")
    private String billAmt;
    /**
     * 账单应还款日
     */
    @JSONField(name = "bill_last_date")
    private String billLastDate;
    /**
     * 账单状态
     */
    @JSONField(name = "bill_status")
    private String billStatus;
    /**
     * 账单完结日期
     */
    @JSONField(name = "bill_payoff_date")
    private String billPayoffDate;
    /**
     * 账单类型违约金额
     */
    @JSONField(name = "bill_type_ovd_amt")
    private String billTypeOvdAmt;
    /**
     * 当前违约开始日期
     */
    @JSONField(name = "bill_type_ovd_date")
    private String billTypeOvdDate;
    /**
     * 备注
     */
    private String memo;


    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getUserCredentialsType() {
        return userCredentialsType;
    }

    public void setUserCredentialsType(String userCredentialsType) {
        this.userCredentialsType = userCredentialsType;
    }

    public String getUserCredentialsNo() {
        return userCredentialsNo;
    }

    public void setUserCredentialsNo(String userCredentialsNo) {
        this.userCredentialsNo = userCredentialsNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(String orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public String getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(String orderEndDate) {
        this.orderEndDate = orderEndDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillInstallment() {
        return billInstallment;
    }

    public void setBillInstallment(String billInstallment) {
        this.billInstallment = billInstallment;
    }

    public String getBillDesc() {
        return billDesc;
    }

    public void setBillDesc(String billDesc) {
        this.billDesc = billDesc;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillAmt() {
        return billAmt;
    }

    public void setBillAmt(String billAmt) {
        this.billAmt = billAmt;
    }

    public String getBillLastDate() {
        return billLastDate;
    }

    public void setBillLastDate(String billLastDate) {
        this.billLastDate = billLastDate;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getBillPayoffDate() {
        return billPayoffDate;
    }

    public void setBillPayoffDate(String billPayoffDate) {
        this.billPayoffDate = billPayoffDate;
    }

    public String getBillTypeOvdAmt() {
        return billTypeOvdAmt;
    }

    public void setBillTypeOvdAmt(String billTypeOvdAmt) {
        this.billTypeOvdAmt = billTypeOvdAmt;
    }

    public String getBillTypeOvdDate() {
        return billTypeOvdDate;
    }

    public void setBillTypeOvdDate(String billTypeOvdDate) {
        this.billTypeOvdDate = billTypeOvdDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreateAmt() {
        return createAmt;
    }

    public void setCreateAmt(String createAmt) {
        this.createAmt = createAmt;
    }

    public String getRemindStatus() {
        return remindStatus;
    }

    public void setRemindStatus(String remindStatus) {
        this.remindStatus = remindStatus;
    }
}

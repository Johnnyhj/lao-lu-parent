package com.ai.ge.platform.model.order;

import java.util.Date;

public class Orders {
    private Long orderId;

    private Long prodId;

    private Long prodSaleAttrId;

    private Long ordersOutId;

    private Long providId;

    private String orderSeq;

    private Integer quantity;

    private Float ordersMoney;

    private Float expressMoney;

    private Float totalMoney;

    private String custId;

    private Date createTime;

    private Date updateTime;

    private Short status;

    private String orderDescribe;

    private String customerName;

    private String customerPhone;

    private String customerAddress;

    private Long offerSpecId;

    private String telPhone;

    private Float loanMoney;

    private Float payMoney;

    private Long lenderId;

    private Long provinceAearId;

    private Long cityAearId;
	
	private String certNo;

    private String certTypeValue;
	
	private String olNbr;

    /**
     * 查询条件
     */
    private Float beginMoney;

    private Float endMoney;

    private Date beginTime;

    private Date endTime;

    private Short userType;

    //前台订单展示用字段
    private String provinceAndCity;

    public String getProvinceAndCity() {
        return provinceAndCity;
    }

    public void setProvinceAndCity(String provinceAndCity) {
        this.provinceAndCity = provinceAndCity;
    }

    public Short getUserType()
    {
        return userType;
    }

    public void setUserType(Short userType)
    {
        this.userType = userType;
    }

    public Float getBeginMoney()
    {
        return beginMoney;
    }

    public void setBeginMoney(Float beginMoney)
    {
        this.beginMoney = beginMoney;
    }

    public Float getEndMoney()
    {
        return endMoney;
    }

    public void setEndMoney(Float endMoney)
    {
        this.endMoney = endMoney;
    }

    public Date getBeginTime()
    {
        return beginTime;
    }

    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public Long getProdSaleAttrId() {
        return prodSaleAttrId;
    }

    public void setProdSaleAttrId(Long prodSaleAttrId) {
        this.prodSaleAttrId = prodSaleAttrId;
    }

    public Long getOrdersOutId() {
        return ordersOutId;
    }

    public void setOrdersOutId(Long ordersOutId) {
        this.ordersOutId = ordersOutId;
    }

    public Long getProvidId() {
        return providId;
    }

    public void setProvidId(Long providId) {
        this.providId = providId;
    }

    public String getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(String orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getOrdersMoney() {
        return ordersMoney;
    }

    public void setOrdersMoney(Float ordersMoney) {
        this.ordersMoney = ordersMoney;
    }

    public Float getExpressMoney() {
        return expressMoney;
    }

    public void setExpressMoney(Float expressMoney) {
        this.expressMoney = expressMoney;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Long getOfferSpecId() {
        return offerSpecId;
    }

    public void setOfferSpecId(Long offerSpecId) {
        this.offerSpecId = offerSpecId;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public Float getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Float loanMoney) {
        this.loanMoney = loanMoney;
    }

    public Float getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Float payMoney) {
        this.payMoney = payMoney;
    }

    public Long getLenderId() {
        return lenderId;
    }

    public void setLenderId(Long lenderId) {
        this.lenderId = lenderId;
    }

    public Long getProvinceAearId() {
        return provinceAearId;
    }

    public void setProvinceAearId(Long provinceAearId) {
        this.provinceAearId = provinceAearId;
    }

    public Long getCityAearId() {
        return cityAearId;
    }

    public void setCityAearId(Long cityAearId) {
        this.cityAearId = cityAearId;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertTypeValue() {
        return certTypeValue;
    }

    public void setCertTypeValue(String certTypeValue) {
        this.certTypeValue = certTypeValue;
    }

    public String getOlNbr() {
        return olNbr;
    }

    public void setOlNbr(String olNbr) {
        this.olNbr = olNbr;
    }
}
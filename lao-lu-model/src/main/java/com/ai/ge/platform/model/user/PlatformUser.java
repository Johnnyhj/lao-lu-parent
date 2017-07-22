package com.ai.ge.platform.model.user;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class PlatformUser {
    private Long id;

    private String userId;

    private String userTypeValue;

    private String userStatus;

    private String firmName;

    private String realName;

    private String username;

    private String email;

    private String certNo;

    private String gender;

    private String certTypeValue;

    private String addressCode;

    private String alipayUserId;

    private String phone;

    private String mobile;

    private String idcardCorrectUrl;

    private String idcardOppositeUrl;

    private String idcardHandUrl;

    private String avatar;

    private Date createTime;

    private Date updateTime;

    private String isCertified;

    private String isBankAuth;

    private String isIdAuth;

    private String isMobileAuth;

    private String isLicenceAuth;

    private String deliverPhone;

    private String deliverMobile;

    private String deliverFullname;

    private String province;

    private String city;

    private String area;

    private String address;

    private String zip;

    private String deliverProvince;

    private String deliverCity;

    private String deliverArea;

    private String defaultDeliverAddress;

    private String isStudentCertified;

    private String isCertifyGradeA;

    private String birthday;

    private String nickName;

    private String familyName;

    private String reducedBirthday;

    private String isBalanceFrozen;

    private String balanceFreezeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    @JSONField(name = "user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserTypeValue() {
        return userTypeValue;
    }

    @JSONField(name = "user_type_value")
    public void setUserTypeValue(String userTypeValue) {
        this.userTypeValue = userTypeValue;
    }

    public String getUserStatus() {
        return userStatus;
    }

    @JSONField(name = "user_status")
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getFirmName() {
        return firmName;
    }

    @JSONField(name = "firm_name")
    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getRealName() {
        return realName;
    }

    @JSONField(name = "real_name")
    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    @JSONField(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCertNo() {
        return certNo;
    }

    @JSONField(name = "cert_no")
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getGender() {
        return gender;
    }
    @JSONField(name = "gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCertTypeValue() {
        return certTypeValue;
    }
    @JSONField(name = "cert_type_value")
    public void setCertTypeValue(String certTypeValue) {
        this.certTypeValue = certTypeValue;
    }

    public String getAddressCode() {
        return addressCode;
    }
    @JSONField(name = "address_code")
    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAlipayUserId() {
        return alipayUserId;
    }
    @JSONField(name = "alipay_user_id")
    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    public String getPhone() {
        return phone;
    }
    @JSONField(name = "phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }
    @JSONField(name = "mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdcardCorrectUrl() {
        return idcardCorrectUrl;
    }

    public void setIdcardCorrectUrl(String idcardCorrectUrl) {
        this.idcardCorrectUrl = idcardCorrectUrl;
    }

    public String getIdcardOppositeUrl() {
        return idcardOppositeUrl;
    }

    public void setIdcardOppositeUrl(String idcardOppositeUrl) {
        this.idcardOppositeUrl = idcardOppositeUrl;
    }

    public String getIdcardHandUrl() {
        return idcardHandUrl;
    }

    public void setIdcardHandUrl(String idcardHandUrl) {
        this.idcardHandUrl = idcardHandUrl;
    }

    public String getAvatar() {
        return avatar;
    }
    @JSONField(name = "avatar")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getIsCertified() {
        return isCertified;
    }
    @JSONField(name = "is_certified")
    public void setIsCertified(String isCertified) {
        this.isCertified = isCertified;
    }

    public String getIsBankAuth() {
        return isBankAuth;
    }
    @JSONField(name = "is_bank_auth")
    public void setIsBankAuth(String isBankAuth) {
        this.isBankAuth = isBankAuth;
    }

    public String getIsIdAuth() {
        return isIdAuth;
    }
    @JSONField(name = "is_id_auth")
    public void setIsIdAuth(String isIdAuth) {
        this.isIdAuth = isIdAuth;
    }

    public String getIsMobileAuth() {
        return isMobileAuth;
    }
    @JSONField(name = "is_mobile_auth")
    public void setIsMobileAuth(String isMobileAuth) {
        this.isMobileAuth = isMobileAuth;
    }

    public String getIsLicenceAuth() {
        return isLicenceAuth;
    }
    @JSONField(name = "is_licence_auth")
    public void setIsLicenceAuth(String isLicenceAuth) {
        this.isLicenceAuth = isLicenceAuth;
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }
    @JSONField(name = "deliver_phone")
    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone;
    }

    public String getDeliverMobile() {
        return deliverMobile;
    }
    @JSONField(name = "deliver_mobile")
    public void setDeliverMobile(String deliverMobile) {
        this.deliverMobile = deliverMobile;
    }

    public String getDeliverFullname() {
        return deliverFullname;
    }
    @JSONField(name = "deliver_fullname")
    public void setDeliverFullname(String deliverFullname) {
        this.deliverFullname = deliverFullname;
    }

    public String getProvince() {
        return province;
    }

    @JSONField(name = "province")
    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }
    @JSONField(name = "city")
    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }
    @JSONField(name = "area")
    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }
    @JSONField(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }
    @JSONField(name = "zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDeliverProvince() {
        return deliverProvince;
    }
    @JSONField(name = "deliver_province")
    public void setDeliverProvince(String deliverProvince) {
        this.deliverProvince = deliverProvince;
    }

    public String getDeliverCity() {
        return deliverCity;
    }
    @JSONField(name = "deliver_city")
    public void setDeliverCity(String deliverCity) {
        this.deliverCity = deliverCity;
    }

    public String getDeliverArea() {
        return deliverArea;
    }
    @JSONField(name = "deliver_area")
    public void setDeliverArea(String deliverArea) {
        this.deliverArea = deliverArea;
    }

    public String getDefaultDeliverAddress() {
        return defaultDeliverAddress;
    }
    @JSONField(name = "default_deliver_address")
    public void setDefaultDeliverAddress(String defaultDeliverAddress) {
        this.defaultDeliverAddress = defaultDeliverAddress;
    }

    public String getIsStudentCertified() {
        return isStudentCertified;
    }
    @JSONField(name = "is_student_certified")
    public void setIsStudentCertified(String isStudentCertified) {
        this.isStudentCertified = isStudentCertified;
    }

    public String getIsCertifyGradeA() {
        return isCertifyGradeA;
    }
    @JSONField(name = "is_certify_grade_a")
    public void setIsCertifyGradeA(String isCertifyGradeA) {
        this.isCertifyGradeA = isCertifyGradeA;
    }

    public String getBirthday() {
        return birthday;
    }
    @JSONField(name = "birthday")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickName() {
        return nickName;
    }
    @JSONField(name = "nick_name")
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFamilyName() {
        return familyName;
    }

    @JSONField(name = "family_name")
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getReducedBirthday() {
        return reducedBirthday;
    }
    @JSONField(name = "reduced_birthday")
    public void setReducedBirthday(String reducedBirthday) {
        this.reducedBirthday = reducedBirthday;
    }

    public String getIsBalanceFrozen() {
        return isBalanceFrozen;
    }
    @JSONField(name = "is_balance_frozen")
    public void setIsBalanceFrozen(String isBalanceFrozen) {
        this.isBalanceFrozen = isBalanceFrozen;
    }

    public String getBalanceFreezeType() {
        return balanceFreezeType;
    }
    @JSONField(name = "balance_freeze_type")
    public void setBalanceFreezeType(String balanceFreezeType) {
        this.balanceFreezeType = balanceFreezeType;
    }
}
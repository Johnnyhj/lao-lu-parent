package com.ai.ge.platform.serviceimpl.http.zhima;

/**
 * 信用套餐查询接口
 */
public class ZhimaOrderConfirmHttpResponseObject extends ZhimaHttpResponseObject {

    /**
     * 姓名
     */
    private String name;
    /**
     * 姓名拼音
     */
    private String nameSpell;
    /**
     * 身份证号
     */
    private String certNo;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private String age;
    /**
     * 教育程度
     */
    private String educationDegree;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 常驻城市
     */
    private String cityName;
    /**
     * 住宅地址
     */
    private String house;
    /**
     * 住宅性质
     */
    private String houseType;
    /**
     * 婚姻状况
     */
    private String marriageStatus;
    /**
     * 税后年收入
     */
    private String taxedIncome;
    /**
     * 单位名称
     */
    private String companyName;
    /**
     * 单位地址
     */
    private String companyAddress;
    /**
     * 单位电话
     */
    private String companyContact;
    /**
     * 行业类型
     */
    private String industryType;
    /**
     * 职业说明
     */
    private String occupation;
    /**
     * 单位性质
     */
    private String companyType;
    /**
     * 职位级别
     */
    private String positionLevel;
    /**
     * 任职部门
     */
    private String department;
    /**
     * 现单位工作年限
     */
    private String workedYears;
    /**
     * 邮寄地址
     */
    private String mailingAddress;
    /**
     * 直亲关系
     */
    private String directRelation;
    /**
     * 直亲姓名
     */
    private String directRelationName;
    /**
     * 直亲手机号
     */
    private String directRelationMobile;
    /**
     * 父母、配偶、子女、兄弟／姐妹、其他
     */
    private String contactRelation;
    /**
     * 联系人姓名
     */
    private String contactName;
    /**
     * 联系人电话
     */
    private String contactMobile;
    /**
     * 用户在商端的身份标识
     */
    private String openId;
    /**
     * 支付宝
     */
    private String userId;
    /**
     * 渠道来源
     */
    private String channelId;
    /**
     * 身份证签发机关
     */
    private String certCity;
    /**
     * 身份证有效期
     */
    private String certIndate;
    /**
     * 芝麻风控产品集联合结果
     */
    private String zmRisk;
    /**
     * 芝麻分
     */
    private String zmScore;
    /**
     * 人脸核身结果
     */
    private String zmFace;
    /**
     * 人脸验证拍摄的图片
     */
    private String zmFacePic;
    /**
     * ivs
     */
    private String ivsDetails;
    /**
     * 行业关注名单产品明细数据
     */
    private String watchlistDetail;
    /**
     * 签证报告数据
     */
    private String visaReport;
    /**
     * 护照号
     */
    private String passportNo;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSpell() {
        return nameSpell;
    }

    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getTaxedIncome() {
        return taxedIncome;
    }

    public void setTaxedIncome(String taxedIncome) {
        this.taxedIncome = taxedIncome;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWorkedYears() {
        return workedYears;
    }

    public void setWorkedYears(String workedYears) {
        this.workedYears = workedYears;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getDirectRelation() {
        return directRelation;
    }

    public void setDirectRelation(String directRelation) {
        this.directRelation = directRelation;
    }

    public String getDirectRelationName() {
        return directRelationName;
    }

    public void setDirectRelationName(String directRelationName) {
        this.directRelationName = directRelationName;
    }

    public String getDirectRelationMobile() {
        return directRelationMobile;
    }

    public void setDirectRelationMobile(String directRelationMobile) {
        this.directRelationMobile = directRelationMobile;
    }

    public String getContactRelation() {
        return contactRelation;
    }

    public void setContactRelation(String contactRelation) {
        this.contactRelation = contactRelation;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCertCity() {
        return certCity;
    }

    public void setCertCity(String certCity) {
        this.certCity = certCity;
    }

    public String getCertIndate() {
        return certIndate;
    }

    public void setCertIndate(String certIndate) {
        this.certIndate = certIndate;
    }

    public String getZmRisk() {
        return zmRisk;
    }

    public void setZmRisk(String zmRisk) {
        this.zmRisk = zmRisk;
    }

    public String getZmScore() {
        return zmScore;
    }

    public void setZmScore(String zmScore) {
        this.zmScore = zmScore;
    }

    public String getZmFace() {
        return zmFace;
    }

    public void setZmFace(String zmFace) {
        this.zmFace = zmFace;
    }

    public String getZmFacePic() {
        return zmFacePic;
    }

    public void setZmFacePic(String zmFacePic) {
        this.zmFacePic = zmFacePic;
    }

    public String getIvsDetails() {
        return ivsDetails;
    }

    public void setIvsDetails(String ivsDetails) {
        this.ivsDetails = ivsDetails;
    }

    public String getWatchlistDetail() {
        return watchlistDetail;
    }

    public void setWatchlistDetail(String watchlistDetail) {
        this.watchlistDetail = watchlistDetail;
    }

    public String getVisaReport() {
        return visaReport;
    }

    public void setVisaReport(String visaReport) {
        this.visaReport = visaReport;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
}

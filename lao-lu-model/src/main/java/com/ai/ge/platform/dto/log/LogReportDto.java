package com.ai.ge.platform.dto.log;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class LogReportDto {

    private BigDecimal[] data;
    private Date[] createDate;


    public Date[] getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date[] createDate) {
        this.createDate = createDate;
    }

    public BigDecimal[] getData() {
        return data;
    }

    public void setData(BigDecimal[] data) {
        this.data = data;
    }




    /*****************************query************************************/
    /**
     * 间隔时间
     */
    private Integer intervalDay;

    public Integer getIntervalDay() {
        return intervalDay;
    }

    public void setIntervalDay(Integer intervalDay) {
        this.intervalDay = intervalDay;
    }


    private String pageName;

    /**
     * 默认为小时
     * 1.1小时
     * 2.1天
     */
    private Integer unit = 1;

    private Date beginDate;

    private Date endDate;

    private String channel;

    private List<String> channelList;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<String> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<String> channelList) {
        this.channelList = channelList;
    }

/*****************************query************************************/
}

package com.ai.ge.platform.dto.log;

import java.util.Date;

/**
 *
 */
public class DashBoardDto {
    /**
     * 0.全部
     * 1.昨日
     * 2.当日
     * 3.本月
     */
    private Integer unit = 0;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 起始时间
     */
    private Date beginDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

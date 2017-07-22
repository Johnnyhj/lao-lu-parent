package com.ai.ge.platform.dto.order;

import com.ai.ge.platform.model.order.IntegrationRule;

/**
 * Created by count on 17/6/21.
 */
public class IntegrationRuleDto extends IntegrationRule
{
    private String offerSpecName;

    private String provinceAearName;

    private String cityAearName;

    public String getOfferSpecName()
    {
        return offerSpecName;
    }

    public void setOfferSpecName(String offerSpecName)
    {
        this.offerSpecName = offerSpecName;
    }

    public String getProvinceAearName()
    {
        return provinceAearName;
    }

    public void setProvinceAearName(String provinceAearName)
    {
        this.provinceAearName = provinceAearName;
    }

    public String getCityAearName()
    {
        return cityAearName;
    }

    public void setCityAearName(String cityAearName)
    {
        this.cityAearName = cityAearName;
    }
}

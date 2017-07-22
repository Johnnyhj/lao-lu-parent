package com.ai.ge.platform.dto.order;

import com.ai.ge.platform.model.order.Freight;

/**
 * Created by count on 17/6/20.
 */
public class FreightDto extends Freight
{
    private String originalProvinceAearName;

    private String originalCityAearName;

    private String destinationProvinceAearName;

    private String destinationCityAearName;

    public String getOriginalProvinceAearName()
    {
        return originalProvinceAearName;
    }

    public void setOriginalProvinceAearName(String originalProvinceAearName)
    {
        this.originalProvinceAearName = originalProvinceAearName;
    }

    public String getOriginalCityAearName()
    {
        return originalCityAearName;
    }

    public void setOriginalCityAearName(String originalCityAearName)
    {
        this.originalCityAearName = originalCityAearName;
    }

    public String getDestinationProvinceAearName()
    {
        return destinationProvinceAearName;
    }

    public void setDestinationProvinceAearName(String destinationProvinceAearName)
    {
        this.destinationProvinceAearName = destinationProvinceAearName;
    }

    public String getDestinationCityAearName()
    {
        return destinationCityAearName;
    }

    public void setDestinationCityAearName(String destinationCityAearName)
    {
        this.destinationCityAearName = destinationCityAearName;
    }
}

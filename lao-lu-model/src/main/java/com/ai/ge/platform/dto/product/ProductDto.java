package com.ai.ge.platform.dto.product;

import com.ai.ge.platform.model.product.ProdSaleAttrConfig;
import com.ai.ge.platform.model.product.Product;

import java.util.List;

/**
 * Created by count on 17/5/22.
 */
public class ProductDto extends Product
{
    private List<ProdSaleAttrConfig> prodSaleAttrConfigs;

    public List<ProdSaleAttrConfig> getProdSaleAttrConfigs()
    {
        return prodSaleAttrConfigs;
    }

    public void setProdSaleAttrConfigs(List<ProdSaleAttrConfig> prodSaleAttrConfigs)
    {
        this.prodSaleAttrConfigs = prodSaleAttrConfigs;
    }
}

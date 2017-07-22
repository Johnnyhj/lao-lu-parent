package com.ai.ge.platform.dto.order;

import com.ai.ge.platform.dto.delivery.DeliveryInfoDto;
import com.ai.ge.platform.dto.product.ProductDto;
import com.ai.ge.platform.model.order.OfferSpec;
import com.ai.ge.platform.model.order.OfferSpecInfo;
import com.ai.ge.platform.model.order.Orders;

/**
 * Created by guochunhao on 17/5/19.
 */
public class OrdersDto extends Orders
{
    /**
     * 套餐-销售品规则
     */
    private OfferSpec offerSpec;

    /**
     * 套餐-销售品规格信息
     */
    private OfferSpecInfo offerSpecInfo;

    /**
     * 商品信息
     */
    private ProductDto productDto;

    /**
     * 信用购机信息(资金方、贷款金额、支付金额等等)
     */

    private DeliveryInfoDto deliveryInfo;

    public DeliveryInfoDto getDeliveryInfo()
    {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfoDto deliveryInfo)
    {
        this.deliveryInfo = deliveryInfo;
    }

    public OfferSpec getOfferSpec()
    {
        return offerSpec;
    }

    public void setOfferSpec(OfferSpec offerSpec)
    {
        this.offerSpec = offerSpec;
    }

    public OfferSpecInfo getOfferSpecInfo()
    {
        return offerSpecInfo;
    }

    public void setOfferSpecInfo(OfferSpecInfo offerSpecInfo)
    {
        this.offerSpecInfo = offerSpecInfo;
    }

    public ProductDto getProductDto()
    {
        return productDto;
    }

    public void setProductDto(ProductDto productDto)
    {
        this.productDto = productDto;
    }
}

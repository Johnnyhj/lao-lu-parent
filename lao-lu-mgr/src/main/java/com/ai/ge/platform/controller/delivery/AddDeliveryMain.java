package com.ai.ge.platform.controller.delivery;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.common.jcaptcha.Constants;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.delivery.DeliveryInfoDto;
import com.ai.ge.platform.model.order.DeliverOrderRelation;
import com.ai.ge.platform.model.order.DeliveryInfo;
import com.ai.ge.utils.AbilityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "addDelivery")
public class AddDeliveryMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(AddDeliveryMain.class);

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;
        String resultMsg = "发货成功";

        Message request = new Message();

        try
        {
            DeliveryInfo deliveryInfo = message.getParam(DeliveryInfo.class);
            DeliverOrderRelation deliverOrderRelation = message.getParam(DeliverOrderRelation.class);

            DeliveryInfoDto deliveryInfoDto = new DeliveryInfoDto();
            BeanUtils.copyProperties(deliveryInfo, deliveryInfoDto);

            deliveryInfoDto.setDeliverOrderRelation(deliverOrderRelation);

            deliveryService.insertDelivery(deliveryInfoDto);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = "发货失败";

        } finally
        {

            request.setAbilityName("listDelivery");

            message.getRequest().setAttribute("addStatus", Constants.ORDER_STATUS.WAIT_DELIVER_GOOD);

            request.setRequest(message.getRequest());
            request = AbilityUtil.invokeSync(request);
            request.setBody(request.getBody());
            request.setCode(resultCode);
            request.setMsg(resultMsg);
        }

        return request;
    }

}

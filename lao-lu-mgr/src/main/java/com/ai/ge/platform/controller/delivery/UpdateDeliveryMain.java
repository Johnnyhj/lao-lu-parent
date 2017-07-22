package com.ai.ge.platform.controller.delivery;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.common.jcaptcha.Constants;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.delivery.DeliveryInfoDto;
import com.ai.ge.platform.model.order.DeliverOrderRelation;
import com.ai.ge.utils.AbilityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/28.
 */
@Service
@AbilityRegister(name = "updateDelivery")
public class UpdateDeliveryMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(UpdateDeliveryMain.class);

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;
        String resultMsg = "更新成功";

        Message request = new Message();

        try
        {
            DeliveryInfoDto deliveryInfo = message.getParam(DeliveryInfoDto.class);
            DeliverOrderRelation deliverOrderRelation = message.getParam(DeliverOrderRelation.class);
            deliveryInfo.setDeliverOrderRelation(deliverOrderRelation);

            deliveryService.updateDelivery(deliveryInfo);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = "更新失败";

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

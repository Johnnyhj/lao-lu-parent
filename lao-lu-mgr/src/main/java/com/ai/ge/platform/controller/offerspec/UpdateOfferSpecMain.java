package com.ai.ge.platform.controller.offerspec;

import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.controller.sys.ServiceParamMain;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.model.order.OfferSpecInfo;
import com.ai.ge.utils.AbilityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by guochunhao on 17/5/12.
 */
@Service
@AbilityRegister(name = "updateOfferSpec")
public class UpdateOfferSpecMain extends ServiceParamMain implements IAbility
{
    private Logger logger = LoggerFactory.getLogger(UpdateOfferSpecMain.class);

    @Override
    public Message execute(Message message)
    {
        int resultCode = AbilityConstant.R_SUCCESS;
        String resultMsg = "更新成功";

        Message request = new Message();

        try
        {
            OfferSpecDto record = message.getParam(OfferSpecDto.class);
            OfferSpecInfo info = message.getParam(OfferSpecInfo.class);
            record.setOfferSpecInfo(info);

            offerSpecService.updateOfferSepc(record);

        } catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());

            resultCode = AbilityConstant.R_ERROR_SYSTEM;
            resultMsg = "更新失败" + e.getMessage();
        }finally
        {
            request.setAbilityName("listOfferSpec");

            message.getRequest().setAttribute("addDto", new OfferSpecDto());

            request.setRequest(message.getRequest());
            request = AbilityUtil.invokeSync(request);
            request.setBody(request.getBody());
            request.setCode(resultCode);
            request.setMsg(resultMsg);

        }
        return request;
    }
}

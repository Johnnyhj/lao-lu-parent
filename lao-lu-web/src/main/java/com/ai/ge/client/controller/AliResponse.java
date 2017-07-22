package com.ai.ge.client.controller;

import com.ai.ge.ali.executor.ActionExecutor;
import com.ai.ge.bus.core.AbilityConstant;
import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.constant.AlipayServiceEnvConstants;
import com.ai.ge.dispatcher.Dispatcher;
import com.ai.ge.util.RequestUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.internal.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Sam on 17/5/26.
 */
@Service
@AbilityRegister(name = "response")
public class AliResponse implements IAbility {

    private Logger logger = LoggerFactory.getLogger(AliResponse.class);

    @Override
    public Message execute(Message message) {
        HttpServletRequest request = message.getRequest();
        //支付宝响应消息
        String responseMsg = "";
        //1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        //打印本次请求日志，开发者自行决定是否需要
        logger.info("支付宝请求串", params.toString());
        try {
            //2. 验证签名
            this.verifySign(params);
            //3. 获取业务执行器   根据请求中的 service, msgType, eventType, actionParam 确定执行器
            ActionExecutor executor = Dispatcher.getExecutor(params);
            //4. 执行业务逻辑
            responseMsg = executor.execute();
        }
        catch (AlipayApiException alipayApiException) {
            //开发者可以根据异常自行进行处理
            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
            message.setMsg(alipayApiException.getMessage());
            alipayApiException.printStackTrace();
        }
        catch (Exception exception) {
            //开发者可以根据异常自行进行处理
            message.setCode(AbilityConstant.R_ERROR_SYSTEM);
            message.setMsg(exception.getMessage());
            exception.printStackTrace();

        } finally {
            //5. 响应结果加签及返回
            try {
                //对响应内容加签
                responseMsg = encryptAndSign(responseMsg,
                        AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY,
                        AlipayServiceEnvConstants.PRIVATE_KEY, AlipayServiceEnvConstants.CHARSET,
                        false, true, AlipayServiceEnvConstants.SIGN_TYPE);
                //http 内容应答
//                response.reset();
//                response.setContentType("text/xml;charset=GBK");
//                PrintWriter printWriter = response.getWriter();
//                printWriter.print(responseMsg);
//                response.flushBuffer();
                //TODO 确认 message.setBody 返回
                message.setBody(responseMsg);
                //开发者自行决定是否要记录，视自己需求
                logger.info("开发者响应串", responseMsg);

            } catch (AlipayApiException alipayApiException) {
                //开发者可以根据异常自行进行处理
                message.setCode(AbilityConstant.R_ERROR_SYSTEM);
                message.setMsg(alipayApiException.getMessage());
                alipayApiException.printStackTrace();
            }
        }
        return message;
    }

    /**
     * 验签
     *
     * @param params‘
     * @return
     */
    private void verifySign(Map<String, String> params) throws AlipayApiException {

        if (!AlipaySignature.rsaCheckV2(params, AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY,
                AlipayServiceEnvConstants.SIGN_CHARSET, AlipayServiceEnvConstants.SIGN_TYPE)) {
            throw new AlipayApiException("verify sign fail.");
        }
    }

    public static String encryptAndSign(String bizContent, String alipayPublicKey, String cusPrivateKey, String charset,
                                        boolean isEncrypt, boolean isSign, String signType) throws AlipayApiException {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(charset)) {
            charset = AlipayConstants.CHARSET_GBK;
        }
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        if (isEncrypt) {// 加密
            sb.append("<alipay>");
            String encrypted = AlipaySignature.rsaEncrypt(bizContent, alipayPublicKey, charset);
            sb.append("<response>" + encrypted + "</response>");
            sb.append("<encryption_type>AES</encryption_type>");
            if (isSign) {
                String sign = AlipaySignature.rsaSign(encrypted, cusPrivateKey, charset, signType);
                sb.append("<sign>" + sign + "</sign>");
                sb.append("<sign_type>");
                sb.append(signType);
                sb.append("</sign_type>");
            }
            sb.append("</alipay>");
        } else if (isSign) {// 不加密，但需要签名
            sb.append("<alipay>");
            sb.append("<response>" + bizContent + "</response>");
            String sign = AlipaySignature.rsaSign(bizContent, cusPrivateKey, charset, signType);
            sb.append("<sign>" + sign + "</sign>");
            sb.append("<sign_type>");
            sb.append(signType);
            sb.append("</sign_type>");
            sb.append("</alipay>");
        } else {// 不加密，不加签
            sb.append(bizContent);
        }
        return sb.toString();
    }
}

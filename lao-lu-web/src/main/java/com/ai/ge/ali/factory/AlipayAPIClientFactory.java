package com.ai.ge.ali.factory;

import com.ai.ge.constant.AlipayServiceEnvConstants;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * Created by Sam on 17/5/18.
 */
public class AlipayAPIClientFactory {
    /** API调用客户端 */
    private static AlipayClient alipayClient;

    /**
     * 获得API调用客户端
     *
     * @return
     */
    public static AlipayClient getAlipayClient(){

        if(null == alipayClient){
            alipayClient = new DefaultAlipayClient(AlipayServiceEnvConstants.ALIPAY_GATEWAY, AlipayServiceEnvConstants.APP_ID,
                    AlipayServiceEnvConstants.PRIVATE_KEY, "json", AlipayServiceEnvConstants.CHARSET,AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY, AlipayServiceEnvConstants.SIGN_TYPE);
        }
        return alipayClient;
    }
}

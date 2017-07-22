package com.ai.ge.constant;

import com.ai.ge.util.CommonUtil;

/**
 *  支付宝服务窗环境常量
 *
 * Created by Sam on 17/5/18.
 */
public class AlipayServiceEnvConstants {

    /**支付宝公钥-从支付宝生活号详情页面获取*/
    public static final String ALIPAY_PUBLIC_KEY = CommonUtil.getConfigValue("alipay.public.key");
            //"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0oJkw6buYnBHLJbnzEEBJwKIJw1rC2MZEtoilLoCXtKCIkgRckriaF9ifS7/85VyupZDSot+af2rxjyh0RMcWJCkx220pPdFqftHaFlfDpU7iFmZt9P5WTxnjc249Cl0xH2VsSTVpDf/g1tWTsPy8e8LVP5uuPMljsFHDnIo0LFUKluw51sZUwieitgzzx21YwZYN5M0VM8N6s6HQECaVG24FfLJMpOC3du/vVY1Rtdti+KgR0ZnH/dIFlJLH2own3tQ2FtImWWxPaC1EKvM2Hz5LvGVVsxVxdzNX6R7Vc/0yWYfAiBFfIWBnHJUJYQm6XrB/j++9wZpFltQcNaSnQIDAQAB";

    /**签名编码-视支付宝服务窗要求*/
    public static final String SIGN_CHARSET      = "GBK";

    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "GBK";

    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA2";

    /**开发者账号PID*/
    public static final String PARTNER           = CommonUtil.getConfigValue("alipay.partner");
            //"2088102169326833";

    /** 服务窗appId  */
    //TODO !!!! 注：该appId必须设为开发者自己的生活号id
    public static final String APP_ID            = CommonUtil.getConfigValue("alipay.app.appid");
            //"2016073100134721";

    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患
    public static final String PRIVATE_KEY       = CommonUtil.getConfigValue("alipay.app.private.key");
            //"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDo7tPBG9iBjUqqXTe53FY3dP+cYncT9sS9Vmr6qZb11NDmdEy6E8teI+MMAyujIrBtNLVKFx/kBe5T1bCzQZJ6K0p33oc+ocIgSJgbQVm3KkAikLXYhQPnZmwNStA7i5For2fL9j5B6+6qssdQrUdmQKbG7jmOWvjjr8AMd5w6ibwoHVcjEfN5T56KvuQ4td7++uxUWKLRgJPJNpaFSkkdpamPu7CPvuqFdLC3Qm1tuX0LVa8k+5p5HGtaGZRHuMzElGO4G6ABl16mSHTH7gH3Xc6Y4F5hDrttCoh/ipzYivF77Wn4N60f955SIQUpU7n3Be5BWggfGPBWV5JicsQlAgMBAAECggEAF4sMHBiUaYO+aDnDyCVdEX3h2AybvIjUmc6CQZOijnZUJvbaSnR1ua4m5K/tWS/IZUFOkY6EyqdOz2pp0bRu+aomfLchNFNlK54qwZZ5WuoKUXQO7TOEkX7orO9C3MHekJYqB5N7923BUb+AJcdd0Bf4w2KQrrLDNUAuSRRN1hykaRnponpyUaYjfLh7wWmdxjKx6zBUbaYG3iRrxHllOeiX17hU1b3EHKxwHFZp6LVK6v+0YXpEWJkwLE5OSiP+0FkaXup7Pmqdm7ewbUhykZGeUVBJn/omycSO7wmv/dVmC1mBoZpAIIujS4YMPJws0VGsVNpEK0+nruUj6SDQAQKBgQD4TYwTvevnJlHoB3sRi1WLGsgCYOseKDRtE/Mw2fCXslPlJemlzaiIEJrHDdmqnGGsoSjNj1mV9x3ZMX0uUpMexlT38E3rYKs44Ssw2U4WCM325TvJjwjQTFfMoNu3ptv5oluPhejAsYJtHTTAHRdhSErKRJLAxkGUkgVKOl/GRQKBgQDwJ07+R09K7d83BUaWUGpAusA0PE6deUel7bdD7yuPSChFBQV/s8PDIpai1HEtNYw7/2hEedvrC111gHn6p8OiE5WTqe9SlZDIxYcnS6dY/no0V4/AtqtgdtRoQKs5AAGtnjmLfFx16HAY0GNQE1S3Y1mH6Lxq/wgXzbgz0VJUYQKBgGT/Hef1y1uFAbHQQSW8t/nR1eLpyxjEH7byc2u+ahc56Nf/GM9hHJjjsCEhKBU2cKBIGRGrqjPOhSyP7awG2GKfJ3aGHxuLgXmsVOYUradWw3gWe8AbVulq9Bd+ooBL9ZPPj1CMlkSyryt0wr0V2CmwvwMQ62RP/+LPlilAHy7FAoGASO+nThLaQid8Y3l2trA1lPMi7LpkJe9vkzVfM4Kv+BQyJsQfp2kxS1J17X4X4WMh9Bbd0+4unHQXLliWs0nAYLkR9Ibn6G0ES/Wx1n1jleOzubHeNulDo0hzujXpyqX13ITxdSuP6T9uzBp+DxPP5uKFjoFguB48lv4js5kfKAECgYAOV3QukJon8YXNSeqqPIOaDLiZx6tSd8HyGw4LaL5+cBa4ZJWkCT1R9MgcNVC7EasBSMPUbQxoFy8aak+NlWnfOOH5IEOnh6r5HiH761bBvjGcHsRg3X0t+nyvveoMl/aeHe4z/pYGL3RiRPRMwIc0aY0hGIbKFKgdVrv/D8q/wg==";

    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        =CommonUtil.getConfigValue("alipay.app.public.key");
            //"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6O7TwRvYgY1Kql03udxWN3T/nGJ3E/bEvVZq+qmW9dTQ5nRMuhPLXiPjDAMroyKwbTS1Shcf5AXuU9Wws0GSeitKd96HPqHCIEiYG0FZtypAIpC12IUD52ZsDUrQO4uRaK9ny/Y+QevuqrLHUK1HZkCmxu45jlr446/ADHecOom8KB1XIxHzeU+eir7kOLXe/vrsVFii0YCTyTaWhUpJHaWpj7uwj77qhXSwt0Jtbbl9C1WvJPuaeRxrWhmUR7jMxJRjuBugAZdepkh0x+4B913OmOBeYQ67bQqIf4qc2Irxe+1p+DetH/eeUiEFKVO59wXuQVoIHxjwVleSYnLEJQIDAQAB";
    /**支付宝网关*/
//    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";
    public static final String ALIPAY_GATEWAY    = CommonUtil.getConfigValue("alipay.gateway");
            //" https://openapi.alipaydev.com/gateway.do";



    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";
}

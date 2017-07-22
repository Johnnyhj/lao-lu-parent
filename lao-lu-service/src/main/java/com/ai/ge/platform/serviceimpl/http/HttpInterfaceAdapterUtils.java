package com.ai.ge.platform.serviceimpl.http;

import com.ai.ge.platform.service.sys.SysDataService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.ContextLoaderListener;

/**
 * 计费、CRM 各接口调用地址适配器工具类
 */
public class HttpInterfaceAdapterUtils {


    /**
     * CRM 订单竣工查询接口报文模板
     *
     * @param areaCode 各省的区域编码 可空
     * @return CRM 订单竣工查询接口报文模板
     */
    public static String getCrmOrderQueryTemplate(String areaCode) {
        String template = "crm_complete_templ";
        if (StringUtils.isNotBlank(areaCode)) {
            template += '/' + areaCode;
        }
        return getSysDataService().getByKeyType(template, SysDataService.INTERFACE_URL);
    }

    /**
     * 计费批量查询用户是否履约接口报文模板
     *
     * @param areaCode 各省的区域编码 可空
     * @return 计费批量查询用户是否履约接口报文模板
     */
    public static String getBillPerformanceQueryTemplate(String areaCode) {
        String template = "bill_performance_templ";
        if (StringUtils.isNotBlank(areaCode)) {
            template += '/' + areaCode;
        }

        return getSysDataService().getByKeyType(template, SysDataService.INTERFACE_URL);
    }


    /**
     * CRM 订单竣工查询接口地址
     *
     * @param areaCode 各省的区域编码 必填
     * @return CRM 订单竣工查询接口地址
     */
    public static String getCrmOrderQueryUrl(String areaCode) {
        return getSysDataService().getByKeyType("crm_complete_url/" + areaCode, SysDataService.INTERFACE_URL);
    }

    /**
     * 计费批量查询用户是否履约接口地址
     *
     * @param areaCode 各省的区域编码 必填
     * @return 计费批量查询用户是否履约接口地址
     */
    public static String getBillPerformanceQueryUrl(String areaCode) {
        return getSysDataService().getByKeyType("bill_performance_url/" + areaCode, SysDataService.INTERFACE_URL);
    }


    private static SysDataService getSysDataService() {
        return ContextLoaderListener.getCurrentWebApplicationContext().getBean("sysDataServiceImpl", SysDataService.class);
    }
}

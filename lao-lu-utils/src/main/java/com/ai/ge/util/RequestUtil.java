package com.ai.ge.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhaocy3
 */
public class RequestUtil {
    private static Logger log = Logger.getLogger(RequestUtil.class);

    /**
     * 从http接口接收Content消息体
     *
     * @param request
     * @return
     */
    public static String readContent(HttpServletRequest request) {
        int length = request.getContentLength();
        StringWriter sw = new StringWriter(length);

        try {
            IOUtils.copy(request.getInputStream(), sw, CharEncoding.UTF_8);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return sw.toString();
    }

    /**
     * 获取远程IP地址
     *
     * @param request
     * @return
     */
    public static String getRemortIP(HttpServletRequest request) {
        return CommonUtil.getRemortIp(request);
    }

    /**
     * @param request
     * @return
     */
    public static String getChannelByHost(HttpServletRequest request) {
        String host = request.getHeader("Host");
        log.debug("host:" + host);
        if (host == null) {
            return null;
        } else if (host.indexOf(".") <= 0) {
            return host;
        }
        String channel = host.split("\\.")[0];

        log.debug("channel:" + channel);

        return channel;
    }

    /**
     * @param request
     * @return
     */
    public static boolean isMoblie(HttpServletRequest request) {
        boolean isMoblie = false;
        String[] mobileAgents = {"iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
                "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
                "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
                "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
                "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
                "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos", "pantech",
                "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320", "240x320",
                "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac", "blaz",
                "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs", "kddi",
                "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi", "mot-",
                "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port", "prox",
                "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem", "smal",
                "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda",
                "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-", "Googlebot-Mobile"};
        if (request.getHeader("User-Agent") != null) {
            for (String mobileAgent : mobileAgents) {
                if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
                    isMoblie = true;
                    break;
                }
            }
        }
        return isMoblie;
    }

    /**
     * 获取访问设备
     *
     * @param userAgent
     * @return
     */
    public static String getDevice(String userAgent) {
        String[] keywords = {"Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser"};

        //排除 Windows 桌面系统
        if (!userAgent.contains("Windows NT") || (userAgent.contains("Windows NT") && userAgent.contains("compatible; MSIE 9.0;")
        )) {
            //排除 苹果桌面系统
            if (!userAgent.contains("Macintosh")) {
                for (String item : keywords) {
                    if (userAgent.contains(item)) {
                        return item;
                    }
                }
            } else {
                return "Macintosh";
            }
        } else {
            return "Windows NT";
        }

        return "Unknow";
    }


    /**
     * 获取所有request请求参数key-value
     *
     * @param request
     * @return
     */
    public static Map<String, String> getRequestParams(HttpServletRequest request) {

        Map<String, String> params = new HashMap<String, String>();
        if (null != request) {
            Set<String> paramsKey = request.getParameterMap().keySet();
            for (String key : paramsKey) {
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }
}

package com.ai.ge.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpUtil {
    private static final Logger logger = LoggerFactory.getLogger(IpUtil.class);


    /**
     * 将127.0.0.1形式的IP地址转换成十进制整数
     *
     * @param strIp
     * @return
     */
    public static long ipToLong(String strIp) {
        if (logger.isDebugEnabled()) {
            logger.debug("IP地址[" + strIp + "]转换成十进制整数");
        }
        if (StringUtils.isBlank(strIp)) {
            return -1;
        }
        long[] ip = new long[4];
        String[] arr = strIp.split("\\.");
        //将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(arr[0]);
        ip[1] = Long.parseLong(arr[1]);
        ip[2] = Long.parseLong(arr[2]);
        ip[3] = Long.parseLong(arr[3]);
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    /**
     * 将十进制整数形式转换成127.0.0.1形式的ip地址
     *
     * @param longIp
     * @return
     */
    public static String longToIP(long longIp) {
        StringBuffer sb = new StringBuffer("");
        //直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        //将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        //将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        //将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(IpUtil.longToIP(3423264768L));
        System.out.println(IpUtil.ipToLong("59.66.245.0"));

    }

}

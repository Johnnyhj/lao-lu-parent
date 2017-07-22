package com.ai.ge.arrears.constant;

import com.ai.ge.util.CommonUtil;

/**
 * Created by Sam on 17/5/25.
 */
public class ArrearsConstants {
    /**
     * 需要催缴
     */
    public static final Integer NEEDCALL = 1;

    /**
     * 不需要催缴
     */
    public static final Integer NONEEDCALL = 2;


    public static final String ARREAR_SIZE = "_ARREAR_SIZE_";

//    public static final String ARREAR_LINE = "_TOTAL_LINE_";

    public static final String CHIP_FILE_FLAG="_CHIP_";

    public static final String HANDLE_SIZE = "_HANDLE_SIZE_";

    public static final String SPLIT_FLAG="split/";

    public static final String FTP_SERVER=CommonUtil.getConfigValue("ftp.server");

    public static final String FTP_USERNAME=CommonUtil.getConfigValue("ftp.username");

    public static final String FTP_PASSWORD=CommonUtil.getConfigValue("ftp.password");

    public static final String FTP_PORT=CommonUtil.getConfigValue("ftp.port");

    public static final String REMOTEPATH=CommonUtil.getConfigValue("file.remote.path");

    public static final String LOCLPATH=CommonUtil.getConfigValue("file.local.path");

    public static final String SEPARATOR="_";



    public static final long CENTRAL_PROCESSING_INTERVAL=Long.parseLong(CommonUtil.getConfigValue("central.processing.interval"));


}

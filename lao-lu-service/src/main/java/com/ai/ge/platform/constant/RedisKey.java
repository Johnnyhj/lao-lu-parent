package com.ai.ge.platform.constant;

/**
 * Redis Key
 */
public interface RedisKey {

    String PROJECT_NAME = "SHOW_ROOM";

    /**
     * 云南展厅所有key值前缀
     */
    String SHOWROOM_PREFIX = PROJECT_NAME + "showroom_prefix_";

    /**
     * WebService配置数据
     */
    String QUERY_ALL_SYSTEM_INTERFACE_CONFIG = PROJECT_NAME + "query_all_system_interface_config";

    /**
     * 管理功能中用户角色权限
     */
    String MGR_QUERY_USER_ROLE = PROJECT_NAME + "mgr_query_user_role_";

    /**
     * 管理功能中用户信息
     */
    String MGR_QUERY_USER_INFO = PROJECT_NAME + "mgr_query_user_info_";

    /**
     * Log采集器数据Redis Key
     */
    String LOGSTASH_LIST = PROJECT_NAME + "logstash-list";

    /**
     * 微信access_token
     */
    String WX_ACCESS_TOKEN = PROJECT_NAME + "wx_access_token";

    /**
     * 微信html access_token
     */
    String WX_HTML_ACCESS_TOKEN = PROJECT_NAME + "wx_html_access_token";

    /**
     * web端行业产品
     */
    String WEB_PRODUCT_LIST = PROJECT_NAME + "_web_product_list_";

    /**
     * mgr 行业产品
     */
    String WEB_PRODUCT_LIST_MGR = PROJECT_NAME + "_web_product_list_mgr_";

    /**
     * 首页轮播图
     */
    String HOME_PIC = PROJECT_NAME + "_home_pic_";


    /**
     * 场馆相关key值
     */
    interface DisplayKey {
        /**
         * 查询客户预约
         */
        String QUERY_RESERVE_LIST = SHOWROOM_PREFIX + "query_reserve_list";

        /**
         * 查询场馆列表
         */
        String QUERY_DISPLAY_VENUE_LIST = SHOWROOM_PREFIX + "query_display_venue_list";

        /**
         * 场馆信息列表查询
         */
        String QUERY_DISPLAY_VENUE_INFO_LIST = SHOWROOM_PREFIX + "query_display_venue_info_list";

    }

    /**
     * 客户相关key值
     */
    interface CustomerKey {
        /**
         * 查询客户列表
         */
        String QUERY_CUSTOMER_LIST = SHOWROOM_PREFIX + "query_customer_list";

        /**
         * 实时数据采集查询
         */
        String QUERY_CUSTOMER_COMMENT_SUGGESTION = SHOWROOM_PREFIX + "query_customer_comment_suggestion";

        /**
         * 个人客户信息列表查询
         */
        String QUERY_CUSTOMER_AND_RESERVE_LIST = SHOWROOM_PREFIX + "query_customer_and_reserve_list";

        /**
         * 企业客户信息列表查询
         */
        String QUERY_CUSTOMER_ENTERPRISE_LIST = SHOWROOM_PREFIX + "query_customer_enterprise_list";

        /**
         * 个人客户信息详情查询
         */
        String QUERY_CUSTOMER_DETAIL = SHOWROOM_PREFIX + "query_customer_detail";

        /**
         * 企业客户信息详情查询
         */
        String QUERY_CUSTOMER_ENTERPRISE_DETAIL = SHOWROOM_PREFIX + "query_customer_enterprise_detail";

        /**
         * 客户问题详情查询
         */
        String QUERY_CUSTOMER_QUESTION_DETAILS = SHOWROOM_PREFIX + "query_customer_question_details";
    }

    /**
     * 日志相关key值
     */
    interface LogKey {
        /**
         * 查询所有消息推送
         */
        String QUERY_LOG_SEND_MSG_ALL = SHOWROOM_PREFIX + "query_log_send_msg_all";

        /**
         * 查询推送消息详情
         */
        String QUERY_LOG_SEND_MSG_DETAIL_ALL = SHOWROOM_PREFIX + "query_log_send_msg_detail_all";

        /**
         * 查询logAuthProcess表所有记录
         */
        String QUERY_LOG_AUTH_PROCESS_ALL = SHOWROOM_PREFIX + "query_log_auth_process_all";

        /**
         * 查询所有预警详情 [按场馆分组]
         */
        String QUERY_WARN_LOG_ALL = SHOWROOM_PREFIX + "query_warn_log_all";
    }
}

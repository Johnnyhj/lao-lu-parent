/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/5/8 14:19:37                            */
/*==============================================================*/


drop table if exists LOG_AUTH_PROCESS;

drop table if exists LOG_CUSTOMER_OPERATION;

drop table if exists LOG_INTERFACE_CALL;

drop table if exists SYSTEM_DATA_DICTIONARY;

drop table if exists SYS_ORGANIZATION;

drop table if exists SYS_ORGA_ROLE_REL;

drop table if exists SYS_RESOURCE;

drop table if exists SYS_ROLE;

drop table if exists SYS_ROLE_RESOURCE_RELEATION;

drop table if exists SYS_USER;

drop table if exists SYS_USER_ORGANIZATION;

drop table if exists SYS_USER_ROLE_RELEATION;

/*==============================================================*/
/* Table: LOG_AUTH_PROCESS                                      */
/*==============================================================*/
create table LOG_AUTH_PROCESS
(
   PROCESS_ID           bigint(12) not null auto_increment comment '授权过程日志主键',
   AUTH_ROLE_NAME       varchar(4000) comment '授权角色列表',
   SYS_USER_ID          bigint(12),
   AUTH_SYS_USER_ID     bigint(12),
   EFFECTIVE_TIME       datetime comment '生效时间',
   FAIL_TIME            datetime comment '失效时间',
   AUTH_TYPE            smallint(3) comment '授权类型，1.权限，2.角色，3.授权',
   OPERATE_TYPE         smallint(3) comment '操作类型，1.新增，2.修改，3.删除',
   RESOURCE_ID          bigint(12),
   RESOURCE_NAME        varchar(512),
   ROLE_ID              bigint(12),
   ROLE_NAME            varchar(512),
   OLD_VAL              varchar(4000) comment '原值',
   NEW_VAL              varchar(4000) comment '新值',
   CREATE_TIME          datetime default NULL comment '创建时间',
   REMARK               varchar(512),
   primary key (PROCESS_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table LOG_AUTH_PROCESS comment '授权过程日志';

/*==============================================================*/
/* Table: LOG_CUSTOMER_OPERATION                                */
/*==============================================================*/
create table LOG_CUSTOMER_OPERATION
(
   CUSTOMER_OPERATION_ID bigint(12) not null auto_increment comment '用户操作日志ID',
   AREA_LINK_CONFIG_ID  bigint(12) comment '区域链接配置表ID',
   CUST_ID              bigint(12) comment '顾客ID',
   PHONE_NUM            varchar(20) comment '电话号码',
   USER_UNIQUE_ID       varchar(64) comment '用户唯一标识',
   CHANNEL              varchar(256) comment '渠道',
   DEVICES              varchar(2048) comment '设备',
   REQUEST_REFERER      varchar(2048) comment '请求来源',
   USER_AGENT           varchar(2048) comment '用户代理',
   COOKIE               varchar(2048) comment 'Cookie',
   REQUEST_URL          varchar(2048) comment '请求链接',
   REQUEST_PARAM        varchar(2048) comment '请求参数',
   REQUEST_TYPE         varchar(16) comment '请求类型',
   REQUEST_IP           varchar(256) comment '请求IP',
   REQUEST_HEADER       varchar(4000) comment '请求头',
   SESSION_ID           varchar(64) comment 'SESSION_ID',
   CREATE_TIME          datetime default NULL comment '创建时间',
   REQUEST_TIME         datetime comment '请求时间',
   RESPONSE_TIME        datetime comment '响应时间',
   INTERVAL_TIME        bigint(6) comment '间隔时间',
   primary key (CUSTOMER_OPERATION_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table LOG_CUSTOMER_OPERATION comment '用户操作轨迹日志';

/*==============================================================*/
/* Table: LOG_INTERFACE_CALL                                    */
/*==============================================================*/
create table LOG_INTERFACE_CALL
(
   INTERFACE_CALL_ID    bigint(12) not null auto_increment,
   PHONE_NUM            varchar(11) comment '手机号码',
   URL                  varchar(1024),
   PARAMS               text,
   ACTION_NAME          varchar(256) comment '接口功能名称',
   REQUEST_TIMES        datetime,
   HTTP_CODE            bigint comment 'HTTP响应码',
   RESPONSE_TIMES       datetime comment '接口请求，响应时间，单位毫秒',
   INTERFACE_CALL_TIMES bigint(12),
   RESULT               int default 1 comment '0.失败，1.成功',
   RESULT_TEXT          text comment '返回内容',
   FAIL_REASON          text comment '失败原因，报文中返回的错误信息或系统异常信息',
   EXTERNAL_ORDER_SEQ   varchar(1024) comment '外部订单流水号',
   ORDER_GROUP_SEQ      varchar(128) comment '订单组流水号',
   REPEATE_CALL_NUM     smallint(3) default 0,
   CREATE_TIME          datetime default NULL,
   REMARKS              varchar(2048),
   primary key (INTERFACE_CALL_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: SYSTEM_DATA_DICTIONARY                                */
/*==============================================================*/
create table SYSTEM_DATA_DICTIONARY
(
   DD_ID                bigint(12) not null auto_increment comment '数据字典主键',
   `KEY`                  varchar(256) comment '数据键',
   VALUE                varchar(4000) comment '数据值',
   TYPE                 varchar(256) comment '数据类别',
   ROLE                 smallint(3) comment '权限：0.系统级别不提供修改界面，1.管理员级别，管理员可修改',
   `DESCRIBE`           varchar(4000) comment '描述',
   EXPAND1              varchar(4000) comment '扩展字段1',
   EXPAND2              varchar(4000) comment '扩展字段2',
   EXPAND3              varchar(4000) comment '扩展字段3',
   primary key (DD_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYSTEM_DATA_DICTIONARY comment '数据字典表';

/*==============================================================*/
/* Table: SYS_ORGANIZATION                                      */
/*==============================================================*/
create table SYS_ORGANIZATION
(
   ID                   bigint(12) not null auto_increment comment '系统组织机构主键',
   USERNAME             varchar(64) comment '名称',
   PARENT_ID            bigint(12) comment '父级ID',
   PARENT_IDS           varchar(1024) comment '所有上级IDS',
   ROOT_ID              bigint(12) comment '顶级ID',
   AVAILABLE            smallint(3) comment '是否有效。1.启用。0.禁用',
   POST                 varchar(256) comment '职务：引用数据字典表中key=SYS_ORGANIZATION_POST 字段的值',
   ORG_ADMIN            smallint(3) default 0 comment '机构负责人：0.否，1.是',
   LEADER_ID            bigint(12) comment '当前用户在该机构内的上级',
   CREATE_TIME          datetime default NULL comment '创建时间',
   UPDATE_TIME          datetime comment '更新时间',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_ORGANIZATION comment '系统组织机构表';

/*==============================================================*/
/* Table: SYS_ORGA_ROLE_REL                                     */
/*==============================================================*/
create table SYS_ORGA_ROLE_REL
(
   ORGA_ROLE_ID         bigint(12) not null auto_increment comment '系统组织机构角色表主键',
   ROLE_ID              bigint(12) comment '系统角色主键',
   ORGA_ID              bigint(12) comment '系统组织机构主键',
   CREATE_TIME          datetime default NULL comment '创建时间',
   EFFECTIVE_TIME       datetime comment '生效时间',
   FAIL_TIME            datetime comment '失效时间',
   primary key (ORGA_ROLE_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_ORGA_ROLE_REL comment '系统组织机构角色表';

/*==============================================================*/
/* Table: SYS_RESOURCE                                          */
/*==============================================================*/
create table SYS_RESOURCE
(
   ID                   bigint(12) not null auto_increment comment '系统资源主键',
   NAME                 varchar(12) comment '名称',
   TYPE                 varchar(64) comment '类型',
   URL                  varchar(128) comment '路径',
   PARENT_ID            bigint(12) comment '父级ID',
   PARENT_IDS           varchar(1024) comment '所有上级IDS',
   ROOT_ID              bigint(12) comment '顶级ID',
   PERMISSION           varchar(512) comment '权限字符串',
   AVAILABLE            smallint(3) comment '是否有效。1.启用。0.禁用',
   CREATE_TIME          datetime default NULL comment '创建时间',
   UPDATE_TIME          datetime comment '更新时间',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_RESOURCE comment '系统资源表';

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE
(
   ID                   bigint(12) not null auto_increment comment '系统角色主键',
   ROLE                 varchar(128) comment '名称',
   DESCRIPTION          varchar(512) comment '描述',
   RESOURCE_IDS         varchar(2048) comment '系统资源IDS',
   AVAILABLE            smallint(3) comment '是否有效。1.启用。0.禁用',
   CREATE_TIME          datetime default NULL comment '创建时间',
   UPDATE_TIME          datetime comment '更新时间',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_ROLE comment '系统角色表';

/*==============================================================*/
/* Table: SYS_ROLE_RESOURCE_RELEATION                           */
/*==============================================================*/
create table SYS_ROLE_RESOURCE_RELEATION
(
   SRR_ID               bigint(12) not null auto_increment comment '系统角色资源ID',
   SYS_ROLE_ID          bigint(12) comment '系统资源主键',
   SYS_RESOURCE_ID      bigint(12) comment '系统角色主键',
   CREATE_TIME          datetime default NULL,
   primary key (SRR_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_ROLE_RESOURCE_RELEATION comment '系统角色资源关联表';

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER
(
   ID                   bigint(12) not null auto_increment comment '系统用户主键',
   USERNAME             varchar(64) comment '用户名',
   PASSWORD             varchar(128) comment '密码',
   SALT                 varchar(128) comment '密码加密盐值',
   LOCKED               smallint(3) comment '是否锁定',
   USER_TYPE            smallint(3) comment '用户类型：
            0.系统管理员，
            1.运营人员',
   TEL_PHONE            varchar(64) comment '电话',
   EMAIL                varchar(128) comment '邮箱',
   JOB_UNIT             varchar(128) comment '单位',
   USER_LEVEL                varchar(512) comment '级别：引用数据字典表中 key = SYS_USER_LEVEL 进行配置',
   CREATE_TIME          datetime default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime default CURRENT_TIMESTAMP comment '更新时间',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_USER comment '系统用户表';


/*==============================================================*/
/* Table: SYS_USER_ORGANIZATION                                 */
/*==============================================================*/
create table SYS_USER_ORGANIZATION
(
   SUO_ID               bigint(12) not null auto_increment comment '用户机构关联ID',
   ORGA_ID              bigint(12) comment '系统组织机构主键',
   USER_ID              bigint(12) comment '系统用户主键',
   CREATE_TIME          datetime default NULL comment '创建时间',
   primary key (SUO_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_USER_ORGANIZATION comment '用户机构关联表';

/*==============================================================*/
/* Table: SYS_USER_ROLE_RELEATION                               */
/*==============================================================*/
create table SYS_USER_ROLE_RELEATION
(
   SURR_ID              bigint(12) not null auto_increment comment '系统用户角色关联主键',
   SYS_ROLE_ID          bigint(12) comment '系统权限主键',
   SYS_USER_ID          bigint(12) comment '系统用户主键',
   CREATE_TIME          datetime default NULL,
   EFFECTIVE_TIME       datetime comment '生效时间',
   FAIL_TIME            datetime comment '失效时间',
   UPDATE_TIME          datetime comment '更新时间',
   primary key (SURR_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_USER_ROLE_RELEATION comment '系统用户角色关联表';


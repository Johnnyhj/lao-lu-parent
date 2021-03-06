CREATE TABLE qrtz_job_details
(
    JOB_NAME VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    DESCRIPTION VARCHAR(250),
    JOB_CLASS_NAME VARCHAR(250) NOT NULL,
    IS_DURABLE VARCHAR(1) NOT NULL,
    IS_VOLATILE VARCHAR(1) NOT NULL,
    IS_STATEFUL VARCHAR(1) NOT NULL,
    REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
    JOB_DATA BLOB,
    CONSTRAINT `PRIMARY` PRIMARY KEY (JOB_NAME, JOB_GROUP)
);
CREATE INDEX JOB_NAME ON qrtz_job_details (JOB_NAME);

CREATE TABLE qrtz_triggers
(
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    JOB_NAME VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    IS_VOLATILE VARCHAR(1) NOT NULL,
    DESCRIPTION VARCHAR(250),
    NEXT_FIRE_TIME BIGINT(13),
    PREV_FIRE_TIME BIGINT(13),
    PRIORITY INT(11),
    TRIGGER_STATE VARCHAR(16) NOT NULL,
    TRIGGER_TYPE VARCHAR(8) NOT NULL,
    START_TIME BIGINT(13) NOT NULL,
    END_TIME BIGINT(13),
    CALENDAR_NAME VARCHAR(200),
    MISFIRE_INSTR SMALLINT(2),
    JOB_DATA BLOB,
    CONSTRAINT `PRIMARY` PRIMARY KEY (TRIGGER_NAME, TRIGGER_GROUP),
    CONSTRAINT qrtz_triggers_ibfk_1 FOREIGN KEY (JOB_NAME, JOB_GROUP) REFERENCES qrtz_job_details (JOB_NAME, JOB_GROUP)
);
CREATE INDEX JOB_NAME ON qrtz_triggers (JOB_NAME, JOB_GROUP);

CREATE TABLE qrtz_blob_triggers
(
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    BLOB_DATA BLOB,
    CONSTRAINT `PRIMARY` PRIMARY KEY (TRIGGER_NAME, TRIGGER_GROUP),
    CONSTRAINT qrtz_blob_triggers_ibfk_1 FOREIGN KEY (TRIGGER_NAME, TRIGGER_GROUP) REFERENCES qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP)
);
CREATE TABLE qrtz_calendars
(
    CALENDAR_NAME VARCHAR(200) PRIMARY KEY NOT NULL,
    CALENDAR BLOB NOT NULL
);
CREATE TABLE qrtz_cron_triggers
(
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    CRON_EXPRESSION VARCHAR(200) NOT NULL,
    TIME_ZONE_ID VARCHAR(80),
    CONSTRAINT `PRIMARY` PRIMARY KEY (TRIGGER_NAME, TRIGGER_GROUP),
    CONSTRAINT qrtz_cron_triggers_ibfk_1 FOREIGN KEY (TRIGGER_NAME, TRIGGER_GROUP) REFERENCES qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP)
);
CREATE TABLE qrtz_fired_triggers
(
    ENTRY_ID VARCHAR(95) PRIMARY KEY NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    IS_VOLATILE VARCHAR(1) NOT NULL,
    INSTANCE_NAME VARCHAR(200) NOT NULL,
    FIRED_TIME BIGINT(13) NOT NULL,
    PRIORITY INT(11) NOT NULL,
    STATE VARCHAR(16) NOT NULL,
    JOB_NAME VARCHAR(200),
    JOB_GROUP VARCHAR(200),
    IS_STATEFUL VARCHAR(1),
    REQUESTS_RECOVERY VARCHAR(1)
);

CREATE TABLE qrtz_job_listeners
(
    JOB_NAME VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    JOB_LISTENER VARCHAR(200) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (JOB_NAME, JOB_GROUP, JOB_LISTENER),
    CONSTRAINT qrtz_job_listeners_ibfk_1 FOREIGN KEY (JOB_NAME, JOB_GROUP) REFERENCES qrtz_job_details (JOB_NAME, JOB_GROUP)
);
CREATE TABLE qrtz_locks
(
    LOCK_NAME VARCHAR(40) PRIMARY KEY NOT NULL
);
CREATE TABLE qrtz_paused_trigger_grps
(
    TRIGGER_GROUP VARCHAR(200) PRIMARY KEY NOT NULL
);
CREATE TABLE qrtz_scheduler_state
(
    INSTANCE_NAME VARCHAR(200) PRIMARY KEY NOT NULL,
    LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
    CHECKIN_INTERVAL BIGINT(13) NOT NULL
);
CREATE TABLE qrtz_simple_triggers
(
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    REPEAT_COUNT BIGINT(7) NOT NULL,
    REPEAT_INTERVAL BIGINT(12) NOT NULL,
    TIMES_TRIGGERED BIGINT(7) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (TRIGGER_NAME, TRIGGER_GROUP),
    CONSTRAINT qrtz_simple_triggers_ibfk_1 FOREIGN KEY (TRIGGER_NAME, TRIGGER_GROUP) REFERENCES qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP)
);
CREATE TABLE qrtz_trigger_listeners
(
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    TRIGGER_LISTENER VARCHAR(200) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (TRIGGER_NAME, TRIGGER_GROUP, TRIGGER_LISTENER),
    CONSTRAINT qrtz_trigger_listeners_ibfk_1 FOREIGN KEY (TRIGGER_NAME, TRIGGER_GROUP) REFERENCES qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP)
);

INSERT INTO `qrtz_locks` VALUES ('CALENDAR_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('JOB_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('MISFIRE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('TRIGGER_ACCESS');


-- CRM竣工查询
INSERT INTO qrtz_job_details (JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_VOLATILE, IS_STATEFUL, REQUESTS_RECOVERY, JOB_DATA) VALUES ('CrmCompleteJob', 'DEFAULT', '0 0/5 * * * ? * 表示每五分钟执行一次, CRM竣工查询', 'com.ai.ge.platform.job.CrmCompleteJob', '0', '0', '0', '0', null);
INSERT INTO qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, IS_VOLATILE, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA) VALUES ('CrmCompleteJobTrigger', 'DEFAULT', 'CrmCompleteJob', 'DEFAULT', '0', null, 1497490914000, 1497423068540, 5, 'WAITING', 'CRON', 1497490914000, 0, null, 0, null);
INSERT INTO qrtz_cron_triggers (TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID) VALUES ('CrmCompleteJobTrigger', 'DEFAULT', '0 0/5 * * * ? *', 'Asia/Shanghai');

-- 访问订单支付定时任务
INSERT INTO qrtz_job_details (JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_VOLATILE, IS_STATEFUL, REQUESTS_RECOVERY, JOB_DATA) VALUES ('OrdersPaymentTimeoutJob', 'DEFAULT', '0 0/7 * * * ? * 表示每7分钟执行一次, 访问订单支付定时任务', 'com.ai.ge.platform.job.OrdersPaymentTimeoutJob', '0', '0', '0', '0', null);
INSERT INTO qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, IS_VOLATILE, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA) VALUES ('OrdersPaymentTimeoutJobTrigger', 'DEFAULT', 'OrdersPaymentTimeoutJob', 'DEFAULT', '0', null, 1497423068540, 1497423068540, 5, 'WAITING', 'CRON', 1497490914000, 0, null, 0, null);
INSERT INTO qrtz_cron_triggers (TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID) VALUES ('OrdersPaymentTimeoutJobTrigger', 'DEFAULT', '0 0/7 * * * ? *', 'Asia/Shanghai');

-- 履约任务
INSERT INTO qrtz_job_details (JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_VOLATILE, IS_STATEFUL, REQUESTS_RECOVERY, JOB_DATA) VALUES ('PerformanceJob', 'DEFAULT', '0 0/3 * * * ? * 表示每3分钟执行一次, 履约任务', 'com.ai.ge.platform.job.PerformanceJob', '0', '0', '0', '0', null);
INSERT INTO qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, IS_VOLATILE, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA) VALUES ('PerformanceJobTrigger', 'DEFAULT', 'PerformanceJob', 'DEFAULT', '0', null, 1497490914000, 1497423068540, 5, 'WAITING', 'CRON', 1497490914000, 0, null, 0, null);
INSERT INTO qrtz_cron_triggers (TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID) VALUES ('PerformanceJobTrigger', 'DEFAULT', '0 0/3 * * * ? *', 'Asia/Shanghai');

-- 释放预占电话号码
INSERT INTO qrtz_job_details (JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_VOLATILE, IS_STATEFUL, REQUESTS_RECOVERY, JOB_DATA) VALUES ('ReleaseNumberJob', 'DEFAULT', '0 0/9 * * * ? * 表示每9分钟执行一次, 释放预占电话号码', 'com.ai.ge.platform.job.ReleaseNumberJob', '0', '0', '0', '0', null);
INSERT INTO qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, IS_VOLATILE, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA) VALUES ('ReleaseNumberJobTrigger', 'DEFAULT', 'ReleaseNumberJob', 'DEFAULT', '0', null, 1497490914000, 1497423068540, 5, 'WAITING', 'CRON', 1497490914000, 0, null, 0, null);
INSERT INTO qrtz_cron_triggers (TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID) VALUES ('ReleaseNumberJobTrigger', 'DEFAULT', '0 0/9 * * * ? *', 'Asia/Shanghai');

-- 履约可能失败，通过本JOB进行手工同步
INSERT INTO qrtz_job_details (JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_VOLATILE, IS_STATEFUL, REQUESTS_RECOVERY, JOB_DATA) VALUES ('SynchronizePerformanceJob', 'DEFAULT', '0 0/8 * * * ? * 表示每8分钟执行一次, 履约可能失败，通过本JOB进行手工同步', 'com.ai.ge.platform.job.SynchronizePerformanceJob', '0', '0', '0', '0', null);
INSERT INTO qrtz_triggers (TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, IS_VOLATILE, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA) VALUES ('SynchronizePerformanceJobTrigger', 'DEFAULT', 'SynchronizePerformanceJob', 'DEFAULT', '0', null, 1497490914000, 1497423068540, 5, 'WAITING', 'CRON', 1497490914000, 0, null, 0, null);
INSERT INTO qrtz_cron_triggers (TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID) VALUES ('SynchronizePerformanceJobTrigger', 'DEFAULT', '0 0/8 * * * ? *', 'Asia/Shanghai');

COMMIT ;
package com.ai.ge.platform.service.sys;

/**
 * Created by Zhaocy3 on 2016/3/15.
 */
public interface WarningService {

    void sendWarningSms(String content, String type, Exception e);
}

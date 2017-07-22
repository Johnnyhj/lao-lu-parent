package com.ai.ge.ali.executor;

import com.ai.ge.ali.exception.AliException;

/**
 *
 * 业务执行器
 * Created by Sam on 17/5/18.
 */
public interface ActionExecutor {

    /**
     * 业务执行方法
     * @return
     */
    public String execute() throws AliException;
}

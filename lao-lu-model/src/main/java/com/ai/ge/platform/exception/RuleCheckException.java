package com.ai.ge.platform.exception;

/**
 * 规则校验异常
 */
public class RuleCheckException extends DataException {
    public RuleCheckException(String errorCode, String message) {
        super(errorCode, message);
    }

    public RuleCheckException(String message) {
        super(message);
    }
}

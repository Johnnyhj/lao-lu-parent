package com.ai.ge.platform.exception;

/**
 * 数据异常，会引发事务回滚
 */
public class DataException extends RuntimeException  {

    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }



    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataException(String errorCode, String message) {
        super(message, null);
        this.errorCode = errorCode;
    }
}

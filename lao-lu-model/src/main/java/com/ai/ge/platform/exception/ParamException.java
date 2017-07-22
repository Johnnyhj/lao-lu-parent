package com.ai.ge.platform.exception;

/**
 * Created by guochunhao on 17/5/28.
 */
public class ParamException extends RuntimeException
{
    private String errorCode;

    public ParamException(String message, String errorCode)
    {
        super(message);
        this.errorCode = errorCode;
    }

    public ParamException(String message, Throwable cause, String errorCode)
    {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ParamException(String message)
    {
        super(message);
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
}

package com.ai.ge.ali.exception;

/**
 * Created by Sam on 17/5/18.
 */
public class AliException extends Exception{

    private static final long serialVersionUID = -5710488447295073398L;

    public AliException(){
    }

    public AliException(String message) {
        super(message);
    }

    public AliException(Throwable throwable){
        super(throwable);
    }

    public AliException(String message, Throwable throwable){
        super(message, throwable);
    }
}
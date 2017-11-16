package me.wenkang.wee.biz.exception;

/**
 * Created by wenkang
 * on 2017/11/15.
 */
public class VerifyException extends RuntimeException{

    public VerifyException() {
        super();
    }

    public VerifyException(String message) {
        super(message);
    }

    public VerifyException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerifyException(Throwable cause) {
        super(cause);
    }

    protected VerifyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.laoge.promise.common.exception;

/**
 * 自定义异常
 * Created by yuhou on 2017/5/10.
 */
public class ApromiseException extends Throwable {

    public ApromiseException() {
    }

    public ApromiseException(String message) {
        super(message);
    }

    public ApromiseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApromiseException(Throwable cause) {
        super(cause);
    }

    public ApromiseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return "a—promise::" + super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return "a—promise::" + super.getLocalizedMessage();
    }

    @Override
    public String toString() {
        return "a—promise::" + super.toString();
    }
}

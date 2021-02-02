package com.senontech.exceptions;

/**
 * 错误代码异常类
 */
public class ErrorCodeException extends Exception {

    /**
     * 错误代码Int
     */
    private int errorCodeInt;

    /**
     * 错误代码构造
     *
     * @param errorCodeInt 错误代码
     */
    public ErrorCodeException(int errorCodeInt) {
        this.errorCodeInt = errorCodeInt;
    }

    /**
     * 错误信息构造
     *
     * @param message 错误信息
     */
    public ErrorCodeException(String message) {
        super(message);
    }

    /**
     * 异常与错误代码构造
     *
     * @param cause        异常
     * @param errorCodeInt 错误代码
     */
    public ErrorCodeException(Throwable cause, int errorCodeInt) {
        super(cause);
        this.errorCodeInt = errorCodeInt;
    }

    /**
     * 异常与错误信息构造
     *
     * @param cause   异常
     * @param message 错误信息
     */
    public ErrorCodeException(Throwable cause, String message) {
        super(message, cause);
    }

    /**
     * 错误代码与错误信息构造
     *
     * @param errorCodeInt 错误代码
     * @param message      错误信息
     */
    public ErrorCodeException(int errorCodeInt, String message) {
        super(message);
        this.errorCodeInt = errorCodeInt;
    }


    public int getErrorCodeInt() {
        return errorCodeInt;
    }

    public void setErrorCodeInt(int errorCodeInt) {
        this.errorCodeInt = errorCodeInt;
    }
}

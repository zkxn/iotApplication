package com.senontech.enums.errorCode;

/**
 * @description: 登录/鉴权返回 -1
 * @author: gyk
 * @date: 2020/12/7 20:24
 */
public enum AuthCode {

    /**
     * 未登录
     */
    NOT_LOGIN(-11, "未登录,请先登录"),

    /**
     * 账号或密码不正确
     */
    ACCOUNT_OR_PASSWORD_ERROR(-12, "账号或密码不正确"),

    /**
     * appKey为空
     */
    APP_KEY_IS_EMPTY(-13, "appKey为空"),

    /**
     * appKey不合法
     */
    APP_KEY_ILLEGAL(-14, "appKey不合法"),

    /**
     * token为空
     */
    TOKEN_IS_EMPTY(-15, "token为空"),

    /**
     * token不合法
     */
    TOKEN_ILLEGAL(-16, "token不合法");

    private Integer code;

    private String message;

    AuthCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

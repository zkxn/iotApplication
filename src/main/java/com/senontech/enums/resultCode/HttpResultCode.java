package com.senontech.enums.resultCode;

import org.springframework.http.HttpStatus;

/**
 * @description:
 * @author: gyk
 * @date: 2020/12/5 15:49
 */
public enum HttpResultCode {
    /**
     * 服务未发现
     */
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE.value(), "系统繁忙,请稍后重试");

    private Integer code;

    private String message;

    HttpResultCode(Integer code, String message) {
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

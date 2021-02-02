package com.senontech.enums.resultCode;

/**
 * @description: 基础返回
 * @author: gyk
 * @date: 2020/12/7 19:53
 */
public enum BaseResultCode {
    /**
     * 查询成功
     */
    SUCCESS(1, "成功"),

    /**
     * 查询失败
     */
    FAIL(0, "失败");

    private Integer code;

    private String message;

    BaseResultCode(Integer code, String message) {
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

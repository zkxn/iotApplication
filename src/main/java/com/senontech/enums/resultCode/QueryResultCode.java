package com.senontech.enums.resultCode;

/**
 * @description: 查询返回
 * @author: gyk
 * @date: 2020/12/11 11:03
 */
public enum QueryResultCode {
    /**
     * 查询成功
     */
    QUERY_SUCCESS(1, "查询成功"),

    /**
     * 查询失败
     */
    QUERY_FAIL(0, "查询失败");

    private Integer code;

    private String message;

    QueryResultCode(Integer code, String message) {
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

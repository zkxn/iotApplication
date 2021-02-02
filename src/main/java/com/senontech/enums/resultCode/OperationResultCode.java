package com.senontech.enums.resultCode;

/**
 * @description:
 * @author: gyk
 * @date: 2020/12/15 16:49
 */
public enum OperationResultCode {
    /**
     * 添加成功
     */
    ADD_SUCCESS(1, "添加成功"),

    /**
     * 添加失败
     */
    ADD_FAIL(0, "添加失败"),

    /**
     * 修改成功
     */
    EDIT_SUCCESS(1, "修改成功"),

    /**
     * 修改失败
     */
    EDIT_FAIL(0, "修改成功"),

    /**
     * 删除成功
     */
    DELETE_SUCCESS(1, "删除成功"),

    /**
     * 删除失败
     */
    DELETE_FAIL(0, "删除失败");

    private Integer code;

    private String message;

    OperationResultCode(Integer code, String message) {
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

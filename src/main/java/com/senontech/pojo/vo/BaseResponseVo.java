package com.senontech.pojo.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.senontech.enums.resultCode.OperationResultCode;
import com.senontech.enums.resultCode.QueryResultCode;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: controller-web 交互类
 * @author: gyk
 * @date: 2020/9/26 17:21
 */
@Data
public class BaseResponseVo implements Serializable {

    private static final long serialVersionUID = -5485116118008575059L;

    /**
     * 信息
     */
    private Object msg;

    /**
     * 状态码
     */
    private Object code;

    /**
     * 数据
     */
    private Map<String, Object> data = new HashMap<>();

    public BaseResponseVo() {
    }

    public BaseResponseVo(Integer code) {
        this.code = code;
    }

    public BaseResponseVo(Object msg) {
        this.msg = msg;
    }

    public BaseResponseVo(Map<String, Object> data) {
        this.data = data;
    }

    public BaseResponseVo(Integer code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponseVo(Integer code, Map<String, Object> data) {
        this.code = code;
        this.data = data;
    }

    public BaseResponseVo(Object msg, Map<String, Object> data) {
        this.msg = msg;
        this.data = data;
    }

    public BaseResponseVo(Integer code, Object msg, Map<String, Object> data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public BaseResponseVo addResult(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public String toJSONString() {
        /*FastJson提供了SerializerFeature.DisableCircularReferenceDetect这个序列化选项，用来关闭引用检测。
        关闭引用检测后，重复引用对象时就不会被$ref
        代替，但是在循环引用时也会导致StackOverflowError异常。*/
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 查询成功
     *
     * @return
     */
    public BaseResponseVo querySuccess() {
        this.code = QueryResultCode.QUERY_SUCCESS.getCode();
        this.msg = QueryResultCode.QUERY_SUCCESS.getMessage();
        return this;
    }

    /**
     * 查询失败
     *
     * @return
     */
    public BaseResponseVo queryFail() {
        this.code = QueryResultCode.QUERY_FAIL.getCode();
        this.msg = QueryResultCode.QUERY_FAIL.getMessage();
        return this;
    }

    /**
     * 查询失败
     *
     * @param message 信息
     * @return
     */
    public BaseResponseVo queryFailWithMessage(String message) {
        this.code = QueryResultCode.QUERY_FAIL.getCode();
        this.msg = message;
        return this;
    }

    /**
     * 添加成功
     *
     * @return
     */
    public BaseResponseVo addSuccess() {
        this.code = OperationResultCode.ADD_SUCCESS.getCode();
        this.msg = OperationResultCode.ADD_SUCCESS.getMessage();
        return this;
    }

    /**
     * 添加失败
     *
     * @return
     */
    public BaseResponseVo addFail() {
        this.code = OperationResultCode.ADD_FAIL.getCode();
        this.msg = OperationResultCode.ADD_FAIL.getMessage();
        return this;
    }

    /**
     * 添加失败
     *
     * @param message 信息
     * @return
     */
    public BaseResponseVo addFailWithMessage(String message) {
        this.code = OperationResultCode.ADD_FAIL.getCode();
        this.msg = message;
        return this;
    }

    /**
     * 修改成功
     *
     * @return
     */
    public BaseResponseVo editSuccess() {
        this.code = OperationResultCode.EDIT_SUCCESS.getCode();
        this.msg = OperationResultCode.EDIT_SUCCESS.getMessage();
        return this;
    }

    /**
     * 修改失败
     *
     * @return
     */
    public BaseResponseVo editFail() {
        this.code = OperationResultCode.EDIT_FAIL.getCode();
        this.msg = OperationResultCode.EDIT_FAIL.getMessage();
        return this;
    }

    /**
     * 修改失败
     *
     * @param message 信息
     * @return
     */
    public BaseResponseVo editFailWithMessage(String message) {
        this.code = OperationResultCode.EDIT_FAIL.getCode();
        this.msg = message;
        return this;
    }

    /**
     * 删除成功
     *
     * @return
     */
    public BaseResponseVo deleteSuccess() {
        this.code = OperationResultCode.DELETE_SUCCESS.getCode();
        this.msg = OperationResultCode.DELETE_SUCCESS.getMessage();
        return this;
    }

    /**
     * 删除失败
     *
     * @return
     */
    public BaseResponseVo deleteFail() {
        this.code = OperationResultCode.DELETE_FAIL.getCode();
        this.msg = OperationResultCode.DELETE_FAIL.getMessage();
        return this;
    }

    /**
     * 删除失败
     *
     * @param message 信息
     * @return
     */
    public BaseResponseVo deleteFailWithMessage(String message) {
        this.code = OperationResultCode.DELETE_FAIL.getCode();
        this.msg = message;
        return this;
    }
}

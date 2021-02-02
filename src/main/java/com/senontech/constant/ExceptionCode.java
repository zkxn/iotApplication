package com.senontech.constant;

/**
 * 异常code与对应情况
 *
 * @author zkxn
 */
public class ExceptionCode {

    /**
     * controller返回成功
     */
    public final static Integer SUCCESS_CODE = 1;

    /**
     * controller返回失败
     */
    public final static Integer FAULT_CODE = 0;

    /**
     * 参数为空  空类型错误 -1
     */
    public final static Integer ISNULL_ERROR = -1;

    /**
     * 未配置该实体类的查询条件
     */
    public final static Integer NOTHAVE_ENTITY_QUERY_ERROR = -11;

    /**
     * 未配置该实体类的参数条件
     */
    public final static Integer NOTHAVE_ENTITY_PARAM_ERROR = -12;

    /**
     * 参数格式不正确  格式类错误 -2
     */
    public final static Integer FORMAT_ERROR = -2;

    /**
     * 分页对象的page或size有误
     */
    public final static Integer PAGE_SIZE_ERROR = -21;

    /**
     * 参数值重复  重复类错误 -3
     */
    public final static Integer REPEAT_ERROR = -3;

    /**
     * 微信重复
     */
    public final static Integer WECHAT_REPEAT_ERROR = -31;

    /**
     * 账号重复
     */
    public final static Integer ACCOUNT_REPEAT_ERROR = -32;

    /**
     * 数据库重复错误
     */
    public final static Integer DATABASE_REPEAT_ERROR = -33;

    /**
     * 权限与登录错误  权限,登录类错误 -4
     */
    public final static Integer AUTHORIZATION_LOGIN_ERROR = -4;

    /**
     * 未登录
     */
    public final static Integer NOT_LOGIN_ERROR = -41;

    /**
     * 未授权
     */
    public final static Integer UNAUTHORIZED_ERROR = -42;

    /**
     * 值错误  值类错误 -5
     */
    public final static Integer VALUE_ERROR = -5;

    /**
     * 配置表格失败
     */
    public final static Integer CONFIG_TABLE_ERROR = -5;

    public final static Integer EXAMPLE = -6;

}

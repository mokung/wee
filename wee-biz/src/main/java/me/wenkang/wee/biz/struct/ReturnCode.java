package me.wenkang.wee.biz.struct;

import me.wenkang.wee.api.common.struct.IReturnCode;

/**
 * Created by wenkang
 * on 2017/9/30.
 */
public enum  ReturnCode implements IReturnCode {
    /**
     * 返回枚举值定义
     */
    SUCCESS("000000", "成功"),
    SYS_EXCEPTION("999999", "系统异常"),
    USERNAME_OR_PASSWORD_ERROR("000001", "用户名或密码错误"),
    USERNAME_EXISTS("000002", "用户名已存在"),

    ;

    ReturnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.message;
    }
}

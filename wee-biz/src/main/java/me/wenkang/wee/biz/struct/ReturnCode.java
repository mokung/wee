package me.wenkang.wee.biz.struct;

import me.wenkang.wee.api.common.struct.IReturnCode;

/**
 * Created by wenkang
 * on 2017/9/30.
 */
public enum  ReturnCode implements IReturnCode {

    SUCCESS("000000", "成功"),

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

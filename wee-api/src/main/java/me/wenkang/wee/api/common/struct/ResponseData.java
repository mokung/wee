package me.wenkang.wee.api.common.struct;

/**
 * Created by wenkang
 * on 2017/9/30.
 */
public class ResponseData {
    private Boolean success;
    private String code;
    private Object data;
    private String message;

    public ResponseData(IReturnCode returnCode) {
        this.code = returnCode.getCode();
        this.message = returnCode.getMsg();
    }

    public ResponseData(IReturnCode returnCode, Object data) {
        this.code = returnCode.getCode();
        this.message = returnCode.getMsg();
        this.data = data;
    }


    public ResponseData(IReturnCode returnCode, Object data, Boolean success) {
        this.code = returnCode.getCode();
        this.message = returnCode.getMsg();
        this.data = data;
        this.success = success;
    }

    public ResponseData(Boolean success, String code, Object data, String message) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResponseData(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return this.success == null ? Boolean.valueOf("000000".equals(this.code)) : this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

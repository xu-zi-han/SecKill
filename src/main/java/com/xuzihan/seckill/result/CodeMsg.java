package com.xuzihan.seckill.result;

/**
 * @author ZihanXu
 * @version 1.0
 */
public class CodeMsg {
    private int code;
    private String message;

    public static final CodeMsg SUCCESS = new CodeMsg(0,"登陆成功");
    public static final CodeMsg USER_NOT_EXIST = new CodeMsg(500101,"用户不存在");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(500100,"密码错误");
    public static final CodeMsg UNKNOWN_ERROR = new CodeMsg(800000,"未知错误");

    private CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

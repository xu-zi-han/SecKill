package com.xuzihan.seckill.result;

/**
 * @author ZihanXu
 * @version 1.0
 */
public class Result<T> {
    private int code;
    private String message;
    private T data;



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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        return new Result(data);
    }

    public static <T> Result<T> error(CodeMsg codeMsg){
        return new Result(codeMsg);
    }

    private Result(CodeMsg codeMsg){
        if(codeMsg != null){
            this.code = codeMsg.getCode();
            this.message = codeMsg.getMessage();
        }
    }

    private Result(T data){
        this.code = 0;
        this.message = "success";
        this.data = data;
    }
}

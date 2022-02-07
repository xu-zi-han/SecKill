package com.xuzihan.seckill.exception;

import com.xuzihan.seckill.result.CodeMsg;
import com.xuzihan.seckill.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZihanXu
 * @version 1.0
 */

@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(Exception e){
        if(e instanceof GlobalException){
            return Result.error(((GlobalException) e).getCodeMsg());
        }else{
            e.printStackTrace();
            return Result.error(CodeMsg.UNKNOWN_ERROR);
        }
    }
}

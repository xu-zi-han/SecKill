package com.xuzihan.seckill.exception;

import com.xuzihan.seckill.result.CodeMsg;

/**
 * @author ZihanXu
 * @version 1.0
 */
public class GlobalException extends RuntimeException{

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg){
        super();
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}

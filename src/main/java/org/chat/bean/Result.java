package org.chat.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Result {
    @Getter @Setter
    private int code;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private Object data;

    public Result(){
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result getErrorResult(String message){
        return getErrorResult(message,null);
    }

    public static Result getErrorResult(String message,Object object){
        return new Result(10001,message,object);
    }

    public Result(ResultCode resultCode, Object data) {
        this.data = data;
    }


    public static Result success(){
        return success(null);
    }

    public static Result success(Object object){
        return new Result(ResultCode.SUCCESS,object);
    }

    public static Result failure(ResultCode resultCode){
        return new Result(resultCode,null);
    }

    public static Result failure(int code, String message){
        return failure(code,message,null);
    }

    public static Result failure(int code, String message, Object object){
        return new Result(code,message,object);
    }

}

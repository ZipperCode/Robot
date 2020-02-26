package org.chat.bean;

/**
 * @author zzp
 * @date 2020/2/26
 */
public enum ResultCode {
    SUCCESS(1000,"success"),
    ERROR(1001,"error"),


    CUSTOM_ERROR(10001,"");
    private int code;
    private String message;

    ResultCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

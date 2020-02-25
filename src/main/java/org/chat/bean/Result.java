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


    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCode resultCode, Object data) {
        this.data = data;
    }


}

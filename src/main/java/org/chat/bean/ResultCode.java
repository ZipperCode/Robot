package org.chat.bean;

public enum ResultCode {
    SUCCESS(1000,"成功"),
    /* 错误 */
    ERROR(1001,"失败"),
    /** 发生异常 */
    EXCEPTION(1002, "发生异常"),
    /** 系统错误 */
    SYS_ERROR(1003, "系统错误"),
    /** 参数错误 */
    PARAMS_ERROR(1004, "参数错误 "),
    /** 不支持或已经废弃 */
    NOT_SUPPORTED(1005, "不支持或已经废弃"),
    /** 未知异常 */
    UNKNOWN_ERROR(1006,"未知异常，请联系管理员"),

    ADD_SUCCESS(2000,"添加成功"),
    ADD_FAILURE(2001,"添加失败"),
    UPDATE_SUCCESS(2002,"更新成功"),
    UPDATE_FAILURE(2003,"更新失败"),
    REMOVE_SUCCESS(2004,"删除成功"),
    REMOVE_FAILURE(2005,"删除失败");

    private int code;
    private String message;

    ResultCode(int code, String message) {
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

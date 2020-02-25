package org.chat.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕获
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception ex){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code","500");
        resultMap.put("msg","出现错误");
        return resultMap;
    }
}

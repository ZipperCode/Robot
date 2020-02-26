package org.chat.exception;

import lombok.extern.slf4j.Slf4j;
import org.chat.annotation.Log;
import org.chat.bean.Result;
import org.chat.bean.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 全局异常捕获
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @Log
    public Result paramsValidatorHandler(ValidationException e){
        if(e instanceof ConstraintViolationException){
            ConstraintViolationException cve = (ConstraintViolationException) e;
            StringBuilder stringBuilder = new StringBuilder();
            Set<ConstraintViolation<?>> violations = cve.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                //打印验证不通过的信息
                System.out.println(item.getMessage());
                log.info(item.getMessage());
                stringBuilder.append(item.getMessage()).append(" ");
            }
            return Result.failure(10001,stringBuilder.toString());
        }
        return Result.failure(ResultCode.ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception ex){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code","500");
        resultMap.put("msg","出现错误");
        return resultMap;
    }
}

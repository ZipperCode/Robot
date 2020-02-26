package org.chat.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(org.chat.annotation.Log)")
    public void logPoint(){}

    @Before("logPoint()")
    public void doBefore(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName =  joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());
        logger.info("Class: "+ className + ", method :" + methodName + ", params : [" + params+ "]");
    }

    @AfterReturning(returning = "returnValue",pointcut = "logPoint()")
    public void doAfterRetuning(Object returnValue){
        System.out.println("处理完返回结果" + returnValue);
        logger.info("处理完返回结果" + returnValue);
    }

    @AfterThrowing(pointcut = "logPoint()", throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwable){
        System.out.println("抛出异常信息" + throwable);
        logger.info("抛出异常信息" + throwable);
    }

}

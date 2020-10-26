package com.kinghao.budai.aspect;

import com.kinghao.budai.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author kinghao
 * @version 2020/8/1 18:46
 */
//对返回统一处理
@Aspect
@Component
public class ResultAspect {


    @Around("execution(public * com.kinghao.budai.controller.*.*(..))")
    public Result doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object object = proceedingJoinPoint.proceed();
        return Result.success(object);//此处调用success
    }


}

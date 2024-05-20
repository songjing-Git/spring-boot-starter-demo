package com.songjing.sbsd.annotation.run.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserLogAspect {
    @Around("@annotation(com.songjing.sbsd.annotation.run.log.UserLogger)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        saveLog(joinPoint,proceed);
        return proceed;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, Object proceed) {
        // savelog
    }
}

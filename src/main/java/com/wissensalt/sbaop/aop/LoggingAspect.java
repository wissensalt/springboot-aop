package com.wissensalt.sbaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    private static final String EXECUTION_TARGET = "execution(* com.wissensalt.sbaop.service.BookService.*(..))";

    @Before(EXECUTION_TARGET)
    public void logBeforeExecution(JoinPoint joinPoint) {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        printLog(joinPoint, methodSignature, "Before");
    }

    @After(EXECUTION_TARGET)
    public void logAfterExecution(JoinPoint joinPoint) {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        printLog(joinPoint, methodSignature, "After");
    }

    @AfterThrowing("com.wissensalt.sbaop.aop.PointCutConfigs.bookServiceExecution()")
    public void afterThrowing(JoinPoint joinPoint) {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        printLog(joinPoint, methodSignature, "After Throwing");
    }

    private void printLog(JoinPoint joinPoint, MethodSignature methodSignature, String adviceType) {
        log.info("Log Class {} and Method {} {} Execution",
                joinPoint.getTarget().getClass().getName(),
                adviceType,
                methodSignature.getMethod().getName()
        );
    }
}

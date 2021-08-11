package com.wissensalt.sbaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("@annotation(com.wissensalt.sbaop.aop.ExecutionTimeTracker)")
    public Object trackExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final Object result = proceedingJoinPoint.proceed();

        stopWatch.stop();
        log.info("Total Execution Time : {} ms", stopWatch.getTotalTimeMillis());

        return result;
    }
}

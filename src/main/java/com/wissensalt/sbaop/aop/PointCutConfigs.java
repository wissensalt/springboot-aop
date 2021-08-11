package com.wissensalt.sbaop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutConfigs {

    @Pointcut("execution(* com.wissensalt.sbaop.service.BookService.*(..))")
    public void bookServiceExecution(){}
}

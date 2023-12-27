package com.company.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Touch {

    @Before("execution(* com.company.aop.Act.foo(..)) && args(name)")
    public void runBefore(String name) {
        System.out.println(name + " Before  method is running");
    }

    @After("execution(* com.company.aop.Act.foo(..)) && args(name)")
    public void runAfter(String name) {
        System.out.println(name + " After  method is running");
    }

    @Around("execution(* com.company.aop.Act.foo(..)) && args(name)")
    public Object runAround(ProceedingJoinPoint pjp, String name) throws Throwable {
        System.out.println(name + " Around  method is running");
        var value = pjp.proceed();
        return value;
    }

    @AfterReturning(
            pointcut = "execution(* com.company.aop.Act.foo(..))", returning = "value"
    )
    public void doAccessCheck(Object value) {
        System.out.println("Helloooo "+value);
    }

}

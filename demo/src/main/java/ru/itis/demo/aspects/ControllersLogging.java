package ru.itis.demo.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllersLogging {
    @Pointcut("execution(* ru.itis.demo.controllers.*.*(..))")
    public void selectAllMethodsAvaliable() {
    }

    @Before("selectAllMethodsAvaliable()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before controllers \n 1)method signature:" + joinPoint.getSignature() + "\n 2)args:"+ Arrays.toString(joinPoint.getArgs())
            +"\n 3)target:" + joinPoint.getTarget());
    }

    @After("selectAllMethodsAvaliable()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After controllers \n 1)method signature:" + joinPoint.getSignature() + "\n 2)args:"+ Arrays.toString(joinPoint.getArgs())
                +"\n 3)target:" + joinPoint.getTarget());
    }

    //Object, method naming
    @AfterReturning(pointcut = "selectAllMethodsAvaliable()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        System.out.println("Value controllers: " + someValue.toString());
    }

    @AfterThrowing(pointcut = "selectAllMethodsAvaliable()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        System.out.println("We have an exception here: " + e.toString());
    }
}

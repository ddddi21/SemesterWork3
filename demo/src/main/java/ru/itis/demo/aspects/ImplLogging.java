//package ru.itis.demo.aspects;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Controller;
//
//import java.util.Arrays;
//
//@Aspect
//@Controller
//public class ImplLogging {
//    @Pointcut("execution(* ru.itis.demo.services.implementations.*.*(..))")
//    public void selectAllMethodsAvaliable() {
//    }
//
//    @Before("selectAllMethodsAvaliable()")
//    public void beforeAdvice(JoinPoint joinPoint) {
//        System.out.println("Before impl\n 1)method signature:" + joinPoint.getSignature() + "\n 2)args:"+ Arrays.toString(joinPoint.getArgs())
//                +"\n 3)target:" + joinPoint.getTarget());
//    }
//
//    @After("selectAllMethodsAvaliable()")
//    public void afterAdvice(JoinPoint joinPoint) {
//        System.out.println("After impl\n 1)method signature:" + joinPoint.getSignature() + "\n 2)args:"+ Arrays.toString(joinPoint.getArgs())
//                +"\n 3)target:" + joinPoint.getTarget());
//    }
//
//    @AfterReturning(pointcut = "selectAllMethodsAvaliable()", returning = "someValue")
//    public void afterReturningAdvice(Object someValue) {
//        System.out.println("Value impl: " + someValue.toString());
//    }
//
//    @AfterThrowing(pointcut = "selectAllMethodsAvaliable()", throwing = "e")
//    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
//        System.out.println("We have an exception here: " + e.toString());
//    }
//}
//ломает удаление тасков (нал поинтер)

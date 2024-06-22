package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

   private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);

//   // Pointcut are used to define a set of join points, where an advice should be executed.
//   @Pointcut("execution(* com.example.aop.services.GreetingsService.sayHello(..))")
//   private void greetingLoggerPointcut() {} // Each pointcut must have a different name even if they are located in another class.

   /*
   * Instead using "execution(* com.example.aop.services.GreetingsService.sayHello(..))",
   * we can use regular expressions to match the method name like:
   * "execution(* com.example.aop.services.*.*(..))" to match all methods in all classes
   * in the package services and so on.
   * */
   @Before("GreetingServicePointcut.greetingLoggerPointcut()")
   public void loggerBefore(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info(" --> Before: ".concat(method).concat(" | args: ").concat(args));
   }

   @After("GreetingServicePointcut.greetingLoggerPointcut()")
   public void loggerAfter(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info(" --> After all: ".concat(method).concat(" | args: ").concat(args));
   }

   @AfterReturning("GreetingServicePointcut.greetingLoggerPointcut()")
   public void loggerAfterReturning(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info(" --> After returning: ".concat(method).concat(" | args: ").concat(args));
   }

   @AfterThrowing("GreetingServicePointcut.greetingLoggerPointcut()")
   public void loggerAfterThrowing(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info(" --> After throwing: ".concat(method).concat(" | args: ").concat(args));
   }

   // Logger Around
   @Around("GreetingServicePointcut.greetingLoggerPointcut()")
   public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());

      Object result = null;
      try {
         logger.info("Around >>> Method: " + method + "() | Args: " + args);
         result = joinPoint.proceed();
         logger.info("Around >>> Method: " + method + "() | Args: " + args + " | Returns: " + result);
         return result;
      } catch (Throwable e) {
         logger.error("Around >>> Method: " + method + "() | Args: " + args + " | Throws: " + e.getMessage());
         throw e;
      }
   }

}

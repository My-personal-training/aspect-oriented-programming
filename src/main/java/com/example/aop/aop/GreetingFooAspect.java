package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1) // The order is like a stack, the lower the number, first in last out
@Component
@Aspect
public class GreetingFooAspect {

   private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);

   @Before("GreetingServicePointcut.goodbyeLoggerPointcutFoo()")
   public void loggerBefore(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info(" --> 1 --> Before: ".concat(method).concat(" | args: ").concat(args));
   }

   @After("GreetingServicePointcut.goodbyeLoggerPointcutFoo()")
   public void loggerAfter(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info(" --> 1 --> After: ".concat(method).concat(" | args: ").concat(args));
   }

}

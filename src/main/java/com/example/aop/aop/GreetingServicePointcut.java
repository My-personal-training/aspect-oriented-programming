package com.example.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcut {

   // Pointcut are used to define a set of join points, where an advice should be executed.
   @Pointcut("execution(* com.example.aop.services.GreetingsService.sayHello(..))")
   public void greetingLoggerPointcut() {} // Each pointcut must have a different name even if they are located in another class.

   @Pointcut("execution(* com.example.aop.services.GreetingsService.*(..))")
   public void goodbyeLoggerPointcutFoo() {}
}

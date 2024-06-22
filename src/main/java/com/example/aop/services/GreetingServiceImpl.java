package com.example.aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingsService{

   @Override
   public String sayHello(String name, String phrase) {
      String greeting = String.format("Hello %s!, %s", name, phrase);
      System.out.println("Execution: ".concat(greeting));
      return greeting;
   }

   @Override
   public String sayHelloWithError(String name, String phrase){
      String goodbye = String.format("Goodbye %s!", name);
      System.out.println("Execution: ".concat(goodbye));
      if (name == null){
         throw new RuntimeException("Name is null");
      }
      return goodbye;
   }

}

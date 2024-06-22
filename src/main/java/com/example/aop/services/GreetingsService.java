package com.example.aop.services;

public interface GreetingsService {
   String sayHello(String name, String phrase);
   String sayHelloWithError(String name, String phrase);
}

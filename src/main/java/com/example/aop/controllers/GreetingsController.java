package com.example.aop.controllers;

import com.example.aop.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class GreetingsController {

   @Autowired
   GreetingsService greetingsService;

   @GetMapping("/greeting")
   public ResponseEntity<?> greetings() {
      String greeting = greetingsService.sayHello("John", "How are you?");
      return ResponseEntity.ok(Collections.singletonMap("greeting", greeting));
   }

   @GetMapping("/greeting-error")
   public ResponseEntity<?> greetingsWithError() {
      String greeting = greetingsService.sayHelloWithError(null, "How are you?");
      return ResponseEntity.ok(Collections.singletonMap("greeting", greeting));
   }

}

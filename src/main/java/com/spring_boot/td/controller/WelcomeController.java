package com.spring_boot.td.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name){
        if ("".equals(name)){
            return ResponseEntity.status(400).build();
        } else  {
            return ResponseEntity.status(200).body("Welcome " + name);
        }
    }

}

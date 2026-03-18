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
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Le paramètre 'name' est requis");
        }

        return ResponseEntity.ok("Welcome " + name);
    }

}

package com.spring_boot.td;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class td2Controller {

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name){
        return "Welcome " + name;
    }
}

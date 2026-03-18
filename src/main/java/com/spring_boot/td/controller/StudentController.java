package com.spring_boot.td.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @PostMapping("/students")
    public List<Students> createStudent () {

    }
}

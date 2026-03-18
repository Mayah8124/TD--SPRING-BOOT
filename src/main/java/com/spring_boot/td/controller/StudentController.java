package com.spring_boot.td.controller;

import com.spring_boot.td.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @PostMapping("/students")
    public List<Student> createStudent (@RequestBody List<Student> students) {
        List<Student> studentList = new ArrayList<>();

        for (Student student : students) {
            studentList.add(student);
        }

        return studentList;
    }
}

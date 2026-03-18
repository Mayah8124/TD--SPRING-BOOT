package com.spring_boot.td.controller;

import com.spring_boot.td.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private final List<Student> studentList = new ArrayList<>();

    @GetMapping("/students")
    public String getStudentsName(@RequestHeader (value = "Accept", defaultValue = "text/plain") String Accept) {
        if (!"text/plain".equalsIgnoreCase(Accept)) {
            return "Format non supporté";
        }

        if (studentList.isEmpty()) {
            return "Student list is empty";
        }

        return studentList.stream()
                .map(Student::getFirstName)
                .collect(Collectors.joining(", "));
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> createStudent (@RequestBody List<Student> students) {
        try {
            studentList.addAll(students);
            return ResponseEntity.status(201).body(studentList);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

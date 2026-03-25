package com.spring_boot.td.controller;

import com.spring_boot.td.entity.Student;
import com.spring_boot.td.service.StudentService;
import com.spring_boot.td.validator.StudentValidator;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final List<Student> studentList = new ArrayList<>();

    @GetMapping("/students")
    public ResponseEntity<String> getStudentsName(@RequestHeader (value = "Accept", defaultValue = "text/plain") String Accept) {
        try {
            if (Accept == null || Accept.trim().isEmpty()) {
                return ResponseEntity.status(400).body("Header 'Accept' require");
            }

            if ("application/json".equalsIgnoreCase(Accept)) {
                return ResponseEntity.status(200).body(studentList.toString());
            }

            if ("text/plain".equalsIgnoreCase(Accept)) {
                String result = studentList.stream()
                        .map(Student::getFirstName)
                        .toList()
                        .toString();

                return ResponseEntity.status(200).body(result);
            }

            return ResponseEntity.status(501).body("Format not supported");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent (@RequestBody List<Student> students) {
        try {
            List<Student> result = studentService.createStudentList(students);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);

        } catch (BadRequestException e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "text/plain")
                    .body(e.getMessage());
        }
    }
}

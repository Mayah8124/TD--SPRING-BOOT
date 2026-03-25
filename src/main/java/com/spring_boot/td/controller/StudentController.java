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
    private final StudentValidator studentValidator;

    public StudentController(StudentService studentService, StudentValidator studentValidator) {
        this.studentService = studentService;
        this.studentValidator = studentValidator;
    }

    private final List<Student> studentList = new ArrayList<>();

    @GetMapping("/students")
    public ResponseEntity<String> getStudentsName(@RequestHeader (value = "Accept", defaultValue = "text/plain") String accept) {
        try {
            studentValidator.validateAcceptHeader(accept);
            String result = studentService.getStudent(accept);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
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

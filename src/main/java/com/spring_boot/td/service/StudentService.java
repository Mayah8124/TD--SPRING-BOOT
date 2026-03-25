package com.spring_boot.td.service;

import com.spring_boot.td.entity.Student;
import com.spring_boot.td.validator.StudentValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> studentsInMemory = new ArrayList<>();
    private StudentValidator studentValidator;

    public StudentService(StudentValidator studentValidator) {
        this.studentValidator = new StudentValidator();
    }

    public List<Student> createStudentList(List<Student> studentList) {
        for (Student student : studentList) {
            studentValidator.validateStudent(student);
        }
        studentsInMemory.addAll(studentList);
        return studentsInMemory;
    }

}

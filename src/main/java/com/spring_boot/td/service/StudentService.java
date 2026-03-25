package com.spring_boot.td.service;

import com.spring_boot.td.entity.Student;
import com.spring_boot.td.validator.StudentValidator;
import org.apache.coyote.BadRequestException;
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

    public List<Student> createStudentList(List<Student> studentList) throws BadRequestException {
        for (Student student : studentList) {
            studentValidator.validateStudent(student);
        }
        studentsInMemory.addAll(studentList);
        return studentsInMemory;
    }

    public String getStudent(String accept) {
        if ("application/json".equalsIgnoreCase(accept)){
            return studentsInMemory.toString();
        }
        if ("text/plain".equalsIgnoreCase(accept)) {
            return studentsInMemory.stream()
                    .map(Student::getFirstName)
                    .toList()
                    .toString();
        }

        return "";
    }

}

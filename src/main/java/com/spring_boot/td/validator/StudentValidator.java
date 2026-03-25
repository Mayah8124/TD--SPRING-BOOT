package com.spring_boot.td.validator;

import com.spring_boot.td.entity.Student;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    public void validateStudent(Student student) {
        if (student.getReference() == null || student.getReference().isBlank()) {
            try {
                throw new BadRequestException("student reference should not be null");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        if (student.getLastName() == null || student.getLastName().isBlank()) {
            try {
                throw new BadRequestException("student name should not be null");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

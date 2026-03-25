package com.spring_boot.td.validator;

import com.spring_boot.td.entity.Student;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    public void validateStudent(Student student) throws BadRequestException {
        if (student.getReference() == null || student.getReference().isBlank()) {
            throw new BadRequestException("student reference should not be null");
        }
        if (student.getLastName() == null || student.getLastName().isBlank()) {
            throw new BadRequestException("student name should not be null");
        }
    }

    public void validateAcceptHeader(String accept) throws BadRequestException {
        if (accept == null || accept.trim().isEmpty()) {
            throw new BadRequestException("Header 'Accept' required");
        }
        if (!accept.equalsIgnoreCase("application/json") &&
                !accept.equalsIgnoreCase("text/plain")) {
            throw new BadRequestException("Format not supported");
        }
    }
}

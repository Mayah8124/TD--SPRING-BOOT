package com.spring_boot.td.entity;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private Integer age;
}

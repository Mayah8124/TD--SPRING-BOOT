package com.spring_boot.td.entity;

import java.util.Objects;

public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private Integer age;

    public Student(String reference, String firstName, String lastName, Integer age) {
        this.reference = reference;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(reference, student.reference) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "reference='" + reference + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

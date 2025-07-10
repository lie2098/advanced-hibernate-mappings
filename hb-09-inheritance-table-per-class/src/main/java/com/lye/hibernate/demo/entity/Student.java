package com.lye.hibernate.demo.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "student")
public class Student extends User {
    private String course;

    public Student(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ",firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}

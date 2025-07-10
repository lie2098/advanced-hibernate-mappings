package com.lye.hibernate.demo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "INSTRUCTOR")
@Entity(name = "instructor")
public class Instructor extends User {
    private Double salary;

    public Instructor(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public Instructor() {

    }
}

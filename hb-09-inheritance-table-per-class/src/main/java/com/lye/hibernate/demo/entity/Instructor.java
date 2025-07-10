package com.lye.hibernate.demo.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "instructor")
public class Instructor extends User {
    private Double salary;

    public Instructor(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public Instructor() {

    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", salary=" + salary +
                '}';
    }
}

package com.lye.hibernate.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SortComparator;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @CollectionTable(name = "image")
    @MapKeyColumn(name = "file_name")
    @Column(name = "image_name")
//    @OrderBy("file_name desc")
    @SortComparator(ReverseStringComparator.class)
    private Map<String, String> images = new TreeMap<>();

    public static class ReverseStringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

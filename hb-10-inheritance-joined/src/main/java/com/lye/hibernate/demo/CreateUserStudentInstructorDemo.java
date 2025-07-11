package com.lye.hibernate.demo;

import com.lye.hibernate.demo.entity.Instructor;
import com.lye.hibernate.demo.entity.Student;
import com.lye.hibernate.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateUserStudentInstructorDemo {

    public static void main(String[] args) {
        String password = System.getenv("pw") != null
                ? System.getenv("pw")
                : System.getProperty("pw");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .setProperty("hibernate.connection.password", password)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Student tempStudent = new Student("Lye", "Lie", "lye.lie@demo.com", "English");
        Instructor tempInstructor = new Instructor("Lie", "Lye", "lie.lye@demo.com", 18000.00);

        try (sessionFactory; Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            System.out.println("Saving the student and address...");
            session.persist(tempStudent);
            session.persist(tempInstructor);

            session.getTransaction().commit();
            System.out.println("Record Saved!");

            Student student = session.find(Student.class, tempStudent.getId());
            Instructor instructor = session.find(Instructor.class, tempInstructor.getId());

            session.refresh(student);
            session.refresh(instructor);

            System.out.println("Student: " + student);
            System.out.println("Instructor: " + instructor);
        }
    }
}

package com.lye.hibernate.demo;

import com.lye.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CreateStudentImagesSetDemo {

    public static void main(String[] args) {
        String password = System.getenv("pw") != null
                ? System.getenv("pw")
                : System.getProperty("pw");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .setProperty("hibernate.connection.password", password)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Student tempStudent = new Student("Lye", "Lie", "lye.lie@demo.com");
            Set<String> images = tempStudent.getImages();

            images.add("image1.jpg");
            images.add("image2.jpg");
            images.add("image3.jpg");
            images.add("image4.jpg");
            images.add("image4.jpg"); //Duplicate
            images.add("image5.jpg");
            images.add("image5.jpg"); //Duplicate

            session.beginTransaction();


            System.out.println("Saving the student and images...");
            session.persist(tempStudent);

            session.getTransaction().commit();
            System.out.println("Record Saved!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

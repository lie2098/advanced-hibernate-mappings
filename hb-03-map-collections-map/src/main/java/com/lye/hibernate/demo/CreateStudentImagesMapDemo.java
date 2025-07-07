package com.lye.hibernate.demo;

import com.lye.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;

public class CreateStudentImagesMapDemo {

    public static void main(String[] args) {
        String password = System.getenv("MySQL_pw") != null
                ? System.getenv("MySQL_pw")
                : System.getProperty("MySQL_pw");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .setProperty("hibernate.connection.password", password)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (sessionFactory; Session session = sessionFactory.getCurrentSession()) {
            Student tempStudent = new Student("Lye", "Lie", "lye.lie@demo.com");
            Map<String,String> images = tempStudent.getImages();

            images.put("image1.jpg", "Image 1");
            images.put("image2.jpg", "Image 2");
            images.put("image3.jpg", "Image 3");
            images.put("image4.jpg", "Image 4");

            session.beginTransaction();


            System.out.println("Saving the student and images...");
            session.persist(tempStudent);

            session.getTransaction().commit();
            System.out.println("Record Saved!");
        }
    }
}

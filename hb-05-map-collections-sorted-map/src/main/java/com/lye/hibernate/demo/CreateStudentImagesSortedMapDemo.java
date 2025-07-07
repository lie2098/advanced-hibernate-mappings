package com.lye.hibernate.demo;

import com.lye.hibernate.demo.entity.Student;
import org.hibernate.Session;

import java.util.Map;

import static com.lye.hibernate.demo.Utils.getSession;

public class CreateStudentImagesSortedMapDemo {

    public static void main(String[] args) {
        Session session = getSession();

        try {

            Student tempStudent = new Student("Lye", "Lie", "lye.lie@demo.com");
            Map<String, String> images = tempStudent.getImages();

            images.put("image1.jpg", "Image 1");
            images.put("image2.jpg", "Image 2");
            images.put("image3.jpg", "Image 3");
            images.put("image4.jpg", "Image 4");

            session.beginTransaction();


            System.out.println("Saving the student and images...");
            session.persist(tempStudent);

            session.getTransaction().commit();
            System.out.println("Record Saved!");
        } finally {
            session.close();
            session.getSessionFactory().close();
        }
    }
}

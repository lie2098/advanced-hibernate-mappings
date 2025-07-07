package com.lye.hibernate.demo;

import com.lye.hibernate.demo.entity.Student;
import org.hibernate.Session;

import static com.lye.hibernate.demo.Utils.getSession;

public class GetStudentImages {
    public static void main(String[] args) {
        Session session = getSession();

        try {
            session.beginTransaction();

            int id = 1;

            Student student = session.find(Student.class, id);

            System.out.println("Student Details: " + student);
            System.out.println("Associated ImageS: " + student.getImages());

            session.getTransaction().commit();
        } finally {
            session.close();
            session.getSessionFactory().close();
        }
    }
}

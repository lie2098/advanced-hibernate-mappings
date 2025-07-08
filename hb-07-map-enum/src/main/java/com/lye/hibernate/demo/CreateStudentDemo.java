package com.lye.hibernate.demo;

import com.lye.hibernate.demo.entity.StatusEnum;
import com.lye.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        String password = System.getenv("pw") != null
                ? System.getenv("pw")
                : System.getProperty("pw");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .setProperty("hibernate.connection.password", password)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Student tempStudent = new Student("Lye", "Lie", "lye.lie@demo.com", StatusEnum.ACTIVE);
        Student tempStudent2 = new Student("Lie", "Lye", "lie.lye@demo.com", StatusEnum.INACTIVE);

        try (sessionFactory; Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            System.out.println("Saving the student and address...");
            session.persist(tempStudent);
            session.persist(tempStudent2);

            session.getTransaction().commit();
            System.out.println("Record Saved!");

            Student student = session.find(Student.class, tempStudent.getId());
            Student student2 = session.find(Student.class, tempStudent2.getId());

            session.refresh(student);
            session.refresh(student2);

            System.out.println("student: " + student);
            System.out.println("student2: " + student2);
        }
    }
}

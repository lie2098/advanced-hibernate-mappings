package com.lye.hibernate.demo;

import com.lye.hibernate.demo.entity.Address;
import com.lye.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentAddressDemo {

    public static void main(String[] args) {
        String password = System.getenv("pw") != null
                ? System.getenv("pw")
                : System.getProperty("pw");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .setProperty("hibernate.connection.password", password)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        try (sessionFactory; Session session = sessionFactory.getCurrentSession()) {
            Student tempStudent = new Student("Lye", "Lie", "lye.lie@demo.com");

            Address homeAddress = new Address("no name st.", "shity", "9696");
            tempStudent.setHomeAddress(homeAddress);

            Address billingAddress = new Address("billing st.", "bill city", "6969");
            tempStudent.setBillingAddress(billingAddress);

            session.beginTransaction();

            System.out.println("Saving the student and address...");
            session.persist(tempStudent);

            session.getTransaction().commit();
            System.out.println("Record Saved!");
        }
    }
}

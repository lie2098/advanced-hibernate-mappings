package com.lye.hibernate.demo;

import com.lye.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {

    public static Session getSession() {
        String password = System.getenv("MySQL_pw") != null
                ? System.getenv("MySQL_pw")
                : System.getProperty("MySQL_pw");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .setProperty("hibernate.connection.password", password)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        return sessionFactory.getCurrentSession();
    }
}

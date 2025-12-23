package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student(
                "Mayuri",
                "Computer Science",
                "mayuri@gmail.com"
        );

        session.persist(student);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }
}

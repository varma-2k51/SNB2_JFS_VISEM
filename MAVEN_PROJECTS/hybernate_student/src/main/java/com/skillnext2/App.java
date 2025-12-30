package com.skillnext2;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\n1.Insert\n2.View\n3.Update\n4.Delete\n5.Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    insert(sc);
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    update(sc);
                    break;
                case 4:
                    delete(sc);
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }

    private static void insert(Scanner sc) {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = new Student(name, branch, email);
        session.persist(s);

        tx.commit();
        session.close();

        System.out.println("Inserted");
    }

    private static void view() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> q = session.createQuery("from Student", Student.class);
        List<Student> list = q.list();

        for (Student s : list) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getBranch() + " " + s.getEmail());
        }

        session.close();
    }

    private static void update(Scanner sc) {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class, id);

        if (s != null) {
            System.out.print("Enter Name: ");
            s.setName(sc.nextLine());

            System.out.print("Enter Branch: ");
            s.setBranch(sc.nextLine());

            System.out.print("Enter Email: ");
            s.setEmail(sc.nextLine());

            session.update(s);
            System.out.println("Updated");
        } else {
            System.out.println("Not Found");
        }

        tx.commit();
        session.close();
    }

    private static void delete(Scanner sc) {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class, id);

        if (s != null) {
            session.delete(s);
            System.out.println("Deleted");
        } else {
            System.out.println("Not Found");
        }

        tx.commit();
        session.close();
    }
}
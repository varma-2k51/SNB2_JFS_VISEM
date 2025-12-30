package com.skillnext2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            StudentDAO dao = new StudentDAO();

            // Add Student
            // Employee e1 = new Employee("Vivek", "vivekk.techie@example.com", 75000);
            Student s1 = new Student(sc.next(), sc.next(), sc.next());

            dao.addStudent(s1);
            System.out.println("Student Added Successfully!");

            // Fetch students
            List<Student> students = dao.getAllStudents();
            for (Student e : students) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

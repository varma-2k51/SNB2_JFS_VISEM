package com.skillnext2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    
    public void addStudent(Student st) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student (name, branch, email) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, st.getName());
        stmt.setString(2, st.getBranch());
        stmt.setString(3, st.getEmail());
        stmt.executeUpdate();
        conn.close();
    }

   
    public List<Student> getAllStudents() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setBranch(rs.getString("branch"));
            s.setEmail(rs.getString("email"));
            list.add(s);
        }
        conn.close();
        return list;
    }

  
    public void deleteStudent(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }

    
    public void updateStudent(Student st) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE student SET name=?, branch=?, email=?, WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, st.getName());
        stmt.setString(2, st.getBranch());
        stmt.setString(3, st.getEmail());
        stmt.setInt(4, st.getId());
        stmt.executeUpdate();
        conn.close();
    }
}

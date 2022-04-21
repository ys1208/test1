package com.JDBC;

import java.sql.*;

public class JDBCtest1 {
    public static void main(String[] args) {
        Connection conn =null;
        Statement statement =null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123456");
            statement =conn.createStatement();
            String sql= "insert into user(loginName,loginPassword) values('张三','111')";
            int count = statement.executeUpdate(sql);
            System.out.println(count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

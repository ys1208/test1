package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbctest4 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123456");
           //将自动提交修改为手动提交
            connection.setAutoCommit(false);
            /* preparedStatement = connection.prepareStatement("insert into user(loginName,loginPassword) values (?,?)");
            preparedStatement.setString(1,"李四");
            preparedStatement.setString(2,"222");*/
           String sql = "update user set loginPassword = ? where loginName = ?";
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1,"222");
           preparedStatement.setString(2,"李四");
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
           //提交事务
            connection.commit();
        } catch (ClassNotFoundException e) {
            if(connection != null){
                try {
                    //回滚事务
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.JDBC;

import java.sql.*;

public class DBUtil {
    /**
     *工具类中的构造方法都是私有的
     * 因为工具类中的方法都是静态的，不需要new对象
     * */
    private DBUtil(){}
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123456");
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
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

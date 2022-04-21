package com.JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class jdbctest2 {
    public static void main(String[] args) {
        Map<String,String> userInfo = initUI();
        boolean loginSuccess = login(userInfo);
        System.out.println(loginSuccess ? "成功" : "失败");
    }

    private static boolean login(Map<String, String> userInfo) {
        boolean flag = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取链接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123456");
            //获取数据库链接对象
            statement = connection.createStatement();
            // 执行sql语句
            // Statement存在sql注入现象
            String sql = "select * from user where loginName = '"+userInfo.get("loginName")+"' and loginPassword = '"+userInfo.get("loginPassword")+"'";
            resultSet = statement.executeQuery(sql);
            //处理查询结果集
            if(resultSet.next()){
                flag = true;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
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

         return  flag;
    }

    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名：");
        String loginName = s.nextLine();
        System.out.println("密码：");
        String loginPassword = s.nextLine();
        Map<String,String> userInfo = new HashMap<>();
        userInfo.put("loginName",loginName);
        userInfo.put("loginPassword",loginPassword);
        return userInfo;
    }
}

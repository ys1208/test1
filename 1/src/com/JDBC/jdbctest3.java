package com.JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class jdbctest3 {
    public static void main(String[] args) {
        Map<String,String> userInfo = initUI();
        boolean loginSuccess = login(userInfo);
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }

    private static boolean login(Map<String, String> userInfo) {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123456");
            //获取数据库操作对象
            //preparedStatement可解决sql注入问题
            preparedStatement = connection.prepareStatement("select * from  user where loginName = ? and loginPassword = ?");
            preparedStatement.setString(1,userInfo.get("loginName"));
            preparedStatement.setString(2,userInfo.get("loginPassword"));
            //处理查询集
            resultSet =  preparedStatement.executeQuery();
            if(resultSet.next()){
                flag =true;
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
        return  flag;
    }


    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String loginName = s.nextLine();
        System.out.println("请输入密码：");
        String loginPassword = s.nextLine();
        Map<String,String> userInfo = new HashMap<>();
        userInfo.put("loginName",loginName);
        userInfo.put("loginPassword",loginPassword);
        return  userInfo;
    }
}

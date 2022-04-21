package com.Reflect;

import java.util.ResourceBundle;

public class ReflectTest1 {
    public static void main(String[] args) {
        //资源绑定器
        ResourceBundle bundle = ResourceBundle.getBundle("com/Reflect/classinfo");
        String className = bundle.getString("className");
        System.out.println(className);
    }
}

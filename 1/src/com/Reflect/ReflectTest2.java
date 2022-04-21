package com.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest2 {
    public static void main(String[] args) throws Exception {
        Class studentClass = Class.forName("com.Reflect.Student");
        //obj就是Student对象（底层调用无参构造方法）
        Object obj = studentClass.newInstance();
        //获取no属性
        Field noFiled = studentClass.getDeclaredField("no");
        //给obj对象（Student对象）的no赋值
        noFiled.set(obj,111);
        System.out.println(noFiled.get(obj));
        //获取Method
        Method loginMethod = studentClass.getDeclaredMethod("login", String.class, String.class);
        //调用方法
        Object retValue = loginMethod.invoke(obj,"zhangsan","123");
        System.out.println(retValue);
    }
}

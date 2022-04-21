package com.Reflect;

public class Student {
    public  int no;

    public  boolean login(String s1, String s2){
        if("zhangsan".equals(s1) && "123".equals(s2)){
            return true;
        }else {
            return  false;
        }
    }
}

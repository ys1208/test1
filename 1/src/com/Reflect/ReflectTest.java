package com.Reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) {
        try {
           InputStream reader = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("classinfo.properties");
            Properties pro= new Properties();
            pro.load(reader);
            reader.close();
            String className = pro.getProperty("className");
            System.out.println(className);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

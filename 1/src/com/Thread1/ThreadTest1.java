package com.Thread1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest1 {
    public static void main(String[] args) {
        //创建一个“未来任务类”对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception { //call（）方法相当于run()方法，有返回值
                System.out.println("begin");
                Thread.sleep(1000);
                System.out.println("end");
                int a=100;
                int b=200;
                return a+b;
            }
        });
        //创建线程对象
        Thread t = new Thread(task);
        t.start();
        try {
            Object obj = task.get();
            System.out.println("执行结果：" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

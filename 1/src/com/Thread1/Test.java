package com.Thread1;

public class Test {
    public static void main(String[] args) {
         Account acc =new Account(1,1000);
         Thread t1 = new AccountThread(acc);
         Thread t2 = new AccountThread(acc);
         t1.setName("t1");
         t2.setName("t2");
         t1.start();
         t2.start();

    }
}

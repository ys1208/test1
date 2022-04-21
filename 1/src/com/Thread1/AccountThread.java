package com.Thread1;

public class AccountThread extends Thread{
    private  Account acc;

    public AccountThread(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        double money = 500;
        acc.withDraw(money);
        System.out.println(Thread.currentThread().getName() + "对" + acc.getNo() + "取款成功，余额" + acc.getMoney());
    }
}

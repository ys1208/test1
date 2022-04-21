package com.Thread1;

public class Account {
    private  int no;
    private  double money;

    public Account() {
    }

    public Account(int no, double money) {
        this.no = no;
        this.money = money;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void withDraw(double money){
        synchronized (this){
            double pre = this.getMoney();
            double after = pre - money;
            this.setMoney(after);
        }

    }
}


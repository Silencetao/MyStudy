package com.silencetao.thread;

class Accounts {
    //定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量
    //每个线程都会保留该变量的一个副本
    private ThreadLocal<String> name = new ThreadLocal<String>();
    
    public Accounts(String str) {
        this.name.set(str);
        System.out.println("----->" + this.name.get());
    }
    
    public String getName() {
        return name.get();
    }
    
    public void setName(String str) {
        name.set(str);
    }
}

class MyThreads extends Thread {
    private Accounts account;
    
    public MyThreads(Accounts account, String name) {
        super(name);
        this.account = account;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                account.setName(getName());
            }
            System.out.println(account.getName() + "----->" + i);
        }
    }
}

public class ThreadLocalTest {

    public static void main(String[] args) {
        Accounts account = new Accounts("Silence");
        /*
         * 虽然两个线程共享同一个账户，即只有一个账户名
         * 但由于账户名是ThreadLocal类型的，所以每个线
         * 程都完全可以拥有各自的账户名副本，因此在i == 6之后，
         * 将看到两个线程访问同一个账户时出现不同的账户名
         */
        new MyThreads(account, "甲").start();
        new MyThreads(account, "乙").start();
    }
}

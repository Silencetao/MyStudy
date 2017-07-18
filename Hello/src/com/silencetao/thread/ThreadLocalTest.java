package com.silencetao.thread;

class Accounts {
    //����һ��ThreadLocal���͵ı������ñ�������һ���ֲ߳̾�����
    //ÿ���̶߳��ᱣ���ñ�����һ������
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
         * ��Ȼ�����̹߳���ͬһ���˻�����ֻ��һ���˻���
         * �������˻�����ThreadLocal���͵ģ�����ÿ����
         * �̶���ȫ����ӵ�и��Ե��˻��������������i == 6֮��
         * �����������̷߳���ͬһ���˻�ʱ���ֲ�ͬ���˻���
         */
        new MyThreads(account, "��").start();
        new MyThreads(account, "��").start();
    }
}

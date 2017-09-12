package com.silencetao.reflect;

/**
 * ��ȡ����������ĺ������
 * @author Silence
 * create time 2017��8��8�� ����1:22:35
 * @version 1.0.1
 */


class Tester {
    
    static {
        System.out.println("Tester Init");
    }
}

public class BootstrapTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader c1 = ClassLoader.getSystemClassLoader();
        c1.loadClass("Tester");
        System.out.println("System load Tester");
        Class.forName("Tester");
    }
}
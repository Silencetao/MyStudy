package com.silencetao.reflect;

/**
 * 获取根类加载器的核心类库
 * @author Silence
 * create time 2017年8月8日 下午1:22:35
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
package com.silencetao.reflect.aop;

/**
 * 
 * @author Silence
 * create time 2017��12��5�� ����3:30:14
 * @version 1.0.1
 */
public class ProxyTest {

    public static void main(String[] args) {
        Dog target = new GunDog();
        
        Dog dog = (Dog) ProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}

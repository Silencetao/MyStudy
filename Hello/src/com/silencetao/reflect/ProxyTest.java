package com.silencetao.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author Silence
 * create time 2017年12月4日 下午4:03:49
 * @version 1.0.1
 */

interface People {
    void walk();
    void sayHello(String name);
}

class MyInvokationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---->" + method);
        if (args != null) {
            System.out.println("实参:");
            for (Object val : args) {
                System.out.println(val);
            }
        } else {
            System.out.println("调用该方法");
        }
        
        return null;
    }
    
}

public class ProxyTest {

    public static void main(String[] args) {
        InvocationHandler handler = new MyInvokationHandler();
        
        People person = (People) Proxy.newProxyInstance(People.class.getClassLoader(),
                new Class[] {People.class}, handler);
        
        person.walk();
        person.sayHello("Silence");
    }
}

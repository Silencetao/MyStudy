package com.silencetao.reflect.aop;

import java.lang.reflect.Proxy;

/**
 * 
 * @author Silence
 * create time 2017年12月5日 下午3:27:23
 * @version 1.0.1
 */
public class ProxyFactory {

    public static Object getProxy(Object target) {
        InvokationHandler handler = new InvokationHandler();
        handler.setTarget(target);
        
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }
}

package com.silencetao.reflect.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author Silence
 * create time 2017年12月5日 下午3:22:58
 * @version 1.0.1
 */
public class InvokationHandler implements InvocationHandler {
    
    private Object target;
    
    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du = new DogUtil();
        
        du.method1();
        Object result = method.invoke(target, args);
        du.method2();
        
        return result;
    }

}

package com.silencetao.reflect;

import java.lang.reflect.Constructor;

/**
 * 
 * @author Silence
 * create time 2017年12月4日 下午1:57:04
 * @version 1.0.1
 */
public class CreateJFrame {

    public static void main(String[] args) throws Exception {
        Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
        
        Constructor ctor = jframeClazz.getConstructor(String.class);
        Object object = ctor.newInstance("测试窗口");
        System.out.println(object);
    }
}

package com.silencetao.reflect;

import java.lang.reflect.Constructor;

/**
 * 
 * @author Silence
 * create time 2017��12��4�� ����1:57:04
 * @version 1.0.1
 */
public class CreateJFrame {

    public static void main(String[] args) throws Exception {
        Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
        
        Constructor ctor = jframeClazz.getConstructor(String.class);
        Object object = ctor.newInstance("���Դ���");
        System.out.println(object);
    }
}

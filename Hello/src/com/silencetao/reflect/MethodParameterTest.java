package com.silencetao.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * 
 * @author Silence
 * create time 2017��11��23�� ����5:34:44
 * @version 1.0.1
 */
class Test {
    public void replace(String str, List<String> list) {}
}

public class MethodParameterTest {

    public static void main(String[] args) throws Exception {
        Class<Test> clazz = Test.class;
        
        Method method = clazz.getMethod("replace", String.class, List.class);
        
        System.out.println("replace�Ĳ�������:" + method.getParameterCount());
        
        Parameter[] parameters = method.getParameters();
        
        int index = 1;
        
        for (Parameter parameter : parameters) {
//            if (parameter.isNamePresent()) {
                System.out.println("---��" + index++ + "��������Ϣ---");
                System.out.println("������:" + parameter.getName());
                System.out.println("�β�����:" + parameter.getType());
                System.out.println("��������:" + parameter.getParameterizedType());
//            }
        }
    }
}

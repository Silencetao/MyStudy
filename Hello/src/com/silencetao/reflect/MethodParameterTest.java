package com.silencetao.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * 
 * @author Silence
 * create time 2017年11月23日 下午5:34:44
 * @version 1.0.1
 */
class Test {
    public void replace(String str, List<String> list) {}
}

public class MethodParameterTest {

    public static void main(String[] args) throws Exception {
        Class<Test> clazz = Test.class;
        
        Method method = clazz.getMethod("replace", String.class, List.class);
        
        System.out.println("replace的参数个数:" + method.getParameterCount());
        
        Parameter[] parameters = method.getParameters();
        
        int index = 1;
        
        for (Parameter parameter : parameters) {
//            if (parameter.isNamePresent()) {
                System.out.println("---第" + index++ + "个参数信息---");
                System.out.println("参数名:" + parameter.getName());
                System.out.println("形参类型:" + parameter.getType());
                System.out.println("泛型类型:" + parameter.getParameterizedType());
//            }
        }
    }
}

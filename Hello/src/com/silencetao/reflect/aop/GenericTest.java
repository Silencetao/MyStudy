package com.silencetao.reflect.aop;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * ��ȡ������Ϣ
 * @author Silence
 * create time 2017��12��5�� ����3:55:14
 * @version 1.0.1
 */
public class GenericTest {

    private Map<String, Integer> score;
    
    public static void main(String[] args) throws Exception {
        Class<GenericTest> clazz = GenericTest.class;
        Field field = clazz.getDeclaredField("score");
        Class<?> a = field.getType();
        System.out.println("score:" + a);
        Type gType = field.getGenericType();
        if (gType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) gType;
            Type rType = pType.getRawType();
            System.out.println("ԭʼ����:" + rType);
            Type[] tArgs = pType.getActualTypeArguments();
            System.out.println("������Ϣ��:");
            for (int i = 0; i < tArgs.length; i++) {
                System.out.println(tArgs[i]);
            }
        }
    }
}

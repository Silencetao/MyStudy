package com.silencetao.reflect.aop;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 获取泛型信息
 * @author Silence
 * create time 2017年12月5日 下午3:55:14
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
            System.out.println("原始类型:" + rType);
            Type[] tArgs = pType.getActualTypeArguments();
            System.out.println("泛型信息是:");
            for (int i = 0; i < tArgs.length; i++) {
                System.out.println(tArgs[i]);
            }
        }
    }
}

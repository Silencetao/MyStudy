package com.silencetao.reflect;

import java.lang.reflect.Array;

/**
 * 通过反射来操作一维数组
 * @author Silence
 * create time 2017年12月4日 下午2:58:24
 * @version 1.0.1
 */
public class ArrayTest1 {

    public static void main(String[] args) {
        try {
            Object arr = Array.newInstance(String.class, 10);
            Array.set(arr, 5, "疯狂Java讲义");
            Array.set(arr, 6, "轻量级Java EE企业应用实战");
            Object book1 = Array.get(arr, 5);
            Object book2 = Array.get(arr, 6);
            System.out.println(book1);
            System.out.println(book2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.silencetao.reflect;

import java.lang.reflect.Array;

/**
 * ͨ������������һά����
 * @author Silence
 * create time 2017��12��4�� ����2:58:24
 * @version 1.0.1
 */
public class ArrayTest1 {

    public static void main(String[] args) {
        try {
            Object arr = Array.newInstance(String.class, 10);
            Array.set(arr, 5, "���Java����");
            Array.set(arr, 6, "������Java EE��ҵӦ��ʵս");
            Object book1 = Array.get(arr, 5);
            Object book2 = Array.get(arr, 6);
            System.out.println(book1);
            System.out.println(book2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

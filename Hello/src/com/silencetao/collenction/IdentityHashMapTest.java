package com.silencetao.collenction;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap����
 * @author Silence
 * create time 2017��11��29�� ����4:04:13
 * @version 1.0.1
 */
public class IdentityHashMapTest {

    public static void main(String[] args) {
        IdentityHashMap ihm = new IdentityHashMap();
        //�������д��뽫����IdentityHashMap�������������key-value
        ihm.put(new String("����"), 89);
        ihm.put(new String("����"), 79);
        //�������д��뽫����IdentityHashMap���������һ��key-value
        ihm.put("java", 93);
        ihm.put("java", 98);
        System.out.println(ihm);
    }
}

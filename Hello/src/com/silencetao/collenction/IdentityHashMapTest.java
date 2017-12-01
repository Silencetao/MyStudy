package com.silencetao.collenction;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap测试
 * @author Silence
 * create time 2017年11月29日 下午4:04:13
 * @version 1.0.1
 */
public class IdentityHashMapTest {

    public static void main(String[] args) {
        IdentityHashMap ihm = new IdentityHashMap();
        //下面两行代码将会向IdentityHashMap对象中添加两个key-value
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 79);
        //下面两行代码将会向IdentityHashMap对象中添加一个key-value
        ihm.put("java", 93);
        ihm.put("java", 98);
        System.out.println(ihm);
    }
}

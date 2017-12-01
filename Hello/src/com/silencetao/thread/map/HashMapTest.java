package com.silencetao.thread.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * HashMap多线程测试
 * @author Silence
 * create time 2017年11月27日 下午5:09:50
 * @version 1.0.1
 */
public class HashMapTest {

    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>(2);
        
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                new Thread(() -> map.put(UUID.randomUUID().toString(), ""), "map" + i).start();
                System.out.println(i);
            }
        }, "map");
        
        thread.start();
        thread.join();
    }
}

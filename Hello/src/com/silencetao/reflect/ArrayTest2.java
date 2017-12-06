package com.silencetao.reflect;

import java.lang.reflect.Array;

/**
 * 通过反射来操作三维数组
 * @author Silence
 * create time 2017年12月4日 下午3:02:45
 * @version 1.0.1
 */
public class ArrayTest2 {

    public static void main(String[] args) {
        Object arr = Array.newInstance(String.class, 3, 4, 10);
        
        Object arrObj = Array.get(arr, 2);
        
        Array.set(arrObj, 2, new String[]
        {
            "疯狂Java讲义",
            "轻量级Java EE企业应用实战"
        });
        
        Object anArr = Array.get(arrObj, 3);
        Array.set(anArr, 8, "疯狂Android讲义");
        String[][][] cast = (String[][][]) arr;
        
        System.out.println(cast[2][2][0]);
        System.out.println(cast[2][2][1]);
        System.out.println(cast[2][3][8]);
    }
}

package com.silencetao.collenction;

import java.util.stream.IntStream;

/**
 * int流
 * @author Silence
 * create time 2017年11月15日 下午4:28:48
 * @version 1.0.1
 */
public class IntStreamTest {

    public static void main(String[] args) {
        IntStream iStream = IntStream.builder().add(20).add(13).add(-2).add(18).build();
        //下面调用聚集方法的代码每次只能执行一行
        iStream.forEach(ele -> System.out.println(ele));
        System.out.println("Max:" + iStream.max().getAsInt());
        System.out.println("Min:" + iStream.min().getAsInt());
        System.out.println("Sum:" + iStream.sum());
        System.out.println("Count:" + iStream.count());
        System.out.println("Average:" + iStream.average());
        System.out.println("是否所有元素的平方大于20:" + iStream.allMatch(ele -> ele * ele > 20));
        System.out.println("是否包含任何元素的平方大于20" + iStream.anyMatch(ele -> ele * ele > 20));
        //将iStream映射成一个新Stream，新Stream的每个元素是原Stream元素的2倍+1
        IntStream newIs = iStream.map(ele -> ele * 2 + 1);
        //使用方法引用的方式来遍历集合元素
        newIs.forEach(System.out::println);
    }
}

package com.silencetao.collenction;

import java.util.Collection;
import java.util.HashSet;

/**
 * Stream
 * @author Silence
 * create time 2017年11月15日 下午4:58:05
 * @version 1.0.1
 */
public class ConllenctionSteam {

    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add(new String("轻量级Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂IOS讲义"));
        books.add(new String("疯狂Ajax讲义"));
        books.add(new String("疯狂Android讲义"));
        System.out.println(books.stream().filter(ele -> ((String)ele).contains("疯狂")).count());
        System.out.println(books.stream().filter(ele -> ((String)ele).contains("Java")).count());
        System.out.println(books.stream().filter(ele -> ((String)ele).length() > 10).count());
        //先调用Collection对象的stream()方法将集合转换为Steam
        //再调用Steam的mapToInt()方法获取原有的Steam对应的IntStream
        books.stream().mapToInt(ele -> ((String)ele).length()).forEach(System.out::println);
    }
}

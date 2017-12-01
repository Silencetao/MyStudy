package com.silencetao.collenction;

import java.util.LinkedHashSet;

/**
 * LinkedHashSetTest
 * @author Silence
 * create time 2017年11月16日 下午2:05:36
 * @version 1.0.1
 */
public class LinkedHashSetTest {

    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
        books.add("Java从入门到放弃");
        books.add("Java从入门到如何治疗颈椎病");
        System.out.println(books);
        books.remove("Java从入门到放弃");
        books.add("Java从入门到住院");
        System.out.println(books);
    }
}

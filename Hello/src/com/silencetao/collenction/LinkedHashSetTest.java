package com.silencetao.collenction;

import java.util.LinkedHashSet;

/**
 * LinkedHashSetTest
 * @author Silence
 * create time 2017��11��16�� ����2:05:36
 * @version 1.0.1
 */
public class LinkedHashSetTest {

    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
        books.add("Java�����ŵ�����");
        books.add("Java�����ŵ�������ƾ�׵��");
        System.out.println(books);
        books.remove("Java�����ŵ�����");
        books.add("Java�����ŵ�סԺ");
        System.out.println(books);
    }
}

package com.silencetao.collenction;

import java.util.Collection;
import java.util.HashSet;

/**
 * Stream
 * @author Silence
 * create time 2017��11��15�� ����4:58:05
 * @version 1.0.1
 */
public class ConllenctionSteam {

    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add(new String("������Java EE��ҵӦ��ʵս"));
        books.add(new String("���Java����"));
        books.add(new String("���IOS����"));
        books.add(new String("���Ajax����"));
        books.add(new String("���Android����"));
        System.out.println(books.stream().filter(ele -> ((String)ele).contains("���")).count());
        System.out.println(books.stream().filter(ele -> ((String)ele).contains("Java")).count());
        System.out.println(books.stream().filter(ele -> ((String)ele).length() > 10).count());
        //�ȵ���Collection�����stream()����������ת��ΪSteam
        //�ٵ���Steam��mapToInt()������ȡԭ�е�Steam��Ӧ��IntStream
        books.stream().mapToInt(ele -> ((String)ele).length()).forEach(System.out::println);
    }
}

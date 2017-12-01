package com.silencetao.collenction;

import java.util.stream.IntStream;

/**
 * int��
 * @author Silence
 * create time 2017��11��15�� ����4:28:48
 * @version 1.0.1
 */
public class IntStreamTest {

    public static void main(String[] args) {
        IntStream iStream = IntStream.builder().add(20).add(13).add(-2).add(18).build();
        //������þۼ������Ĵ���ÿ��ֻ��ִ��һ��
        iStream.forEach(ele -> System.out.println(ele));
        System.out.println("Max:" + iStream.max().getAsInt());
        System.out.println("Min:" + iStream.min().getAsInt());
        System.out.println("Sum:" + iStream.sum());
        System.out.println("Count:" + iStream.count());
        System.out.println("Average:" + iStream.average());
        System.out.println("�Ƿ�����Ԫ�ص�ƽ������20:" + iStream.allMatch(ele -> ele * ele > 20));
        System.out.println("�Ƿ�����κ�Ԫ�ص�ƽ������20" + iStream.anyMatch(ele -> ele * ele > 20));
        //��iStreamӳ���һ����Stream����Stream��ÿ��Ԫ����ԭStreamԪ�ص�2��+1
        IntStream newIs = iStream.map(ele -> ele * 2 + 1);
        //ʹ�÷������õķ�ʽ����������Ԫ��
        newIs.forEach(System.out::println);
    }
}

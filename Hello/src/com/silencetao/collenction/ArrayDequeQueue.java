package com.silencetao.collenction;

import java.util.ArrayDeque;

/**
 * ArrayDequeQueue
 * @author Silence
 * create time 2017��11��17�� ����11:21:58
 * @version 1.0.1
 */
public class ArrayDequeQueue {

    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        queue.offer("Java�����ŵ�����");
        queue.offer("Java�����ŵ�������ƾ�׵��");
        queue.offer("ΪʲôѧJava���");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}

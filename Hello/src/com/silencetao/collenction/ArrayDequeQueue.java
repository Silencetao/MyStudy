package com.silencetao.collenction;

import java.util.ArrayDeque;

/**
 * ArrayDequeQueue
 * @author Silence
 * create time 2017年11月17日 上午11:21:58
 * @version 1.0.1
 */
public class ArrayDequeQueue {

    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        queue.offer("Java从入门到放弃");
        queue.offer("Java从入门到如何治疗颈椎病");
        queue.offer("为什么学Java会疯");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}

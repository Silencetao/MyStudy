package com.silencetao.collenction;

import java.util.ArrayDeque;

/**
 * ArrayDequeStack
 * @author Silence
 * create time 2017年11月17日 上午10:52:43
 * @version 1.0.1
 */
public class ArrayDequeStack {

    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();
        stack.push("Java从入门到放弃");
        stack.push("Java从入门到如何治疗颈椎病");
        stack.push("为什么学Java会疯");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}

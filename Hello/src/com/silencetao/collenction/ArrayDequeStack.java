package com.silencetao.collenction;

import java.util.ArrayDeque;

/**
 * ArrayDequeStack
 * @author Silence
 * create time 2017��11��17�� ����10:52:43
 * @version 1.0.1
 */
public class ArrayDequeStack {

    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();
        stack.push("Java�����ŵ�����");
        stack.push("Java�����ŵ�������ƾ�׵��");
        stack.push("ΪʲôѧJava���");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}

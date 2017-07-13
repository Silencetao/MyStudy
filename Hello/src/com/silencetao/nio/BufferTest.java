package com.silencetao.nio;

import java.nio.CharBuffer;

/**
 * Buffer测试
 * @author Silence
 *
 */
public class BufferTest {

	public static void main(String[] args) {
		//创建Buffer
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		System.out.println("length:" + buff.length());
		//放入元素
		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("加入三个元素之后----->");
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		System.out.println("length:" + buff.length());
		//调用flip()方法
		buff.flip();
		System.out.println("调用flip()方法之后----->");
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		System.out.println("length:" + buff.length());
		System.out.println(buff.get());
		System.out.println("position:" + buff.position());
		//调用clear()方法
		buff.clear();
		System.out.println("调用clear()方法之后----->");
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		System.out.println("length:" + buff.length());
		System.out.println(buff.get(2));
		System.out.println("position:" + buff.position());
		buff.put('d');
		System.out.println("position:" + buff.position());
		buff.clear();
		System.out.println(buff);
	}
}

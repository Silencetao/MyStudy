package com.silencetao.nio;

import java.nio.CharBuffer;

/**
 * Buffer����
 * @author Silence
 *
 */
public class BufferTest {

	public static void main(String[] args) {
		//����Buffer
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		System.out.println("length:" + buff.length());
		//����Ԫ��
		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("��������Ԫ��֮��----->");
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		System.out.println("length:" + buff.length());
		//����flip()����
		buff.flip();
		System.out.println("����flip()����֮��----->");
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		System.out.println("length:" + buff.length());
		System.out.println(buff.get());
		System.out.println("position:" + buff.position());
		//����clear()����
		buff.clear();
		System.out.println("����clear()����֮��----->");
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

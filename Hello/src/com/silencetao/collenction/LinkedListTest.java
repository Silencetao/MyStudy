package com.silencetao.collenction;

import java.util.LinkedList;

/**
 * LinkedListʵ����
 * @author Silence
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList books = new LinkedList();
		books.offer("���Java����");
		books.push("������Java EE��ҵӦ��ʵս");
		books.offerFirst("���Android����");
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
		System.out.println(books.peekFirst());
		System.out.println(books.peekLast());
		System.out.println(books.pop());
		System.out.println(books);
		System.out.println(books.pollLast());
		System.out.println(books);
	}
}

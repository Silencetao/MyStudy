package com.silencetao.collenction;

import java.util.LinkedList;

/**
 * LinkedList实现类
 * @author Silence
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList books = new LinkedList();
		books.offer("疯狂Java讲义");
		books.push("轻量级Java EE企业应用实战");
		books.offerFirst("疯狂Android讲义");
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

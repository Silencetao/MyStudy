package com.silencetao.collenction;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 使用Iterator遍历Collection集合
 * @author Silence
 *
 */
public class IteratorTest {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("Java从入门到放弃");
		books.add("Java从入门到如何治疗颈椎病");
		books.add("Java从入门到住院");
		Iterator it = books.iterator();
		
		it.forEachRemaining(book -> System.out.println(book));
		while (it.hasNext()) {
			String book = (String) it.next();
			System.out.println(book);
			if (book.equals("Java从入门到放弃")) {
				it.remove();
			}
		}
		System.out.println(books);
	}
}

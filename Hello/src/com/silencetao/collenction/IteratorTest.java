package com.silencetao.collenction;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * ʹ��Iterator����Collection����
 * @author Silence
 *
 */
public class IteratorTest {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("Java�����ŵ�����");
		books.add("Java�����ŵ�������ƾ�׵��");
		books.add("Java�����ŵ�סԺ");
		Iterator it = books.iterator();
		
		it.forEachRemaining(book -> System.out.println(book));
		while (it.hasNext()) {
			String book = (String) it.next();
			System.out.println(book);
			if (book.equals("Java�����ŵ�����")) {
				it.remove();
			}
		}
		System.out.println(books);
	}
}

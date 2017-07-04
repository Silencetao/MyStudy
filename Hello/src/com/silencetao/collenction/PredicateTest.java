package com.silencetao.collenction;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * ʹ��Java 8������Predicate��������
 * @author Silence
 *
 */
public class PredicateTest {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add(new String("������Java EE��ҵӦ��ʵս"));
		books.add(new String("���Java����"));
		books.add(new String("���IOS����"));
		books.add(new String("���Ajax����"));
		books.add(new String("���Android����"));
		System.out.println(callAll(books, ele -> ((String)ele).length() < 10));
		books.removeIf(ele -> ((String)ele).length() < 10);
		System.out.println(books);
	}
	
	public static int callAll(Collection books, Predicate p) {
		int total = 0;
		for (Object object : books) {
			if (p.test(object)) {
				total++;
			}
		}
		return total;
	}
}

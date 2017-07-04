package com.silencetao.collenction;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * 使用Java 8新增的Predicate操作集合
 * @author Silence
 *
 */
public class PredicateTest {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂IOS讲义"));
		books.add(new String("疯狂Ajax讲义"));
		books.add(new String("疯狂Android讲义"));
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

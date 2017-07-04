package com.silencetao.collenction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 使用foreach循环遍历集合元素
 * @author Silence
 *
 */
public class ForeachTest {

	public static void main(String[] args) {
		Collection books = new ArrayList();
		books.add("Java从入门到放弃");
		books.add("Java从入门到如何治疗颈椎病");
		books.add("Java从入门到住院");
		for (Object obj : books) {
			System.out.println(obj);
		}
		System.out.println(books);
	}
}

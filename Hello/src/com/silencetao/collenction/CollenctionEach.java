package com.silencetao.collenction;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * 使用Lambda表达式来遍历集合
 * @author Silence
 *
 */
public class CollenctionEach {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("Java从入门到放弃");
		books.add("Java从入门到如何治疗颈椎病");
		books.add("Java从入门到住院");
		books.forEach(book -> System.out.println(book));
	}
}

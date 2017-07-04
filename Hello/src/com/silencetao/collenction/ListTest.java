package com.silencetao.collenction;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * list集合
 * @author Silence
 *
 */
public class ListTest {

	public static void main(String[] args) {
		List books = new ArrayList();
		books.add(new String("Java从入门到放弃"));
		books.add(new String("Java从入门到如何治疗颈椎病"));
		books.add(new String("为什么学Java会疯"));
		System.out.println(books);
		books.add(1, new String("因为看了Java疯狂讲义"));
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
//		books.remove(0);
		System.out.println(books);
		System.out.println(books.indexOf(new String("为什么学Java会疯")));//第一次出现的位置
		books.set(2, new String("Java从入门到放弃治疗"));
		System.out.println(books);
		System.out.println(books.subList(1, 2));//切割字符串
		books.sort((o1, o2) -> ((String)o1).length() - ((String)o2).length());//排序
		System.out.println(books);
		books.replaceAll(ele -> ((String)ele).length());//按一定的规则替换集合元素
		System.out.println(books);
		
		System.out.println("--------------------");
		//ListIterator
		ListIterator lit = books.listIterator();
		while (lit.hasNext()) {//向后遍历
			System.out.println(lit.next());
		}
		
		System.out.println("--------------------");
		while (lit.hasPrevious()) {//向前迭代
			System.out.println(lit.previous());
		}
	}
}

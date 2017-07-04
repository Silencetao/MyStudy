package com.silencetao.collenction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合基本方法测试
 * @author Silence
 *
 */
public class CollectionTest {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		//添加元素
		c.add("Silence");
		c.add(3);//因为java支持自动装箱,所以可以直接放基本类型的值到集合里
		//输出集合的长度
		System.out.println(c.size());
		//删除一个元素
		c.remove(3);
		System.out.println(c.size());//集合长度减1
		//判断集合里是否含有指定元素
		System.out.println(c.contains("Silence"));
		c.add("今天天气真心不错");
		System.out.println(c);
		Collection books = new HashSet();
		books.add("Java从入门到放弃");
		books.add("Java从入门到如何治疗颈椎病");
		//判断集合c是否包含集合books集合的所有元素
		System.out.println(c.containsAll(books));
		//用集合c减去集合books的元素
		c.removeAll(books);
		System.out.println(c);
		//清空集合c
		c.clear();
		System.out.println(c);
		//删除集合books中在集合c里不包含的元素,也就是取集合books和集合c的交集
		books.retainAll(c);
		System.out.println(books);//因为集合c为空,所以连个集合的交集也为空
	}
}

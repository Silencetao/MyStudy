package com.silencetao.collenction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * ʹ��foreachѭ����������Ԫ��
 * @author Silence
 *
 */
public class ForeachTest {

	public static void main(String[] args) {
		Collection books = new ArrayList();
		books.add("Java�����ŵ�����");
		books.add("Java�����ŵ�������ƾ�׵��");
		books.add("Java�����ŵ�סԺ");
		for (Object obj : books) {
			System.out.println(obj);
		}
		System.out.println(books);
	}
}

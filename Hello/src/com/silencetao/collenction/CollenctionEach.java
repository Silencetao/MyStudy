package com.silencetao.collenction;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * ʹ��Lambda���ʽ����������
 * @author Silence
 *
 */
public class CollenctionEach {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("Java�����ŵ�����");
		books.add("Java�����ŵ�������ƾ�׵��");
		books.add("Java�����ŵ�סԺ");
		books.forEach(book -> System.out.println(book));
	}
}

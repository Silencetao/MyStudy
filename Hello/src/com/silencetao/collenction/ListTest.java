package com.silencetao.collenction;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * list����
 * @author Silence
 *
 */
public class ListTest {

	public static void main(String[] args) {
		List books = new ArrayList();
		books.add(new String("Java�����ŵ�����"));
		books.add(new String("Java�����ŵ�������ƾ�׵��"));
		books.add(new String("ΪʲôѧJava���"));
		System.out.println(books);
		books.add(1, new String("��Ϊ����Java�����"));
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
//		books.remove(0);
		System.out.println(books);
		System.out.println(books.indexOf(new String("ΪʲôѧJava���")));//��һ�γ��ֵ�λ��
		books.set(2, new String("Java�����ŵ���������"));
		System.out.println(books);
		System.out.println(books.subList(1, 2));//�и��ַ���
		books.sort((o1, o2) -> ((String)o1).length() - ((String)o2).length());//����
		System.out.println(books);
		books.replaceAll(ele -> ((String)ele).length());//��һ���Ĺ����滻����Ԫ��
		System.out.println(books);
		
		System.out.println("--------------------");
		//ListIterator
		ListIterator lit = books.listIterator();
		while (lit.hasNext()) {//������
			System.out.println(lit.next());
		}
		
		System.out.println("--------------------");
		while (lit.hasPrevious()) {//��ǰ����
			System.out.println(lit.previous());
		}
	}
}

package com.silencetao.collenction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * ���ϻ�����������
 * @author Silence
 *
 */
public class CollectionTest {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		//���Ԫ��
		c.add("Silence");
		c.add(3);//��Ϊjava֧���Զ�װ��,���Կ���ֱ�ӷŻ������͵�ֵ��������
		//������ϵĳ���
		System.out.println(c.size());
		//ɾ��һ��Ԫ��
		c.remove(3);
		System.out.println(c.size());//���ϳ��ȼ�1
		System.out.println("c add:" + c.add("Silence"));
		//�жϼ������Ƿ���ָ��Ԫ��
        System.out.println("c contains:" + c.contains("Silence"));
		c.add("�����������Ĳ���");
		System.out.println(c);
		Collection books = new HashSet();
		books.add("Java�����ŵ�����");
		books.add("Java�����ŵ�������ƾ�׵��");
		System.out.println("books add:" + books.add("Java�����ŵ�����"));
		//�жϼ���c�Ƿ��������books���ϵ�����Ԫ��
		System.out.println("books containsAll c:" + c.containsAll(books));
		//�ü���c��ȥ����books��Ԫ��
		c.removeAll(books);
		System.out.println(c);
		//��ռ���c
		c.clear();
		System.out.println(c);
		//ɾ������books���ڼ���c�ﲻ������Ԫ��,Ҳ����ȡ����books�ͼ���c�Ľ���
		books.retainAll(c);
		System.out.println(books);//��Ϊ����cΪ��,�����������ϵĽ���ҲΪ��
	}
}

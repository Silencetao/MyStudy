package com.silencetao.collenction;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Hashtable����
 * @author Silence
 *
 */

class A {
	int count;
	
	public A(int count) {
		this.count = count;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null && obj.getClass() == A.class) {
			A a = (A)obj;
			return this.count == a.count;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return count;
	}
	
	@Override
	public String toString() {
		return "A.count:" + count;
	}
}

class B {
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	@Override
	public String toString() {
		return "B.class";
	}
}

public class HashtableTest {

	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put(new A(1000), "���Java����");
		ht.put(new A(439), "������Java EE��ҵӦ��ʵս");
		ht.put(new A(1232), new B());
		System.out.println(ht);
		System.out.println(ht.containsValue("����ѩ��"));
		System.out.println(ht.containsKey(new A(1232)));
		ht.remove(new A(1232));
		System.out.println(ht);
		System.out.println(">---------�ɰ��ķָ���--------<");
		Iterator it = ht.keySet().iterator();
		A first = (A)it.next();
		first.count = 11111;
		System.out.println(ht);
		ht.remove(new A(1111));//��Ϊ�����ֵ���޸Ĺ���,�����޷�ɾ��
		System.out.println(ht);
		System.out.println(ht.get(new A(439)));
		System.out.println(ht.get(new A(1111)));
		System.out.println(">---------�ɰ��ķָ���--------<");
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("����", 89);
		scores.put("��ѧ", 97);
		scores.put("Ӣ��", 87);
		scores.forEach((key, value) -> System.out.println(key + "----->" + value));
	}
}

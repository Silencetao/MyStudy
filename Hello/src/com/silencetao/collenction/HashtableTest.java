package com.silencetao.collenction;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Hashtable测试
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
		ht.put(new A(1000), "疯狂Java讲义");
		ht.put(new A(439), "轻量级Java EE企业应用实战");
		ht.put(new A(1232), new B());
		System.out.println(ht);
		System.out.println(ht.containsValue("旺旺雪饼"));
		System.out.println(ht.containsKey(new A(1232)));
		ht.remove(new A(1232));
		System.out.println(ht);
		System.out.println(">---------可爱的分割线--------<");
		Iterator it = ht.keySet().iterator();
		A first = (A)it.next();
		first.count = 11111;
		System.out.println(ht);
		ht.remove(new A(1111));//因为对象的值被修改过了,所以无法删除
		System.out.println(ht);
		System.out.println(ht.get(new A(439)));
		System.out.println(ht.get(new A(1111)));
		System.out.println(">---------可爱的分割线--------<");
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("语文", 89);
		scores.put("数学", 97);
		scores.put("英语", 87);
		scores.forEach((key, value) -> System.out.println(key + "----->" + value));
	}
}

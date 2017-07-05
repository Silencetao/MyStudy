package com.silencetao.collenction;

import java.util.TreeMap;

/**
 * TreeMap�����
 * @author Silence
 *
 */

class T implements Comparable {
	int count;
	
	public T(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "T[count:]" + count + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null && obj.getClass() == T.class) {
			T t = (T)obj;
			return t.count == this.count;
		}
		return false;
	}
	
	@Override
	public int compareTo(Object o) {
		T t = (T)o;
		return this.count > t.count ? 1 : this.count < t.count ? -1 : 0;
	}
}

public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap tm = new TreeMap();
		tm.put(new T(3), "������Java EE��ҵӦ��ʵս");
		tm.put(new T(-5), "���Java����");
		tm.put(new T(9), "���Android����");
		System.out.println(tm);
		System.out.println(tm.lastKey());
		System.out.println(tm.higherKey(new T(2)));
		System.out.println(tm.lowerKey(new T(2)));
		System.out.println(tm.subMap(new T(-1), new T(4)));
	}
}

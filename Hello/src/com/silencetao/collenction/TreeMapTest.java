package com.silencetao.collenction;

import java.util.TreeMap;

/**
 * TreeMap类测试
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
		tm.put(new T(3), "轻量级Java EE企业应用实战");
		tm.put(new T(-5), "疯狂Java讲义");
		tm.put(new T(9), "疯狂Android讲义");
		System.out.println(tm);
		System.out.println(tm.lastKey());
		System.out.println(tm.higherKey(new T(2)));
		System.out.println(tm.lowerKey(new T(2)));
		System.out.println(tm.subMap(new T(-1), new T(4)));
	}
}

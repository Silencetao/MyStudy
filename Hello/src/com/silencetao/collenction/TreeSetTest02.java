package com.silencetao.collenction;

import java.util.TreeSet;

/**
 * TreeSet测试
 * @author Silence
 *
 */

class R implements Comparable {
	
	int count;
	
	public R(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "R[count:" + count + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == R.class) {
			R r = (R) obj;
			return r.count == this.count;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		R r = (R) o;
		return this.count > r.count ? -1 : this.count < r.count ? 1 : 0;
	}
	
}

class M {
	int age;
	public M(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "M[age:" + age + "]";
	}
}

public class TreeSetTest02 {

	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new R(5));
		ts.add(new R(-3));
		ts.add(new R(9));
		ts.add(new R(-2));
		System.out.println(ts);//有序
		R first = (R) ts.first();
		first.count = 20;
		R last = (R) ts.last();
		last.count = -2;
		System.out.println(ts);//无序,有重复元素
		System.out.println(ts.remove(new R(-2)));//删除被修改的元素,删除失败
		System.out.println(ts);
		System.out.println(ts.remove(new R(5)));//删除没有被修改的元素,删除成功
		System.out.println(ts);
		
		TreeSet t = new TreeSet((o1, o2) -> {
			int r1 = (int) o1;
			int r2 = (int) o2;
			return r1 > r2 ? -1 : r1 < r2 ? 1 : 0;
		});
		t.add(2);
		t.add(9);
		t.add(-3);
		System.out.println(t);
	}
}

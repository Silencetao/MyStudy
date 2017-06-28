package com.silencetao.finaltest;

/**
 * 缓存类
 * @author Silence
 *
 */

class CacheImmutale {
	//用一个CacheImmutale对象数组来缓存已有的实例
	private static int MAX_SIZE = 10;//缓存数组的长度为10
	private static CacheImmutale[] cache = new CacheImmutale[MAX_SIZE];//定义缓存数组
	private static int pos = 0;//记录缓存的位置
	private final String name;
	
	private CacheImmutale(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static CacheImmutale valueOf(String name) {
		for (int i = 0; i < MAX_SIZE; i++) {
			if (cache[i] != null && cache[i].getName().equals(name)) {
				return cache[i];
			}
		}
		if (pos == MAX_SIZE) {
			cache[0] = new CacheImmutale(name);
			pos = 1;
		} else {
			cache[pos++] = new CacheImmutale(name);
		}
		return cache[pos - 1];
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == CacheImmutale.class) {
			CacheImmutale cacheImmutale = (CacheImmutale) obj;
			return name.equals(cacheImmutale.getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}
}

public class CacheImmutaleTest {
	public static void main(String[] args) {
		CacheImmutale c1 = CacheImmutale.valueOf("Hello");
		CacheImmutale c2 = CacheImmutale.valueOf("Hello");
		System.out.println(c1 == c2);
		System.out.println(c1.getName());
		System.out.println(c2.valueOf("World"));
	}
}

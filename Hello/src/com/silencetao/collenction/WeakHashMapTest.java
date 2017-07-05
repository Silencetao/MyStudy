package com.silencetao.collenction;

import java.util.WeakHashMap;

/**
 * WeakHashMap测试
 * @author Silence
 *
 */
public class WeakHashMapTest {

	public static void main(String[] args) {
		WeakHashMap whm = new WeakHashMap();
		//向WeakHashMap对象中添加匿名字符串对象
		whm.put(new String("语文"), 88);
		whm.put(new String("数学"), 87);
		whm.put(new String("英语"), 93);
		//向WeakHashMap对象添加一个系统缓存字符串
		whm.put("Java", 98);
		System.out.println(whm);
		//通知系统立即进行垃圾回收
		System.gc();
		System.runFinalization();
		System.out.println(whm);
	}
}

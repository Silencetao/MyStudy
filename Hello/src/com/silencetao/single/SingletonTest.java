package com.silencetao.single;

/**
 * 单列模式
 * @author Silence
 *
 */
class Singleton {
	//使用一个类变量来缓存曾经创建的实例
	private static Singleton instance;
	
	//对构造器使用private修饰,隐藏构造器
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		//如果instance为null,则表明还不曾创建Singleton对象
		//如果instance不为null,则表明已创建了Singleton对象
		if (instance == null) {
			//创建一个Singleton对象,并缓存在instance变量里
			instance = new Singleton();
		}
		return instance;
	}
}

public class SingletonTest {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
		//输出为true,表明创建的是同一个对象
		
		String a = "java";
		String b = "ja" + "va";
		System.out.println(a == b);
		
		Integer integer = new Integer(100);
		
		String str1 = new String("Hello");
		String str2 = new String("Hellw");
		System.out.println(str1 == str2);
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}

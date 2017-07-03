package com.silencetao.basic;

/**
 * Object类中clone方法测试
 * @author Silence
 *
 */

class Address {
	private String detail;
	public Address(String detail) {
		this.detail = detail;
	}
	
	public String getDetail() {
		return detail;
	}
}

class User implements Cloneable {
	private int age;
	public Address address;
	
	public User(int age) {
		this.age = age;
		address = new Address("上海松江");
	}
	
	public User clone() throws CloneNotSupportedException {
		return (User)super.clone();
	}
}

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		User u1 = new User(22);
		User u2 = u1.clone();
		System.out.println(u1 == u2);
		//Object类的clone()方法是浅克隆,对于引用类型的实例变量只是复制了这个引用变量
		//所以原有对象的引用类型的实例变量和克隆对象的引用类型的实例变量指向的是内存中的同一个实例
		System.out.println(u1.address == u2.address);//这里输出的是true
	}
}

package com.silencetao.basic;

/**
 * Object����clone��������
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
		address = new Address("�Ϻ��ɽ�");
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
		//Object���clone()������ǳ��¡,�����������͵�ʵ������ֻ�Ǹ�����������ñ���
		//����ԭ�ж�����������͵�ʵ�������Ϳ�¡������������͵�ʵ������ָ������ڴ��е�ͬһ��ʵ��
		System.out.println(u1.address == u2.address);//�����������true
	}
}

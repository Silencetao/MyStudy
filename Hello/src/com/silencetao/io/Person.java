package com.silencetao.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 实现Serializable接口进行序列化
 * @author Silence
 *
 */
class Person implements Serializable {
	private static final long serialVersionUID = 5121662651192715706L;
	private String name;
	private int age;
	//transient修饰的实例变量，将不会被序列化
	private transient String sex;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		//将name实例变量值反转后写入二进制流
		System.out.println("writeObject----->" + name);
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		//将读取的字符串反转后赋给name实例变量
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age = in.readInt();
		System.out.println("readObject----->" + name);
	}
	
	private Object writeReplace() throws ObjectStreamException {//系统在序列化对象时最先调用此方法
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(name);
		list.add(age);
		System.out.println("writeReplace----->" + name);
		return list;
	}
}

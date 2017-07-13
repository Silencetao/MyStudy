package com.silencetao.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * ʵ��Serializable�ӿڽ������л�
 * @author Silence
 *
 */
class Person implements Serializable {
	private static final long serialVersionUID = 5121662651192715706L;
	private String name;
	private int age;
	//transient���ε�ʵ�������������ᱻ���л�
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
		//��nameʵ������ֵ��ת��д���������
		System.out.println("writeObject----->" + name);
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		//����ȡ���ַ�����ת�󸳸�nameʵ������
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age = in.readInt();
		System.out.println("readObject----->" + name);
	}
	
	private Object writeReplace() throws ObjectStreamException {//ϵͳ�����л�����ʱ���ȵ��ô˷���
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(name);
		list.add(age);
		System.out.println("writeReplace----->" + name);
		return list;
	}
}

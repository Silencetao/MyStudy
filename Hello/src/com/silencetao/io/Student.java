package com.silencetao.io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 通过实现Externalizable接口来序列化
 * @author Silence
 *
 */
public class Student implements Externalizable {
	private String name;
	private int age;
	
	//注意必须提供无参数的构造器，否则反序列化时会失败
	public Student() {
		
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		//将name实例变量值反转后写入二进制流
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		//将读取的字符串反转后赋给name实例变量
		this.name = ((StringBuffer) in.readObject()).reverse().toString();
		this.age = in.readInt();
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/Externalizable.txt"));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/Externalizable.txt"));
			) {
			Student s1 = new Student("Silence", 22);
			Student s2 = new Student("陈涛", 22);
			oos.writeObject(s1);
			oos.writeObject(s2);
			Student s3 = (Student) ois.readObject();
			Student s4 = (Student) ois.readObject();
			System.out.println(s3);
			System.out.println(s4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

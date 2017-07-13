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
 * ͨ��ʵ��Externalizable�ӿ������л�
 * @author Silence
 *
 */
public class Student implements Externalizable {
	private String name;
	private int age;
	
	//ע������ṩ�޲����Ĺ��������������л�ʱ��ʧ��
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
		//��nameʵ������ֵ��ת��д���������
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		//����ȡ���ַ�����ת�󸳸�nameʵ������
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
			Student s2 = new Student("����", 22);
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

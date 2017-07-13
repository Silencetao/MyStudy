package com.silencetao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * �Ժ����������͵Ķ���������л�
 * @author Silence
 *
 */
public class WriteReadTeacher {

	public static void writeTeacher() {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/teacher.txt"));
			) {
			Person person = new Person("Silence", 22);
			Teacher t1 = new Teacher("���", person);
			Teacher t2 = new Teacher("��ɮ", person);
			//���ν�4������д�������
			oos.writeObject(t1);
			oos.writeObject(t2);
			oos.writeObject(person);
			oos.writeObject(t2);
			System.out.println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readTeacher() {
		try (
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/teacher.txt"));
			) {
			//���ζ�ȡObjectInputStream�������еĶ���
			Teacher t1 = (Teacher) ois.readObject();
			Teacher t2 = (Teacher) ois.readObject();
			Person person = (Person) ois.readObject();
			Teacher t3 = (Teacher) ois.readObject();
			System.out.println("t1��student�����Ƿ��person��ȣ�" + (t1.getStudent() == person));
			System.out.println("t2��student�����Ƿ��person��ȣ�" + (t2.getStudent() == person));
			System.out.println("t2��t3�Ƿ�������ͬһ������" + (t2.getStudent() == t3.getStudent()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		writeTeacher();
		readTeacher();
	}
}

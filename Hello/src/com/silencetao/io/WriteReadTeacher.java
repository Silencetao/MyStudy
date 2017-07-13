package com.silencetao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对含有引用类型的对象进行序列化
 * @author Silence
 *
 */
public class WriteReadTeacher {

	public static void writeTeacher() {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/teacher.txt"));
			) {
			Person person = new Person("Silence", 22);
			Teacher t1 = new Teacher("悟空", person);
			Teacher t2 = new Teacher("唐僧", person);
			//依次将4个对象写入输出流
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
			//依次读取ObjectInputStream输入流中的对象
			Teacher t1 = (Teacher) ois.readObject();
			Teacher t2 = (Teacher) ois.readObject();
			Person person = (Person) ois.readObject();
			Teacher t3 = (Teacher) ois.readObject();
			System.out.println("t1的student引用是否和person相等：" + (t1.getStudent() == person));
			System.out.println("t2的student引用是否和person相等：" + (t2.getStudent() == person));
			System.out.println("t2和t3是否引用了同一个对象：" + (t2.getStudent() == t3.getStudent()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		writeTeacher();
		readTeacher();
	}
}

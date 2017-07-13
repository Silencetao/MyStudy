package com.silencetao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 使用Java序列化机制多次序列化可变对象时
 * 第一次输出该对象以后，如果改变该对象的实例变量
 * 再次输出该对象时，改变后的实例将不会被输出 
 * @author Silence
 *
 */
public class SerializeMutable {

	public static void main(String[] args) {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/mutable.txt"));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/mutable.txt"));
			) {
			Person person = new Person("孙悟空", 22);
			oos.writeObject(person);
			person.setName("猪八戒");
			oos.writeObject(person);
			Person p1 = (Person) ois.readObject();
			Person p2 = (Person) ois.readObject();
			System.out.println(p1 == p2);
			System.out.println(p2.getName());//第二次写入的name属性没有改变
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

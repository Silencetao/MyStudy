package com.silencetao.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 在文件中读取对象，对其进行反序列化
 * @author Silence
 *
 */
public class ReadObject {

	public static void main(String[] args) {
		try (
				//创建一个ObjectInputStream输入流
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/object.txt"));
			) {
			//从输入流中读取一个Java对象，并将其强制转换为Person类
			Person p = (Person) ois.readObject();
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.silencetao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ʹ��Java���л����ƶ�����л��ɱ����ʱ
 * ��һ������ö����Ժ�����ı�ö����ʵ������
 * �ٴ�����ö���ʱ���ı���ʵ�������ᱻ��� 
 * @author Silence
 *
 */
public class SerializeMutable {

	public static void main(String[] args) {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/mutable.txt"));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/mutable.txt"));
			) {
			Person person = new Person("�����", 22);
			oos.writeObject(person);
			person.setName("��˽�");
			oos.writeObject(person);
			Person p1 = (Person) ois.readObject();
			Person p2 = (Person) ois.readObject();
			System.out.println(p1 == p2);
			System.out.println(p2.getName());//�ڶ���д���name����û�иı�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

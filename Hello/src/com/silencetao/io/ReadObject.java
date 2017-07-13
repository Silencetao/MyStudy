package com.silencetao.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * ���ļ��ж�ȡ���󣬶�����з����л�
 * @author Silence
 *
 */
public class ReadObject {

	public static void main(String[] args) {
		try (
				//����һ��ObjectInputStream������
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/object.txt"));
			) {
			//���������ж�ȡһ��Java���󣬲�����ǿ��ת��ΪPerson��
			Person p = (Person) ois.readObject();
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

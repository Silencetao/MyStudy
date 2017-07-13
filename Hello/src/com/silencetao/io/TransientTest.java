package com.silencetao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * transient�ؼ��ֲ���
 * @author Silence
 *
 */
public class TransientTest {

	public static void main(String[] args) {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/transient.txt"));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/transient.txt"));
			) {
			Person person = new Person("Silence", 22, "��");
			oos.writeObject(person);
			ArrayList list = (ArrayList) ois.readObject();
			System.out.println(list);//sexΪnull
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

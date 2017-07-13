package com.silencetao.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ������д���ļ���
 * @author Silence
 *
 */
public class WriteObject {

	public static void main(String[] args) {
		try (
				//����һ��ObjectOutputSteam�����
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/object.txt"));
			) {
			Person per = new Person("Silence", 22);
			//��per����д�������
			oos.writeObject(per);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

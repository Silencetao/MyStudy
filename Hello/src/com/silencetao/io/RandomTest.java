package com.silencetao.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ʹ��RandomAccessFile������ָ�����м䲿������
 * @author Silence
 *
 */
public class RandomTest {

	public static void main(String[] args) {
		try (
				RandomAccessFile raf = new RandomAccessFile("io/RandomAccessFileTest.txt", "rw");
			) {
			//�ƶ�raf���ļ���¼ָ���λ��
			raf.seek(160);
			raf.write("Hello world!".getBytes());
			byte[] bbuf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(bbuf)) > 0) {
				System.out.println(new String(bbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

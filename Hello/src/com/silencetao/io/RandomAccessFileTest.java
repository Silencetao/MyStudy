package com.silencetao.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ʹ��RandomAccessFile������ָ�����м䲿������
 * @author Silence
 *
 */
public class RandomAccessFileTest {

	public static void main(String[] args) {
		try (
				RandomAccessFile raf = new RandomAccessFile("src\\com\\silencetao\\io\\RandomAccessFileTest.java", "r");
			) {
			//��ȡRandomAccessFile�����ļ�ָ���λ�ã���ʼλ����0
			System.out.println("RandomAccessFile�����ļ�ָ��ĳ�ʼλ�ã�" + raf.getFilePointer());
			//�ƶ�raf���ļ���¼ָ���λ��
			raf.seek(100);
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

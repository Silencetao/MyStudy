package com.silencetao.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ���ļ���ĩβ�������
 * @author Silence
 *
 */
public class AppendContent {

	public static void main(String[] args) {
		try (
				//�Զ�д�ķ�ʽ��һ��RandomAccessFile����
				RandomAccessFile raf = new RandomAccessFile("io/out.txt", "rw");
			) {
			//����¼ָ���ƶ����ļ�ĩβ
			raf.seek(raf.length());
			raf.write("׷�ӽڵ�\r\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

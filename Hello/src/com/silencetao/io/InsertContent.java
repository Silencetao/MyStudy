package com.silencetao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ָ���ļ���ָ��λ�ò������ݵĹ���
 * @author Silence
 *
 */
public class InsertContent {

	public static void insert(String fileName, long pos, String insertContent) throws IOException {
		File temp = File.createTempFile("tmp", null);
		temp.deleteOnExit();
		try (
				RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
				//ʹ����ʱ�ļ���������������
				FileOutputStream tempOut = new FileOutputStream(temp);
				FileInputStream tempIn = new FileInputStream(temp);
			) {
			raf.seek(pos);
			//������뽫����������ݶ�����ʱ�ļ��б���
			byte[] bbuf = new byte[64];
			//���ڱ���ʵ�ʶ�ȡ���ֽ���
			int hasRead = 0;
			//ʹ��ѭ����ʽ��ȡ�����������
			while ((hasRead = raf.read(bbuf)) > 0) {
				//����ȡ������д����ʱ�ļ�
				tempOut.write(bbuf, 0, hasRead);
			}
			//����������ڲ�������
			//���ļ���¼ָ�����¶�λ��posλ��
			raf.seek(pos);
			//׷����Ҫ���������
			raf.write(insertContent.getBytes());
			//׷����ʱ�ļ��е�����
			while ((hasRead = tempIn.read(bbuf)) > 0) {
				raf.write(bbuf, 0, hasRead);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		insert("io/out.txt", 23, "����һ������");
	}
}

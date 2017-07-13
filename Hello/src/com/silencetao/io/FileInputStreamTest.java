package com.silencetao.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputSteam�����
 * @author Silence
 *
 */
public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		//�����ֽ�������
		FileInputStream fis = new FileInputStream("src\\com\\silencetao\\io\\FileInputStreamTest.java");
		//������һ������Ϊ1024�ġ���Ͳ��
		byte[] bbuf = new byte[1024];
		//���ڱ���ʵ�ʶ�ȡ���ֽ���
		int hasRead = 0;
		//ʹ��ѭ�����ظ���ȡˮ������
		while ((hasRead = fis.read(bbuf)) > 0) {
			System.out.println(new String(bbuf, 0, hasRead));
		}
		//�ر��ļ�������
		fis.close();
	}
}

package com.silencetao.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader����ԡ�
 * @author Silence
 *
 */
public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		try (FileReader fr = new FileReader("src\\com\\silencetao\\io\\FileReaderTest.java")) {
			//����һ������Ϊ32�ġ���Ͳ��
			char[] cbuf = new char[32];
			//���ڱ���ʵ�ʶ�ȡ���ַ���
			int hasRead = 0;
			//ʹ��ѭ�����ظ���ȡˮ������
			while ((hasRead = fr.read(cbuf)) > 0) {
				System.out.println(new String(cbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

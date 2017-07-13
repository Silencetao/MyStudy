package com.silencetao.io;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * �����ַ���
 * @author Silence
 *
 */
public class StringNodeTest {

	public static void main(String[] args) {
		String src = "�����쿪ʼ����һ���Ҹ�����\n"
				+ "ι��������������\n"
				+ "�����쿪ʼ��������ʳ���߲�\n"
				+ "����һ�����ӣ��泯�󺣣���ů����\n"
				+ "�����쿪ʼ����ÿһ������ͨ��\n"
				+ "���������ҵ��Ҹ�\n";
		char[] buffer = new char[32];
		int hasRead = 0;
		try (StringReader sr = new StringReader(src)) {
			//����ѭ����ȡ�ķ�ʽ��ȡ�ַ���
			while ((hasRead = sr.read(buffer)) > 0) {
				System.out.println(new String(buffer, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (StringWriter sw = new StringWriter()) {
			sw.write("��һ�������ĳ��У�\n");
			sw.write("����Զ�����ң�\n");
			sw.write("����������Ļ��ǣ�\n");
			sw.write("�����ǹ���ľ���\n");
			System.out.println(sw.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

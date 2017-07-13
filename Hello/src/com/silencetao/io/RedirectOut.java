package com.silencetao.io;

import java.io.IOException;
import java.io.PrintStream;

/**
 * �ض����׼�����
 * @author Silence
 *
 */
public class RedirectOut {

	public static void main(String[] args) {
		try (
				PrintStream ps = new PrintStream("io/out.txt");
			) {
			//����׼����ض���ps�����
			System.setOut(ps);
			//���׼��������һ���ַ���
			System.out.println("��ͨ�ַ���");
			//���׼��������һ������
			System.out.println(new RedirectOut());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

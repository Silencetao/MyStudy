package com.silencetao.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * �ض����׼������
 * @author Silence
 *
 */
public class RedirectIn {

	public static void main(String[] args) {
		try (
				FileInputStream fis = new FileInputStream("src\\com\\silencetao\\io\\RedirectIn.java");
			) {
			//����׼�����ض���fis������
			System.setIn(fis);
			//ʹ��System.in����Scanner�������ڻ�ȡ��׼����
			Scanner sc = new Scanner(System.in);
			//��������һ�аѻس���Ϊ�ָ���
			sc.useDelimiter("\n");
			//�ж��Ƿ�����һ��������
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

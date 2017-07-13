package com.silencetao.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * ��Java����������Java�����������һ��Java���򣬲�����һ��Java��������������
 * @author Silence
 *
 */
public class WriteToProcess {

	public static void main(String[] args) throws IOException {
		//����java ReadStandard����������и�������ӽ���
		Process p = Runtime.getRuntime().exec("java ReadStandard");
		try (
				//��p���̵����������PrintStream����
				//���������Ա����������������p��������������
				PrintStream ps = new PrintStream(p.getOutputStream());
			) {
			//��ReadStandard����д�����ݣ���Щ���ݽ���ReadStandard��ȡ
			ps.println("��ͨ�ַ���");
			ps.println(new WriteToProcess());
		}
	}
}

class ReadStandard {
	
	public static void main(String[] args) {
		try (
				//ʹ��System.in����Scanner�������ڻ�ȡ��׼����
				Scanner sc = new Scanner(System.in);
				PrintStream ps = new PrintStream(new FileOutputStream("io/ReadStandard.txt"));
			) {
			//��������һ��ֻ�ѻس���Ϊ�ָ���
			sc.useDelimiter("\n");
			while (sc.hasNext()) {
				ps.println("��������������ǣ�" + sc.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

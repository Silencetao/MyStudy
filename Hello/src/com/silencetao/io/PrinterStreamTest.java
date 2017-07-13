package com.silencetao.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * PrinterSteam�����
 * @author Silence
 *
 */
public class PrinterStreamTest {

	public static void main(String[] args) {
		try (
				FileOutputStream fos = new FileOutputStream("io/PrintStream.txt");
				PrintStream ps = new PrintStream(fos);
			) {
			//ʹ��PrintSreamִ�����
			ps.println("��ͨ�ַ�");
			//ֱ��ʹ��PrintStream�������
			ps.println(new PrinterStreamTest());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package com.silencetao.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * PrinterSteam类测试
 * @author Silence
 *
 */
public class PrinterStreamTest {

	public static void main(String[] args) {
		try (
				FileOutputStream fos = new FileOutputStream("io/PrintStream.txt");
				PrintStream ps = new PrintStream(fos);
			) {
			//使用PrintSream执行输出
			ps.println("普通字符");
			//直接使用PrintStream输出对象
			ps.println(new PrinterStreamTest());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package com.silencetao.io;

import java.io.IOException;
import java.io.PrintStream;

/**
 * 重定向标准输出流
 * @author Silence
 *
 */
public class RedirectOut {

	public static void main(String[] args) {
		try (
				PrintStream ps = new PrintStream("io/out.txt");
			) {
			//将标准输出重定向到ps输出流
			System.setOut(ps);
			//向标准输出流输出一个字符串
			System.out.println("普通字符串");
			//向标准输出流输出一个对象
			System.out.println(new RedirectOut());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

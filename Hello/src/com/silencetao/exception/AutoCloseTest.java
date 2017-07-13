package com.silencetao.exception;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 自动关闭资源
 * @author Silence
 *
 */
public class AutoCloseTest {

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("a.ini"));
			PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))) {
			System.out.println(br.readLine());
			ps.println("何以解忧,唯有杜康");
		}
	}
}

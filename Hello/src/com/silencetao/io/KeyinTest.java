package com.silencetao.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 转换流测试
 * @author Silence
 *
 */
public class KeyinTest {

	public static void main(String[] args) {
		try (
				//将System.in对象转换为Reader对象
				InputStreamReader reader = new InputStreamReader(System.in);
				//将普通的Reader包装成BufferedReader(缓冲流)
				BufferedReader br = new BufferedReader(reader);
			) {
			String line = null;
			//采用循环的方式来逐行的读取
			while ((line = br.readLine()) != null) {
				if (line.equals("exit")) {
//					System.exit(1);
					break ;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}*/
	}
}

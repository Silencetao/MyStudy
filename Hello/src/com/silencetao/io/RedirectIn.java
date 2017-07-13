package com.silencetao.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 重定向标准输入流
 * @author Silence
 *
 */
public class RedirectIn {

	public static void main(String[] args) {
		try (
				FileInputStream fis = new FileInputStream("src\\com\\silencetao\\io\\RedirectIn.java");
			) {
			//将标准输入重定向到fis输入流
			System.setIn(fis);
			//使用System.in创建Scanner对象，用于获取标准输入
			Scanner sc = new Scanner(System.in);
			//增加下面一行把回车作为分隔符
			sc.useDelimiter("\n");
			//判断是否还有下一个输入项
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

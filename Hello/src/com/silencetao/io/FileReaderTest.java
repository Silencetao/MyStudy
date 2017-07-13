package com.silencetao.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader类测试　
 * @author Silence
 *
 */
public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		try (FileReader fr = new FileReader("src\\com\\silencetao\\io\\FileReaderTest.java")) {
			//创建一个长度为32的“竹筒”
			char[] cbuf = new char[32];
			//用于保存实际读取的字符数
			int hasRead = 0;
			//使用循环来重复“取水”过程
			while ((hasRead = fr.read(cbuf)) > 0) {
				System.out.println(new String(cbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

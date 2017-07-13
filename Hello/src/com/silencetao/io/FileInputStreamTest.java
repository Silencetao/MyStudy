package com.silencetao.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputSteam类测试
 * @author Silence
 *
 */
public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		//创建字节输入流
		FileInputStream fis = new FileInputStream("src\\com\\silencetao\\io\\FileInputStreamTest.java");
		//创建过一个长度为1024的“竹筒”
		byte[] bbuf = new byte[1024];
		//用于保存实际读取的字节数
		int hasRead = 0;
		//使用循环来重复“取水”过程
		while ((hasRead = fis.read(bbuf)) > 0) {
			System.out.println(new String(bbuf, 0, hasRead));
		}
		//关闭文件输入流
		fis.close();
	}
}

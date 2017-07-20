package com.silencetao.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RandomAccessFile来访问指定的中间部分数据
 * @author Silence
 *
 */
public class RandomTest {

	public static void main(String[] args) {
		try (
				RandomAccessFile raf = new RandomAccessFile("io/RandomAccessFileTest.txt", "rw");
			) {
			//移动raf的文件记录指针的位置
			raf.seek(160);
			raf.write("Hello world!".getBytes());
			byte[] bbuf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(bbuf)) > 0) {
				System.out.println(new String(bbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

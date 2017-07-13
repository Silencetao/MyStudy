package com.silencetao.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 在文件的末尾添加内容
 * @author Silence
 *
 */
public class AppendContent {

	public static void main(String[] args) {
		try (
				//以读写的方式打开一个RandomAccessFile对象
				RandomAccessFile raf = new RandomAccessFile("io/out.txt", "rw");
			) {
			//将记录指针移动到文件末尾
			raf.seek(raf.length());
			raf.write("追加节点\r\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

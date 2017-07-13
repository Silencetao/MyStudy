package com.silencetao.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RandomAccessFile来访问指定的中间部分数据
 * @author Silence
 *
 */
public class RandomAccessFileTest {

	public static void main(String[] args) {
		try (
				RandomAccessFile raf = new RandomAccessFile("src\\com\\silencetao\\io\\RandomAccessFileTest.java", "r");
			) {
			//获取RandomAccessFile对象文件指针的位置，初始位置是0
			System.out.println("RandomAccessFile对象文件指针的初始位置：" + raf.getFilePointer());
			//移动raf的文件记录指针的位置
			raf.seek(100);
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

package com.silencetao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 向指定文件、指定位置插入内容的功能
 * @author Silence
 *
 */
public class InsertContent {

	public static void insert(String fileName, long pos, String insertContent) throws IOException {
		File temp = File.createTempFile("tmp", null);
		temp.deleteOnExit();
		try (
				RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
				//使用临时文件保存插入点后的数据
				FileOutputStream tempOut = new FileOutputStream(temp);
				FileInputStream tempIn = new FileInputStream(temp);
			) {
			raf.seek(pos);
			//下面代码将插入点后的内容读入临时文件中保存
			byte[] bbuf = new byte[64];
			//用于保存实际读取的字节数
			int hasRead = 0;
			//使用循环方式读取插入点后的数据
			while ((hasRead = raf.read(bbuf)) > 0) {
				//将读取的数据写入临时文件
				tempOut.write(bbuf, 0, hasRead);
			}
			//下面代码用于插入内容
			//把文件记录指针重新定位到pos位置
			raf.seek(pos);
			//追加需要插入的内容
			raf.write(insertContent.getBytes());
			//追加临时文件中的内容
			while ((hasRead = tempIn.read(bbuf)) > 0) {
				raf.write(bbuf, 0, hasRead);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		insert("io/out.txt", 23, "插入一条数据");
	}
}

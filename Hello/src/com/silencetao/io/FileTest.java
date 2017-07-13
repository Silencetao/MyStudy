package com.silencetao.io;

import java.io.File;
import java.io.IOException;

/**
 * File类测试
 * @author Silence
 *
 */
public class FileTest {

	public static void main(String[] args) throws IOException {
		File file = new File(".");
		System.out.println(file.getName());
		//最后一级子目录的父目录名(相对路径)
		System.out.println(file.getParent());
		//相对路径名
		System.out.println(file.getPath());
		//绝对路径
		System.out.println(file.getAbsoluteFile().getParent());
		//绝对路径名
		System.out.println(file.getAbsolutePath());
		System.out.println("是否存在" + file.exists());
		System.out.println("是否可读" + file.canRead());
		System.out.println("是否可写" + file.canWrite());
		System.out.println("是否可以执行" + file.canExecute());
		System.out.println("是否为文件" + file.isFile());
		System.out.println("是否为目录" + file.isDirectory());
		System.out.println("是否为绝对路径" + file.isAbsolute());
		System.out.println(">-------我是可爱的分割线-------<");
		//在当前路径下创建一个临时文件
		File tmpFile = File.createTempFile("aaa", ".txt", file);
		//指定JVM退出时删除该文件
		tmpFile.deleteOnExit();
		File newFile = new File(System.currentTimeMillis() + "");
		System.out.println("newFile对象是否存在" + newFile.exists());
		newFile.createNewFile();//以newFile对象来创建一个文件
		//因为newFile已存在，所以下面的方法返回false
		newFile.mkdir();
		String[] fileList = file.list();
		for (String fileName : fileList) {
			System.out.println(fileName);
		}
		File[] roots = File.listRoots();
		for (File root : roots) {
			System.out.println(root);
		}
	}
}

package com.silencetao.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用FileVisitor遍历文件和目录
 * @author Silence
 *
 */
public class FileVisitorTest {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("nio/FileVisitor.txt");
		List<String> pathList = new ArrayList<String>();
		//遍历E:\Code\GitHub\MyStudy\Hello目录下的所有文件和子目录
		Files.walkFileTree(Paths.get("E:", "Code", "GitHub", "MyStudy", "Hello"), 
				new SimpleFileVisitor<Path>() {
			//访问文件时触发该方法
			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("正在访问" + file + "文件");
				pathList.add("正在访问" + file + "文件");
				//如果找到了FileVisitorTest.java文件
				if (file.endsWith("FileVisitorTest.java")) {
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}
			
			//开始访问目录时触发该方法
			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("正在访问" + dir + "路径");
				pathList.add("正在访问" + dir + "文件");
				return FileVisitResult.CONTINUE;
			}
		});
		//将路径写到FileVisitor.txt文件中
		Files.write(path, pathList, Charset.forName("gbk"));
	}
}

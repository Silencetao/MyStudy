package com.silencetao.nio;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Files工具类测试
 * @author Silence
 *
 */
public class FilesTest {

	public static void main(String[] args) throws Exception {
		//复制文件
		Files.copy(Paths.get("nio/header.txt"), new FileOutputStream("nio/header.jpg"));
		//判断文件是否为隐藏文件
		System.out.println("a.ini是否为隐藏文件:" + Files.isHidden(Paths.get("a.ini")));
		//一次性读取a.ini的所有行
		List<String> lines = Files.readAllLines(Paths.get("a.ini"), Charset.forName("gbk"));
		System.out.println(lines);
		//判断指定文件大小
		System.out.println("a.ini的大小为:" + Files.size(Paths.get("a.ini")));
		List<String> poem = new ArrayList<String>();
		poem.add("大漠孤烟直");
		poem.add("长河落日圆");
		//直接将多个字符串内容写入指定文件中
		Files.write(Paths.get("nio/pome.txt"), poem, Charset.forName("GBK"));
		//使用Java 8新增的Stream API列出当前目录下所有文件和子目录
		Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
		//使用Java 8新增的Stream API读取文件内容
		Files.lines(Paths.get("a.ini"), Charset.forName("gbk")).forEach(line -> System.out.println(line));
		FileStore store = Files.getFileStore(Paths.get("D:"));
		//获取D盘的总空间、可用空间
		System.out.println("D:共有空间:" + store.getTotalSpace() / 1024 / 1024 / 1024);
		System.out.println("D:剩余空间:" + store.getUnallocatedSpace() / 1024 / 1024 / 1024);
	}
}

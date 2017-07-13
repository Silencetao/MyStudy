package com.silencetao.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 在Java程序中启动Java虚拟机运行另一个Java程序，并向另一个Java程序中输入数据
 * @author Silence
 *
 */
public class WriteToProcess {

	public static void main(String[] args) throws IOException {
		//运行java ReadStandard命令，返回运行该命令的子进程
		Process p = Runtime.getRuntime().exec("java ReadStandard");
		try (
				//以p进程的输出流创建PrintStream对象
				//这个输出流对本程序是输出流，对p进程则是输入流
				PrintStream ps = new PrintStream(p.getOutputStream());
			) {
			//向ReadStandard程序写入内容，这些内容将被ReadStandard读取
			ps.println("普通字符串");
			ps.println(new WriteToProcess());
		}
	}
}

class ReadStandard {
	
	public static void main(String[] args) {
		try (
				//使用System.in创建Scanner对象，用于获取标准输入
				Scanner sc = new Scanner(System.in);
				PrintStream ps = new PrintStream(new FileOutputStream("io/ReadStandard.txt"));
			) {
			//增加下面一行只把回车作为分隔付
			sc.useDelimiter("\n");
			while (sc.hasNext()) {
				ps.println("键盘输入的内容是：" + sc.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

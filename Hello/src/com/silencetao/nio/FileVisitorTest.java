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
 * ʹ��FileVisitor�����ļ���Ŀ¼
 * @author Silence
 *
 */
public class FileVisitorTest {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("nio/FileVisitor.txt");
		List<String> pathList = new ArrayList<String>();
		//����E:\Code\GitHub\MyStudy\HelloĿ¼�µ������ļ�����Ŀ¼
		Files.walkFileTree(Paths.get("E:", "Code", "GitHub", "MyStudy", "Hello"), 
				new SimpleFileVisitor<Path>() {
			//�����ļ�ʱ�����÷���
			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("���ڷ���" + file + "�ļ�");
				pathList.add("���ڷ���" + file + "�ļ�");
				//����ҵ���FileVisitorTest.java�ļ�
				if (file.endsWith("FileVisitorTest.java")) {
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}
			
			//��ʼ����Ŀ¼ʱ�����÷���
			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("���ڷ���" + dir + "·��");
				pathList.add("���ڷ���" + dir + "�ļ�");
				return FileVisitResult.CONTINUE;
			}
		});
		//��·��д��FileVisitor.txt�ļ���
		Files.write(path, pathList, Charset.forName("gbk"));
	}
}

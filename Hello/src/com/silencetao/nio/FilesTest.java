package com.silencetao.nio;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Files���������
 * @author Silence
 *
 */
public class FilesTest {

	public static void main(String[] args) throws Exception {
		//�����ļ�
		Files.copy(Paths.get("nio/header.txt"), new FileOutputStream("nio/header.jpg"));
		//�ж��ļ��Ƿ�Ϊ�����ļ�
		System.out.println("a.ini�Ƿ�Ϊ�����ļ�:" + Files.isHidden(Paths.get("a.ini")));
		//һ���Զ�ȡa.ini��������
		List<String> lines = Files.readAllLines(Paths.get("a.ini"), Charset.forName("gbk"));
		System.out.println(lines);
		//�ж�ָ���ļ���С
		System.out.println("a.ini�Ĵ�СΪ:" + Files.size(Paths.get("a.ini")));
		List<String> poem = new ArrayList<String>();
		poem.add("��Į����ֱ");
		poem.add("��������Բ");
		//ֱ�ӽ�����ַ�������д��ָ���ļ���
		Files.write(Paths.get("nio/pome.txt"), poem, Charset.forName("GBK"));
		//ʹ��Java 8������Stream API�г���ǰĿ¼�������ļ�����Ŀ¼
		Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
		//ʹ��Java 8������Stream API��ȡ�ļ�����
		Files.lines(Paths.get("a.ini"), Charset.forName("gbk")).forEach(line -> System.out.println(line));
		FileStore store = Files.getFileStore(Paths.get("D:"));
		//��ȡD�̵��ܿռ䡢���ÿռ�
		System.out.println("D:���пռ�:" + store.getTotalSpace() / 1024 / 1024 / 1024);
		System.out.println("D:ʣ��ռ�:" + store.getUnallocatedSpace() / 1024 / 1024 / 1024);
	}
}

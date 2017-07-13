package com.silencetao.io;

import java.io.File;
import java.io.IOException;

/**
 * File�����
 * @author Silence
 *
 */
public class FileTest {

	public static void main(String[] args) throws IOException {
		File file = new File(".");
		System.out.println(file.getName());
		//���һ����Ŀ¼�ĸ�Ŀ¼��(���·��)
		System.out.println(file.getParent());
		//���·����
		System.out.println(file.getPath());
		//����·��
		System.out.println(file.getAbsoluteFile().getParent());
		//����·����
		System.out.println(file.getAbsolutePath());
		System.out.println("�Ƿ����" + file.exists());
		System.out.println("�Ƿ�ɶ�" + file.canRead());
		System.out.println("�Ƿ��д" + file.canWrite());
		System.out.println("�Ƿ����ִ��" + file.canExecute());
		System.out.println("�Ƿ�Ϊ�ļ�" + file.isFile());
		System.out.println("�Ƿ�ΪĿ¼" + file.isDirectory());
		System.out.println("�Ƿ�Ϊ����·��" + file.isAbsolute());
		System.out.println(">-------���ǿɰ��ķָ���-------<");
		//�ڵ�ǰ·���´���һ����ʱ�ļ�
		File tmpFile = File.createTempFile("aaa", ".txt", file);
		//ָ��JVM�˳�ʱɾ�����ļ�
		tmpFile.deleteOnExit();
		File newFile = new File(System.currentTimeMillis() + "");
		System.out.println("newFile�����Ƿ����" + newFile.exists());
		newFile.createNewFile();//��newFile����������һ���ļ�
		//��ΪnewFile�Ѵ��ڣ���������ķ�������false
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

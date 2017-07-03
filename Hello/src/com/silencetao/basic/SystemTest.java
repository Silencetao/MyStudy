package com.silencetao.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * System�����
 * @author Silence
 *
 */
public class SystemTest {
	
	public static void main(String[] args) throws IOException {
		//��ȡϵͳ���еĻ�������
		/*Map<String, String> env = System.getenv();
		for (String name : env.keySet()) {
			System.out.println(name + "----->" + env.get(name));
		}*/
		//��ȡָ������������ֵ
		System.out.println(System.getenv("JAVA_HOME"));
		//��ȡ���е�ϵͳ����
		//Properties properties = System.getProperties();
		//�����е�ϵͳ���Ա��浽properties.txt�ļ���
		//properties.store(new FileOutputStream("properties.txt"), "System Properties");
		//����ض���ϵͳ����
		System.out.println(System.getProperty("os.name"));
		
		/*
		 * System.identityHashCode(Object x)
		 * ��ȡ���ݸö���ĵ�ַ����õ���hashCodeֵ
		 */
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}

package com.silencetao.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * System类测试
 * @author Silence
 *
 */
public class SystemTest {
	
	public static void main(String[] args) throws IOException {
		//获取系统所有的环境变量
		/*Map<String, String> env = System.getenv();
		for (String name : env.keySet()) {
			System.out.println(name + "----->" + env.get(name));
		}*/
		//获取指定环境变量的值
		System.out.println(System.getenv("JAVA_HOME"));
		//获取所有的系统属性
		//Properties properties = System.getProperties();
		//将所有的系统属性保存到properties.txt文件中
		//properties.store(new FileOutputStream("properties.txt"), "System Properties");
		//输出特定的系统属性
		System.out.println(System.getProperty("os.name"));
		
		/*
		 * System.identityHashCode(Object x)
		 * 获取根据该对象的地址计算得到的hashCode值
		 */
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}

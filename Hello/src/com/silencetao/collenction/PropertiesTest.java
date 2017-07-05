package com.silencetao.collenction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties¿‡≤‚ ‘
 * @author Silence
 *
 */
public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		Properties pro1 = new Properties();
		pro1.setProperty("username", "Silence");
		pro1.setProperty("password", "123456");
		pro1.setProperty("email", "service@silencetao.com");
		pro1.store(new FileOutputStream("a.properties"), "comment line");
		Properties pro2 = new Properties();
		pro2.setProperty("gender", "male");
		pro2.load(new FileInputStream("a.properties"));
		System.out.println(pro2);
	}
}

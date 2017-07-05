package com.silencetao.collenction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		pro1.store(new FileOutputStream("a.ini"), "comment line");
		Properties pro2 = new Properties();
		pro2.setProperty("gender", "male");
		pro2.load(new FileInputStream("a.ini"));
		System.out.println(pro2);
	}
}

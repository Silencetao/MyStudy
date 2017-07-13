package com.silencetao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutStreamÀà²âÊÔ
 * @author Silence
 *
 */
public class FileOutStreamTest {

	public static void main(String[] args) throws IOException {
		try (
				//FileInputStream fis = new FileInputStream("src\\com\\silencetao\\io\\FileOutStreamTest.java");
				//FileOutputStream fos = new FileOutputStream("io/FileOutStream.txt")
				FileInputStream fis = new FileInputStream("header.jpg");
				FileOutputStream fos = new FileOutputStream("io/header.jpg")
			) {
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			while ((hasRead = fis.read(bbuf)) > 0) {
				fos.write(bbuf, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

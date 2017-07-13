package com.silencetao.io;

import java.io.File;

/**
 * ÎÄ¼þ¹ýÂËÆ÷¡ª¡ªFilenameFilter
 * @author Silence
 *
 */
public class FilenameFilterTest {

	public static void main(String[] args) {
		File file = new File(".");
		String[] nameList = file.list((dir, name) -> name.endsWith(".java")
				|| new File(name).isDirectory());
		for (String name : nameList) {
			System.out.println(name);
		}
	}
}

package com.silencetao.basic;

/**
 * ������ʽ
 * @author Silence
 *
 */
public class RegexTest {

	public static void main(String[] args) {
		String str = "hello, java";
		System.out.println(str.replaceFirst("\\w*", "����"));
		System.out.println(str.replaceFirst("\\w*?", "����"));
	}
}

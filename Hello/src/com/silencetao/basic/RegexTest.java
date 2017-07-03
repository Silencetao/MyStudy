package com.silencetao.basic;

/**
 * 正则表达式
 * @author Silence
 *
 */
public class RegexTest {

	public static void main(String[] args) {
		String str = "hello, java";
		System.out.println(str.replaceFirst("\\w*", "陈涛"));
		System.out.println(str.replaceFirst("\\w*?", "陈涛"));
	}
}

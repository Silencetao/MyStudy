package com.silencetao.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽMatcher���start()��end()��������
 * @author Silence
 *
 */
public class StartEnd {

	public static void main(String[] args) {
		String regStr = "Java is very easy!";
		System.out.println("Ŀ���ַ���:" + regStr);
		Matcher m = Pattern.compile("\\w+").matcher(regStr);
		while (m.find()) {
			System.out.println(m.group() + "," + m.start() + "," + m.end());
		}
	}
}

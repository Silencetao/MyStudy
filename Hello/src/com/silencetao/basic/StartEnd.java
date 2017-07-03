package com.silencetao.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式Matcher类的start()和end()方法测试
 * @author Silence
 *
 */
public class StartEnd {

	public static void main(String[] args) {
		String regStr = "Java is very easy!";
		System.out.println("目标字符串:" + regStr);
		Matcher m = Pattern.compile("\\w+").matcher(regStr);
		while (m.find()) {
			System.out.println(m.group() + "," + m.start() + "," + m.end());
		}
	}
}

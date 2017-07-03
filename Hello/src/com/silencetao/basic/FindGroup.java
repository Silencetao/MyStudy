package com.silencetao.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式获取指定子串
 * @author Silence
 *
 */
public class FindGroup {

	public static void main(String[] args) {
		String str = "12345678900放大镜15932432433，发护发18770814753，"
				+ "阿德福43284032934建大佛IE我i18770813015";
		Matcher m = Pattern.compile("1[3578]\\d{9}").matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}

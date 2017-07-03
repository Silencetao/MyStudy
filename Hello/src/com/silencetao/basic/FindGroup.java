package com.silencetao.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ��ȡָ���Ӵ�
 * @author Silence
 *
 */
public class FindGroup {

	public static void main(String[] args) {
		String str = "12345678900�Ŵ�15932432433��������18770814753��"
				+ "���¸�43284032934�����IE��i18770813015";
		Matcher m = Pattern.compile("1[3578]\\d{9}").matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}

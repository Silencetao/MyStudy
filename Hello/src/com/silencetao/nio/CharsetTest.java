package com.silencetao.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * ��ȡJDK��֧�ֵ�ȫ���ַ���
 * @author Silence
 *
 */
public class CharsetTest {

	public static void main(String[] args) {
		//��ȡJava֧�ֵ�ȫ���ַ���
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet()) {
			System.out.println(alias + "----->" + map.get(alias));
		}
	}
}

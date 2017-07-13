package com.silencetao.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * 获取JDK所支持的全部字符集
 * @author Silence
 *
 */
public class CharsetTest {

	public static void main(String[] args) {
		//获取Java支持的全部字符集
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet()) {
			System.out.println(alias + "----->" + map.get(alias));
		}
	}
}

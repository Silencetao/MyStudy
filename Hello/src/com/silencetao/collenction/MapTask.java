package com.silencetao.collenction;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 《疯狂Java讲义》第332页-本章练习
 * 	3.给定["a", "b", "a", "b", "c", "a", "b", "c", "b"]字符串数组,然后使用Map的key来保存数组中的
 * 	字符串元素,vlaue来保存字符串元素的出现的次数,最后统计出各字符串元素的出现次数
 * @author Silence
 *
 */
public class MapTask {

	public static void main(String[] args) {
		String[] str = {"d", "b", "a", "b", "a", "b", "c", "a", "b", "c", "b"};
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < str.length; i++) {
			if (map.containsKey(str[i])) {
				int times = map.get(str[i]);
				map.put(str[i], ++times);
			} else {
				map.put(str[i], 1);
			}
		}
		for (String key : map.keySet()) {
			System.out.println(key + "----->" + map.get(key));
		}
		System.out.println(str[0].getBytes()[0]);
		Collection<String> c = Arrays.asList(str);
		System.out.println(c);
		Set<String> set = new TreeSet<String>((o1, o2) -> {
			String a = (String)o1;
			String b = (String)o2;
			return a.getBytes()[0] > b.getBytes()[0] ? -1 : a.getBytes()[0] < b.getBytes()[0] ? 1 : 0;
		});
		set.addAll(map.keySet());
		System.out.println(set);
		for (String key : set) {
			System.out.println(key + "----->" + map.get(key));
		}
	}
}

package com.silencetao.collenction;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Map的基本功能
 * @author Silence
 *
 */
public class MapTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("疯狂Java讲义", 100);
		map.put("疯狂IOS讲义", 90);
		map.put("疯狂Ajax讲义", 78);
		map.put("轻量级Java EE企业应用实战", 99);
		System.out.println(map.put("疯狂IOS讲义", 89));
		System.out.println(map);
		System.out.println(map.containsKey("疯狂IOS讲义"));
		System.out.println(map.containsValue(99));
		for (Object key : map.keySet()) {
			System.out.println(key + "----->" + map.get(key));
		}
//		map.remove("疯狂Ajax讲义");
		System.out.println(map);
		for (Object object : map.entrySet()) {
			Entry entry = (Entry) object;
			System.out.println(entry.getKey() + "----->" + entry.getValue());
			System.out.println(entry);
		}
		System.out.println(">---------可爱的分割线--------<");
		map.forEach((key, value) -> System.out.println(key + "---->" + value));
		System.out.println(map.getOrDefault("疯狂IOS讲义", "f"));
		System.out.println(">---------可爱的分割线--------<");
		//key存在则覆盖,不存在则返回null
		map.replace("疯狂XML讲义", 67);
		System.out.println(map);
		//若value为空,用新value覆盖,若不为null,根据原value和新value计算一个value覆盖
		map.merge("疯狂Ajax讲义", 12, (oldVal, param) -> (Integer)oldVal + (Integer)param);
		System.out.println(map);
		//value为null,根据key计算新的value覆盖原来的value
		map.computeIfAbsent("Java", key -> ((String)key).length());
		System.out.println(map);
		//value不为null,根据key和value计算新值,新值不为null,覆盖原value,若新值为null,则删除原key-value对
		map.computeIfPresent("Java", (key, value) -> ((String)key).length() * (Integer)value);
		System.out.println(map);
	}
}

package com.silencetao.collenction;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Map�Ļ�������
 * @author Silence
 *
 */
public class MapTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("���Java����", 100);
		map.put("���IOS����", 90);
		map.put("���Ajax����", 78);
		map.put("������Java EE��ҵӦ��ʵս", 99);
		System.out.println(map.put("���IOS����", 89));
		System.out.println(map);
		System.out.println(map.containsKey("���IOS����"));
		System.out.println(map.containsValue(99));
		for (Object key : map.keySet()) {
			System.out.println(key + "----->" + map.get(key));
		}
//		map.remove("���Ajax����");
		System.out.println(map);
		for (Object object : map.entrySet()) {
			Entry entry = (Entry) object;
			System.out.println(entry.getKey() + "----->" + entry.getValue());
			System.out.println(entry);
		}
		System.out.println(">---------�ɰ��ķָ���--------<");
		map.forEach((key, value) -> System.out.println(key + "---->" + value));
		System.out.println(map.getOrDefault("���IOS����", "f"));
		System.out.println(">---------�ɰ��ķָ���--------<");
		//key�����򸲸�,�������򷵻�null
		map.replace("���XML����", 67);
		System.out.println(map);
		//��valueΪ��,����value����,����Ϊnull,����ԭvalue����value����һ��value����
		map.merge("���Ajax����", 12, (oldVal, param) -> (Integer)oldVal + (Integer)param);
		System.out.println(map);
		//valueΪnull,����key�����µ�value����ԭ����value
		map.computeIfAbsent("Java", key -> ((String)key).length());
		System.out.println(map);
		//value��Ϊnull,����key��value������ֵ,��ֵ��Ϊnull,����ԭvalue,����ֵΪnull,��ɾ��ԭkey-value��
		map.computeIfPresent("Java", (key, value) -> ((String)key).length() * (Integer)value);
		System.out.println(map);
	}
}

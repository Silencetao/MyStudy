package com.silencetao.collenction;

import java.util.WeakHashMap;

/**
 * WeakHashMap����
 * @author Silence
 *
 */
public class WeakHashMapTest {

	public static void main(String[] args) {
		WeakHashMap whm = new WeakHashMap();
		//��WeakHashMap��������������ַ�������
		whm.put(new String("����"), 88);
		whm.put(new String("��ѧ"), 87);
		whm.put(new String("Ӣ��"), 93);
		//��WeakHashMap�������һ��ϵͳ�����ַ���
		whm.put("Java", 98);
		System.out.println(whm);
		//֪ͨϵͳ����������������
		System.gc();
		System.runFinalization();
		System.out.println(whm);
	}
}

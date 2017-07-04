package com.silencetao.collenction;

import java.util.EnumSet;

/**
 * EnumSet����
 * @author Silence
 *
 */

enum Season {
	SPRING, SUMMER, FALL, WINTER
}

public class EnumSetTest {

	public static void main(String[] args) {
		EnumSet es1 = EnumSet.allOf(Season.class);//����Ԫ�ؾ���ȫ��ö��ֵ
		System.out.println(es1);
		EnumSet es2 = EnumSet.noneOf(Season.class);//����һ���յļ���
		System.out.println(es2);
		es2.add(Season.FALL);
		es2.add(Season.SUMMER);
		System.out.println(es2);
		EnumSet es3 = EnumSet.of(Season.SUMMER, Season.WINTER);//��ָ����ö��ֵ����EnumSet����
		System.out.println(es3);
		EnumSet es4 = EnumSet.range(Season.SPRING, Season.SUMMER);//����һ��������SPRING��SUMMER�ļ���
		System.out.println(es4);
		EnumSet es5 = EnumSet.complementOf(es4);//��������es4�����ļ���
		System.out.println(es5);
	}
}

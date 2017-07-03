package com.silencetao.basic;

import java.math.BigDecimal;

/**
 * BigDecimal�����
 * @author Silence
 *
 */

/*
 * ����һ��������,��BigDecimal����ķ���ִ��������ٽ����ת����double�ͱ���
 * ʹ��BigDecimal.valueOf(double v)�ķ�ʽ������BigDecimal����
 * �Ա�֤���Ȳ��ᶪʧ
 */
class Arith {
	//Ĭ�ϳ������㾫��
	private static final int DEF_DIV_SCALE = 10;
	
	//������˽�л�,���������ʵ����
	private Arith() {
		
	}
	
	//�ӷ�����
	public static double add(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.add(b2).doubleValue();
	}
	
	//��������
	public static double sub(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.subtract(b2).doubleValue();
	}
	
	//�˷�����
	public static double mul(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.multiply(b2).doubleValue();
	}
	
	//��������
	public static double div(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}

public class BigDecimalTest {

	public static void main(String[] args) {
		System.out.println(Arith.add(5.2, 8.3));
		System.out.println(Arith.sub(2.6, 4.8));
		System.out.println(Arith.mul(7.3, 3.9));
		System.out.println(Arith.div(3.3, 6.7));
	}
}

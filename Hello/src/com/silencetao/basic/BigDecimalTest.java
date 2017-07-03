package com.silencetao.basic;

import java.math.BigDecimal;

/**
 * BigDecimal类测试
 * @author Silence
 *
 */

/*
 * 创建一个工具类,将BigDecimal对象的方法执行运算后再将结果转换成double型变量
 * 使用BigDecimal.valueOf(double v)的方式来创建BigDecimal对象
 * 以保证精度不会丢失
 */
class Arith {
	//默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;
	
	//构造器私有化,不让这个类实例化
	private Arith() {
		
	}
	
	//加法运算
	public static double add(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.add(b2).doubleValue();
	}
	
	//减法运算
	public static double sub(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.subtract(b2).doubleValue();
	}
	
	//乘法运算
	public static double mul(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.multiply(b2).doubleValue();
	}
	
	//除法运算
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

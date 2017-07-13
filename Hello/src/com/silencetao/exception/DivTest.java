package com.silencetao.exception;

/**
 * 异常处理测试类
 * @author Silence
 *
 */
public class DivTest {

	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println(c);
		} catch (IndexOutOfBoundsException e) {//数组越界
			System.out.println("------" + e.getMessage());
			System.out.println("数组越界");
		} catch (NumberFormatException e) {//数组格式异常
			System.out.println("------" + e.getMessage());
			System.out.println("数组格式异常");
		} catch (ArithmeticException e) {//算术异常
			System.out.println("------" + e.getMessage());
			System.out.println("算术异常");
		} catch (Exception e) {
			System.out.println("未知异常");
		}
	}
}

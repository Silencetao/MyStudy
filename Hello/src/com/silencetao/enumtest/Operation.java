package com.silencetao.enumtest;

/**
 * 包含抽象方法的枚举类
 * @author Silence
 *
 */
public enum Operation {
	
	PLUS {
		
		@Override
		public double eval(double x, double y) {
			return x + y;
		}
		
	}, MINUS {

		@Override
		public double eval(double x, double y) {
			return x -y;
		}
		
	}, TIMES {

		@Override
		public double eval(double x, double y) {
			return x * y;
		}
		
	}, DIVIDE {

		@Override
		public double eval(double x, double y) {
			return x / y;
		}
		
	};
	
	public abstract double eval(double x, double y);
	
	public static void main(String[] args) {
		System.out.println(Operation.PLUS.eval(3, 5));
		System.out.println(Operation.MINUS.eval(5, 3));
		System.out.println(Operation.TIMES.eval(3, 5));
		System.out.println(Operation.DIVIDE.eval(6, 3));
	}
}

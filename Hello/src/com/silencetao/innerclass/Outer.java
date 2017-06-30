package com.silencetao.innerclass;

/**
 * ÄÚ²¿Àà
 * @author Silence
 *
 */
public class Outer {
	
	private int outProp = 9;
	
	class Inner {
		private int inProp = 4;
		public void accessOuterProp() {
			System.out.println("outProp:" + outProp + ", inProp:" + inProp);
		}
	}
	
	public void accessInnerProp() {
		Inner inner = new Inner();
		System.out.println(inner.inProp);
		inner.accessOuterProp();
	}
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.accessInnerProp();
		System.out.println(outer.outProp);
	}
}

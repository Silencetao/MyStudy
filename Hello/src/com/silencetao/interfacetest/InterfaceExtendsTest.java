package com.silencetao.interfacetest;

/**
 * ½Ó¿Ú²âÊÔ
 * @author Silence
 *
 */

abstract class Shape {
	public abstract void getType();
}

interface interfaceA {
	int PROP_A = 5;
	void testA();
}

interface interfaceB {
	int PROP_B = 6;
	void testB();
}

interface interfaceC extends interfaceA, interfaceB {
	int PROP_C = 7;
	void testC();
}

public class InterfaceExtendsTest implements interfaceC {
	public static void main(String[] args) {
		System.out.println(interfaceC.PROP_A);
		System.out.println(interfaceC.PROP_B);
		System.out.println(interfaceC.PROP_C);
		System.out.println(PROP_A);
	}

	@Override
	public void testA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testC() {
		// TODO Auto-generated method stub
		
	}
}

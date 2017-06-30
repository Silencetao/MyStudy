package com.silencetao.innerclass;

/**
 * 匿名内部类,接口实现类
 * @author Silence
 *
 */

interface Product {
	public double getPrice();
	public String getName();
}

interface A {
	void test();
}

public class AnonymousTest {

	public void test(Product product) {
		System.out.println(product.getName() + "," + product.getPrice());
	}
	
	public static void main(String[] args) {
		AnonymousTest ta = new AnonymousTest();
		ta.test(new Product() {
			@Override
			public double getPrice() {
				return 89.3;
			}
			
			@Override
			public String getName() {
				return "Silence";
			}
		});
		
		final int age = 22;
		A a = new A() {
			@Override
			public void test() {
				System.out.println(age);
			}
		};
		a.test();
	}
}

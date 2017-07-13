package com.silencetao.exception;

/**
 * throw用法
 * @author Silence
 *
 */
public class ThrowTest {

	public static void main(String[] args) {
		try {
			throwChecked(3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		throwRuntime(-2);
	}
	
	public static void throwChecked(int a) throws Exception {
		if (a > 0) {
			throw new AuctionException("a的值大于0，不符合要求");
		}
	}
	
	public static void throwRuntime(int a) {
		if (a > 0) {
			throw new RuntimeException("a的值大于0，不符合要求");
		}
	}
}

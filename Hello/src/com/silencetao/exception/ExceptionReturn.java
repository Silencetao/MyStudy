package com.silencetao.exception;

/**
 * 异常处理中,当finally中也有return时,最后return的是finally里的值
 * 所以finally是在return中执行的,try或catch中执行了return时,
 * 不会马上把return的值返回给方法的调用者,
 * 而是等执行完finally之后才会把return的值返回给方法的调用者,
 * 故在finally有return的话,会把try或catch里return的值覆盖掉
 * 最终return的是finally的值
 * @author Silence
 *
 */
public class ExceptionReturn {

	@SuppressWarnings("finally")
	public static int test() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(test());
	}
}

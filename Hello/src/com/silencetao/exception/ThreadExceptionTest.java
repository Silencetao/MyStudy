package com.silencetao.exception;

/**
 * 多线程异常处理
 * @author Silence
 *
 */
public class ThreadExceptionTest implements Runnable {

	@Override
	public void run() {
		firstMethod();
	}

	public void firstMethod() {
		secondMethod();
	}
	
	public void secondMethod() {
		int a = 2;
		int b = 0;
		int c = a / b;
	}
	
	public static void main(String[] args) {
		new Thread(new ThreadExceptionTest()).start();
	}
}

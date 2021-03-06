package com.silencetao.thread;

/**
 * 线程的异常处理器
 * @author Silence
 *
 */
class MyExHandler implements Thread.UncaughtExceptionHandler {

	//实现uncaughtException()方法，该方法将处理线程的未处理异常
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + "线程出现了异常:" + e);
	}
	
}

public class ExHandler {

	public static void main(String[] args) {
		//设置主线程的异常处理器
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 3 / 0;
		System.out.println("ending");
	}
}

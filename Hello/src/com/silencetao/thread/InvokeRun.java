package com.silencetao.thread;

public class InvokeRun extends Thread {
	private int i = 0;
	
	//重写run()方法，run()方法的方法体就是线程执行体
	@Override
	public void run() {
		for ( ; i < 100; i++) {
			//当线程类继承Thread类时，直接使用this即可获得当前线程
			//Thread对象的getName()返回当前线程的名字
			//因此可以直接调用getName()方法返回当前线程的名字
			System.out.println(getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			//调用Thread的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				//直接调用线程对象的run()方法
				//系统会把线程对象当成普通对象，把run()方法当成普通方法
				//所以下面两行代码并不会启动两个线程，而是依次执行两个run()方法
				new InvokeRun().run();
				new InvokeRun().run();
			}
		}
	}
}

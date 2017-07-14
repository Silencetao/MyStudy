package com.silencetao.thread;

/**
 * 尝试对处于死亡状态的线程再次调用start()方法
 * 当死亡状态的线程调用start()方法时
 * 将引发IllegalThreadStateException异常
 * 
 * 对新建状态的进程两次调用start()方法也是错误的
 * 也会引发IllegalThreadStateException异常
 * @author Silence
 *
 */
public class StartDead extends Thread {
	private int i;
	
	@Override
	public void run() {
		for ( ; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		StartDead sd = new StartDead();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				sd.start();
				System.out.println(sd.isAlive());
			}
			if (i > 20 && !sd.isAlive()) {
				sd.start();//将引发IllegalThreadStateException异常
			}
		}
	}
}
